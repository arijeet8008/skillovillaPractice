package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.exception.BookException;
import com.lms.model.Book;
import com.lms.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("")
	public ResponseEntity<Book> addBook(@RequestBody Book book) throws BookException{
		
		return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
		
	}
	
}
