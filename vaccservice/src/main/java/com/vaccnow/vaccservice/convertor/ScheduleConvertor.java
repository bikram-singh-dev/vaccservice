package com.vaccnow.vaccservice.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaccnow.vaccservice.dto.ReportBranchVaccineDTO;
import com.vaccnow.vaccservice.entity.Schedule;

@Component
public class ScheduleConvertor {

	public List<ReportBranchVaccineDTO> entityToDTO(List<Schedule> schedule){
		
		ReportBranchVaccineDTO reportBranchVaccineDTO;
		List<ReportBranchVaccineDTO> reportBranchVaccineDTOList=new ArrayList<>();
		for(Schedule sched:schedule) {
			reportBranchVaccineDTO=new ReportBranchVaccineDTO();
			reportBranchVaccineDTO.setBranchAddress(sched.getBranch().getAddress());
			reportBranchVaccineDTO.setBranchCity(sched.getBranch().getCity());
			reportBranchVaccineDTO.setBranchId(sched.getBranch().getId());
			reportBranchVaccineDTO.setBranchName(sched.getBranch().getName());
			
			reportBranchVaccineDTO.setGenSchedId(sched.getGenSchedId());
			reportBranchVaccineDTO.setTimeSlot(sched.getTimeSlot());
			reportBranchVaccineDTO.setVaccineDesc(sched.getVaccine().getDesc());
			reportBranchVaccineDTO.setVaccineId(sched.getVaccine().getId());
			reportBranchVaccineDTO.setVaccineName(sched.getVaccine().getName());
			reportBranchVaccineDTOList.add(reportBranchVaccineDTO);
			
		}
		return reportBranchVaccineDTOList;
		
	}
}
