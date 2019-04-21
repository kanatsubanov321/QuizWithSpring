package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Quiz;
import com.example.quizWithSpring.repository.QuizRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServicelmpl implements QuizService {
    @Autowired
    private QuizRep quizRep;

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
