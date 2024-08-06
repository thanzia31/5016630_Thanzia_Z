package com.library.service;

import com.library.repository.BookRepository;
import java.util.*;

public class BookService {
	private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
   

    
    public void addBook(Integer id, String title) {
        bookRepository.addBook(id, title);
    }

    
    public String getBookById(Integer id) {
        return bookRepository.getBookById(id);
    }

    
    public Map<Integer, String> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public void printAllBooks() {
        Map<Integer, String> books = getAllBooks();
        for (Map.Entry<Integer, String> entry : books.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Title: " + entry.getValue());
        }}

}
