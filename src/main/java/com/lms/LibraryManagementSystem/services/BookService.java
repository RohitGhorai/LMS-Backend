package com.lms.LibraryManagementSystem.services;

import com.lms.LibraryManagementSystem.entities.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book, int lanId, int facId, int catId, int authId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
    Book updateBook(Book book, int bookId, int catId);
}
