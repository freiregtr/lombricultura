package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.Sensor;
import com.lombricultura.app.repository.SensorRepository;
import com.lombricultura.app.services.dao.SensorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensorDAOImplement extends GenericDAOImplement<Sensor, SensorRepository> implements SensorDAO {


    @Autowired
    public SensorDAOImplement(SensorRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Sensor> searchSensorByName(String name) {
        return repository.searchSensorByName(name);
    }
}
