package com.SmartComplaintBox.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid ;
	
    private String userName ;
    
    private long userMob;
    
    private String userEmail;
    
    private String userAdd ;
    
    private String userGender;
    
    private String UserPassword;
    
}
