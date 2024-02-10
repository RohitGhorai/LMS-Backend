package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {
}
