package com.example.quizWithSpring.repository;

import com.example.quizWithSpring.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRep
        extends JpaRepository<Question, Long> {
}
