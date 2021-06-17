class A extends Thread
{
int i =1;
public void run()
{
while(i<=10)
{

System.out.println("i = "+i);
try
{
Thread.sleep(1000);
}
catch(Exception e)
{
}
i++;
}
}
}



class SleepDemo
{
public static void main(String args[])
{
A a = new A();
a.start();
}
}