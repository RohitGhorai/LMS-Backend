package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.City;
import com.lms.LibraryManagementSystem.repositories.CityRepo;
import com.lms.LibraryManagementSystem.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Override
    public City addCity(City city) {
        return this.cityRepo.save(city);
    }

    @Override
    public List<City> getAllCities() {
        return this.cityRepo.findAll();
    }
}
