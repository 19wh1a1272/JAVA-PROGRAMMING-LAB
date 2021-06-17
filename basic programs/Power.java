import java.util.Scanner;
public class Power{
public static void main(String[] args){
int a,b;
Scanner sc = new Scanner(System.in);
System.out.println("Enter base: ");
        a = sc.nextInt();
        
        System.out.println("Enter exponent: ");
        b = sc.nextInt();
        
        sc.close();
double result = Math.pow(a , b);
System.out.println("ans : "+result);
}
}