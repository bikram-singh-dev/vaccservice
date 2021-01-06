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
import com.vaccnow.vaccservice.repo.AvailableVaccRepo;
import com.vaccnow.vaccservice.repo.BranchRepo;
import com.vaccnow.vaccservice.repo.ScheduleRepo;

@Service
public class BranchServiceImpl implements IBranchService {

	@Autowired
	private BranchRepo branchRepo;
	@Autowired
	private BranchConvertor branchConv;
	@Autowired
	private AvailableVaccRepo availVaccRepo;
	@Autowired
	private BranchAndVaccineConvertor branchVaccConv;
	@Autowired
	private ScheduleRepo scheduleRepo;
	
	@Value("${vacc.firstSlot}")
	private String timeslot;	
	@Value("${vacc.slotDuration}")
	private Long slotDuration;
	
	@Override
	public List<BranchDTO> getAllBranches() {
		return branchConv.getBranchVOList(branchRepo.findAll());
	}

	@Override
	public List<BranchAndVaccineDTO> getAllAvilableVaccines() {
		return branchVaccConv.entitytoVOList(availVaccRepo.getVaccByAvailablility(0));
		
	}

	@Override
	public List<BranchAndVaccineDTO> getBranch(int id) {
		return branchVaccConv.entitytoVOList(availVaccRepo.getVaccByAvailablilityAndBranch(0, id));
	}

	@Override
	public List<BranchTimeSlotDTO> getBranchSlots(int branchId) {
		//System.out.println(branchId);
		//List<AvailableVacc> availableVaccL=availVaccRepo.getVaccByAvailablilityAndBranch(0, branchId).size();
		List<BranchAndVaccineDTO> branchAndVaccineDTOList=getBranch(branchId);
		if(branchAndVaccineDTOList.size()>0) {
			List<LocalDateTime> slotList=new LinkedList<>();
			LocalDate tomorrow=LocalDate.now().plus(1, ChronoUnit.DAYS);
			String stringDateTime=tomorrow.toString() +" "+ timeslot;
			DateTimeFormatter form= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime dateTime= LocalDateTime.parse(stringDateTime, form);
			Long totMins=dateTime.until(dateTime.plus(7, ChronoUnit.DAYS), ChronoUnit.MINUTES);
			Long totSLot=totMins/slotDuration;
			slotList.add(dateTime);
			for(long i=1;i<totSLot;i++) {
				dateTime=dateTime.plus(slotDuration,ChronoUnit.MINUTES);
				slotList.add(dateTime);
			}
			//List<LocalDateTime> blockedSlot= scheduleRepo.getBlockedTimeSlotByBranch(branchId, dateTime);
			List<Schedule> ScheduleL= scheduleRepo.getBlockedTimeSlotByBranch(branchId, LocalDateTime.parse(stringDateTime, form));
			//System.out.println(ScheduleL);
			//System.out.println(slotList);
			for(Schedule obj:ScheduleL) {
				//System.out.println(obj.getTimeSlot());
				slotList.remove(obj.getTimeSlot());
			}
			//System.out.println(slotList);
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
				//System.out.println(branchSlotList);
				return branchSlotList;
			}
		}
		//System.out.println(slotList);
		//System.out.println(dateTime);
		//LocalDateTime 
		return null;
	}

}
