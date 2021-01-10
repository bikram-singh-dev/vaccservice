package com.vaccnow.vaccservice.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccservice.entity.Schedule;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

	@Query("SELECT s FROM Schedule s JOIN FETCH s.branch b JOIN FETCH s.vaccine v WHERE b.id=?1 AND s.timeSlot>=?2 AND s.schedStatus IN (?3) ORDER BY s.timeSlot")
	public List<Schedule> getBlockedTimeSlotByBranch(int branchId, LocalDateTime dateTime, List<String> blockedschedStatusList);
	
	@Query("SELECT s FROM Schedule s JOIN FETCH s.branch b JOIN FETCH s.vaccine v WHERE b.id=?1 AND s.timeSlot=?2 AND v.id=?3 AND s.schedStatus IN (?4)")
	public List<Schedule> getSchedCountByBranchAndVaccineAndDateTime(int branchId, LocalDateTime dateTime, int vaccineId, List<String> schedStatus);
	
	@Query("SELECT s FROM Schedule s WHERE s.genSchedId=?1")
	public List<Schedule> getSchedByGenSchedId(String genSchedId);
	
	@Query("SELECT s FROM Schedule s JOIN FETCH s.branch b JOIN FETCH s.vaccine v WHERE b.id=?1 AND s.timeSlot<CURRENT_TIMESTAMP AND s.schedStatus IN (?2) ORDER BY s.timeSlot")
	public List<Schedule> getVaccSchedByBranchAndSchedStatusTillNow(int branchId, List<String> schedStatusList);
	
	@Query("SELECT s FROM Schedule s JOIN FETCH s.branch b JOIN FETCH s.vaccine v WHERE s.timeSlot BETWEEN ?1 AND ?2 AND s.schedStatus IN (?3) ORDER BY s.timeSlot")
	public List<Schedule> getVaccSchedBySchedStatusBetweenDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime, List<String> schedStatusList);
	
}
