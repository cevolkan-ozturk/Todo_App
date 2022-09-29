package com.example.todoapp.services;

import com.example.todoapp.dto.UserDto;
import com.example.todoapp.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User findUserByEmail (String email);

    public void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();

    public int getLoggedUserId();

    User findByUserId(int userId);


    public void deleteUser(int userId);

    List<User> getAllUsers();



}
