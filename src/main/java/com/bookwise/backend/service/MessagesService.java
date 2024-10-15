package com.bookwise.backend.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookwise.backend.dao.MessageRepository;
import com.bookwise.backend.entities.Message;
import com.bookwise.backend.requestmodels.AdminQuestionRequest;

@Service
@Transactional
public class MessagesService {

	private MessageRepository messageRepository;
	
	public MessagesService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public void postMessage(Message messageRequest, String userEmail) {
		Message message = new Message(messageRequest.getTitle(), messageRequest.getQuestion());
		message.setUserEmail(userEmail);
		messageRepository.save(message);
	}
	
	public void putMessage(AdminQuestionRequest adminQuestionRequest, String adminEmail) throws Exception {
		Optional<Message> message = messageRepository.findById(adminQuestionRequest.getId());
		if(!message.isPresent()) {
			throw new Exception("Message not found");
		}
		message.get().setAdminEmail(adminEmail);
		message.get().setResponse(adminQuestionRequest.getResponse());
		message.get().setClosed(true);
		messageRepository.save(message.get());
	}
}
