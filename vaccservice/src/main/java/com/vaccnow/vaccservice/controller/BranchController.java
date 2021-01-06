package com.vaccnow.vaccservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccservice.dto.BranchAndVaccineDTO;
import com.vaccnow.vaccservice.dto.BranchDTO;
import com.vaccnow.vaccservice.dto.BranchTimeSlotDTO;
import com.vaccnow.vaccservice.service.IBranchService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	private IBranchService branchService;
	
	@GetMapping("/branches")
	@ApiOperation(value = "Finds all the branches",response = BranchDTO.class)
	public List<BranchDTO> getAllBranches(){
		
		return branchService.getAllBranches();
	}
	
	@GetMapping("/branches/{id}")
	@ApiOperation(value = "Finds available vaccines by branchId", response = BranchAndVaccineDTO.class)
	public List<BranchAndVaccineDTO> getBranch(@PathVariable int id){
		
		return branchService.getBranch(id);
	}
	
	@GetMapping("/vaccines")
	@ApiOperation(value = "Finds all the avilable vaccines branch wise",response = BranchAndVaccineDTO.class)
	public List<BranchAndVaccineDTO> getAllVaccines(){
		return branchService.getAllAvilableVaccines();
	}
	
	@GetMapping("/brancheSlots/{id}")
	@ApiOperation(value = "Finds availble slots by branchId",response = BranchTimeSlotDTO.class)
	public List<BranchTimeSlotDTO> getBranchSlots(@PathVariable int id){
		return branchService.getBranchSlots(id);
		//return null;
	}
}
