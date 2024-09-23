package com.bookwise.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookwise.backend.entities.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
	
	Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
	
	List<Checkout> findBooksByUserEmail(String userEmail);

}
