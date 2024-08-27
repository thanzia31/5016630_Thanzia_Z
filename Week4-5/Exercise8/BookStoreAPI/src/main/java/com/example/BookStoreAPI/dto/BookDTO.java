package com.example.BookStoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;

    @NotNull(message = "Author cannot be null")
    @Size(min = 1, max = 100, message = "Author must be between 1 and 100 characters")
    private String author;

    @NotNull(message = "Price cannot be null")
    private double price;

    @NotNull(message = "ISBN cannot be null")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;
}
