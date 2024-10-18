package com.bookwise.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookwise.backend.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	Page<Review> findByBookId(@RequestParam("bookId") Long bookId, Pageable pageable);
	
	Review findByUserEmailAndBookId(String userEmail, Long bookId);
	
	@Modifying
	@Query("delete from Review where bookId in :book_id")
	void deleteAllByBookId(@Param("book_id") Long bookId);
}
