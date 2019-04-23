package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.util.QuestionAndAnswersObj;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestions();
    Question findQuestionById(Long id);
    Question saveQuestion(Question q);
    Question updateQuestion(Question q);
    void deleteQuestionById(Long id);
    void deleteAllQuestions();
    List<Answer> getAnswersByQuestion(Long id);
    List<String> getQuestionAndAnswers(Long id);
    QuestionAndAnswersObj getQuestionAndAnswers2(Long id);
}
