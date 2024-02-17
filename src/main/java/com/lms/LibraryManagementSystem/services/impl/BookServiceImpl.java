package com.lms.LibraryManagementSystem.services.impl;

import com.lms.LibraryManagementSystem.entities.*;
import com.lms.LibraryManagementSystem.exceptions.ResourceNotFoundException;
import com.lms.LibraryManagementSystem.repositories.*;
import com.lms.LibraryManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private FacultyRepo facultyRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Book addBook(Book book, int lanId, int facId, int catId, int authId) {
        Language language = this.languageRepo.findById(lanId).orElseThrow(() -> new ResourceNotFoundException("Language", "Id", lanId));
        Faculty faculty = this.facultyRepo.findById(facId).orElseThrow(() -> new ResourceNotFoundException("Faculty", "Id", facId));
        Category category = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", catId));
        Author author = this.authorRepo.findById(authId).orElseThrow(() -> new ResourceNotFoundException("Author", "Id", authId));
        book.setLanguage(language);
        book.setFaculty(faculty);
        book.setCategory(category);
        book.setAuthor(author);
        return this.bookRepo.save(book);
    }

    @Override
    public Book getBookById(int bookId) {
        return this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", bookId));
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepo.findAll();
    }

    @Override
    public Book updateBook(Book book, int bookId, int catId) {
        Book update = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", bookId));
        Category category = this.categoryRepo.findById(catId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", catId));
        update.setTitle(book.getTitle());
        update.setEdition(book.getEdition());
        update.setPages(book.getPages());
        update.setPublisher(book.getPublisher());
        update.setPublicationYear(book.getPublicationYear());
        update.setCategory(category);
        update.setDescription(book.getDescription());
        return this.bookRepo.save(update);
    }
}
