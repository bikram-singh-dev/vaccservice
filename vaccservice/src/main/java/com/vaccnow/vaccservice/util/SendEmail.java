package com.vaccnow.vaccservice.util;

public class SendEmail implements Runnable {

	private String email;
	private String messgae;
	
	public SendEmail(String email, String messgae) {
		super();
		this.email = email;
		this.messgae = messgae;
	}

	@Override
	public void run() {
		System.out.println("Sending email to: "+email);
		System.out.println("Email message: "+messgae);
		System.out.println("Email sent");
	}

}
