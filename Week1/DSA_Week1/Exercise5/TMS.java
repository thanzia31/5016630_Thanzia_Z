import java.util.*;

class Task
{
    int taskId;
    String taskName;
    int status;
    public Task(int taskId, String taskName, int status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
}

class Node{
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

 class TaskManager {

    public void addTask(Node[] headTail, Task task) {
        Node head = headTail[0];
        Node tail = headTail[1];
        Node newNode = new Node(task);

        if (head == null) {
            headTail[0] = newNode; 
            headTail[1] = newNode; 
        } else {
            tail.next = newNode;
            headTail[1] = newNode; 
        }

        System.out.println("Task added successfully.");
    }

    public void searchTask(Node head, int id) {
        Node current = head;
        int flag=0;
        while (current != null) {
            if (current.task.getTaskId() == id) {
                System.out.println("Task Found");
                flag=1;
                System.out.println("Task ID: " + current.task.getTaskId());
                System.out.println("Task Name: " + current.task.getTaskName());
                System.out.print("Task Status: ");
                if (current.task.getStatus() != 0) {
                    System.out.println("Completed");
                } else {
                    System.out.println("Not Completed");
                }
                return;
            }
            current = current.next;
        }
        if(flag==0)
        {
        System.out.println("Task not found");
        }
    }

    public void traverseTasks(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.task.getTaskId());
            System.out.println("Task Name: " + current.task.getTaskName());
            System.out.print("Task Status: ");
            if (current.task.getStatus() != 0) {
                System.out.println("Completed");
            } else {
                System.out.println("Not Completed");
            }
            System.out.println();
            current = current.next;
        }
    }

    public void deleteTask(Node[] headTail, int id) {
        Node head = headTail[0];
        Node tail = headTail[1];
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.task.getTaskId() == id) {
                if (previous == null) {
                    headTail[0] = current.next; 
                } else {
                    previous.next = current.next;
                }
                if (current == tail) {
                    headTail[1] = previous; 
                }
                System.out.println("Task Deleted");
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Task not found");
    }
}


public class TMS {
    public static void main(String[] args) {
        Node head = null;
        Node tail = null;
        Node[] headTail = {head, tail}; 
        TaskManager taskManager = new TaskManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    
                    System.out.println("Enter Task ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Task Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Status (Enter 0 if task not completed and 1 if task completed):");
                    int status = sc.nextInt();

                    Task task = new Task(id, name, status);
                    taskManager.addTask(headTail, task);
                    head = headTail[0];
                    tail = headTail[1];
                    break;

                case 2:
                    
                    System.out.println("Enter ID of task to search:");
                    int searchId = sc.nextInt();
                    taskManager.searchTask(head, searchId);
                    break;

                case 3:
                    taskManager.traverseTasks(head);
                    break;

                case 4:
                   
                    System.out.println("Enter ID of task to delete:");
                    int deleteId = sc.nextInt();
                    taskManager.deleteTask(headTail, deleteId);
                    head = headTail[0];
                    tail = headTail[1];
                    break;

                case 5:
                    System.out.println("Exiting...");
                    
                    return;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}

/*
 OUTPUT:
 
 --- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 1
Enter Task ID:
1
Enter Task Name:
water filling
Enter Status (Enter 0 if task not completed and 1 if task completed):
0
Task added successfully.

--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 1
Enter Task ID:
3
Enter Task Name:
Groceries shopping
Enter Status (Enter 0 if task not completed and 1 if task completed):
1
Task added successfully.

--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 1
Enter Task ID:
5
Enter Task Name:
Electricity Bill payment
Enter Status (Enter 0 if task not completed and 1 if task completed):
0
Task added successfully.

--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 3
Task ID: 1
Task Name: water filling
Task Status: Not Completed

Task ID: 3
Task Name: Groceries shopping
Task Status: Completed

Task ID: 5
Task Name: Electricity Bill payment
Task Status: Not Completed


--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 2
Enter ID of task to search:
5
Task Found
Task ID: 5
Task Name: Electricity Bill payment
Task Status: Not Completed

--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 4
Enter ID of task to delete:
3
Task Deleted

--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 3
Task ID: 1
Task Name: water filling
Task Status: Not Completed

Task ID: 5
Task Name: Electricity Bill payment
Task Status: Not Completed


--- Task Management System ---
1. Add Task
2. Search Task
3. Traverse
4. Delete
5. Exit
Choose an option: 5
Exiting...
 
 */