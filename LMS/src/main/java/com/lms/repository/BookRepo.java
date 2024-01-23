package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
