package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Integer> {

    // Query Methods
    @Query("select p from Country p where p.name = ?1")
    Optional<Country> findCountryByName(String name);

}
