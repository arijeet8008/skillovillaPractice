package com.lms.service;

import java.time.LocalDate;

import com.lms.exception.BookException;
import com.lms.exception.UserException;
import com.lms.model.User;
import com.lms.model.UserDto;

public interface UserService {

	public User addUser(UserDto userDto) throws UserException;
	
	public User issueBook(Integer userId,Integer bookId) throws UserException,BookException;
	
	public User returnBook(Integer userId,Integer bookId,LocalDate returnDate) throws UserException,BookException;
	
}
