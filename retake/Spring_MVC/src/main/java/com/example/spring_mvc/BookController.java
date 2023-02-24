package com.example.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

public class BookController {
    //TODO 1: make this a controller
    //TODO 2: Implement the getBooks method
    //TODO 3: implement the addBook methods
    //TODO 4: implement the editBook methods
    //TODO 5: implement the deleteBook method
    //TODO 6: implement the searchBook method
    //There are templates present for some simple views, but you can make your own if you want!
    //You should only need to change this file if you use the templates provided.
    ArrayList<Book> books = new ArrayList<Book>();

    public BookController() {
    }

    @GetMapping("/")
    public String Redirect(){
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        return null;
    }
    public String addBook(Model model) {
        return null;
    }
    public String addBook(Book book) {
        return null;
    }
    public String deleteBook() {
        return null;
    }
    public String editBook(Model model) {
        return null;
    }
    public String editBook() {
        return null;
    }

    public String searchBook() {
        return null;
    }

    // Helper methods
    Book getBookByIsbn(String isbn) {
        int index = getIndexByIsbn(isbn);
        return index == -1 ? null : books.get(index);
    }
    int getIndexByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }
    ArrayList<Book> searchBookByTitle(String title){
        ArrayList<Book> foundBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
