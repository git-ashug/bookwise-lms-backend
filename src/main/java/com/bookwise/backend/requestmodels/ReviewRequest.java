package com.bookwise.backend.requestmodels;

import java.util.Optional;

import lombok.Data;

@Data
public class ReviewRequest {

	private Double rating;
	
	private Long bookId;
	
	private Optional<String> reviewDescription;	//as review description is optional on frontend
}
