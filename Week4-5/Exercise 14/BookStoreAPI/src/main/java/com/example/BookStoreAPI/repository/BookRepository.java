package com.example.BookStoreAPI.repository;

import com.example.BookStoreAPI.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(String title, String author);
}
