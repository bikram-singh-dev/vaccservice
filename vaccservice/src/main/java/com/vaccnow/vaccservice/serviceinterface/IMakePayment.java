package com.vaccnow.vaccservice.serviceinterface;

import com.vaccnow.vaccservice.dto.PaymentDTO;

public interface IMakePayment {

	public PaymentDTO makePayment(PaymentDTO paymentDTO);
}
