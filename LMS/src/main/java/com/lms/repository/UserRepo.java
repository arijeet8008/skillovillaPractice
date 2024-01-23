package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.model.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
