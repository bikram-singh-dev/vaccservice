package com.vaccnow.vaccservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccservice.dto.PaymentDTO;
import com.vaccnow.vaccservice.dto.PaymentReplyDTO;
import com.vaccnow.vaccservice.dto.ScheduleDTO;
import com.vaccnow.vaccservice.serviceinterface.IScheduleService;


@RestController
@RequestMapping("/api")
public class ScheduleController {
	
	@Autowired
	IScheduleService scheduleService;
	

	@PostMapping("/schedule/add")
	public ResponseEntity<String> addSchedule(@Valid @RequestBody ScheduleDTO scheduleDTO){
		HttpStatus status;
		String reply=scheduleService.addSchedule(scheduleDTO);
		if(reply.contains("Slot")||reply.contains("Please"))
			status=HttpStatus.NOT_FOUND;
		else
			status=HttpStatus.OK;
		return ResponseEntity.status(status).body(reply);
		
	}
	
	@PostMapping("/make-payment")
	public ResponseEntity<PaymentReplyDTO> makePayment(@Valid @RequestBody PaymentDTO paymentDTO){
		HttpStatus status;
		PaymentReplyDTO paymentReplyDTO=scheduleService.confirmSched(paymentDTO);
		if(paymentReplyDTO.getGenPayId()!=null)
			status=HttpStatus.OK;
		else
			status=HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body(paymentReplyDTO);
		
	}
	
	
}
