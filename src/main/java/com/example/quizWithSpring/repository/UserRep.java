package com.example.quizWithSpring.repository;

import com.example.quizWithSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep
        extends JpaRepository<User, Long> {
}
