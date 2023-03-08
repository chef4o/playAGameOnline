package com.example.pago.domains.dto.models.seed;

import com.example.pago.domains.dto.models.BaseEntityDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class GameSeedDto extends BaseEntityDto {
    @Expose
    private String name;
    @Expose
    private String genre;
    @Expose
    private String description;
    @Expose
    private Double rating;
    @Expose
    @SerializedName("icon_file")
    private String iconFile;

    @Length(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getIconFile() {
        return iconFile;
    }

    public void setIconFile(String iconFile) {
        this.iconFile = iconFile;
    }
}


