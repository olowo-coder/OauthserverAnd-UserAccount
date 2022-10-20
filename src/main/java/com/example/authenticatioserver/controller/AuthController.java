package com.example.authenticatioserver.controller;

import com.example.authenticatioserver.entity.User;
import com.example.authenticatioserver.entity.UserModel;
import com.example.authenticatioserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserModel userModel) {
        return userService.registerUser(userModel);
    }

    @GetMapping("/test")
    public String test(){
        return "Testing";
    }

    @GetMapping("/access")
    public String access(){
        return "Access";
    }
}
