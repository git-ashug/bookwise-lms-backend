package com.bookwise.backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookwise.backend.dao.PaymentRepository;
import com.bookwise.backend.entities.Payment;
import com.bookwise.backend.requestmodels.PaymentInfoRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
@Transactional
public class PaymentService {

	private PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository, @Value("${stripe.key.secret}") String secretKey) {
		this.paymentRepository = paymentRepository;
		Stripe.apiKey = secretKey;
	}
	
	public PaymentIntent createPaymentIntent(PaymentInfoRequest paymentInfoRequest) throws StripeException{
		List<String> paymentMethods = new ArrayList<>();
		paymentMethods.add("card");
		
		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentInfoRequest.getAmount());
		params.put("currency", paymentInfoRequest.getCurrency());
		params.put("payment_method_types", paymentMethods);
		
		return PaymentIntent.create(params);
	}
	
	public String stripePaymentComplete(String userEmail) throws Exception{
		Payment payment = paymentRepository.findByUserEmail(userEmail);
		
		if(payment == null) {
			throw new Exception("Payment information is missing");
		}
		payment.setAmount(0.0);
		paymentRepository.save(payment);
		return "Payment Complete";
	}
}
