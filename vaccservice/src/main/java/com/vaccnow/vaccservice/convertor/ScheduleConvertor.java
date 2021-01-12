package com.vaccnow.vaccservice.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.vaccnow.vaccservice.dto.ReportBranchVaccineDTO;
import com.vaccnow.vaccservice.entity.Schedule;

@Component
public class ScheduleConvertor {
	
	public ReportBranchVaccineDTO entityToDTO(Schedule schedule){
		ReportBranchVaccineDTO reportBranchVaccineDTO = new ReportBranchVaccineDTO();
		reportBranchVaccineDTO.setBranchAddress(schedule.getBranch().getAddress());
		reportBranchVaccineDTO.setBranchCity(schedule.getBranch().getCity());
		reportBranchVaccineDTO.setBranchId(schedule.getBranch().getId());
		reportBranchVaccineDTO.setBranchName(schedule.getBranch().getName());
		
		reportBranchVaccineDTO.setGenSchedId(schedule.getGenSchedId());
		reportBranchVaccineDTO.setTimeSlot(schedule.getTimeSlot());
		reportBranchVaccineDTO.setVaccineDesc(schedule.getVaccine().getDesc());
		reportBranchVaccineDTO.setVaccineId(schedule.getVaccine().getId());
		reportBranchVaccineDTO.setVaccineName(schedule.getVaccine().getName());
		
		return reportBranchVaccineDTO;
	}

	public List<ReportBranchVaccineDTO> entityToDTOList(List<Schedule> schedule){
		
		return schedule.stream().map(sched->entityToDTO(sched)).collect(Collectors.toList());
		
	}
}
