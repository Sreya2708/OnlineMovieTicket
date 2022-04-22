package com.example.MovieSPE.Controller;

import com.example.MovieSPE.Model.Admin;
import com.example.MovieSPE.Service.Admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin")
    public ResponseEntity<Boolean> checkAdmin(@RequestBody Admin admin) {
        return new ResponseEntity<Boolean>(adminService.checkAdmin(admin), HttpStatus.OK);
    }
}
