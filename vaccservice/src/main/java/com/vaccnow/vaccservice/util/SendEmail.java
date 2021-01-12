package com.vaccnow.vaccservice.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendEmail implements Runnable {

	private String email;	
	private String message;
	private String subject;

	@Override
	public void run() {
		System.out.println("Sending email to: "+email);
		System.out.println("Email subject: "+subject);
		System.out.println("Email message: "+message);
		System.out.println("Email sent");
	}

}
