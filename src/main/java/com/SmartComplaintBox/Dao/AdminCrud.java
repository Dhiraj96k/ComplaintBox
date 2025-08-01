package com.SmartComplaintBox.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SmartComplaintBox.Entities.Admin;

public interface AdminCrud extends JpaRepository<Admin, String> {

}
