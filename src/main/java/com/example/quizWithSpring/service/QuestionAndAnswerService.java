package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.QuestionAndAnswer;

import java.util.List;

public interface QuestionAndAnswerService {
    List<QuestionAndAnswer> findAllQuestionAndAnswers();
    QuestionAndAnswer findQuestionAndAnswerById(Long id);
    QuestionAndAnswer saveQuestionAndAnswer(QuestionAndAnswer q);
    QuestionAndAnswer updateQuestionAndAnswer(QuestionAndAnswer q);
    void deleteQuestionAndAnswerById(Long id);
    void deleteAllQuestionAndAnswers();
}
