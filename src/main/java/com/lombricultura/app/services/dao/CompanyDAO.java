package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Company;

import java.util.Optional;

public interface CompanyDAO extends GenericDAO<Company>{
    Optional<Company> findCompanyByName(String name);
    Optional<Company> findByPostalCode(String postalCode);
}
