package com.vaccnow.vaccservice.dto;

public class PaymentDTO {
	
	private long paymentId;
	private String genPaymentId;
	private String genSchedId;
	private String paymentType;
	private String desc;
	private String paymentStatus;
	private long phone;
	private String email;
	
	public String getGenPaymentId() {
		return genPaymentId;
	}
	public void setGenPaymentId(String genPaymentId) {
		this.genPaymentId = genPaymentId;
	}
	public String getGenSchedId() {
		return genSchedId;
	}
	public void setGenSchedId(String genSchedId) {
		this.genSchedId = genSchedId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	
}
