package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Person;

import java.util.Optional;

public interface GenericDAO<E>{
    // implementación básica que contiene todas las operaciones. Se define este genérico para evitar
    // la duplicidad de código en los diferentes tipos de implementación de servicio

    // GET
    Optional<E> findById(Integer id);
    Iterable<E> findAll();

    //POST
    E save(E entity);

    // DELETE
    void deleteById(Integer id);

}
