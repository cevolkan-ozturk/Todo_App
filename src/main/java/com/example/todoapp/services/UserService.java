package com.example.todoapp.services;

import com.example.todoapp.dto.UserDto;
import com.example.todoapp.entity.User;

import java.util.List;

public interface UserService {

    public User findUserByEmail (String email);

    public void saveUser(UserDto userDto);

    List<UserDto> findAllUsers();

}
