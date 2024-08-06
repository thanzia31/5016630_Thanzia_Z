package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.BookService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        BookService bookService = (BookService) context.getBean("bookService");
       
        System.out.println("BookService bean: " + bookService);
        bookService.display();
    }
}
