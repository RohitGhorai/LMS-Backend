package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
}
