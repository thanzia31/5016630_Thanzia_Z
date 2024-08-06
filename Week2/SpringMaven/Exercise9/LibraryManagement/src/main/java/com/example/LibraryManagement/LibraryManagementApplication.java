package com.example.LibraryManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

}


/* Commands to execute 
 

Add a Book:
curl -X POST http://localhost:8080/books -H "Content-Type: application/json" -d "{\"title\": \"The Great Gatsby\", \"author\": \"F. Scott Fitzgerald\", \"isbn\": \"9780743273565\"}"


Get All Books:
curl -X GET http://localhost:8080/books


Get a Single Book by ID :
curl -X GET http://localhost:8080/books/1


Update a Book by ID:
curl -X PUT http://localhost:8080/books/1 -H "Content-Type: application/json" -d "{\"title\": \"Updated Title\", \"author\": \"Updated Author\", \"isbn\": \"1234567890\"}"


Delete a Book by ID:
curl -X DELETE http://localhost:8080/books/1
 
 */