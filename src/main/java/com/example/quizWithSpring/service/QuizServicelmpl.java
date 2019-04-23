package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.model.Quiz;
import com.example.quizWithSpring.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizServicelmpl implements QuizService {
    @Autowired
    private QuizRep quizRep;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private UserService userService;
    @Override
    public List<Quiz> findAllQuizzes() {
        return quizRep.findAll();
    }

    @Override
    public Quiz findQuizById(Long id) {
        return quizRep.findById(id).get();
    }

    @Override
    public Quiz saveQuiz(Quiz q) {
        return quizRep.save(q);
    }

    @Override
    public Quiz updateQuiz(Quiz q) {
        return quizRep.save(q);
    }

    @Override
    public void deleteQuizById(Long id) {
        quizRep.deleteById(id);
    }

    @Override
    public void deleteAllQuizzes() {
        quizRep.deleteAll();
    }
}
