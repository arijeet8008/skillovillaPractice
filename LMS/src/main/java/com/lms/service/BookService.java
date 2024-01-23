package com.lms.service;

import com.lms.exception.BookException;
import com.lms.model.Book;

public interface BookService {

	public Book addBook(Book book) throws BookException;
	
}
