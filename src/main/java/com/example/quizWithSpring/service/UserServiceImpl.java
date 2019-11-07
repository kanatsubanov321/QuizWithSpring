package com.example.quizWithSpring.service;

import com.example.quizWithSpring.model.Answer;
import com.example.quizWithSpring.model.QuestionAndAnswer;
import com.example.quizWithSpring.model.Quiz;
import com.example.quizWithSpring.model.User;
import com.example.quizWithSpring.repository.QuestionAndAnswerRep;
import com.example.quizWithSpring.repository.QuizRep;
import com.example.quizWithSpring.repository.UserRep;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRep userRep;
    private final QuizRep quizRep;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final QuizService quizService;
    private final UserService userService;
    private final QuestionAndAnswerRep questionAndAnswerRep;
    private final QuestionAndAnswerService questionAndAnswerService;

    public UserServiceImpl(UserRep userRep, QuizRep quizRep, QuestionService questionService, AnswerService answerService, QuizService quizService, UserService userService, QuestionAndAnswerRep questionAndAnswerRep, QuestionAndAnswerService questionAndAnswerService) {
        this.userRep = userRep;
        this.quizRep = quizRep;
        this.questionService = questionService;
        this.answerService = answerService;
        this.quizService = quizService;
        this.userService = userService;
        this.questionAndAnswerRep = questionAndAnswerRep;
        this.questionAndAnswerService = questionAndAnswerService;
    }

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

    private boolean checkUserPassword(Long id, String login, String password) {
        return userService.findUserById(id).getLogin().equals(login) &&
                userService.findUserById(id).getPassword().equals(password);
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
