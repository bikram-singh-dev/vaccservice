package com.vaccnow.vaccservice.service;

import java.time.LocalDate;
import java.util.List;

import com.vaccnow.vaccservice.dto.ReportBranchVaccineDTO;

public interface IReportingService {

	public List<ReportBranchVaccineDTO> getAppliedVaccPerBranch(int branchId);

	public List<ReportBranchVaccineDTO> getVaccAppliedBetweenDates(LocalDate startDate, LocalDate endDate);

	public List<ReportBranchVaccineDTO> getVaccConfirmedBetweenDates(LocalDate startDate, LocalDate endDate);
}
