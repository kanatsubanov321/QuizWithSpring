package com.example.quizWithSpring.repository;

import com.example.quizWithSpring.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRep
        extends JpaRepository<Answer,Long> {
}
