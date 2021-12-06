package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.City;
import com.lombricultura.app.repository.CityRepository;
import com.lombricultura.app.services.dao.CityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityDAOImplement extends GenericDAOImplement<City, CityRepository> implements CityDAO {


    @Autowired
    public CityDAOImplement(CityRepository repository) {
        super(repository);
    }

    @Override
    public Optional<City> findCityByName(String name) {
        return repository.findCityByName(name);
    }

    @Override
    public Optional<City> findCityByCountry(Integer id) {
        return repository.findCityByCountry(id);
    }
}
