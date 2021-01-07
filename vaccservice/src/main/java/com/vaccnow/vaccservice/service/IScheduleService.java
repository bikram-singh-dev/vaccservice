package com.vaccnow.vaccservice.service;

import java.util.List;

import com.vaccnow.vaccservice.dto.PaymentDTO;
import com.vaccnow.vaccservice.dto.PaymentReplyDTO;
import com.vaccnow.vaccservice.dto.ScheduleDTO;

public interface IScheduleService {

	public String addSchedule(ScheduleDTO scheduleDTO);
	
	public int schedCheck(ScheduleDTO scheduleDTO, List<String> schedStatus);
	
	public PaymentReplyDTO confirmSched(PaymentDTO paymentDTO);
}
