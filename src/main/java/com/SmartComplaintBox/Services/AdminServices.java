package com.SmartComplaintBox.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SmartComplaintBox.Dao.AdminCrud;
import com.SmartComplaintBox.Entities.Admin;

@Service
public class AdminServices {

    @Autowired
    private AdminCrud adminCrud;

    public Admin verifyAdmin(String email, String password) {
        return adminCrud.findByAdmingmailAndAdminpass(email, password);
    }
}
