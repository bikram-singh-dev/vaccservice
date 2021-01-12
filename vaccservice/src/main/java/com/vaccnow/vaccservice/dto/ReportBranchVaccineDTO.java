package com.vaccnow.vaccservice.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReportBranchVaccineDTO {
	
	private int branchId;
	private String branchName;
	private String branchCity;
	private String branchAddress;
	
	private int vaccineId;
	private String vaccineName;
	
	private String vaccineDesc;
	
	private String genSchedId;
	private LocalDateTime timeSlot;

}
