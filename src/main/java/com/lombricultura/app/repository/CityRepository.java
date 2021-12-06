package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    // Query Methods
    @Query("select c from City c where c.name = ?1")
    Optional<City> findCityByName(String name);

    @Query("select c from City c where c.country.id = ?1")
    Optional<City> findCityByCountry(Integer id);
}
