package com.vaccnow.vaccservice.serviceimpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccservice.convertor.ScheduleConvertor;
import com.vaccnow.vaccservice.dto.ReportBranchVaccineDTO;
import com.vaccnow.vaccservice.repo.ScheduleRepo;
import com.vaccnow.vaccservice.serviceinterface.IReportingService;

@Service
public class ReportingServiceImpl implements IReportingService {
	
	@Autowired
	ScheduleRepo scheduleRepo;	
	@Autowired
	ScheduleConvertor scheduleConvertor;
	
	@Value("${vacc.schedStatusConf}")
	String schedStatusConf;

	@Override
	public List<ReportBranchVaccineDTO> getAppliedVaccPerBranch(int branchId) {
		return scheduleConvertor.entityToDTOList(scheduleRepo.getVaccSchedByBranchAndSchedStatusTillNow(branchId, Arrays.asList(schedStatusConf)));
	}

	@Override
	public List<ReportBranchVaccineDTO> getVaccAppliedBetweenDates(LocalDate startDate, LocalDate endDate) {
		
		LocalDateTime endDateTime;
		if(endDate!=null) {
			if(startDate.isAfter(endDate)) {//swap the dates if start date is after end date
				LocalDate date=startDate;
				startDate=endDate;
				endDate=date;
			}
			if(startDate.isAfter(LocalDate.now()))//Since future date can't have applied vaccines
				return null;
			if(endDate.isBefore(LocalDate.now()))//Since future date can't have applied vaccines
				endDateTime=endDate.atTime(23, 59, 59);
			else
				endDateTime=LocalDateTime.now();
		}
		else {
			if(startDate.isAfter(LocalDate.now()))
				return null;
			endDateTime=startDate.atTime(23, 59, 59);
		}
		
		return scheduleConvertor.entityToDTOList(scheduleRepo.getVaccSchedBySchedStatusBetweenDateTime(startDate.atStartOfDay(), endDateTime, Arrays.asList(schedStatusConf)));
	}

	@Override
	public List<ReportBranchVaccineDTO> getVaccConfirmedBetweenDates(LocalDate startDate, LocalDate endDate) {
		
		LocalDateTime startDateTime;
		LocalDateTime endDateTime;		
		if(endDate!=null) {
			if(startDate.isAfter(endDate)) {//swap the dates if start date is after end date
				LocalDate date=startDate;
				startDate=endDate;
				endDate=date;
			}
			if(endDate.isBefore(LocalDate.now()))//Since past date confirmed vaccines means applied ones
				return null;
			else
				endDateTime=endDate.atTime(23, 59, 59);
			if(startDate.isBefore(LocalDate.now())||startDate.isEqual(LocalDate.now()))//Since past date confirmed vaccines means applied ones
				startDateTime=LocalDateTime.now();
			else
				startDateTime=startDate.atStartOfDay();
		}
		else {
			if(startDate.isBefore(LocalDate.now())||startDate.isEqual(LocalDate.now()))//Since past date confirmed vaccines means applied ones
				startDateTime=LocalDateTime.now();
			else
				startDateTime=startDate.atStartOfDay();
			endDateTime=startDate.atTime(23, 59, 59);
		}
		
		return scheduleConvertor.entityToDTOList(scheduleRepo.getVaccSchedBySchedStatusBetweenDateTime(startDateTime, endDateTime, Arrays.asList(schedStatusConf)));
	}

}
