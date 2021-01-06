package com.vaccnow.vaccservice.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.vaccnow.vaccservice.dto.BranchDTO;
import com.vaccnow.vaccservice.entity.Branch;

@Component
public class BranchConvertor {

	public BranchDTO entityToVO(Branch branch){
		BranchDTO branchVO=new BranchDTO();
		branchVO.setId(branch.getId());
		branchVO.setName(branch.getName());
		branchVO.setCity(branch.getCity());
		branchVO.setAddress(branch.getAddress());
		return branchVO;
		
	}	
	
	public List<BranchDTO> getBranchVOList(List<Branch> branchList){
		return branchList.stream().map(branch -> entityToVO(branch)).collect(Collectors.toList());		
	}
}
