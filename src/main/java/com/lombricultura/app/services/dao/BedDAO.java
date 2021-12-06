package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Bed;

import java.util.Optional;

public interface BedDAO extends GenericDAO<Bed>{

    // QueryMethods
    Optional<Bed> SearchBedByname(String name);
}
