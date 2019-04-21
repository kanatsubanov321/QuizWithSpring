package com.example.quizWithSpring.repository;

import com.example.quizWithSpring.model.QuestionAndAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAndAnswerRep
        extends JpaRepository<QuestionAndAnswer,Long> {
}
