package com.library;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	BookRepository()
	{
		System.out.println("Inside Book repository");
	}

}
