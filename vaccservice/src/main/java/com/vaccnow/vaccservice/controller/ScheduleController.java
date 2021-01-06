package com.vaccnow.vaccservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
