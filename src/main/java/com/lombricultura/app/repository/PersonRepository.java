package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("select p from Person p where p.firtName = ?1 and p.lastName = ?2")
    Optional<Person> searchByNameAndLastName(String name, String lastName);

    @Query("select p from Person p where p.rut = ?1")
    Optional<Person> seachByRut(String rut);

    @Query("select p from Person p where p.lastName like %?1%")
    Iterable<Person> searchByLastName(String lastName);

}