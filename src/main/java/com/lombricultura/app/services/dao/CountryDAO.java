package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Country;

import java.util.Optional;

public interface CountryDAO extends GenericDAO<Country>{

    // Query Methods
    Optional<Country> findCountryByName(String name);
}
