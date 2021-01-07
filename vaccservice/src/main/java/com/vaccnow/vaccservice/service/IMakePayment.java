package com.vaccnow.vaccservice.service;

import com.vaccnow.vaccservice.dto.PaymentDTO;

public interface IMakePayment {

	public PaymentDTO makePayment(PaymentDTO paymentDTO);
}
