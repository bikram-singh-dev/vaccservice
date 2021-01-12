package com.vaccnow.vaccservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BranchAndVaccineDTO {

	private int branchId;
	private String branchName;
	private String branchCity;
	private String branchAddress;
	
	private int vaccineId;
	private String vaccineName;
	private String vaccineDesc;
	private int vaccineReqDoses;
	private long vaccineAvailableNo;
	
	
}
