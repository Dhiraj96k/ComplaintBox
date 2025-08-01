package com.SmartComplaintBox.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	private String adminid ;
	
    private String adminpass ;
    
    private String admingmail ;
    
    private long adminnumber ;
}
