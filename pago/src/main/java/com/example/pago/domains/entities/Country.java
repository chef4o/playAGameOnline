package com.example.pago.domains.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {
    private String isoCode;
    private String name;
    private String continent;
    private String region;
    private Long population;

    public Country() {
    }

    @Column(name = "iso_code", unique = true, nullable = false, length = 3)
    public String getIsoCode() {
        return isoCode;
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }
    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public Long getPopulation() {
        return population;
    }

    public Country setIsoCode(String isoCode) {
        this.isoCode = isoCode;
        return this;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Country setContinent(String continent) {
        this.continent = continent;
        return this;
    }

    public Country setRegion(String region) {
        this.region = region;
        return this;
    }

    public Country setPopulation(Long population) {
        this.population = population;
        return this;
    }
}
