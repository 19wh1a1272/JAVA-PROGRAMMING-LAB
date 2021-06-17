class A extends Thread
{
public A(String s)
{
super(s);
}
public void run()
{
for (int i=0;i<=5;i++)
{
System.out.println(getName());
}
}
}


class ThreadbyThread
{
public static void main(String args[])
{
A a1 = new A("sreeja");
A a2 = new A ("rishi");
A a3 = new A ("sahit");
a1.start();
a2.start();
a3.start();

System.out.println(" Hello");

}
}