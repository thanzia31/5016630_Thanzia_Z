package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.BookService;
import com.library.BookRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
BookRepository bookRepository = new BookRepository();
        //constructor check
        BookService bookService = (BookService) context.getBean("bookService");
        
        //setter method check
        
        bookService.setBookRepository(bookRepository);
        System.out.println("BookService bean retrieved: " + (bookService != null));
    }
}
