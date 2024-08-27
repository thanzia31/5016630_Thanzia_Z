package com.example.BookStoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private Long id;
    
    @JsonProperty("bookTitle")
    private String title;
    
    @JsonProperty("bookAuthor")
    private String author;
    
    private double price;
    private String isbn;
}
