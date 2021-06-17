public class MainThread0
{
public static void main(String args[])
{
Thread t = Thread.currentThread();

System.out.println(" Current Thread Name : " + t);
t.setName("Rishitha");
System.out.println("After Changing the Name : " +t);
}
}