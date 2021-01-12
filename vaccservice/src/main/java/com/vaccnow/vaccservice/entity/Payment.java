package com.vaccnow.vaccservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String genPaymentId;
	private String paymentType;
	private String desc;
	private String paymentStatus;
	private long phone;
	private String email;
	
}
