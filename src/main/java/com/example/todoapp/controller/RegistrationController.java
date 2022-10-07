package com.example.todoapp.controller;

import com.example.todoapp.dto.UserDto;
import com.example.todoapp.models.User;
import com.example.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user-register")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public void registerUser(@RequestBody UserDto userdto) {
        this.userService.saveUser(userdto);
    }

    @GetMapping("/list")
    public List<User> getUserAll()
    {
        return this.userService.getAllUsers();
    }
}
