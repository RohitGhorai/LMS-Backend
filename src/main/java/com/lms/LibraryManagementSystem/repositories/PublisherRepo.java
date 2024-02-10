package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
}
