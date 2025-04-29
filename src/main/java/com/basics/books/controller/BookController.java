package com.basics.books.controller;

import com.basics.books.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
//    @GetMapping("/api/books")
//    public List<Book> getBooks() {
//        return books;
//    }

//    path parameters - dynamic parts of the url
//    path varaible lets spring know that were passing a varaible that will match at the end of the url
    @GetMapping ("/api/books/{title}")
    public Book getBookByTitle(@PathVariable String title){
        for (Book book : books){
//            if there exists a book with that title we want return that book
            if(book.getTitle().equalsIgnoreCase(title)) return book;
        }
//        otherwise no book with that title exsits return nothing
        return null;
    }

//    Query parameter
    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false)  String category){
//        if we do not pass anything just return all the books
        if (category == null) return books;
//        otherwise create new list that returns a filter of the category that is passed in
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book : books){
            if(book.getCategory().equalsIgnoreCase(category)) filteredBooks.add(book);
        }
        return filteredBooks ;
    }

}
