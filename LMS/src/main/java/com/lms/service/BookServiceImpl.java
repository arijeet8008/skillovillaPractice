package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.exception.BookException;
import com.lms.model.Book;
import com.lms.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book addBook(Book book) throws BookException {
		
		Book book2 = bookRepo.save(book);
		
		if(book2==null)
			throw new BookException("Invalid format....");
		
		return book2;
		
	}
	
}
