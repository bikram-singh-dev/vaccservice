package com.vaccnow.vaccservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccservice.entity.Branch;

@Repository
public interface BranchRepo extends JpaRepository<Branch, Integer>{

	
}
