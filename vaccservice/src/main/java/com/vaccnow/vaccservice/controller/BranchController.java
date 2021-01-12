package com.vaccnow.vaccservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccservice.dto.BranchAndVaccineDTO;
import com.vaccnow.vaccservice.dto.BranchDTO;
import com.vaccnow.vaccservice.dto.BranchTimeSlotDTO;
import com.vaccnow.vaccservice.serviceinterface.IBranchService;


@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	private IBranchService branchService;
	
	@GetMapping("/branch-list")
	public ResponseEntity<List<BranchDTO>> getAllBranches(){		
		HttpStatus status;
		List<BranchDTO> branchDTOList= branchService.getAllBranches();
		if(branchDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		
		
		return ResponseEntity.status(status).body(branchDTOList);
	}
	
	@GetMapping("/branch-vaccines/{id}")
	public ResponseEntity<List<BranchAndVaccineDTO>> getBranch(@PathVariable int id){
		HttpStatus status;
		List<BranchAndVaccineDTO> branchAndVaccineDTOList=branchService.getBranch(id);
		if(branchAndVaccineDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(branchAndVaccineDTOList);
	}
	
	@GetMapping("/branch-vaccine-list")
	public ResponseEntity<List<BranchAndVaccineDTO>> getAllVaccines(){
		HttpStatus status;
		List<BranchAndVaccineDTO> branchAndVaccineDTOList=branchService.getAllAvilableVaccines();
		if(branchAndVaccineDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(branchAndVaccineDTOList);
	}
	
	@GetMapping("/branch-slots/{id}")
	public ResponseEntity<List<BranchTimeSlotDTO>> getBranchSlots(@PathVariable int id){
		HttpStatus status;
		List<BranchTimeSlotDTO> branchTimeSlotDTOList=branchService.getBranchSlots(id);		
		if(branchTimeSlotDTOList.size()>0)
			status=HttpStatus.OK;
		else
			status=HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).body(branchTimeSlotDTOList);		
	}
}
