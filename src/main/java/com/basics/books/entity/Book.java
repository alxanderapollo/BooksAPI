package com.basics.books.entity;

public class Book {
    private String title;
    private String author;
    private String category;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public String getTitle(){
       return  this.title;
    } public String getAuthor(){
       return  this.author;
    } public String getCategory(){
       return  this.category;
    }
    public void setTitle(String title){
        this.title = title;
    }public void setAuthor(String author){
        this.author = author;
    }public void setCategory(String category){
        this.category = category;
    }
}
