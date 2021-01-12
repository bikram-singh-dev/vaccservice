package com.vaccnow.vaccservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentDTO {
	
	private long paymentId;
	private String genPaymentId;
	@NotNull(message = "Generated Schedule Id cannot be null")
	private String genSchedId;
	@NotNull(message = "Payment type cannot be null")
	@Pattern(regexp = "Cash|Credit|Fawry",message = "Payment type supported: Cash, Credit & Fawry")
	private String paymentType;
	private String desc;
	private String paymentStatus;
	@NotNull(message = "Phone number cannot be null")
	private long phone;
	@NotNull(message = "Payment type cannot be null")
	@Email
	private String email;
		
}
