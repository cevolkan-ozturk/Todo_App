package com.example.todoapp.controller;


import com.example.todoapp.entity.User;
import com.example.todoapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public User getUserById(Integer userId)
    {
       return this.userService.findByUserId(userId);
    }


    @DeleteMapping ("/{userId}")
    public void deleteUser(Integer userId)
    {
        this.userService.deleteUser(userId);
    }

    @GetMapping("/list")
    public List<User> getUserAll()
    {
        return this.userService.getAllUsers();
    }

}