package com.example.quizWithSpring.util;

import java.util.ArrayList;
import java.util.List;

public class QuestionAndAnswersObj {
    private String question;
    private List<String> answers = new ArrayList<>();

    public QuestionAndAnswersObj() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
