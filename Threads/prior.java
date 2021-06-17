class MyClass extends Thread
{
	int count = 0; 	//this counts numbers
	public void run()
	{
		for(int i = 1; i<=10000; i++)
		count++;	//count numbers upto 10000
		// display which thread has completed counting and its priority
		System.out.println("completed Thread : " + Thread.currentThread().getName());
		System.out.println("Its Priority :" + Thread.currentThread().getPriority());
	}
}

class Prior
{
public static void main(String args[])
{
	MyClass obj = new MyClass();
	//create two threads
	Thread t1 = new Thread(obj, "First");
	Thread t2 = new Thread(obj, "Second");
	
	//set Priorities for them
	t1.setPriority(2);
	t2.setPriority(Thread.NORM_PRIORITY); //This means priority no is 5

	//start first t1 and then t2
	t1.start();
	t2.start();
}
}