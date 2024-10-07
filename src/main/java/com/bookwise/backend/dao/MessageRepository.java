package com.bookwise.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookwise.backend.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
