package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.User;
import com.example.quizWithSpring.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserRep userRep;

    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    public User saveUser(User u) {
        return userRep.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRep.save(u);
    }

    @Override
    public void deleteUserById(Long id) {
        userRep.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRep.deleteAll();
    }
}
