package com.example.todoapp.controller;

import com.example.todoapp.dto.UserDto;
import com.example.todoapp.entity.User;
import com.example.todoapp.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RegistrationController {


    private UserService userService;

    @PostMapping("/add")
    public void registerUser(@RequestBody User user) {
        //this.userService.saveUser(user);
    }
}
