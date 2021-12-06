package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Person;

import java.util.Optional;

public interface PersonDAO extends GenericDAO<Person>{

    Optional<Person> searchByNameAndLastName(String name, String lastName);
    Optional<Person> seachByRut(String rut);
    Iterable<Person> searchByLastName(String lastName);
}
