package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.Quiz;
import com.example.quizWithSpring.model.User;
import com.example.quizWithSpring.service.QuizService;
import com.example.quizWithSpring.service.UserService;
import com.example.quizWithSpring.util.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<User> getQuizzes() {
        return this.userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id,
                            @RequestHeader(name = "user-login") String login,
                            @RequestHeader(name = "user-password") String password) {

        if(!userService.checkUser(id,login,password)){
            return null;
        }
        return this.userService.findUserById(id);
    }
    @GetMapping("/{id}/quizzes")
    public List<Quiz> getQuizByUser(@PathVariable Long id) {
        return this.userService.getQuizzes(id);
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

    @PostMapping("/{id}/test")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean goodLuck(@PathVariable Long id,
                            @RequestBody Test t) {
        if (userService.checkAnswer(t.getId(), t.getAnswer(), id)) {
            return true;
        }
        return false;
    }
}
