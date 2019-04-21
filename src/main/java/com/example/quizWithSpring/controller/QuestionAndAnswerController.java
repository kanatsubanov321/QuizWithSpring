package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.QuestionAndAnswer;
import com.example.quizWithSpring.service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questionAndAnswer")
public class QuestionAndAnswerController {
    @Autowired
    private QuestionAndAnswerService questionAndAnswerService;

    @GetMapping
    public List<QuestionAndAnswer> getQuestionAndAnswers() {
        return this.questionAndAnswerService.findAllQuestionAndAnswers();
    }

    @GetMapping("/{id}")
    public QuestionAndAnswer getQuestionAndAnswerById(@PathVariable Long id) {
        return this.questionAndAnswerService.findQuestionAndAnswerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionAndAnswer saveQuestionAndAnswer(@RequestBody QuestionAndAnswer q) {
        return this.questionAndAnswerService.saveQuestionAndAnswer(q);
    }

    @PutMapping
    public QuestionAndAnswer updateQuestionAndAnswer(@RequestBody QuestionAndAnswer q) {
     return this.questionAndAnswerService.updateQuestionAndAnswer(q);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestionAndAnswerById(@PathVariable Long id) {
        this.questionAndAnswerService.deleteQuestionAndAnswerById(id);
    }

    @DeleteMapping
    public void deleteAllQuestionAndAnswers() {
        this.questionAndAnswerService.deleteAllQuestionAndAnswers();
    }
}
