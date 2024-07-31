
import java.util.*;
class Order
{
    int orderId;
    String customerName;
    int totalPrice;

    public Order(int orderId, String customerName, int totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    
}

class Sort
{
    public static void bubble(List<Order> orders)
    {
        int n = orders.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1-i; j++) {
                if (orders.get(j).getTotalPrice() > orders.get(j + 1).getTotalPrice()) {
                    
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break; 
            }
        }
    }


    public static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1); 
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(List<Order> orders, int low, int high) {
        int pivot = orders.get(high).getTotalPrice(); 
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() < pivot) {
                i++;
                
                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }

        
        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }
}


public class SortC {

    private static List<Order> orders = new ArrayList<>();

    public static void addProduct(int id, String name, int price) {
        orders.add(new Order(id, name, price));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Sort using Bubble sort");
            System.out.println("3. Sort using Quick Sort");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Customer Total price: ");
                    int price = sc.nextInt();
                    addProduct(id, name, price);
                    System.out.println("Order added successfully!");
                    break;

                case 2:
                    
                    
                     
                    Sort.bubble(orders);
                    System.out.println("Orders Sorted click choice 4 to display sorted orders");
                    
                    break;

                case 3:
                    
                    
                    
                    Sort.quickSort(orders,0,orders.size()-1);
                    System.out.println("Orders Sorted click choice 4 to display sorted orders");
                    
                    break;
                    case 4:

                    System.out.println("The Orders are ");
                    for(int i=0;i<orders.size();i++)
                    {
                        System.out.println("Order Id : " +orders.get(i).getOrderId());
                        System.out.println("Customer Name : " +orders.get(i).getCustomerName());
                        System.out.println("Total Price : " +orders.get(i).getTotalPrice());
                    }
                    break;

                case 5:
                    
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        
    }
    
}

/*OUTPUT:
 Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 1
Enter Order ID: 3
Enter Customer Name: aaa
Enter Customer Total price: 5000
Order added successfully!
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 1
Enter Order ID: 2
Enter Customer Name: bbb
Enter Customer Total price: 2
Order added successfully!
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 4
The Orders are
Order Id : 3
Customer Name : aaa
Total Price : 5000
Order Id : 2
Customer Name : bbb
Total Price : 2
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 2
Orders Sorted click choice 4 to display sorted orders
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 4
The Orders are
Order Id : 2
Customer Name : bbb
Total Price : 2
Order Id : 3
Customer Name : aaa
Total Price : 5000
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 1
Enter Order ID: 5
Enter Customer Name: ccc
Enter Customer Total price: 1
Order added successfully!
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 4
The Orders are
Order Id : 2
Customer Name : bbb
Total Price : 2
Order Id : 3
Customer Name : aaa
Total Price : 5000
Order Id : 5
Customer Name : ccc
Total Price : 1
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 3
Orders Sorted click choice 4 to display sorted orders
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 4
The Orders are
Order Id : 5
Customer Name : ccc
Total Price : 1
Order Id : 2
Customer Name : bbb
Total Price : 2
Order Id : 3
Customer Name : aaa
Total Price : 5000
Menu:
1. Add Product
2. Sort using Bubble sort
3. Sort using Quick Sort
4. Display
5. Exit
Enter your choice: 5
Exiting...
 */
