package com.SmartComplaintBox.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SmartComplaintBox.Entities.Admin;

@Repository
public interface AdminCrud extends JpaRepository<Admin, String> {
    Admin findByAdmingmailAndAdminpass(String admingmail, String adminpass);
}
