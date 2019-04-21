package com.example.quizWithSpring.repository;

import com.example.quizWithSpring.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRep
        extends JpaRepository<Quiz,Long> {
}
