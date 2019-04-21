package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User saveUser(User u);
    User updateUser(User u);
    void deleteUserById(Long id);
    void deleteAllUsers();
}
