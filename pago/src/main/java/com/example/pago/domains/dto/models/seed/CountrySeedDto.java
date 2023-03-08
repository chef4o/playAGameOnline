package com.example.pago.domains.dto.models.seed;

import com.example.pago.domains.dto.models.BaseEntityDto;
import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class CountrySeedDto extends BaseEntityDto {
    @Expose
    private String code;
    @Expose
    private String name;
    @Expose
    private String continent;
    @Expose
    private String region;
    @Expose
    private Long population;

    @Length(min = 3, max = 3)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotBlank
    @Length(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Length(min = 3)
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @NotBlank
    @Length(min = 3)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @NotNull
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
