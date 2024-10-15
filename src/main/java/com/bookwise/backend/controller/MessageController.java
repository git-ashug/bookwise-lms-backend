package com.bookwise.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookwise.backend.entities.Message;
import com.bookwise.backend.requestmodels.AdminQuestionRequest;
import com.bookwise.backend.service.MessagesService;
import com.bookwise.backend.utils.JWTExtractor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

	private MessagesService messagesService;

	public MessageController(MessagesService messagesService) {
		this.messagesService = messagesService;
	}
	
	@PostMapping("/secure/add/message")
	public void postMessage(@RequestHeader(value = "Authorization") String token, @RequestBody Message message) {
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		messagesService.postMessage(message, userEmail);
	}
	
	@PutMapping("/secure/admin/message")
	public void putMessage(@RequestHeader(value="Authorization")String token, @RequestBody AdminQuestionRequest adminQuestionRequest) throws Exception{
		String admin = JWTExtractor.payloadJWTExtraction(token,"\"userType\"");
		if(admin == null || !admin.equals("admin")) {
			throw new Exception("Administration page only");
		}
		String adminEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		messagesService.putMessage(adminQuestionRequest, adminEmail);
	}
	
	
}
