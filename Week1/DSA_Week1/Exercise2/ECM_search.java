

import java.util.*;

class Product{

    int productId;
    String productName;
    String category;
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    
}

class Search
{
    public static Product Linear(List<Product> products,int tar)
    {
        for(int i=0;i<products.size();i++)
        {
            if(products.get(i).getProductId() == tar)
            {
                return products.get(i);
            }
            
        }
        return null;
    }



    public static Product Binary(List<Product> products,int tar)
    {

        Collections.sort(products, Comparator.comparingInt(Product::getProductId));
        int start=0;
        int stop=products.size()-1;

        while(start<=stop)
        {
            int mid=(start+stop)/2;

            if(products.get(mid).getProductId() == tar)
            {
                return products.get(mid);
            }
            else if (products.get(mid).getProductId()<tar) {

                start=mid+1;
                
            }
            else
            {
                stop=mid-1;
            }
        }
        return null;

    }
}



public class ECM_search {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(int id, String name, String category) {
        products.add(new Product(id, name, category));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Find Product using Linear Search");
            System.out.println("3. Find Product using Binary Search");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Product Category: ");
                    String category = sc.nextLine();
                    addProduct(id, name, category);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    
                    System.out.print("Enter Product ID to search: ");
                    int searchIdLinear = sc.nextInt();
                    sc.nextLine();  
                    Product foundProductLinear = Search.Linear(products, searchIdLinear);
                    if (foundProductLinear != null) {
                        System.out.println("Product found: ");
                        System.out.println("Product Id:  " + foundProductLinear.getProductId());
                        System.out.println("Product Name: " + foundProductLinear.getProductName());
                        System.out.println("Product Category:  " + foundProductLinear.getCategory());

                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    
                    System.out.print("Enter Product ID to search: ");
                    int searchIdBinary = sc.nextInt();
                    sc.nextLine(); 
                    Product foundProductBinary = Search.Binary(products, searchIdBinary);
                    if (foundProductBinary != null) {
                        System.out.println("Product found: ");
                        System.out.println("Product Id:  " + foundProductBinary.getProductId());
                        System.out.println("Product Name: " + foundProductBinary.getProductName());
                        System.out.println("Product Category:  " + foundProductBinary.getCategory());
                    } else {
                        System.out.println("Product not found.");
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

/*
OUTPUT:

Menu:
1. Add Product
2. Find Product using Linear Search
3. Find Product using Binary Search
4. Exit
Enter your choice: 1
Enter Product ID: 3
Enter Product Name: aaa
Enter Product Category: b
Product added successfully!
Menu:
1. Add Product
2. Find Product using Linear Search
3. Find Product using Binary Search
4. Exit
Enter your choice: 1
Enter Product ID: 2
Enter Product Name: rrr
Enter Product Category: a
Product added successfully!
Menu:
1. Add Product
2. Find Product using Linear Search
3. Find Product using Binary Search
4. Exit
Enter your choice: 2
Enter Product ID to search: 2
Product found: 
Product Id:  2
Product Name: rrr
Product Category:  a
Menu:
1. Add Product
2. Find Product using Linear Search
3. Find Product using Binary Search
4. Exit
Enter your choice: 3
Enter Product ID to search: 2
Product found:
Product Id:  2
Product Name: rrr
Product Category:  a
Menu:
1. Add Product
2. Find Product using Linear Search
3. Find Product using Binary Search
4. Exit
Enter your choice: 4
Exiting...
 */
