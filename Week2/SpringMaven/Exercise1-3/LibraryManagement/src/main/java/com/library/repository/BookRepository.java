package com.library.repository;
import java.util.*;

public class BookRepository {
	
	private Map<Integer, String> bookStorage = new HashMap<>();

    
    public void addBook(Integer id, String title) {
        bookStorage.put(id, title);
    }

    
    public String getBookById(Integer id) {
        return bookStorage.get(id);
    }

    
    public Map<Integer, String> getAllBooks() {
        return new HashMap<>(bookStorage);

}
}
