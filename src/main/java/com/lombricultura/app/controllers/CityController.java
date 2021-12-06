package com.lombricultura.app.controllers;

import com.lombricultura.app.exception.BadRequestException;
import com.lombricultura.app.modelos.entities.City;
import com.lombricultura.app.services.dao.CityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityDAO cityDao;

    @Autowired
    public CityController(CityDAO cityDao) {
        this.cityDao = cityDao;
    }

    @GetMapping
    public List<City> getCities(){
        List<City> cities = (List<City>) cityDao.findAll();

        // verificación
        if(cities.isEmpty()){
            throw new BadRequestException("no existen ciudades");
        }
        return cities;
    }
}
