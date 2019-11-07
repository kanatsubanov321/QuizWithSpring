package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping
    public List<Answer> getAnswers() {
        return this.answerService.findAllAnswers();
    }

    @GetMapping("/{id}")
    public Answer getAnswerById(@PathVariable Long id) {
        return this.answerService.findAnswerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Answer saveAnswer(@RequestBody Answer a) {
        return this.answerService.saveAnswer(a);
    }

    @PutMapping
    public Answer updateAnswer(@RequestBody Answer a) {
        return this.answerService.updateAnswer(a);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswerById(@PathVariable Long id) {
        this.answerService.deleteAnswerById(id);
    }

    @DeleteMapping
    public void deleteAllAnswers() {
        this.answerService.deleteAllAnswers();
    }
}
