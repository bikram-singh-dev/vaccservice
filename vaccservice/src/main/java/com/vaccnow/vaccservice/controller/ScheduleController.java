package com.vaccnow.vaccservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccnow.vaccservice.dto.PaymentDTO;
import com.vaccnow.vaccservice.dto.PaymentReplyDTO;
import com.vaccnow.vaccservice.dto.ScheduleDTO;
import com.vaccnow.vaccservice.service.IScheduleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ScheduleController {
	
	@Autowired
	IScheduleService scheduleService;

	@PostMapping("/schedule/add")
	@ApiOperation(value = "Adds a schedule and returns either reference Id for the slot or error message")
	public String addSchedule(@RequestBody ScheduleDTO scheduleDTO){
		
		return scheduleService.addSchedule(scheduleDTO);
		
	}
	
	@PostMapping("/makePayment")
	@ApiOperation(value = "Makes payment as per payment type and returns either generated payId or error message")
	public PaymentReplyDTO makePayment(@RequestBody PaymentDTO paymentDTO){
		
		return scheduleService.confirmSched(paymentDTO);
		
	}
}
