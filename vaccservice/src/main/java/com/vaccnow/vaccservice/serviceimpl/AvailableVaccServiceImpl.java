package com.vaccnow.vaccservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccservice.entity.AvailableVacc;
import com.vaccnow.vaccservice.repo.AvailableVaccRepo;
import com.vaccnow.vaccservice.serviceinterface.IAvailableVaccService;

@Service
public class AvailableVaccServiceImpl implements IAvailableVaccService {
	
	@Autowired
	private AvailableVaccRepo availableVaccRepo;

	@Override
	public List<AvailableVacc> getAvailableVacc(long minAvailableNo) {		
		return availableVaccRepo.getVaccByAvailablility(minAvailableNo);		
	}

	@Override
	public List<AvailableVacc> getAvailableVaccPerBranch(long minAvailableNo, int branchId) {
		return availableVaccRepo.getVaccByAvailablilityAndBranch(minAvailableNo, branchId);
	}

	@Override
	public List<AvailableVacc> getSingleVaccPerBranch(long minAvailableNo, int branchId, int vaccinId) {
		return availableVaccRepo.getVaccByAvailablilityAndBranchAndVaccine(minAvailableNo, branchId, vaccinId);
	}

	@Override
	public AvailableVacc saveAvailSched(AvailableVacc availableVacc) {
		return availableVaccRepo.saveAndFlush(availableVacc);
	}

}
