package com.bookwise.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookwise.backend.entities.Book;
import com.bookwise.backend.responsemodels.ShelfCurrentLoansResponse;
import com.bookwise.backend.service.BookService;
import com.bookwise.backend.utils.JWTExtractor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/secure/currentloans/count")	
	public int currentLoansCount(@RequestHeader(value="Authorization") String token) {	// accessing Access token sent from frontend
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		return bookService.currenLoansCount(userEmail);
	}
	
	@GetMapping("/secure/ischeckedout/byuser")
	public Boolean checkoutBookByUser(@RequestHeader(value="Authorization") String token, @RequestParam Long bookId) {
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		return bookService.checkoutBookByUser(userEmail, bookId);
	}
	
	@PutMapping("/secure/checkout")
	public Book checkoutBook(@RequestHeader(value="Authorization") String token, @RequestParam Long bookId) throws Exception{
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		return bookService.checkoutBook(userEmail, bookId);
	}
	
	@GetMapping("/secure/currentloans")
	public List<ShelfCurrentLoansResponse> currentLoans(@RequestHeader(value="Authorization") String token) throws Exception{
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		return bookService.currentLoans(userEmail);
	}
	
	@PutMapping("/secure/return")
	public void returnBook(@RequestHeader(value="Authorization") String token, @RequestParam Long bookId) throws Exception{
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		bookService.returnBook(userEmail, bookId);
	}
	
	@PutMapping("/secure/renew/loan")
	public void renewLoan(@RequestHeader(value="Authorization") String token, @RequestParam Long bookId) throws Exception{
		String userEmail = JWTExtractor.payloadJWTExtraction(token,"\"sub\"");
		bookService.renewLoan(userEmail, bookId);
	}
}
