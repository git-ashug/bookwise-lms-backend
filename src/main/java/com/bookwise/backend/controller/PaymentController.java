package com.bookwise.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookwise.backend.requestmodels.PaymentInfoRequest;
import com.bookwise.backend.service.PaymentService;
import com.bookwise.backend.utils.JWTExtractor;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/payment/secure")
public class PaymentController {

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping("/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest) throws StripeException{
		PaymentIntent paymentIntent = paymentService.createPaymentIntent(paymentInfoRequest);
		String paymentStr = paymentIntent.toJson();
		
		return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
	}
	
	@PutMapping("/payment-complete")
	public ResponseEntity<String> stripePaymentComplete(@RequestHeader(value="Authorization") String token) throws Exception{
		String userEmail = JWTExtractor.payloadJWTExtraction(token, "\"sub\"");
		if(userEmail == null) {
			throw new Exception("User email is missing");
		}
		String stripePaymentCompleteStr = paymentService.stripePaymentComplete(userEmail);
		return new ResponseEntity<String>(stripePaymentCompleteStr, HttpStatus.OK);
	}
	
	
}
