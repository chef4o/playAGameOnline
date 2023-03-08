package com.example.pago.domains.entities;

import jakarta.persistence.*;

@Entity
@Table(name="towns")
public class Town extends BaseEntity {
    private String name;
    private Country country;
    private Long population;
    private Integer isCapital;

    public Town() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    public Long getPopulation() {
        return population;
    }

    @Column(nullable = false)
    public Integer getIsCapital() {
        return isCapital;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }
    public Town setCountry(Country country) {
        this.country = country;
        return this;
    }
    public Town setPopulation(Long population) {
        this.population = population;
        return this;
    }
    public Town setIsCapital(Integer isCapital) {
        this.isCapital = isCapital;
        return this;
    }
}
