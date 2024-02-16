package com.lms.LibraryManagementSystem.controllers;

import com.lms.LibraryManagementSystem.config.AppConstants;
import com.lms.LibraryManagementSystem.entities.Book;
import com.lms.LibraryManagementSystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppConstants.URL_BASE + "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/languages/{lanId}/categories/{catId}/authors/{authId}/faculties/{facId}")
    public ResponseEntity<Book> add(@RequestBody Book book, @PathVariable int lanId, @PathVariable int facId, @PathVariable int catId, @PathVariable int authId){
        return new ResponseEntity<>(this.bookService.addBook(book, lanId, facId, catId, authId), HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId){
        return ResponseEntity.ok(this.bookService.getBookById(bookId));
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @PutMapping("/categories/{catId}/books/{bookId}")
    public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable int bookId, @PathVariable int catId){
        return ResponseEntity.ok(this.bookService.updateBook(book, bookId, catId));
    }
}
