package com.codegym.service;

import com.codegym.model.City;
import com.codegym.model.Nation;

public interface CityService {

    Iterable<City> findAll();

    City findById(Long id);

    void save(City city);

    void remove(Long id);

    Iterable<City> findAllByNation(Nation nation);
}
