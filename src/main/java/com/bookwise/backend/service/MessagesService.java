package com.bookwise.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookwise.backend.dao.MessageRepository;
import com.bookwise.backend.entities.Message;

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
}
