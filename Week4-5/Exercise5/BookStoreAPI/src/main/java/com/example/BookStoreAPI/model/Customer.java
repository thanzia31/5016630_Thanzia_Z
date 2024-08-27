package com.example.BookStoreAPI.model;

import lombok.Data;

@Data
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String password;
}
