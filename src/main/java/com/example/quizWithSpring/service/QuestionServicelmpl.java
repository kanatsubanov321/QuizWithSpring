package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.repository.QuestionRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServicelmpl implements QuestionService {
    @Autowired
    private QuestionRep questionRep;

    @Override
    public List<Question> findAllQuestions() {
        return questionRep.findAll();
    }

    @Override
    public Question findQuestionById(Long id) {
        return questionRep.findById(id).get();
    }

    @Override
    public Question saveQuestion(Question q) {
        return questionRep.save(q);
    }

    @Override
    public Question updateQuestion(Question q) {
        return questionRep.save(q);
    }

    @Override
    public void deleteQuestionById(Long id) {
        questionRep.deleteById(id);
    }

    @Override
    public void deleteAllQuestions() {
        questionRep.deleteAll();
    }
}
