package com.bookwise.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookwise.backend.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Payment findByUserEmail(String userEmail);
}
