package com.vaccnow.vaccservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String genSchedId;
	private LocalDateTime timeSlot;
	@ManyToOne
	private Branch branch;
	@ManyToOne
	private Vaccine vaccine;
	@OneToOne
	private Payment payment;
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
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getSchedStatus() {
		return schedStatus;
	}
	public void setSchedStatus(String schedStatus) {
		this.schedStatus = schedStatus;
	}
	
	
}
