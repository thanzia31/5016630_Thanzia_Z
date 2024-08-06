package com.library;

    	import org.springframework.context.ApplicationContext;
    	import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;  

/**
 * Hello world!
 *
 */

//Exercise 1
public class App 
{
    public static void main( String[] args )
    {	       
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        BookService bookService = (BookService) context.getBean("bookService");
       //Exercise 2
        bookService.addBook(1, "Helen Keller");
        bookService.addBook(2, "Twisted Fate");
        bookService.addBook(3, "November story");

        System.out.println("Book with ID 1: " + bookService.getBookById(1));

       
        System.out.println("All books:");
        bookService.printAllBooks();
    	
    }
}
