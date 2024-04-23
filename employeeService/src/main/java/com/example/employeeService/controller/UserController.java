package com.example.employeeService.controller;


import com.example.employeeService.domain.Employee;
import com.example.employeeService.domain.User;
import com.example.employeeService.service.EmployeeService;
import com.example.employeeService.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if(userService.saveUser(user)!=null){
            return new ResponseEntity<>("User Registered Successfully", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Something bad happened", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
