package com.example.MovieSPE.Service.Admin;

import com.example.MovieSPE.Model.Admin;
import com.example.MovieSPE.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    public boolean checkAdmin(Admin admin) {
        if(adminRepository.existsById(admin.getId())) {
            Admin currentAdmin = adminRepository.findById(admin.getId()).get();
            return currentAdmin.getPassword().equals(admin.getPassword());
        }
        else
            return false;
    }
}
