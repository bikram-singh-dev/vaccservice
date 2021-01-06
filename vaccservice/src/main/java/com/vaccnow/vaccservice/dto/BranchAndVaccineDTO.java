package com.vaccnow.vaccservice.dto;

import java.util.ArrayList;
import java.util.List;

public class BranchAndVaccineDTO {

	private int branchId;
	private String branchName;
	private String branchCity;
	private String branchAddress;
	
	/*
	 * private int VaccineId; private String VaccineName; private String
	 * VaccineDesc;
	 */
	private List<VaccineDTO> vaccineList=new ArrayList<>();

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

	/*
	 * public int getVaccineId() { return VaccineId; }
	 * 
	 * public void setVaccineId(int vaccineId) { VaccineId = vaccineId; }
	 * 
	 * public String getVaccineName() { return VaccineName; }
	 * 
	 * public void setVaccineName(String vaccineName) { VaccineName = vaccineName; }
	 * 
	 * public String getVaccineDesc() { return VaccineDesc; }
	 * 
	 * public void setVaccineDesc(String vaccineDesc) { VaccineDesc = vaccineDesc; }
	 */

	/*
	 * public long getAvailableNo() { return availableNo; }
	 * 
	 * public void setAvailableNo(long availableNo) { this.availableNo =
	 * availableNo; }
	 */

	public List<VaccineDTO> getVaccineList() {
		return vaccineList;
	}

	public void setVaccineList(List<VaccineDTO> vaccineList) {
		this.vaccineList = vaccineList;
	}
	
	
}
