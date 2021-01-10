package com.vaccnow.vaccservice.dto;

import java.time.LocalDateTime;

public class ReportBranchVaccineDTO {
	
	private int branchId;
	private String branchName;
	private String branchCity;
	private String branchAddress;
	
	private int vaccineId;
	private String vaccineName;
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
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
	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getVaccineDesc() {
		return vaccineDesc;
	}
	public void setVaccineDesc(String vaccineDesc) {
		this.vaccineDesc = vaccineDesc;
	}
	public String getGenSchedId() {
		return genSchedId;
	}
	public void setGenSchedId(String genSchedId) {
		this.genSchedId = genSchedId;
	}
	public LocalDateTime getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(LocalDateTime timeSlot) {
		this.timeSlot = timeSlot;
	}
	private String vaccineDesc;
	
	private String genSchedId;
	private LocalDateTime timeSlot;
	
	

}
