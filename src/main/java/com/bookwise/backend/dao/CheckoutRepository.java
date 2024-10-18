package com.bookwise.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookwise.backend.entities.Checkout;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>{
	
	Checkout findByUserEmailAndBookId(String userEmail, Long bookId);
	
	List<Checkout> findBooksByUserEmail(String userEmail);
	
	@Modifying
	@Query("delete from Checkout where bookId in :book_id")
	void deleteAllByBookId(@Param("book_id") Long bookId);

}
