package com.vaccnow.vaccservice.service;

import java.util.List;

import com.vaccnow.vaccservice.dto.BranchAndVaccineDTO;
import com.vaccnow.vaccservice.dto.BranchDTO;
import com.vaccnow.vaccservice.dto.BranchTimeSlotDTO;

public interface IBranchService {

	public List<BranchDTO> getAllBranches();

	public List<BranchAndVaccineDTO> getAllAvilableVaccines();

	public List<BranchAndVaccineDTO> getBranch(int id);
	
	public List<BranchTimeSlotDTO> getBranchSlots(int branchId);
}
