package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getQuestions() {
        return this.questionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return this.questionService.findQuestionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Question saveQuestion(@RequestBody Question q) {
        return this.questionService.saveQuestion(q);
    }

    @PutMapping
    public Question updateQuestion(@RequestBody Question q) {
        return this.questionService.updateQuestion(q);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable Long id) {
        this.questionService.deleteQuestionById(id);
    }

    @DeleteMapping
    public void deleteAllQuestions() {
        this.questionService.deleteAllQuestions();
    }
}
