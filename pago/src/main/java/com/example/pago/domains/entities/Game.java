package com.example.pago.domains.entities;

import com.example.pago.domains.enums.Genre;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {

    private String name;
    private Genre genre;
    private String description;
    private Double rating;
    private String iconFile;
    private Set<User> likedBy;

    public Game() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Genre getGenre() {
        return genre;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Double getRating() {
        return rating;
    }

    @ManyToMany
    public Set<User> getLikedBy() {
        return likedBy;
    }

    @Column(name="icon_file")
    public String getIconFile() {
        return iconFile;
    }


    public Game setName(String name) {
        this.name = name;
        return this;
    }
    public Game setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }
    public Game setDescription(String description) {
        this.description = description;
        return this;
    }
    public Game setRating(Double rating) {
        this.rating = rating;
        return this;
    }
    public Game setIconFile(String iconFile) {
        this.iconFile = iconFile;
        return this;
    }
    public Game setLikedBy(Set<User> likedBy) {
        this.likedBy = likedBy;
        return this;
    }
}
