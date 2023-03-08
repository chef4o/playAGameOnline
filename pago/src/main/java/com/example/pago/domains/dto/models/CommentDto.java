package com.example.pago.domains.dto.models;

import com.example.pago.domains.entities.Comment;
import com.example.pago.domains.entities.Game;
import com.example.pago.domains.entities.Score;
import com.example.pago.domains.entities.User;

import java.time.LocalDateTime;

public class CommentDto {
    private Long id;
    private User owner;
    private String content;
    private Boolean isReply;
    private Comment parent;
    private LocalDateTime logTime;
    private Game game;
    private Score score;

    public Long getId() {
        return id;
    }

    public CommentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public CommentDto setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentDto setContent(String content) {
        this.content = content;
        return this;
    }

    public Boolean getReply() {
        return isReply;
    }

    public CommentDto setReply(Boolean reply) {
        isReply = reply;
        return this;
    }

    public Comment getParent() {
        return parent;
    }

    public CommentDto setParent(Comment parent) {
        this.parent = parent;
        return this;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public CommentDto setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
        return this;
    }

    public Game getGame() {
        return game;
    }

    public CommentDto setGame(Game game) {
        this.game = game;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public CommentDto setScore(Score score) {
        this.score = score;
        return this;
    }
}
