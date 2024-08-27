package com.example.BookStoreAPI.controller;

import com.example.BookStoreAPI.dto.BookDTO;
import com.example.BookStoreAPI.mapper.BookMapper;
import com.example.BookStoreAPI.model.Book;
import com.example.BookStoreAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<EntityModel<BookDTO>>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<EntityModel<BookDTO>> bookDTOs = books.stream()
            .map(book -> {
                BookDTO dto = BookMapper.INSTANCE.toDTO(book);
                EntityModel<BookDTO> entityModel = EntityModel.of(dto);
                entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
                return entityModel;
            })
            .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable("id") Long id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(b -> {
            BookDTO dto = BookMapper.INSTANCE.toDTO(b);
            EntityModel<BookDTO> entityModel = EntityModel.of(dto);
            entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(b.getId())).withSelfRel());
            entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getAllBooks()).withRel("all-books"));
            return ResponseEntity.ok(entityModel);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<EntityModel<BookDTO>> addBook(@RequestBody @Valid BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        Book savedBook = bookService.addBook(book);
        BookDTO savedBookDTO = BookMapper.INSTANCE.toDTO(savedBook);
        EntityModel<BookDTO> entityModel = EntityModel.of(savedBookDTO);
        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(savedBook.getId())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(entityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> updateBook(@PathVariable("id") Long id, @RequestBody @Valid BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        book.setId(id);
        Optional<Book> updatedBook = bookService.updateBook(id, book);
        return updatedBook.map(b -> {
            BookDTO updatedBookDTO = BookMapper.INSTANCE.toDTO(b);
            EntityModel<BookDTO> entityModel = EntityModel.of(updatedBookDTO);
            entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookController.class).getBookById(b.getId())).withSelfRel());
            return ResponseEntity.ok(entityModel);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
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
