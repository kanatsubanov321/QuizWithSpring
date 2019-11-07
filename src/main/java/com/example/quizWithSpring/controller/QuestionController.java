package com.example.quizWithSpring.controller;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.service.QuestionService;
import com.example.quizWithSpring.util.QuestionAndAnswersObj;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<Question> getQuestions() {
        return this.questionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return this.questionService.findQuestionById(id);
    }

    @GetMapping("/{id}/answers")
    public List<Answer> getAnswersByQuestion(@PathVariable Long id) {
        return this.questionService.getAnswersByQuestion(id);
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

    @GetMapping("/{id}/listAll")
    private List<String> getQuestionAndAnswers(@PathVariable Long id) {
        return questionService.getQuestionAndAnswers(id);
    }

    @GetMapping("/{id}/list")
    private QuestionAndAnswersObj getQuestionAndAnswers2(@PathVariable Long id) {
        return questionService.getQuestionAndAnswers2(id);
    }
}
