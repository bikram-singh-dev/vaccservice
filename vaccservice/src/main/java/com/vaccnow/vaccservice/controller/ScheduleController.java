package com.vaccnow.vaccservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccservice.dto.PaymentDTO;
import com.vaccnow.vaccservice.dto.PaymentReplyDTO;
import com.vaccnow.vaccservice.dto.ReportBranchVaccineDTO;
import com.vaccnow.vaccservice.dto.ScheduleDTO;
import com.vaccnow.vaccservice.service.IReportingService;
import com.vaccnow.vaccservice.service.IScheduleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ScheduleController {
	
	@Autowired
	IScheduleService scheduleService;
	@Autowired
	IReportingService reportingService;

	@PostMapping("/schedule/add")
	@ApiOperation(value = "Adds a schedule and returns either reference Id for the slot or error message")
	public String addSchedule(@RequestBody ScheduleDTO scheduleDTO){
		
		return scheduleService.addSchedule(scheduleDTO);
		
	}
	
	@PostMapping("/makePayment")
	@ApiOperation(value = "Makes payment as per payment type and returns generated payId with a message")
	public PaymentReplyDTO makePayment(@RequestBody PaymentDTO paymentDTO){
		
		return scheduleService.confirmSched(paymentDTO);
		
	}
	
	@GetMapping("/vaccsAppliedBranch/{id}")
	@ApiOperation(value = "Finds applied vaccines list till now by branchId",response = ReportBranchVaccineDTO.class)
	public List<ReportBranchVaccineDTO> getVaccAppliedPerBranch(@PathVariable int id){
		
		return reportingService.getAppliedVaccPerBranch(id);
	}
	
	@GetMapping("/vaccsAppliedPeriod")
	@ApiOperation(value = "Finds applied vaccines list between start and end date. /n Pass start date for single day result",response = ReportBranchVaccineDTO.class)
	public List<ReportBranchVaccineDTO> getVaccAppliedBetweenDates(
			@RequestParam(name="startDate",required = true)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate startDate,
			@RequestParam(name="endDate", required = false)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate endDate){
		
		return reportingService.getVaccAppliedBetweenDates(startDate,endDate);
	}
	
	@GetMapping("/vaccsConfirmedPeriod")
	@ApiOperation(value = "Finds confirmed vaccines list between start and end date. /n Pass start date for single day result",response = ReportBranchVaccineDTO.class)
	public List<ReportBranchVaccineDTO> getVaccConfirmedBetweenDates(
			@RequestParam(name="startDate",required = true)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate startDate,
			@RequestParam(name="endDate", required = false)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate endDate){
		
		return reportingService.getVaccConfirmedBetweenDates(startDate,endDate);
	}
}
