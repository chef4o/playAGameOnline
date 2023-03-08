package com.example.pago.domains.dto.models.seed;

import com.example.pago.domains.dto.models.BaseEntityDto;
import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class TownSeedDto extends BaseEntityDto {
    @Expose
    private String city;
    @Expose
    private String country;
    @Expose
    private Long population;
    @Expose
    private Integer capital;

    @NotBlank
    @Size(min = 3)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NotNull
    @Length(min = 3)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NotNull
    @Min(0)
    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    @NotNull
    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        capital = capital;
    }
}
