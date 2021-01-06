package com.vaccnow.vaccservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccservice.dto.ScheduleDTO;
import com.vaccnow.vaccservice.entity.AvailableVacc;
import com.vaccnow.vaccservice.entity.Branch;
import com.vaccnow.vaccservice.entity.Schedule;
import com.vaccnow.vaccservice.entity.Vaccine;
import com.vaccnow.vaccservice.repo.AvailableVaccRepo;
import com.vaccnow.vaccservice.repo.ScheduleRepo;

@Service
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private ScheduleRepo scheduleRepo;
	
	@Autowired
	private AvailableVaccRepo availableVaccRepo;
	
	@Value("${vacc.schedStatusConf}")
	private String schedStatusConf;
	@Value("${vacc.slotDuration}")
	private Long slotDuration;

	@Override
	public String addSchedule(ScheduleDTO scheduleDTO) {		
		
		if(scheduleDTO.getTimeSlot().toLocalDate().isAfter(LocalDate.now()))
		{			
			StringBuilder time=new StringBuilder(scheduleDTO.getTimeSlot().toLocalTime().toString());
			time.deleteCharAt(2);
			int i=Integer.parseInt(time.toString());			
			if(i>slotDuration-1) {
				if(i%slotDuration!=0)
					return "Please enter a valid date";
			} else if(i!=0) {
				return "Please enter a valid date";
			}			
		}else {
			return "Please enter a valid date";
		}
		if(schedCheck(scheduleDTO, schedStatusConf)==0) {
			Schedule schd=new Schedule();
			Branch b=new Branch();
			b.setId(scheduleDTO.getBranchId());
			schd.setBranch(b);
			Vaccine v=new Vaccine();
			v.setId(scheduleDTO.getVaccineId());
			schd.setVaccine(v);
			schd.setTimeSlot(scheduleDTO.getTimeSlot());			
			schd.setGenSchedId(getGenSchedId());
			schd.setSchedStatus(schedStatusConf);	
			AvailableVacc availVac=availableVaccRepo.getVaccByAvailablilityAndBranchAndVaccine(0, scheduleDTO.getBranchId(), scheduleDTO.getVaccineId()).get(0);
			availVac.setAvailableNo(availVac.getAvailableNo()-1);
			availableVaccRepo.save(availVac);
			return scheduleRepo.saveAndFlush(schd).getGenSchedId();	
		}else {
			return "Slot not available";
		}	
	}

	private String getGenSchedId() {
		String ref="VACCID"+LocalDateTime.now().toString();
		return ref;
	}

	@Override
	public int schedCheck(ScheduleDTO scheduleDTO, String schedStatus) {
		if(availableVaccRepo.getVaccByAvailablilityAndBranchAndVaccine(0, scheduleDTO.getBranchId(), scheduleDTO.getVaccineId()).size()>0)
			return scheduleRepo.getSchedCountByBranchAndVaccineAndDateTime(scheduleDTO.getBranchId(), scheduleDTO.getTimeSlot(), scheduleDTO.getVaccineId(), schedStatus).size();
		return 0;
		
	}

	
	

}
