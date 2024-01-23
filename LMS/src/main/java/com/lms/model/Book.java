package com.lms.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId; 
	
	private String bookName;
	
	@JsonFormat(shape = Shape.STRING,pattern = "yyyy-MM-dd")
	@JsonIgnore
	private LocalDate issueDate;
	
	@JsonFormat(shape = Shape.STRING,pattern = "yyyy-MM-dd")
	@JsonIgnore
	private LocalDate returnDate;
	
	@JsonIgnore
	private long noOfDays;
	
	@JsonIgnore
	private Integer penalty;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, String bookName, LocalDate issueDate, LocalDate returnDate, long noOfDays,
			Integer penalty) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.noOfDays = noOfDays;
		this.penalty = penalty;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	public long getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(long l) {
		this.noOfDays = l;
	}
	
	public Integer getPenalty() {
		return penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", noOfDays=" + noOfDays + ", penalty=" + penalty + "]";
	}

}
