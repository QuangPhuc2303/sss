package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name_city;
    private Float area_city;
    private Long population_city;
    private Long gdp_city;
    private String description_city;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    public City() {
    }

    public City(String name_city, Float area_city, Long population_city, Long gdp_city, String description_city) {
        this.name_city = name_city;
        this.area_city = area_city;
        this.population_city = population_city;
        this.gdp_city = gdp_city;
        this.description_city = description_city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    public Float getArea_city() {
        return area_city;
    }

    public void setArea_city(Float area_city) {
        this.area_city = area_city;
    }

    public Long getPopulation_city() {
        return population_city;
    }

    public void setPopulation_city(Long population_city) {
        this.population_city = population_city;
    }

    public Long getGdp_city() {
        return gdp_city;
    }

    public void setGdp_city(Long gdp_city) {
        this.gdp_city = gdp_city;
    }

    public String getDescription_city() {
        return description_city;
    }

    public void setDescription_city(String description_city) {
        this.description_city = description_city;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}
