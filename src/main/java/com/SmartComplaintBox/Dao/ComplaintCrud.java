package com.SmartComplaintBox.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartComplaintBox.Entities.Complaint;

public interface ComplaintCrud extends JpaRepository<Complaint, Integer>{
	
}
