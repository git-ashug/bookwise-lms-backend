package com.bookwise.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookwise.backend.requestmodels.ReviewRequest;
import com.bookwise.backend.service.ReviewService;
import com.bookwise.backend.utils.JWTExtractor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService= reviewService;
	}
	
	@GetMapping("/secure/user/book")
	public Boolean userReviewListed(@RequestHeader(value = "Authorization") String token, @RequestParam Long bookId) throws Exception {
		String userEmail = JWTExtractor.payloadJWTExtraction(token, "\"sub\"");
		if(userEmail == null) {
			throw new Exception("User email is missing");
		}
		return reviewService.userReviewListed(userEmail, bookId);
	}
	
	@PostMapping("/secure")
	public void postReview(@RequestHeader(value = "Authorization") String token, 
			@RequestBody ReviewRequest reviewRequest) throws Exception {
		String userEmail = JWTExtractor.payloadJWTExtraction(token, "\"sub\"");
		if(userEmail == null) {
			throw new Exception("User email is missing");
		}
		reviewService.postReview(userEmail, reviewRequest);
	}
}
