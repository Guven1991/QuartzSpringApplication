package com.guven.quartzspringapplication.repo;

import com.guven.quartzspringapplication.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks(){
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public int getBookCount() {
        return books.size();
    }
}
