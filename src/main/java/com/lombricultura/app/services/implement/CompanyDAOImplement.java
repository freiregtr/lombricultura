package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.Company;
import com.lombricultura.app.repository.CompanyRepository;
import com.lombricultura.app.services.dao.CompanyDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompanyDAOImplement extends GenericDAOImplement<Company, CompanyRepository> implements CompanyDAO {


    public CompanyDAOImplement(CompanyRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Company> findCompanyByName(String name) {
        return repository.findCompanyByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Company> findByPostalCode(String postalCode) {
        return repository.findByPostalCode(postalCode);
    }
}
