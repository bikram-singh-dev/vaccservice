package com.vaccnow.vaccservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccservice.convertor.BranchAndVaccineConvertor;
import com.vaccnow.vaccservice.convertor.BranchConvertor;
import com.vaccnow.vaccservice.dto.BranchAndVaccineDTO;
import com.vaccnow.vaccservice.dto.BranchDTO;
import com.vaccnow.vaccservice.dto.BranchTimeSlotDTO;
import com.vaccnow.vaccservice.entity.Schedule;
import com.vaccnow.vaccservice.repo.BranchRepo;
import com.vaccnow.vaccservice.repo.ScheduleRepo;

@Service
public class BranchServiceImpl implements IBranchService {

	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private BranchConvertor branchConv;
	@Autowired
	private IAvailableVaccService availableVaccService;
	
	@Autowired
	private BranchAndVaccineConvertor branchVaccConv;
	@Autowired
	private ScheduleRepo scheduleRepo;
	
	@Value("${vacc.firstSlot}")
	private String timeslot;	
	@Value("${vacc.slotDuration}")
	private Long slotDuration;
	@Value("${vacc.slotDays}")
	private Long slotDays;
	
	@Override
	public List<BranchDTO> getAllBranches() {
		return branchConv.getBranchVOList(branchRepo.findAll());
	}

	@Override
	public List<BranchAndVaccineDTO> getAllAvilableVaccines() {
		return branchVaccConv.entitytoVOList(availableVaccService.getAvailableVacc(1));
	}

	@Override
	public List<BranchAndVaccineDTO> getBranch(int id) {
		return branchVaccConv.entitytoVOList(availableVaccService.getAvailableVaccPerBranch(1, id));
	}

	@Override
	public List<BranchTimeSlotDTO> getBranchSlots(int branchId) {
		
		List<BranchAndVaccineDTO> branchAndVaccineDTOList=getBranch(branchId);
		if(branchAndVaccineDTOList.size()>0) {
			List<LocalDateTime> slotList=new LinkedList<>();
			LocalDate tomorrow=LocalDate.now().plus(1, ChronoUnit.DAYS);
			String stringDateTime=tomorrow.toString() +" "+ timeslot;
			DateTimeFormatter form= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime= LocalDateTime.parse(stringDateTime, form);
			Long totMins=dateTime.until(dateTime.plus(slotDays, ChronoUnit.DAYS), ChronoUnit.MINUTES);
			Long totSLot=totMins/slotDuration;
			slotList.add(dateTime);
			for(long i=1;i<totSLot;i++) {
				dateTime=dateTime.plus(slotDuration,ChronoUnit.MINUTES);
				slotList.add(dateTime);
			}
			
			//List<Schedule> ScheduleL= scheduleRepo.getBlockedTimeSlotByBranch(branchId, LocalDateTime.parse(stringDateTime, form));
			
			//for(Schedule obj:ScheduleL) {
				
				//slotList.remove(obj.getTimeSlot());
			//}
			
			List<Schedule> ScheduleL= scheduleRepo.getBlockedTimeSlotByBranch(branchId, LocalDateTime.parse(stringDateTime, form));
			int slott=0;
			if(ScheduleL.size()>0)
				slott=ScheduleL.get(0).getBranch().getShotCapPerSlot();
			int counter=slott;
			for(int i=0;i<ScheduleL.size();i++) {
				if(i+1<ScheduleL.size()) {
					if(ScheduleL.get(i).getTimeSlot().equals(ScheduleL.get(i+1).getTimeSlot()))
						counter--;
					else
						counter=slott;
				}
				if(counter==1)
					slotList.remove(ScheduleL.get(i).getTimeSlot());
			}
			
			List<BranchTimeSlotDTO> branchSlotList;
			if(slotList.size()>0) {
				branchSlotList=new ArrayList<>();
				BranchTimeSlotDTO myobj=new BranchTimeSlotDTO();
				myobj.setBranchID(branchId);
				myobj.setBranchAddress(branchAndVaccineDTOList.get(0).getBranchAddress());
				myobj.setBranchCity(branchAndVaccineDTOList.get(0).getBranchCity());
				myobj.setBranchName(branchAndVaccineDTOList.get(0).getBranchName());
				myobj.getTimeSlot().addAll(slotList);
				branchSlotList.add(myobj);
				
				return branchSlotList;
			}
		}		
		return null;
	}

}
