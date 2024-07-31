import java.util.*;

class Library
{
    int bookId;
    String title;
    String author;
    public Library(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    

}

class Search
{
    public static Library Linear(LinkedList<Library> books,String tar)
    {
        for(int i=0;i<books.size();i++)
        {
            if(books.get(i).getTitle().equals(tar) || books.get(i).getAuthor().equals(tar) )
            {
                return books.get(i);
            }
            
        }
        return null;
    }


    
    public static Library binarySearchByTitle(List<Library> books, String title) {
        Collections.sort(books, Comparator.comparing(Library::getTitle));
        int start = 0;
        int stop = books.size() - 1;

        while (start <= stop) {
            int mid = (start + stop) / 2;
            int comparison = books.get(mid).getTitle().compareTo(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                start = mid + 1;
            } else {
                stop = mid - 1;
            }
        }
        return null;
    }

    
     public static Library binarySearchByAuthor(List<Library> books, String author) {
        Collections.sort(books, Comparator.comparing(Library::getAuthor));
        int start = 0;
        int stop = books.size() - 1;

        while (start <= stop) {
            int mid = (start + stop) / 2;
            int comparison = books.get(mid).getAuthor().compareTo(author);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                start = mid + 1;
            } else {
                stop = mid - 1;
            }
        }
        return null;
    }
    public static Library Binary(LinkedList<Library> books, String tar) {
        
        Library result = binarySearchByTitle(books, tar);
        if (result != null) {
            return result;
        }

        
        result = binarySearchByAuthor(books, tar);
        return result;
    }
}


class LMS
{
    
        private static LinkedList<Library> books = new LinkedList<>();

    public static void add(int id, String name, String title) {
        books.add(new Library(id, name, title));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Find Book using Linear Search");
            System.out.println("3. Find Book using Binary Search");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  
                    System.out.print("Enter Author Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String category = sc.nextLine();
                    add(id, name, category);
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    
                    System.out.print("Enter Book Title or Author to search: ");
                    String search = sc.nextLine();
                     
                    Library foundProductLinear = Search.Linear(books, search);
                    if (foundProductLinear != null) {
                        System.out.println("Book found: ");
                        System.out.println("Book Id:  " + foundProductLinear.getBookId());
                        System.out.println("Author Name: " + foundProductLinear.getAuthor());
                        System.out.println("Book Title:  " + foundProductLinear.getTitle());

                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    
                    System.out.print("Enter Book Title or Author to search: ");
                    String searchStr = sc.nextLine();
                    
                    Library foundProductBinary = Search.Binary(books, searchStr);
                    if (foundProductBinary != null) {
                        System.out.println("Book found: ");
                        System.out.println("Book Id:  " + foundProductBinary.getBookId());
                        System.out.println("Author Name: " + foundProductBinary.getAuthor());
                        System.out.println("Book Title:  " + foundProductBinary.getTitle());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
    }
}
}
