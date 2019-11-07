package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.repository.QuestionRep;
import com.example.quizWithSpring.util.QuestionAndAnswersObj;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRep questionRep;
    private final AnswerService answerService;
    private final QuestionService questionService;

    public QuestionServiceImpl(QuestionRep questionRep, AnswerService answerService, QuestionService questionService) {
        this.questionRep = questionRep;
        this.answerService = answerService;
        this.questionService = questionService;
    }

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

    @Override
    public List<Answer> getAnswersByQuestion(Long id) {
        List<Answer> answers = answerService.findAllAnswers();
        ArrayList<Answer> answers1 = new ArrayList<>();
        for (Answer answer : answers) {
            if (answer.getQuestion().getId().equals(id)) {
                answers1.add(answer);
            }
        }
        return answers1;
    }

    @Override
    public List<String> getQuestionAndAnswers(Long id) {
        List<Answer> answers = answerService.findAllAnswers();
        List<Question> questions = questionService.findAllQuestions();
        List<String> strings = new ArrayList<>();
        for (Answer answer : answers) {
            for (Question question : questions) {
                if (answer.getQuestion().getId().equals(question.getId())) {
                    strings.add(question.getText());
                    strings.add(answer.getText());
                }
            }
        }
        return strings;
    }

    @Override
    public QuestionAndAnswersObj getQuestionAndAnswers2(Long id) {
        List<Answer> answers = answerService.findAllAnswers();
        QuestionAndAnswersObj questionAndAnswersObj = new QuestionAndAnswersObj();
        List<String> strings = new ArrayList<>();
        String string = "";
        for (Answer answer : answers) {
                if (answer.getQuestion().getId().equals(id)) {
                    strings.add(answer.getText());
                    string = answer.getQuestion().getText();
            }
        }
        questionAndAnswersObj.setAnswers(strings);
        questionAndAnswersObj.setQuestion(string);
        return questionAndAnswersObj;
    }
}
