package library.librarymanaging;


import library.librarymanaging.BookRepository;
import java.util.*;

public class BookService {
	private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
   


    public void displayBook(){
        System.out.println("The Book Repository is : "+bookRepository);
    }

}
