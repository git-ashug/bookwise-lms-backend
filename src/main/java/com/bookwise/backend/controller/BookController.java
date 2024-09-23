package com.bookwise.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookwise.backend.entities.Book;
import com.bookwise.backend.service.BookService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/secure/currentloans/count")
	public int currentLoansCount() {
		String userEmail = "testuser@email.com";
		return bookService.currenLoansCount(userEmail);
	}
	
	@GetMapping("/secure/ischeckedout/byuser")
	public Boolean checkoutBookByUser(@RequestParam Long bookId) {
		String userEmail = "testuser@email.com";
		return bookService.checkoutBookByUser(userEmail, bookId);
	}
	
	@PutMapping("/secure/checkout")
	public Book checkoutBook(@RequestParam Long bookId) throws Exception{
		String userEmail = "testuser@email.com";
		return bookService.checkoutBook(userEmail, bookId);
	}
}
