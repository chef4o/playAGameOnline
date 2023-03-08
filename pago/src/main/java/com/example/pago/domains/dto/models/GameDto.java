package com.example.pago.domains.dto.models;

import com.example.pago.domains.entities.User;
import com.example.pago.domains.enums.Genre;

import java.util.Set;

public class GameDto {
    private Long id;
    private String name;
    private Genre genre;
    private String description;
    private Double rating;
    private String iconFile;
    private Set<User> likedBy;

    public Long getId() {
        return id;
    }

    public GameDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GameDto setName(String name) {
        this.name = name;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public GameDto setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GameDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public GameDto setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public String getIconFile() {
        return iconFile;
    }

    public GameDto setIconFile(String iconFile) {
        this.iconFile = iconFile;
        return this;
    }

    public Set<User> getLikedBy() {
        return likedBy;
    }

    public GameDto setLikedBy(Set<User> likedBy) {
        this.likedBy = likedBy;
        return this;
    }
}
