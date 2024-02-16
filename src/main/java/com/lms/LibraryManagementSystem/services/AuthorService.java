package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Author;

import java.util.List;

public interface AuthorService {
    Author registerAuthor(Author author);
    List<Author> getAllAuthors();
}
