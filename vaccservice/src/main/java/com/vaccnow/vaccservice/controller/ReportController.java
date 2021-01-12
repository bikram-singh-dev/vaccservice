package com.vaccnow.vaccservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccservice.dto.ReportBranchVaccineDTO;
import com.vaccnow.vaccservice.serviceinterface.IReportingService;

@RestController
@RequestMapping("/api")
public class ReportController {

	@Autowired
	IReportingService reportingService;
	
	@GetMapping("/report/vacc-applied-branch/{id}")
	public ResponseEntity<List<ReportBranchVaccineDTO>> getVaccAppliedPerBranch(@PathVariable int id){
		HttpStatus status;
		List<ReportBranchVaccineDTO> reportBranchVaccineDTOList=reportingService.getAppliedVaccPerBranch(id);
		if(reportBranchVaccineDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(reportBranchVaccineDTOList);
	}
	
	@GetMapping("/report/vaccs-applied-period")
	public ResponseEntity<List<ReportBranchVaccineDTO>> getVaccAppliedBetweenDates(
			@RequestParam(name="startDate",required = true)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate startDate,
			@RequestParam(name="endDate", required = false)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate endDate){
		
		HttpStatus status;
		List<ReportBranchVaccineDTO> reportBranchVaccineDTOList=reportingService.getVaccAppliedBetweenDates(startDate,endDate);
		if(reportBranchVaccineDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(reportBranchVaccineDTOList); 
	}
	
	@GetMapping("/report/vaccs-confirmed-period")
	public ResponseEntity<List<ReportBranchVaccineDTO>> getVaccConfirmedBetweenDates(
			@RequestParam(name="startDate",required = true)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate startDate,
			@RequestParam(name="endDate", required = false)
			@DateTimeFormat(iso = ISO.DATE)
			LocalDate endDate){
		HttpStatus status;
		List<ReportBranchVaccineDTO> reportBranchVaccineDTOList=reportingService.getVaccConfirmedBetweenDates(startDate,endDate);
		if(reportBranchVaccineDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(reportBranchVaccineDTOList);
	}
}
