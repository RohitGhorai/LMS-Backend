package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.City;

import java.util.List;

public interface CityService {
    City addCity(City city);
    List<City> getAllCities();
}
