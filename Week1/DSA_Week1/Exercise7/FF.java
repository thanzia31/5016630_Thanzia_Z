
import java.util.*;
public class FF {

    
    public static double calculateFutureValue(double principal, double rate, int periods) {
        
        if (periods == 0) {
            return principal;
        }
        
        return calculateFutureValue(principal, rate, periods - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter principal value:");
        double principal = sc.nextDouble(); 
        System.out.println("Enter rate in percentage:");
        double rate = sc.nextDouble();   
        System.out.println("Enter period:");     
        int periods =sc.nextInt();          

        double futureValue = calculateFutureValue(principal, rate/100, periods);
        System.out.println("Future Value: " + futureValue);
    }
}

/*
OUTPUT:
Enter principal value:
1000
Enter rate in percentage:
10
Enter period:
4
Future Value: 1464.1000000000001
 */
