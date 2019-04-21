package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.User;
import com.example.quizWithSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getQuizzes() {
        return this.userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User u) {
        return this.userService.saveUser(u);
    }

    @PutMapping
    public User updateUser(@RequestBody User u) {
        return this.userService.updateUser(u);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);
    }

    @DeleteMapping
    public void deleteAllUsers() {
        this.userService.deleteAllUsers();
    }
}
