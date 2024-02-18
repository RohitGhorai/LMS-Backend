package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.Book;
import com.lms.LibraryManagementSystem.entities.Copies;
import com.lms.LibraryManagementSystem.exceptions.ApiException;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.repositories.BookRepo;
import com.lms.LibraryManagementSystem.repositories.CopiesRepo;
import com.lms.LibraryManagementSystem.services.CopiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CopiesServiceImpl implements CopiesService {

    @Autowired
    private CopiesRepo copiesRepo;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public Copies addCopy(Copies copy, int bookId) {
        Book book = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", bookId));
        copy.setBook(book);
        return this.copiesRepo.save(copy);
    }

    @Override
    public Copies updateCopy(Copies copy, int copyId) {
        Copies copies = this.copiesRepo.findById(copyId).orElseThrow(() -> new ResourceNotFoundException("Copy", "Id", copyId));
        copies.setStatus(copy.getStatus());
        return this.copiesRepo.save(copies);
    }

    @Override
    public Copies getCopyById(int copyId) {
        return this.copiesRepo.findById(copyId).orElseThrow(() -> new ResourceNotFoundException("Copy", "Id", copyId));
    }
}
