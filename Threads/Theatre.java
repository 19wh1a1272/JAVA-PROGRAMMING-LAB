class MyThread implements Runnable
{
	String str;
	MyThread(String str)
	{
	this.str = str;
	}
	
	public void run()
	{
		for (int i =0;i<5;i++)
		{
		System.out.println(str + ": " + i);
		try
		{
		Thread.sleep(2000);
		}
		catch(InterruptedException ie)
		{
		ie.printStackTrace();
		}
		}
	}
}

class Theatre
{
public static void main(String args[])
{
MyThread obj1 = new MyThread("Cut the Ticket");
MyThread obj2 = new MyThread("Show the Seat");
Thread t1 = new Thread(obj1);
Thread t2 = new Thread(obj2);
t1.start();
t2.start();
}
}