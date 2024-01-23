package com.lms.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.exception.BookException;
import com.lms.exception.UserException;
import com.lms.model.User;
import com.lms.model.UserDto;
import com.lms.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("")
	public ResponseEntity<User>addUser(@RequestBody UserDto user) throws UserException{
		
		return new ResponseEntity<User>(userService.addUser(user),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/issue/{userId}/{bookId}")
	public ResponseEntity<User>issueBook(@PathVariable Integer userId,@PathVariable Integer bookId) throws UserException, BookException{
		
		User user= userService.issueBook(userId, bookId);
		
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/return/{userId}/{bookId}/{date}")
	public ResponseEntity<User>returnBook(@PathVariable Integer userId,@PathVariable Integer bookId,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) throws UserException, BookException{
		
		User user= userService.returnBook(userId, bookId, date);
		
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
		
	}
	
}
