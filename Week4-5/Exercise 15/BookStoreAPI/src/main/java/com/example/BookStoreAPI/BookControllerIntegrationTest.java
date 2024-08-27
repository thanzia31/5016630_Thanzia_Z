package com.example.BookStoreAPI;

import com.example.BookStoreAPI.model.Book;
import com.example.BookStoreAPI.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Prepare any data required for the tests
        Book book = new Book();
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        bookRepository.save(book);
    }

    @Test
    public void testGetBookById() throws Exception {
        // Fetch the book from the repository to get its ID
        Book book = bookRepository.findByTitle("Effective Java");

        ResultActions response = mockMvc.perform(get("/books/{id}", book.getId())
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }

    @Test
    public void testCreateBook() throws Exception {
        Book newBook = new Book();
        newBook.setTitle("Clean Code");
        newBook.setAuthor("Robert C. Martin");

        ResultActions response = mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newBook)));

        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Clean Code"))
                .andExpect(jsonPath("$.author").value("Robert C. Martin"));
    }

    // Add more tests for other endpoints (e.g., update, delete)
}
