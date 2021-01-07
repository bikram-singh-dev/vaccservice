package com.vaccnow.vaccservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaccnow.vaccservice.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
