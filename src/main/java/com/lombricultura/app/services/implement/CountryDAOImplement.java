package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.Country;
import com.lombricultura.app.repository.CountryRepository;
import com.lombricultura.app.services.dao.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryDAOImplement extends GenericDAOImplement<Country, CountryRepository> implements CountryDAO {


    @Autowired
    public CountryDAOImplement(CountryRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Country> findCountryByName(String name) {
        return repository.findCountryByName(name);
    }
}
