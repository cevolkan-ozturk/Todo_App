package com.example.todoapp.controller;


import com.example.todoapp.models.TodoItem;
import com.example.todoapp.models.User;
import com.example.todoapp.repository.TodoItemRepository;
import com.example.todoapp.repository.UserRepository;
import com.example.todoapp.request.AddTodoItemRequest;
import com.example.todoapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final TodoItemRepository todoItemRepository;


    @GetMapping("{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PostMapping("{userId}/todos")
    public void addTodoItem(@PathVariable Long userId, @RequestBody AddTodoItemRequest todoItemRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException());
        TodoItem todoItem = new TodoItem();
        todoItem.setDescription(todoItemRequest.getDescription());
        user.getTodoItems().add(todoItem);
        todoItemRepository.save(todoItem);
        userRepository.save(user);
    }

    @GetMapping("{userId}/todos/{todoItemId}")
    public void getTodo(@PathVariable Long userId, @PathVariable Long todoItemId){
        User user = userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow(()->new NoSuchElementException());
        user.getTodoItems().add(todoItem);
        todoItemRepository.findById(todoItemId);
    }

    @PostMapping("todos/{todoItemId}")
    public void toggleTodoItemCompleted(@PathVariable Long todoItemId) {
        TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow(() -> new NoSuchElementException());
        todoItem.setCompleted(!todoItem.getCompleted());
        todoItemRepository.save(todoItem);
    }

    @DeleteMapping("{userId}/todos/{todoItemId}")
    public void deleteTodo(@PathVariable Long userId, @PathVariable Long todoItemId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        TodoItem todoItem = todoItemRepository.findById(todoItemId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoItems().remove(todoItem);
        todoItemRepository.delete(todoItem);
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        userRepository.delete(user);
    }

}