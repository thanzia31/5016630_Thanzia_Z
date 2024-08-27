package com.example.BookStoreAPI.service;

import com.example.BookStoreAPI.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private List<Book> bookList = new ArrayList<>();

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(Long id) {
        return bookList.stream()
            .filter(book -> book.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public Book addBook(Book book) {
        bookList.add(book);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> existingBook = bookList.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst();
        if (existingBook.isPresent()) {
            bookList.remove(existingBook.get());
            book.setId(id);
            bookList.add(book);
            return book;
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        return bookList.removeIf(book -> book.getId().equals(id));
    }

    public List<Book> filterBooks(String title, String author) {
        return bookList.stream()
            .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                            (author == null || book.getAuthor().equalsIgnoreCase(author)))
            .collect(Collectors.toList());
    }
}
