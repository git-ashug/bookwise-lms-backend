package com.bookwise.backend.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookwise.backend.dao.ReviewRepository;
import com.bookwise.backend.entities.Review;
import com.bookwise.backend.requestmodels.ReviewRequest;

@Service
@Transactional
public class ReviewService {
	
	private ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
		Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
		
		if(validateReview != null) {
			throw new Exception("Review already created");
		}
		
		Review review = new Review();
		review.setBookId(reviewRequest.getBookId());
		review.setRating(reviewRequest.getRating());
		review.setUserEmail(userEmail);
		review.setDate(LocalDate.now());
		if(reviewRequest.getReviewDescription().isPresent()) {
			review.setReviewDescription(reviewRequest.getReviewDescription().map(Object::toString).orElse(null));
		}
		
		reviewRepository.save(review);
	}
	
	public Boolean userReviewListed(String userEmail, Long bookId) {
		Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, bookId);
		if(validateReview != null) {
			return true;
		}
		return false;
	}
}
