package com.vaccnow.vaccservice.serviceimpl;

import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccnow.vaccservice.dto.PaymentDTO;
import com.vaccnow.vaccservice.entity.Payment;
import com.vaccnow.vaccservice.repo.PaymentRepo;
import com.vaccnow.vaccservice.serviceinterface.IMakePayment;

@Service
public class MakePaymentImpl implements IMakePayment {
	
	@Autowired
	private PaymentRepo paymentRepo;

	@Override
	public PaymentDTO makePayment(PaymentDTO paymentDTO) {
		System.out.println("Making payment using "+paymentDTO.getPaymentType());
		Payment payment=new Payment();		
		paymentDTO.setGenPaymentId("vaccnowPay"+LocalTime.now().toString());
		paymentDTO.setPaymentStatus("Success");
		payment.setDesc(paymentDTO.getDesc());
		payment.setEmail(paymentDTO.getEmail());
		payment.setGenPaymentId(paymentDTO.getGenPaymentId());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
		payment.setPaymentType(paymentDTO.getPaymentType());
		payment.setPhone(paymentDTO.getPhone());		
		payment=paymentRepo.saveAndFlush(payment);
		paymentDTO.setPaymentId(payment.getId());
		return paymentDTO;
	}


}
