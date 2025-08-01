package com.SmartComplaintBox.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SmartComplaintBox.Dao.AdminCrud;
import com.SmartComplaintBox.Entities.Admin;

@RestController
public class AdminController {
	
	@Autowired
	AdminCrud AdminOperation;

	
	@PostMapping("/AddAdmin")
	public ResponseEntity<String> AddAdmin(@RequestBody Admin admin){
		try {
			AdminOperation.save(admin);
			return ResponseEntity.status(HttpStatus.CREATED).body("Admin Created Succesfull");
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Admin Not Created");
		}
	}
	
	@GetMapping("/GetAdmin")
	public ResponseEntity<String> GetAdmin(){
		try {
			List<Admin> admins = AdminOperation.findAll();
			admins.forEach(admin -> System.out.println(admin));
			return ResponseEntity.status(HttpStatus.OK).body("Admins Found");
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}
