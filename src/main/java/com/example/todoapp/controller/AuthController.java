package com.example.todoapp.controller;


import com.example.todoapp.dto.UserDto;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {

        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult bindingResult, Model model) {
        if (userService.findUserByEmail(user.getEmail()) != null) {
            bindingResult.rejectValue("email", null, "Bu email adresine kayıtılı bir kullanıcı var ! ");
        }
        ;
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/register?success";


    }
        @GetMapping("/users")
                public String listRegisteredUsers (Model model) {
            List<UserDto> users = userService.findAllUsers();
            model.addAttribute("users", users);
            return "users";
        }

    }


