package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepo extends JpaRepository<Semester, Integer> {
}
