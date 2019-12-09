package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "nations")
public class Nation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name_nation;

    @OneToMany(mappedBy = "nation")
    private Set<City> cities;

    public Nation() {
    }

    public Nation(String name_nation) {
        this.name_nation = name_nation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_nation() {
        return name_nation;
    }

    public void setName_nation(String name_nation) {
        this.name_nation = name_nation;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}
