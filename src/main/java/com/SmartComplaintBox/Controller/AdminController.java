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
import com.SmartComplaintBox.Services.AdminServices;

@RestController
public class AdminController {
	
	@Autowired
	AdminCrud AdminOperation;
	
	@Autowired
	AdminServices adminService;

	
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
	public ResponseEntity<?> GetAdmin(){
		try {
			List<Admin> admins = AdminOperation.findAll();
			admins.forEach(System.out::println); // O.W. admins.forEach(admin -> System.out.println(admin));
			return ResponseEntity.status(HttpStatus.OK).body(admins);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/verify")
    public ResponseEntity<?> verifyAdmin(@RequestBody Admin admin) {
        Admin foundAdmin = adminService.verifyAdmin(admin.getAdmingmail(), admin.getAdminpass());
        System.out.println(foundAdmin); // need to give full body data of admin if verified successfully
        if (foundAdmin != null) {
            return ResponseEntity.ok("Admin Verified Successfully!");
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials!");
        }
    }
	
}
