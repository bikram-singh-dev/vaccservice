package com.vaccnow.vaccservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
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
	
}
