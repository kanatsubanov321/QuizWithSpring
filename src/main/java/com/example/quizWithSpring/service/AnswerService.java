package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Answer;

import java.util.List;

public interface AnswerService {
    List<Answer> findAllAnswers();
    Answer findAnswerById(Long id);
    Answer saveAnswer(Answer a);
    Answer updateAnswer(Answer a);
    void deleteAnswerById(Long id);
    void deleteAllAnswers();
}
