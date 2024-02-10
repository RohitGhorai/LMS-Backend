package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Copies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopiesRepo extends JpaRepository<Copies, Integer> {
}
