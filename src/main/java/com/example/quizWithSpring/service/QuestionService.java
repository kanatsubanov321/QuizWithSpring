package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestions();
    Question findQuestionById(Long id);
    Question saveQuestion(Question q);
    Question updateQuestion(Question q);
    void deleteQuestionById(Long id);
    void deleteAllQuestions();
}
