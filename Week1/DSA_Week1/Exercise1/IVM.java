
import java.util.*;

class Product
{
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId,String productName,int quantity,double price)
    {
        this.productId=productId;
        this.productName=productName;
        this.quantity=quantity;
        this.price=price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

}

class InventoryManagementSystem {
     Map<Integer, Product> inventory = new HashMap<>();
     Scanner sc= new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n--- Inventory Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display All Products");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public void addProduct() {
        System.out.print("Enter Product ID: ");
        int productId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        Product product = new Product(productId, productName, quantity, price);
        inventory.put(productId, product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int productId = sc.nextInt();
        
        Product product = inventory.get(productId);
        if (product != null) {
            System.out.print("Enter New Product Name: ");
            String productName = sc.nextLine();
            sc.nextLine();
            System.out.print("Enter New Quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();
            product.setProductName(productName);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int productId = sc.nextInt();
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println("ID  " + product.getProductId());
                System.out.println("Name  "  +product.getProductName());
                System.out.println("Quantity  " + product.getQuantity());
                System.out.println("Price  " + product.getPrice());
               
            }
        }
    }

    public void menu() {
        int option;
        do {
            displayMenu();
            option = sc.nextInt();
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 5);
       
    }
}


public class IVM {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        ims.menu();
    }
}

/*
OUTPUT:

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 1
Enter Product ID: 1
Enter Product Name: pen
Enter Quantity: 5
Enter Price: 5
Product added successfully.

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 1
Enter Product ID: 2
Enter Product Name: pencil
Enter Quantity: 10
Enter Price: 3
Product added successfully.

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 4
ID  1
Name  pen
Quantity  5
Price  5.0
ID  2
Name  pencil
Quantity  10
Price  3.0

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 2
Enter Product ID to update: 2
Enter New Product Name: Sharpner
Enter New Quantity: 67
Enter New Price: 4
Product updated successfully.

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 3
Enter Product ID to delete: 1
Product deleted successfully.

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 4
ID  2
Name
Quantity  67
Price  4.0

--- Inventory Management System ---
1. Add Product
2. Update Product
3. Delete Product
4. Display All Products
5. Exit
Choose an option: 5
Exiting...
 */