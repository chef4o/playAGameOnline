package com.example.pago.domains.dto.models;

import com.example.pago.domains.entities.Comment;
import com.example.pago.domains.entities.User;

public class ReactionDto {
    private Long id;
    private Boolean isLike;
    private User owner;
    private Comment comment;

    public Long getId() {
        return id;
    }

    public ReactionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getLike() {
        return isLike;
    }

    public ReactionDto setLike(Boolean like) {
        isLike = like;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public ReactionDto setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Comment getComment() {
        return comment;
    }

    public ReactionDto setComment(Comment comment) {
        this.comment = comment;
        return this;
    }
}
