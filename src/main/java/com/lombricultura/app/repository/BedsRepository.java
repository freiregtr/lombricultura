package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BedsRepository extends JpaRepository<Bed, Integer> {

    // QueryMethods
    @Query("select b from Bed b where b.name = ?1")
    Optional<Bed> SearchBedByname(String name);
}
