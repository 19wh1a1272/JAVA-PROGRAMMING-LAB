class B extends Thread
{

public void run()
{
for (int j=0;j<=5;j++)
{
System.out.println("Threa B =" + j);
}
System.out.println("End of Threa B");
}
}


class SetPriority
{
public static void main(String args[])
{
A a = new A();
B b = new B();

a.setPriority(Thread.MAX_PRIORITY);
b.setPriority(Thread.MIN_PRIORITY);

a.start();
b.start();


System.out.println(" Main Thread--Hello");

}
}





