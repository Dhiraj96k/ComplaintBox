package com.SmartComplaintBox.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartComplaintBox.Entities.User;

public interface UserCrud extends JpaRepository<User, Integer> {
	
	Optional<User> findByuserEmailAndUserPassword(String userEmail, String UserPassword);
	
}