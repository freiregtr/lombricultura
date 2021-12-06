package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.Bed;
import com.lombricultura.app.repository.BedsRepository;
import com.lombricultura.app.services.dao.BedDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BedDAOImplement extends GenericDAOImplement<Bed, BedsRepository> implements BedDAO {

    @Autowired
    public BedDAOImplement(BedsRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Bed> SearchBedByname(String name) {
        return repository.SearchBedByname(name);
    }
}
