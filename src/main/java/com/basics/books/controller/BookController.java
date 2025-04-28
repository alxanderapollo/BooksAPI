package com.basics.books.controller;

import com.basics.books.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// first part of the application that will consume the api endpoint 
// this annotation tells spring boot this is a restufl endpoint
@RestController
public class BookController {

    private final List<Book> books = new ArrayList<Book>();

    private void initlizeBooks(){
        books.addAll(List.of( new Book("Title One", "Author one", "science"),
                new Book("Title Two", "Author Two", "science"),
                new Book("Title Three", "Author Three", "History"),
                new Book("Title Four", "Author Four", "Math"),
                new Book("Title Five", "Author Five", "Math"),
                new Book("Title Six", "Author Six", "Math")
                ));
    }
    public BookController(){
        initlizeBooks();
    }

    // get mapping without any given api linke goes to our root 8080 page
    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return books;
    }

}
