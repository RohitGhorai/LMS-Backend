package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Author;
import com.lms.LibraryManagementSystem.repositories.AuthorRepo;
import com.lms.LibraryManagementSystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public Author registerAuthor(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepo.findAll();
    }
}
