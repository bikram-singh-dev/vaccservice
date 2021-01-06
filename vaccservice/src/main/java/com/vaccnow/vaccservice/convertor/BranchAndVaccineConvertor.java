package com.vaccnow.vaccservice.convertor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.vaccnow.vaccservice.dto.BranchAndVaccineDTO;
import com.vaccnow.vaccservice.dto.VaccineDTO;
import com.vaccnow.vaccservice.entity.AvailableVacc;

@Component
public class BranchAndVaccineConvertor {
	
	public List<BranchAndVaccineDTO> entitytoVOList(List<AvailableVacc> availableVaccList) {
		
		List<BranchAndVaccineDTO> branchAndVaccineVOList=new ArrayList<>();
		BranchAndVaccineDTO obj=new BranchAndVaccineDTO();
		for(int i=0;i<availableVaccList.size();i++) {
			
			obj.setBranchAddress(availableVaccList.get(i).getBranch().getAddress());
			obj.setBranchCity(availableVaccList.get(i).getBranch().getCity());
			obj.setBranchId(availableVaccList.get(i).getBranch().getId());
			obj.setBranchName(availableVaccList.get(i).getBranch().getName());
			
			VaccineDTO vacVO=new VaccineDTO();
			vacVO.setDesc(availableVaccList.get(i).getVaccine().getDesc());
			vacVO.setId(availableVaccList.get(i).getVaccine().getId());
			vacVO.setName(availableVaccList.get(i).getVaccine().getName());
			vacVO.setReqDoses(availableVaccList.get(i).getVaccine().getReqDoses());
			vacVO.setAvailableNo(availableVaccList.get(i).getAvailableNo());
			
			obj.getVaccineList().add(vacVO);
			if(i==availableVaccList.size()-1) {
				branchAndVaccineVOList.add(obj);
			}
			else {
				if(availableVaccList.get(i).getBranch().getId()!=availableVaccList.get(i+1).getBranch().getId()) {
					branchAndVaccineVOList.add(obj);
					obj=new BranchAndVaccineDTO();
				}
			}			
		}
		return branchAndVaccineVOList;
		
	}
}
