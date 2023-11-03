package com.itschool.spring_boot.services;

import com.itschool.spring_boot.models.Book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface BookService {

    Book createBook(Book book);
    List<Book> getAllBooks();

    Book updateBook(UUID id, Book book);
    Book deleteBook(UUID id);
}