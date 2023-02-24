package com.example.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BookController {

    ArrayList<Book> books = new ArrayList<Book>();

    public BookController() {
    }

    @GetMapping("/")
    public String Redirect(){
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", books);
        return "books";
    }
    @GetMapping("/addBook")
    public String addBook(Model model) {
        return "addBook";
    }
    @PostMapping("/addBook")
    public String addBook(Book book) {
        books.add(book);
        return "redirect:/books";
    }

    @GetMapping("/deleteBook/{isbn}")
    public String deleteBook(@PathVariable("isbn") String isbn) {
        Book book = getBookByIsbn(isbn);
        if(book != null)
            books.remove(book);
        return "redirect:/books";
    }
    @GetMapping("/editBook/{isbn}")
    public String editBook(@PathVariable("isbn") String isbn, Model model) {
        Book book = getBookByIsbn(isbn);
        model.addAttribute("book", book);
        return "editBook";
    }
    @PostMapping("/editBook")
    public String editBook(Book book, String title, String author) {
        book.setTitle(title);
        book.setAuthor(author);
        int index = getIndexByIsbn(book.getIsbn());
        books.set(index, book);
        return "redirect:/books";
    }

    @GetMapping("/searchBook")
    public String searchBook(@RequestParam(required = false) String title, Model model) {
        if(title != null) {
            ArrayList<Book> foundBooks = searchBookByTitle(title);
            if (foundBooks != null)
                model.addAttribute("books", foundBooks);
        }
        return "searchBook";
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
