package com.vaccnow.vaccservice.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the ScheduleDTO")
public class ScheduleDTO {

	private long id;
	private String genSchedId;
	@ApiModelProperty(notes = "Required and date should start from tomorrow and time should be in 15mins slot")
	private LocalDateTime timeSlot;
	@ApiModelProperty(notes = "Required")
	private int branchId;
	@ApiModelProperty(notes = "Required")
	private int vaccineId;
	private long paymentId;
	private String schedStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public String getSchedStatus() {
		return schedStatus;
	}
	public void setSchedStatus(String schedStatus) {
		this.schedStatus = schedStatus;
	}
	
}
