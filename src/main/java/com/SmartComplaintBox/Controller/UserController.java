package com.SmartComplaintBox.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SmartComplaintBox.Dao.ComplaintCrud;
import com.SmartComplaintBox.Dao.UserCrud;
import com.SmartComplaintBox.Entities.Complaint;
import com.SmartComplaintBox.Entities.User;

@RestController
public class UserController {

	@Autowired
	UserCrud UserOperation;
	
	@Autowired
	ComplaintCrud ComplaintOper;

	@PostMapping("/AddUser")
	public ResponseEntity<String> AddUser(@RequestBody User user) {
		try {
			UserOperation.save(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error In Creating User :" + e.getMessage());
		}
	}

	@GetMapping("/GetUser")
	public ResponseEntity<String> GetUser() {
		try {
			List<User> users = UserOperation.findAll();
			if (users == null) {
				return ResponseEntity.ofNullable("No User Found");
			} else {
				users.forEach(user->System.out.println(user));
				return ResponseEntity.status(HttpStatus.OK).body("Users Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
