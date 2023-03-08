package com.example.pago.domains.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="comments")
public class Comment extends BaseEntity {

    private User owner;
    private String content;
    private Boolean isReply;
    private Comment parent;
    private LocalDateTime logTime;
    private Game game;
    private Score score;
    public Comment() {
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    @Column(name = "is_reply", nullable = false)
    public Boolean getIsReply() {
        return isReply;
    }

    @ManyToOne
    public Comment getParent() {
        return parent;
    }

    @Column(name="log_time", nullable = false)
    public LocalDateTime getLogTime() {
        return logTime;
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    @ManyToOne
    public Score getScore() {
        return score;
    }

    public Comment setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public Comment setIsReply(Boolean isReply) {
        this.isReply = isReply;
        return this;
    }

    public Comment setParent(Comment parent) {
        this.parent = parent;
        return this;
    }

    public Comment setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
        return this;
    }

    public Comment setGame(Game game) {
        this.game = game;
        return this;
    }

    public Comment setScore(Score score) {
        this.score = score;
        return this;
    }
}
