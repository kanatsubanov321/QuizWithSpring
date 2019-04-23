package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> findAllQuizzes();
    Quiz findQuizById(Long id);
    Quiz saveQuiz(Quiz q);
    Quiz updateQuiz(Quiz q);
    void deleteQuizById(Long id);
    void deleteAllQuizzes();

}
