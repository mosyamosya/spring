package com.dubinetska.demo1.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @PostMapping("/register")
    public String registerUser(@RequestBody String user) {
        return "User registered successfully.";
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "User deleted successfully.";
    }
    
    @PostMapping("/login")
    public String loginUser(@RequestBody String credentials) {
        return "User logged in successfully.";
    }
}