
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
t1.setName("sreeja");
t2.setName("rishi");
//send the requests for berths
t1.start();
t2.start();

}
}