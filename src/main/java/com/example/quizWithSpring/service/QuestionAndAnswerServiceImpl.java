package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.QuestionAndAnswer;
import com.example.quizWithSpring.repository.QuestionAndAnswerRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {
    private final QuestionAndAnswerRep questionAndAnswerRep;

    public QuestionAndAnswerServiceImpl(QuestionAndAnswerRep questionAndAnswerRep) {
        this.questionAndAnswerRep = questionAndAnswerRep;
    }

    @Override
    public List<QuestionAndAnswer> findAllQuestionAndAnswers() {
        return questionAndAnswerRep.findAll();
    }

    @Override
    public QuestionAndAnswer findQuestionAndAnswerById(Long id) {
        return questionAndAnswerRep.findById(id).get();
    }

    @Override
    public QuestionAndAnswer saveQuestionAndAnswer(QuestionAndAnswer q) {
        return questionAndAnswerRep.save(q);
    }

    @Override
    public QuestionAndAnswer updateQuestionAndAnswer(QuestionAndAnswer q) {
        return questionAndAnswerRep.save(q);
    }

    @Override
    public void deleteQuestionAndAnswerById(Long id) {
        questionAndAnswerRep.deleteById(id);
    }

    @Override
    public void deleteAllQuestionAndAnswers() {
        questionAndAnswerRep.deleteAll();
    }
}
