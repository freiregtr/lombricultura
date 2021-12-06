package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    // Query Methods
    @Query("select s from Sensor s where s.name = ?1")
    Optional<Sensor> searchSensorByName(String name);

}
