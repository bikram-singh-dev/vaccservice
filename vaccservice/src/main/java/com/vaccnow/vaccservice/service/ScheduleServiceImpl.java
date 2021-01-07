package com.vaccnow.vaccservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccservice.dto.ScheduleDTO;
import com.vaccnow.vaccservice.entity.AvailableVacc;
import com.vaccnow.vaccservice.entity.Branch;
import com.vaccnow.vaccservice.entity.Schedule;
import com.vaccnow.vaccservice.entity.Vaccine;
import com.vaccnow.vaccservice.repo.ScheduleRepo;

@Service
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private ScheduleRepo scheduleRepo;	
	@Autowired
	private IAvailableVaccService availableVaccService;
	
	@Value("${vacc.schedStatusConf}")
	private String schedStatusConf;
	@Value("${vacc.schedStatusInit}")
	private String schedStatusInit;
	@Value("${vacc.schedStatusCancled}")
	private String schedStatusCancled;
	@Value("${vacc.slotDuration}")
	private Long slotDuration;

	@Override
	public String addSchedule(ScheduleDTO scheduleDTO) {		
		
		if(scheduleDTO.getTimeSlot().toLocalDate().isAfter(LocalDate.now())){
			int time=scheduleDTO.getTimeSlot().toLocalTime().getMinute();
				
			if(time!=0&&time!=15&&time!=30&&time!=45)
				return "Please enter a valid date";
			
		}
		synchronized(this) {
			if(schedCheck(scheduleDTO, Arrays.asList(schedStatusConf,schedStatusInit))==0) {
				Schedule schd=new Schedule();
				Branch b=new Branch();
				b.setId(scheduleDTO.getBranchId());
				schd.setBranch(b);
				Vaccine v=new Vaccine();
				v.setId(scheduleDTO.getVaccineId());
				schd.setVaccine(v);
				schd.setTimeSlot(scheduleDTO.getTimeSlot());			
				schd.setGenSchedId(getGenSchedId());
				schd.setSchedStatus(schedStatusInit);	
				AvailableVacc availVac=availableVaccService.getSingleVaccPerBranch(1, scheduleDTO.getBranchId(), scheduleDTO.getVaccineId()).get(0);
				availVac.setAvailableNo(availVac.getAvailableNo()-1);
				availableVaccService.saveAvailSched(availVac);
				schd=scheduleRepo.saveAndFlush(schd);	
				
				// Thread to change status of Schedule table from "Initiated" to "Cancelled" &
				// update the available qty in AvailableVacc table if not "Confirmed" within 1 min 
				Thread t=new Thread(new Runnable() {
					private long anonVar;
					@Override
					public void run() {						
						try {
							Thread.sleep(60000);
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						schedStatusCheckAndUpdate(anonVar);
					}
					private Runnable init(long l) {
						anonVar = l;
						return this;
					}					
				}.init(schd.getId()));
				t.start();
								
				return schd.getGenSchedId();	
			}else {
				return "Slot not available";
			}
		}
	}

	private String getGenSchedId() {
		String ref="VACCID"+LocalDateTime.now().toString();
		return ref;
	}
	
	private void schedStatusCheckAndUpdate(long schedId) {
		List<Long> schedIdList=new ArrayList<>();
		schedIdList.add(schedId);
		Schedule schd=new Schedule();		
		schd=scheduleRepo.findAllById(schedIdList).get(0);
		if(schd.getSchedStatus().equals(schedStatusInit)) {
			schd.setSchedStatus(schedStatusCancled);
			scheduleRepo.saveAndFlush(schd);
			AvailableVacc availVac=availableVaccService.getSingleVaccPerBranch(0, schd.getBranch().getId(), schd.getVaccine().getId()).get(0);
			availVac.setAvailableNo(availVac.getAvailableNo()+1);
			availableVaccService.saveAvailSched(availVac);
		}
	}

	@Override
	public int schedCheck(ScheduleDTO scheduleDTO, List<String> schedStatus) {
		if(availableVaccService.getSingleVaccPerBranch(1, scheduleDTO.getBranchId(), scheduleDTO.getVaccineId()).size()>0)
			return scheduleRepo.getSchedCountByBranchAndVaccineAndDateTime(scheduleDTO.getBranchId(), scheduleDTO.getTimeSlot(), scheduleDTO.getVaccineId(), schedStatus).size();
		return 0;
		
		
	}

	
	

}
