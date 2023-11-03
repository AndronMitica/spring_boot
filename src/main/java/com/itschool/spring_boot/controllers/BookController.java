package com.itschool.spring_boot.controllers;

import com.itschool.spring_boot.models.Book;
import com.itschool.spring_boot.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/books")
@RestController
public class BookController {

    //create CRUD REST API
    private final BookService bookService;

    public BookController(BookService bookServices) {
        this.bookService = bookServices;
    }

    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> changeBook(@PathVariable UUID id, Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable UUID id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }
}