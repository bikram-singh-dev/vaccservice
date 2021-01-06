package com.vaccnow.vaccservice.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BranchTimeSlotDTO {

	private int branchID;
	private String branchName;
	private String branchCity;
	private String branchAddress;
	
	private List<LocalDateTime> timeSlot=new ArrayList<>();

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCity() {
		return branchCity;
	}

	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public List<LocalDateTime> getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(List<LocalDateTime> timeSlot) {
		this.timeSlot = timeSlot;
	}

	
}
