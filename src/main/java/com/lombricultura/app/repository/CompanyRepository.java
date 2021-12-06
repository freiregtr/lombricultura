package com.lombricultura.app.repository;

import com.lombricultura.app.modelos.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Query Methods
    @Query("select c from Company c where c.name = ?1")
    Optional<Company> findCompanyByName(String name);

    @Query("select c from Company c where c.postalCode = ?1")
    Optional<Company> findByPostalCode(String postalCode);
}
