package com.example.todoapp.repository;

import com.example.todoapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);


}
