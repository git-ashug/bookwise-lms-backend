package com.bookwise.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookwise.backend.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
