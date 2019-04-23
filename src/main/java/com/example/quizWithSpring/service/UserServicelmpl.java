package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.*;
import com.example.quizWithSpring.repository.QuestionAndAnswerRep;
import com.example.quizWithSpring.repository.QuizRep;
import com.example.quizWithSpring.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServicelmpl implements UserService {
    @Autowired
    private UserRep userRep;
    @Autowired
    private QuizRep quizRep;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuizService quizService;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionAndAnswerRep questionAndAnswerRep;
    @Autowired
    private QuestionAndAnswerService questionAndAnswerService;

    @Override
    public List<User> findAllUsers() {
        return userRep.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRep.findById(id).get();
    }

    @Override
    public User saveUser(User u) {
        return userRep.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRep.save(u);
    }

    @Override
    public void deleteUserById(Long id) {
        userRep.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRep.deleteAll();
    }

    @Override
    public boolean checkAnswer(Long id, String answer, Long userId) {
        Quiz quiz = quizRep.save(new Quiz());
        quiz.setUser(userService.findUserById(userId));
        quiz.setTime(LocalDateTime.now());
        quiz.setTotalGrade(0);
        List<Answer> answers = answerService.findAllAnswers();
        int sum = 0;
        Answer answer1 = answerService.findAnswerById(id);
        for (Answer ans : answers) {
            if (ans.getQuestion().getId().equals(id)) {
                if (ans.getText().equals(answer)) {
                    answer1 = ans;
                    if (ans.isCorrect()) {
                        sum++;
                    }
                }
            }
        }
        quiz.setTotalGrade(sum);
        quizRep.save(quiz);
        QuestionAndAnswer questionAndAnswer = questionAndAnswerRep.save(new QuestionAndAnswer());
        questionAndAnswer.setAnswer(answer1);
        questionAndAnswer.setCorrect(false);
        questionAndAnswer.setQuestion(questionService.findQuestionById(answer1.getQuestion().getId()));
        questionAndAnswer.setQuiz(quiz);
        questionAndAnswerRep.save(questionAndAnswer);
        if (sum > 0) {
            questionAndAnswer.setCorrect(true);
            questionAndAnswerRep.save(questionAndAnswer);
            return true;
        }
        return false;
    }

    @Override
    public List<Quiz> getQuizzes(Long id) {
        List<Quiz> quizzes = quizService.findAllQuizzes();
        List<Quiz> quizzes1 = new ArrayList<>();
        for (Quiz quiz : quizzes) {
            if (quiz.getUser().getId().equals(id)) {
                quizzes1.add(quiz);
            }
        }
        return quizzes1;
    }

    @Override
    public boolean checkUser(Long id, String login, String password) {
        if (userService.findUserById(id).getLogin().equals(login)) {
            if (checkUserPassword(id, login, password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUserPassword(Long id, String login, String password) {
        if (userService.findUserById(id).getLogin().equals(login) &&
                userService.findUserById(id).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public List<QuestionAndAnswer> getQuestionAndAnswerByUser(Long id) {
        List<QuestionAndAnswer> questionAndAnswers = questionAndAnswerService.findAllQuestionAndAnswers();
        User user = userService.findUserById(id);
        List<QuestionAndAnswer> questionAndAnswers1 = new ArrayList<>();
        for (QuestionAndAnswer questionAndAnswer : questionAndAnswers) {
            if (user.getId().equals(id)) {
                questionAndAnswers1.add(questionAndAnswer);
            }
        }
        return questionAndAnswers1;
    }
}
