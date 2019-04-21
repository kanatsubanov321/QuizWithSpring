package com.example.quizWithSpring.bootstrap;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.Category;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.service.AnswerService;
import com.example.quizWithSpring.service.CategoryService;
import com.example.quizWithSpring.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Override
    public void run(String... args) throws Exception {
        Category category = new Category("Biology");
        categoryService.saveCategory(category);

        Question question = new Question();
        question.setCategory(category);
        question.setDecription("first question");
        question.setGrade(10);
        question.setText("How are you?");
        questionService.saveQuestion(question);

        Answer answer = new Answer();
        answer.setCorrect(true);
        answer.setQuestion(question);
        answer.setText("I'm fine");
        answerService.saveAnswer(answer);

        Answer answer1 = new Answer();
        answer1.setCorrect(false);
        answer1.setQuestion(question);
        answer1.setText("Bad");
        answerService.saveAnswer(answer1);
    }
}
