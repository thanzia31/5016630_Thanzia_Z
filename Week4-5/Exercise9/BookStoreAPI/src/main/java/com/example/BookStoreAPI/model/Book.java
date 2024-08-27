package com.example.BookStoreAPI.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Version
    private Long version; // Optimistic locking field
}
