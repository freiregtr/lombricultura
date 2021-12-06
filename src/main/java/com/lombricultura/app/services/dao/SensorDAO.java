package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Sensor;

import java.util.Optional;

public interface SensorDAO extends GenericDAO<Sensor>{

    // Query Methods
    Optional<Sensor> searchSensorByName(String name);

}
