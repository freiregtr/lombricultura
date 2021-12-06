package com.lombricultura.app.services.implement;

import com.lombricultura.app.modelos.entities.Person;
import com.lombricultura.app.repository.EmployeeRepository;
import com.lombricultura.app.repository.PersonRepository;
import com.lombricultura.app.services.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImplement extends PersonDAOImplement implements EmployeeDAO {

    @Autowired
    public EmployeeDAOImplement(@Qualifier("employeeRepository") PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> seachEmployeeByRol(String rol) {
        return ((EmployeeRepository)repository).seachEmployeeByRol(rol);
    }
}
