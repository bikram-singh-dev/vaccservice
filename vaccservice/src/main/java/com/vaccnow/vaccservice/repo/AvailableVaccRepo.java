package com.vaccnow.vaccservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccservice.entity.AvailableVacc;

@Repository
public interface AvailableVaccRepo extends JpaRepository<AvailableVacc, Integer> {

	@Query("SELECT av FROM AvailableVacc av JOIN FETCH av.branch b JOIN FETCH av.vaccine v where av.availableNo>=?1 ORDER BY b.id")
	public List<AvailableVacc> getVaccByAvailablility(long minAvailableNo);
	
	@Query("SELECT av FROM AvailableVacc av JOIN FETCH av.branch b JOIN FETCH av.vaccine v where av.availableNo>=?1 AND b.id=?2 ORDER BY b.id")
	public List<AvailableVacc> getVaccByAvailablilityAndBranch(long minAvailableNo,int branchId);
	
	@Query("SELECT av FROM AvailableVacc av JOIN FETCH av.branch b JOIN FETCH av.vaccine v where av.availableNo>=?1 AND b.id=?2 AND v.id=?3 ORDER BY b.id")
	public List<AvailableVacc> getVaccByAvailablilityAndBranchAndVaccine(long minAvailableNo,int branchId, int vaccinId);
}
