
# 1. Program main thread and currentThread() method

public class MainThread0
{
public static void main(String args[])
{
Thread t = Thread.currentThread();

System.out.println(" Current Thread Name : " + t);
t.setName("Gabber");
System.out.println("After Changing the Name : " +t);
}
}

output:




# 2.Program to use get Name and get Priority
class MainThread
{
public static void main (String args[])
{
System.out.println("Thread Name = " + Thread.currentThread().getName());
System.out.println(" Priority = " + Thread.currentThread().getPriority());
}
} 

Output




# 3. Program to create a Thread by Extending from Thread Class


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
A a1 = new A("Akshara");
A a2 = new A ("Gabber");
A a3 = new A ("Singh");
a1.start();
a2.start();
a3.start();

System.out.println(" Hello");

}
}

output1:


output2:




# 4. creating a thread by implementing Runnable interface.

class A implements Runnable
{

public void run()
{
for (int i=0;i<=5;i++)
{
System.out.println(Thread.currentThread().getName());
}
}
}


class ThreadbyRunnable
{
public static void main(String args[])
{
A a = new A();
Thread t1 = new Thread (a, "Akshara");
Thread t2 = new Thread (a, "Gabber");
Thread t3 = new Thread (a, "Singh");
t1.start();
t2.start();
t3.start();

System.out.println(" Hello");

}
}


output:


# 5. Program to implement multiple classes from Thread class

class A extends Thread
{

public void run()
{
for (int i=0;i<=5;i++)
{
System.out.println("Gabber");
}
}
}

class B extends Thread
{

public void run()
{
for (int i=0;i<=5;i++)
{
System.out.println("Akshara");
}
}
}

class C extends Thread
{

public void run()
{
for (int i=0;i<=5;i++)
{
System.out.println("II - IT");
}
}
}


class MultiClassFromThread
{
public static void main(String args[])
{
A a = new A();
B b  = new B();
C c = new C();
a.start();
b.start();
c.start();

System.out.println(" Hello");

}
}

output:


# 6. use of setPriority Method


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

output:



7. use of sleep() method

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

output:


# 8. MultiTasking using Threads



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

output1:



output2:




# 9. Multiple Thread acting on Single object - Train Berths example


class Reserve implements Runnable
{
	int available =1;
	int wanted;	

	Reserve(int i)
	{
	wanted = i;
	}
	
	public void run()
	{
		//display available seats
		System.out.println("Available berths  = " + available);

		//if available berths are more than wanted berths
		if (available >= wanted)
		{
			//get the name of passenger	
			String name = Thread.currentThread().getName();
		
			//allot the berth to him			
			System.out.println(wanted + " Berth reserved for  " + name);
			try
			{
			Thread.sleep(1500); //wait for  printing the ticket
			available = available - wanted;
			//update the no. of available berths
			}
			catch(InterruptedException ie)
			{
			//ie.printStackTrace();
			}
		}
		
		// if available berths are less, display sorry
		else System.out.println("Sorry, no berths ");
	}
}

class Train
{
public static void main(String args[])
{
// Tell that 1 berth is needed
Reserve obj = new Reserve(1);

//attach first thread to the object
Thread t1 = new Thread(obj);

//attach second thread to the object
Thread t2 = new Thread (obj);

//take the thread name as persons Names
t1.setName("Anil");
t2.setName("Gabber");
//send the requests for berths
t1.start();
t2.start();

}
}



output1:

output2:


# 10. Thread Synchonization on Train Berth

class Reserve implements Runnable
{
	int available =1;
	int wanted;	

	Reserve(int i)
	{
	wanted = i;
	}
	
	public void run()
	{
		
	synchronized(this) //Synchronize the current object
	{
		//display available seats
		System.out.println("Available berths  = " + available);

		//if available berths are more than wanted berths
		if (available >= wanted)
		{
			//get the name of passenger	
			String name = Thread.currentThread().getName();
		
			//allot the berth to him			
			System.out.println(wanted + " Berth reserved for  " + name);
			try
			{
			Thread.sleep(1500); //wait for  printing the ticket
			available = available - wanted;
			//update the no. of available berths
			}
			catch(InterruptedException ie)
			{
			//ie.printStackTrace();
			}
		}
		
		// if available berths are less, display sorry
		else System.out.println("Sorry, no berths ");
	} //end of Synchronized block
	}
}

class SychronizedTrain
{
public static void main(String args[])
{
// Tell that 1 berth is needed
Reserve obj = new Reserve(1);

//attach first thread to the object
Thread t1 = new Thread(obj);

//attach second thread to the object
Thread t2 = new Thread (obj);

//take the thread name as persons Names
t1.setName("Anil");
t2.setName("Gabber");
//send the requests for berths
t1.start();
t2.start();

}
}

OUtput:



	
	
# 11. Thread Priorities Example


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

output1:

C:\Users\Anil\Desktop\Java Practice programs\Threads>java Prior
completed Thread : First
completed Thread : Second
Its Priority :2
Its Priority :5

output2:

C:\Users\Anil\Desktop\Java Practice programs\Threads>java Prior
completed Thread : Second
Its Priority :5
completed Thread : First
Its Priority :2



Thread Group


Thread group represents several threads as a single group. The main advantage of taking several threads as a group is that
by using a single method. we will be able to control all the threads in the group

1. To create a thread group. we should simply creat an object to ThreadGroup class as
	ThreadGroup tg = new ThreadGroup("Group Name");

2. To add a thread to this group
	Thread t1 = new Thread(tg, targetobj, "thread name");

	here, t1 thread is created and added to the thread group tg, this thread acts on targetobj, which is the target 
	object for the thread. the threadname represents the name of the thread t1

3. To add another thread group(tg1) to this group(tg)
	ThreadGroup tg1 = new ThreadGroup(tg, "group name");
	
	here, we are creating and adding the thread group tg1 to the thread group tg, the name of the added group is 
	represented by groupname.

4. To know the parent of a thread or a thread group. 
	tg.getParent();

5. To know the parent thread group of a thread
	t.getThreadGroup();

6. To know the no.of threads actively running in a thread group
	tg.activeCount();


Daemon Threads

Sometimes, a thread has to continuously excecute without any interruption to provide services to other threads. such threads are called daemon threads. For example oracle.exe is a program to thread that continuously executes in a computer. when the system is switched on, it also starts running and will terminate only when the systemm is off. Any other threads like SQL+ can communicate with it to store or retrieve data. 

Daemon thread: It isa thread that executes continuouly. Daemon threads are service providers for other threads or objects. It generally provides a background processing.

1. To make a thread  t as daemon thread, we can do in the following
	t.setDaemon(true);

2. To know if a thread is daemon or not.
	boolean x = t.isDaemon();
	if isDaemon returns true, then the thread t is a daemon thread, otherwise not.
