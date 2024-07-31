


import java.util.*;

class Employee
{
    int empId;
    String empName;
    String pos;
    double sal;
    public Employee(int empId, String empName, String pos, double sal) {
        this.empId = empId;
        this.empName = empName;
        this.pos = pos;
        this.sal = sal;
    }
    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getPos() {
        return pos;
    }
    public void setPos(String pos) {
        this.pos = pos;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    
    
}

class EmployeeFunctions
{
    ArrayList<Employee> arr=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    public void add()
    {
        System.out.println("Enter Employee ID:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Employee Name");
        String name=sc.nextLine();
        System.out.println("Enter Position");
        String pos=sc.nextLine();
        System.out.println("Enter Salary");
        double sal=sc.nextDouble();

        Employee emp=new Employee(id, name, pos, sal);
        arr.add(emp);

    }
public void search()
{
    int id;
    int flag=0;
    System.out.println("Enter id of employee to search");

    id=sc.nextInt();
    for(int i=0;i<arr.size();i++)
    {
        if(arr.get(i).getEmpId()==id)
        {
            System.out.println("Employee Found");
            System.out.println("Employee id : " + arr.get(i).getEmpId());
            System.out.println("Employee Name : " + arr.get(i).getEmpName());
            System.out.println("Employee Position : " +arr.get(i).getPos());
            System.out.println("Employee Salary : " +arr.get(i).getSal());
            flag=1;
            break;
        }
    }
    if(flag==0)
    {
        System.out.println("Employee not found");
    }
}
public void traverse()
{
    
    
    for(int i=0;i<arr.size();i++)
    {
        
            
            System.out.println("Employee id : " + arr.get(i).getEmpId());
            System.out.println("Employee Name : " + arr.get(i).getEmpName());
            System.out.println("Employee Position : " +arr.get(i).getPos());
            System.out.println("Employee Salary : " +arr.get(i).getSal());
            System.out.println();
           
        
    }
    
}
public void delete()
{
    int id;
    int flag=0;
    System.out.println("Enter id of employee to delete");

    id=sc.nextInt();
    for(int i=0;i<arr.size();i++)
    {
        if(arr.get(i).getEmpId()==id)
        {
            arr.remove(arr.get(i));
            System.out.println("Employee Deleted");
        
            flag=1;
            break;
        }
    }
    if(flag==0)
    {
        System.out.println("Employee not found");
    }
}
    public void menu(){
        
        int option;
        do {
        System.out.println("\n--- Employee Management System ---");
        System.out.println("1. Add Employee");
        System.out.println("2. Search Employee");
        System.out.println("3. Traverse");
        System.out.println("4. Delete");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
            
            option = sc.nextInt();
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    traverse();
                    break;
                case 4:
                    delete();
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

public class EMS
{
    public static void main(String args[])
    {
        EmployeeFunctions emp=new EmployeeFunctions();

        emp.menu();
        
    }
}


/*
OUTPUT:
--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option:1
Enter Employee ID:
1
Enter Employee Name
aaa
Enter Position
manager
Enter Salary
34500

--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option: 1
Enter Employee ID:
2
Enter Employee Name
bbb
Enter Position
developer
Enter Salary
6000

--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option: 3
Employee id : 1
Employee Name : aaa
Employee Position : manager
Employee Salary : 34500.0

Employee id : 2
Employee Name : bbb
Employee Position : developer
Employee Salary : 6000.0


--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option: 2
Enter id of employee to search
2
Employee Found
Employee id : 2
Employee Name : bbb
Employee Position : developer
Employee Salary : 6000.0

--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option: 4
Enter id of employee to delete
1
Employee Deleted

--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option: 3
Employee id : 2
Employee Name : bbb
Employee Position : developer
Employee Salary : 6000.0


--- Employee Management System ---
1. Add Employee
2. Search Employee
3. Traverse
4. Delete
5. Exit
Choose an option: 5
Exiting...
 */