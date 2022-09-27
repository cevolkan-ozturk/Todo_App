package com.example.todoapp.services;

import com.example.todoapp.dto.UserDto;
import com.example.todoapp.entity.Role;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.RoleRepository;
import com.example.todoapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    //private static BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        //this.passwordEncoder = passwordEncoder;
    }




    @Override
    public void saveUser (UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());

    }

    private UserDto mapToUserDto (User user){
        UserDto userDto = new UserDto();
        String[] str = user.getUsername().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;

    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
