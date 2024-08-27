package com.example.BookStoreAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    
    // To exclude password from serialization
    @JsonIgnore
    private String password;
}
