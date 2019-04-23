package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.Quiz;
import com.example.quizWithSpring.service.QuizService;
import com.example.quizWithSpring.util.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getQuizzes() {
        return this.quizService.findAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return this.quizService.findQuizById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz saveQuiz(@RequestBody Quiz q) {
        return this.quizService.saveQuiz(q);
    }

    @PutMapping
    public Quiz updateQuiz(@RequestBody Quiz q) {
        return this.quizService.updateQuiz(q);
    }

    @DeleteMapping("/{id}")
    public void deleteQuizById(@PathVariable Long id) {
        this.quizService.deleteQuizById(id);
    }

    @DeleteMapping
    public void deleteAllQuizzes() {
        this.quizService.deleteAllQuizzes();
    }
}
