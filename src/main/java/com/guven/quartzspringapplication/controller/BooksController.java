package com.guven.quartzspringapplication.controller;

import com.guven.quartzspringapplication.model.Book;
import com.guven.quartzspringapplication.repo.BookRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BooksController {
    private final BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }
}
