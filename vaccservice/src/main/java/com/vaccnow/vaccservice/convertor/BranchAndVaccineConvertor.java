package com.vaccnow.vaccservice.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.vaccnow.vaccservice.dto.BranchAndVaccineDTO;
import com.vaccnow.vaccservice.entity.AvailableVacc;

@Component
public class BranchAndVaccineConvertor {
	
	public BranchAndVaccineDTO entitytoDTO(AvailableVacc availableVacc) {
		BranchAndVaccineDTO obj=new BranchAndVaccineDTO();
		obj.setBranchAddress(availableVacc.getBranch().getAddress());
		obj.setBranchCity(availableVacc.getBranch().getCity());
		obj.setBranchId(availableVacc.getBranch().getId());
		obj.setBranchName(availableVacc.getBranch().getName());
		obj.setVaccineAvailableNo(availableVacc.getAvailableNo());
		obj.setVaccineDesc(availableVacc.getVaccine().getDesc());
		obj.setVaccineId(availableVacc.getVaccine().getId());
		obj.setVaccineName(availableVacc.getVaccine().getName());
		obj.setVaccineReqDoses(availableVacc.getVaccine().getReqDoses());
		return obj;
		
	}
	
	public List<BranchAndVaccineDTO> entitytoDTOList(List<AvailableVacc> availableVaccList) {
		
		return availableVaccList.stream().map(availableVacc->entitytoDTO(availableVacc)).collect(Collectors.toList());
		
	}
}
