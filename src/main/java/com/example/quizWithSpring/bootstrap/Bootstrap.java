package com.example.quizWithSpring.bootstrap;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.Category;
import com.example.quizWithSpring.model.Question;
import com.example.quizWithSpring.model.User;
import com.example.quizWithSpring.service.AnswerService;
import com.example.quizWithSpring.service.CategoryService;
import com.example.quizWithSpring.service.QuestionService;
import com.example.quizWithSpring.service.UserService;
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

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category("English");
        categoryService.saveCategory(category);

        Category category1 = new Category("Deutsch");
        categoryService.saveCategory(category1);

        Question question = new Question();
        question.setCategory(category);
        question.setDescription("first question");
        question.setText("How ___ you?");
        questionService.saveQuestion(question);

        Answer answer = new Answer();
        answer.setCorrect(true);
        answer.setQuestion(question);
        answer.setText("are");
        answerService.saveAnswer(answer);

        Answer answer1 = new Answer();
        answer1.setCorrect(false);
        answer1.setQuestion(question);
        answer1.setText("is");
        answerService.saveAnswer(answer1);

        Question question1 = new Question();
        question1.setCategory(category1);
        question1.setText("Wir geht es ___?");
        question1.setDescription("Erste frage");
        questionService.saveQuestion(question1);

        Answer answer2 = new Answer();
        answer2.setCorrect(true);
        answer2.setQuestion(question1);
        answer2.setText("dir");
        answerService.saveAnswer(answer2);

        Answer answer3 = new Answer();
        answer3.setCorrect(false);
        answer3.setQuestion(question1);
        answer3.setText("dich");
        answerService.saveAnswer(answer3);

        User user = new User();
        user.setEmail("subanovkanat321@gmail.com");
        user.setFio("Kanat Subanov");
        user.setLogin("subanov_16");
        user.setPassword("123");
        userService.saveUser(user);

        User user1 = new User();
        user1.setPassword("123");
        user1.setLogin("subanovsamat");
        user1.setFio("Samat Subanov");
        user1.setEmail("samatsubanov95@gmail.com");
        userService.saveUser(user1);
    }
}
