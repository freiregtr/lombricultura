package com.lombricultura.app.repository;


import com.lombricultura.app.modelos.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends PersonRepository{
    // repositorio hijo, este hereda todos los métodos declarados de la clase abstracta Person y su repositorio
    @Query("select e from Employee e where e.rol = ?1")
    Iterable<Person> seachEmployeeByRol(String rol);
}
