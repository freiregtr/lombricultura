package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.City;

import java.util.Optional;

public interface CityDAO extends GenericDAO<City>{

    // Query Methods
    Optional<City> findCityByName(String name);
    Optional<City> findCityByCountry(Integer id);
}
