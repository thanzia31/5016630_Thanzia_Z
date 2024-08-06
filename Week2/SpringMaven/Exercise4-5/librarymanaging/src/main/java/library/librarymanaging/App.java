package library.librarymanaging;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import library.librarymanaging.BookService; 

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	

/**
 * Hello world!
 *
 */

//Exercise 1

ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        
        BookService bookService = (BookService) context.getBean("bookService");
       //Exercise 2
        bookService.displayBook();
        
        
    	
 

    }
}
