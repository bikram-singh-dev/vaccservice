package com.vaccnow.vaccservice.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ScheduleDTO {

	private long id;
	private String genSchedId;	
	@NotNull(message = "Time slot cannot be null")
	private LocalDateTime timeSlot;
	@NotNull(message = "Branch Id cannot be null")
	private int branchId;
	@NotNull(message = "Vaccine Id cannot be null")
	private int vaccineId;
	private long paymentId;
	private String schedStatus;
	
}
