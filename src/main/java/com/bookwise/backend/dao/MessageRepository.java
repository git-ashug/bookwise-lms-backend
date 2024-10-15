package com.bookwise.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookwise.backend.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

	Page<Message> findByUserEmail(@RequestParam("userEmail") String userEmail, Pageable pageable);
	
	//For admins to know all the messages pending
	Page<Message> findByClosed(@RequestParam("closed") boolean closed, Pageable pageable);
}
