package com.lms.LibraryManagementSystem.repositories;

import com.lms.LibraryManagementSystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
