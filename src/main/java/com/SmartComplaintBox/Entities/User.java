package com.SmartComplaintBox.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid ;
	
    private String userName ;
    
    private long userMob;
    
    private String userEmail;
    
    private String userAdd ;
    
    private String userGender;
    
    private String UserPassword;
    
    // One user can have many complaints
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Complaint> complaints;
    
}
