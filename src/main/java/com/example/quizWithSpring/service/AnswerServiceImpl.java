package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.repository.AnswerRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRep answerRep;

    public AnswerServiceImpl(AnswerRep answerRep) {
        this.answerRep = answerRep;
    }

    @Override
    public List<Answer> findAllAnswers() {
        return answerRep.findAll();
    }

    @Override
    public Answer findAnswerById(Long id) {
        return answerRep.findById(id).get();
    }

    @Override
    public Answer saveAnswer(Answer a) {
        return answerRep.save(a);
    }

    @Override
    public Answer updateAnswer(Answer a) {
        return answerRep.save(a);
    }

    @Override
    public void deleteAnswerById(Long id) {
        answerRep.deleteById(id);
    }

    @Override
    public void deleteAllAnswers() {
        answerRep.deleteAll();
    }
}
