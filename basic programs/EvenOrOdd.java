import java.util.Scanner;
class EvenOrOdd{
public static void main(String[] args){
int num;
Scanner sc = new Scanner(System.in);
System.out.println("Enter a number: ");
num = sc.nextInt();
sc.close();
if(num % 2 == 0)
System.out.println("The given number is Even");
else
System.out.println("The given number is Odd");
}
}