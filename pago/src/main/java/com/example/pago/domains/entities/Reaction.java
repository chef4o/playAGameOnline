package com.example.pago.domains.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reactions")
public class Reaction extends BaseEntity {
    private Boolean isLike;
    private User owner;
    private Comment comment;

    public Reaction() {
    }

    @Column(name = "is_like")
    public Boolean getIsLike() {
        return isLike;
    }
    @ManyToOne
    public User getOwner() {
        return owner;
    }
    @ManyToOne
    public Comment getComment() {
        return comment;
    }

    public Reaction setIsLike(Boolean isLike) {
        this.isLike = isLike;
        return this;
    }
    public Reaction setOwner(User owner) {
        this.owner = owner;
        return this;
    }
    public Reaction setComment(Comment comment) {
        this.comment = comment;
        return this;
    }
}
