package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.City;
import com.lms.LibraryManagementSystem.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/")
    public ResponseEntity<City> addCity(@RequestBody City city){
        return new ResponseEntity<>(this.cityService.addCity(city), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<City>> getAllCities(){
        return ResponseEntity.ok(this.cityService.getAllCities());
    }
}
