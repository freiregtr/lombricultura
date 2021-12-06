package com.lombricultura.app.services.implement;


import com.lombricultura.app.modelos.entities.Person;
import com.lombricultura.app.repository.PersonRepository;
import com.lombricultura.app.services.dao.PersonDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonDAOImplement extends GenericDAOImplement<Person, PersonRepository> implements PersonDAO {

    public PersonDAOImplement(PersonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> searchByNameAndLastName(String name, String lastName) {
        return repository.searchByNameAndLastName(name, lastName);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> seachByRut(String rut) {
        return repository.seachByRut(rut);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> searchByLastName(String lastName) {
        return repository.searchByLastName(lastName);
    }
}
