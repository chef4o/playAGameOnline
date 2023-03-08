package com.example.pago.domains.dto.models;

import com.example.pago.domains.entities.Game;
import com.example.pago.domains.entities.User;

import java.time.LocalDateTime;

public class ScoreDto {
    private Long id;
    private Long value;
    private User user;
    private Game game;
    private LocalDateTime logTime;

    public Long getId() {
        return id;
    }

    public ScoreDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public ScoreDto setValue(Long value) {
        this.value = value;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ScoreDto setUser(User user) {
        this.user = user;
        return this;
    }

    public Game getGame() {
        return game;
    }

    public ScoreDto setGame(Game game) {
        this.game = game;
        return this;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public ScoreDto setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
        return this;
    }
}
