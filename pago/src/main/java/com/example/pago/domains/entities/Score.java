package com.example.pago.domains.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="scores")
public class Score extends BaseEntity{
    private Long value;
    private User user;
    private Game game;
    private LocalDateTime logTime;

    public Score() {
    }

    @Column(nullable = false)
    public Long getValue() {
        return value;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    @Column(name="log_time", nullable = false)
    public LocalDateTime getLogTime() {
        return logTime;
    }

    public Score setValue(Long value) {
        this.value = value;
        return this;
    }
    public Score setUser(User user) {
        this.user = user;
        return this;
    }
    public Score setGame(Game game) {
        this.game = game;
        return this;
    }
    public Score setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
        return this;
    }
}
