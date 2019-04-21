package com.example.quizWithSpring.model;

import javax.persistence.*;

@Entity
public class QuestionAndAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
    @OneToMany
    @JoinColumn(name = "question_id")
    private Question question;
    @OneToMany
    @JoinColumn(name = "answer_id")
    private Answer answer;
    private boolean isCorrect;

    public QuestionAndAnswer() {
    }

    public QuestionAndAnswer(Quiz quiz, Question question, Answer answer, boolean isCorrect) {
        this.quiz = quiz;
        this.question = question;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
