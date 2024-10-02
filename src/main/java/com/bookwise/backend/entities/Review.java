package com.bookwise.backend.entities;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="review")
@Data
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="date")
	@CreationTimestamp
	private LocalDate date;
	
	@Column(name="rating")
	private Double rating;
	
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="review_description")
	private String reviewDescription;

}
