package com.vaccnow.vaccservice.serviceinterface;

import java.util.List;

import com.vaccnow.vaccservice.entity.AvailableVacc;

public interface IAvailableVaccService {

	public AvailableVacc saveAvailSched(AvailableVacc availableVacc);
	
	public List<AvailableVacc> getAvailableVacc(long minAvailableNo);	
	
	public List<AvailableVacc> getAvailableVaccPerBranch(long minAvailableNo,int branchId);
	
	public List<AvailableVacc> getSingleVaccPerBranch(long minAvailableNo,int branchId, int vaccinId);
}
