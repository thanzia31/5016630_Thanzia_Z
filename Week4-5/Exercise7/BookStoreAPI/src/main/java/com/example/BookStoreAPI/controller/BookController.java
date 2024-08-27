package com.example.BookStoreAPI.controller;

import com.example.BookStoreAPI.dto.BookDTO;
import com.example.BookStoreAPI.mapper.BookMapper;
import com.example.BookStoreAPI.model.Book;
import com.example.BookStoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        List<Book> books;
        if (title != null || author != null) {
            books = bookService.filterBooks(title, author);
        } else {
            books = bookService.getAllBooks();
        }
        List<BookDTO> bookDTOs = books.stream()
                                      .map(BookMapper.INSTANCE::toDTO)
                                      .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        Book savedBook = bookService.addBook(book);
        BookDTO savedBookDTO = BookMapper.INSTANCE.toDTO(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(savedBookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        book.setId(id);
        Book updatedBook = bookService.updateBook(id, book);
        if (updatedBook != null) {
            BookDTO updatedBookDTO = BookMapper.INSTANCE.toDTO(updatedBook);
            return ResponseEntity.ok(updatedBookDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
