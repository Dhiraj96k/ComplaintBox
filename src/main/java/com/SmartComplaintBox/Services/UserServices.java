package com.SmartComplaintBox.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SmartComplaintBox.Dao.UserCrud;
import com.SmartComplaintBox.Entities.User;

@Service
public class UserServices {
	
	@Autowired
	UserCrud userService;
	
	public User AddUser(User user) {
		return userService.save(user);
	}
	
	public List<User> GetUser() {
		return userService.findAll();
	}
	
}
