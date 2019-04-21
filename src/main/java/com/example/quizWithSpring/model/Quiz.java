package com.example.quizWithSpring.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalGrade;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDateTime time;

    public Quiz() {
    }

    public Quiz(Integer totalGrade, User user, LocalDateTime time) {
        this.totalGrade = totalGrade;
        this.user = user;
        this.time = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Integer totalGrade) {
        this.totalGrade = totalGrade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
