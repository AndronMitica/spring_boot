package com.itschool.spring_boot.services;

import com.itschool.spring_boot.models.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final List<Book> bookList = new ArrayList<>();

    @Override
    public Book createBook(Book book) {
        book.setId(UUID.randomUUID());
        book.setCreatedAt(LocalDateTime.now());
        bookList.add(book);
        System.out.println("A new book was created: " + book.getTitle());
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book updateBook(UUID id, Book book) {
        for (Book currentBook : bookList) {
            if (currentBook.getId().equals(id)) {
                currentBook.setTitle(book.getTitle());
                currentBook.setAuthor(book.getAuthor());
                currentBook.setPageNo(book.getPageNo());
                currentBook.setDescription(book.getDescription());
                System.out.println("The book " + currentBook.getId() + "was updated.");
                return currentBook;
            }
        }
        return null;
    }

    public Book deleteBook(UUID id) {
        for (Book currentBook : bookList) {
            if (currentBook.getId().equals(id)) {
                bookList.remove(currentBook);
                return currentBook;
            }
        }
        return null;
    }
}