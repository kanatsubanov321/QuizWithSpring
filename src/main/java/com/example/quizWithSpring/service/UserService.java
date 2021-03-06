package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.QuestionAndAnswer;
import com.example.quizWithSpring.model.Quiz;
import com.example.quizWithSpring.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User saveUser(User u);
    User updateUser(User u);
    void deleteUserById(Long id);
    void deleteAllUsers();
    boolean checkAnswer(Long id, String answer, Long userId);
    boolean checkUser(Long id, String login,String password);
    List<Quiz> getQuizzes(Long id);
    List<QuestionAndAnswer> getQuestionAndAnswerByUser(Long id);

}
