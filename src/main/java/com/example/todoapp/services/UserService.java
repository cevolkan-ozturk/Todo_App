package com.example.todoapp.services;


import com.example.todoapp.models.User;
import com.example.todoapp.request.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationRequest userRegistrationRequest);

   /* public User findUserByEmail (String email);

    public void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();

    public int getLoggedUserId();

    User findByUserId(int userId);


    public void deleteUser(int userId);

    List<User> getAllUsers();*/



}
