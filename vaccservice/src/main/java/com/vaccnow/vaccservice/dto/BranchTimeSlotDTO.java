package com.vaccnow.vaccservice.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BranchTimeSlotDTO {

	private int branchID;
	private String branchName;
	private String branchCity;
	private String branchAddress;
	
	private List<LocalDateTime> timeSlot=new ArrayList<>();
	
}
