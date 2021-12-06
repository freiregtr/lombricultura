package com.lombricultura.app.services.dao;

import com.lombricultura.app.modelos.entities.Person;

public interface EmployeeDAO extends PersonDAO{

    Iterable<Person> seachEmployeeByRol(String rol);

}
