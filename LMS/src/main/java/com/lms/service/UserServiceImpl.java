package com.lms.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.exception.BookException;
import com.lms.exception.UserException;
import com.lms.model.Book;
import com.lms.model.User;
import com.lms.model.UserDto;
import com.lms.repository.BookRepo;
import com.lms.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BookRepo bookRepo;

	@Override
	public User addUser(UserDto userDto) throws UserException {
		
		User user = new User();
		
		user.setName(userDto.getName());
		
		User user2 = userRepo.save(user);
		
		if(user2==null)
			throw new UserException("InValid");
		
		return user2;
		
	}

	@Override
	public User issueBook(Integer userId, Integer bookId) throws UserException, BookException {
		
		Optional<User> userOpt = userRepo.findById(userId);
		
		if(userOpt.isEmpty())
			throw new UserException("Invalid User data");
		
		User user = userOpt.get();
		
		Optional<Book> bookOpt = bookRepo.findById(bookId);
		
		if(bookOpt.isEmpty())
			throw new BookException("Invalid Book");
		
		Book book = bookOpt.get();
		
		book.setIssueDate(LocalDate.now());
		
		user.getBooks().add(book);
		
		return userRepo.save(user);
		
	}

	@Override
	public User returnBook(Integer userId, Integer bookId,LocalDate returnDate) throws UserException, BookException {
		
		Optional<User> userOpt = userRepo.findById(userId);
		
		if(userOpt.isEmpty())
			throw new UserException("Invalid User data");
		
		User user = userOpt.get();
		
		Optional<Book> bookOpt = bookRepo.findById(bookId);
		
		if(bookOpt.isEmpty())
			throw new BookException("Invalid Book");
		
		Book book = bookOpt.get();
		
		book.setReturnDate(returnDate);
		
		Period period = Period.between(book.getIssueDate(), book.getReturnDate());
		
		book.setNoOfDays(period.getDays());
		
		List<Book> books = user.getBooks();
		
		books.remove(book);
		
		Integer cost = 0;
		
		if(period.getDays() > 4) {
			cost = period.getDays()*5;
		}
		
		book.setPenalty(cost);
		
		user.setBooks(books);
		
		return userRepo.save(user);
		
	}

}
