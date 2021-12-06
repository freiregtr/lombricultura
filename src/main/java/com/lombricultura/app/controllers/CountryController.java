package com.lombricultura.app.controllers;

import com.lombricultura.app.exception.BadRequestException;
import com.lombricultura.app.modelos.entities.Country;
import com.lombricultura.app.services.dao.CountryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryDAO countryDao;

    @Autowired
    public CountryController(CountryDAO countryDao) {
        this.countryDao = countryDao;
    }

    @GetMapping
    public List<Country> getCountries(){
        List<Country> countries = (List<Country>) countryDao.findAll();

        // verificacion
        if(countries.isEmpty()){
            throw new BadRequestException("no existen paises");
        }
        return countries;
    }

}
