package com.SmartComplaintBox.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartComplaintBox.Entities.User;

public interface UserCrud extends JpaRepository<User, Integer>{

}
