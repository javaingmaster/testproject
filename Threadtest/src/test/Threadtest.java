package test;

public class Threadtest extends Thread 
{
	public static void main(String[] args) throws InterruptedException
	{
		Study s=new Study();
		Studytwo two=new Studytwo();
		Thread th=new Thread(s);
		Thread th2=new Thread(two);
		th.start();
		th2.start();

		int m=0;
		while(true)
		{
			System.out.println("mainmain"+m+"mainmain");
			if(m==50)
			{
				th.sleep(10000);
				th2.sleep(10000);
			}
		}
	}	
		
		/*public void run()
		{
		for(int i=0;i<100;i++)
		{
			if(i==50)
			{
				System.out.println("mainmain"+i+"mainmain");
			}
		}
		
		}*/
}

class Study implements Runnable
{
	boolean flag=true;
	int m=0;
	public void run()
	{
		while(flag)
		{
			System.out.println("***ss**"+m+"**sss***");
			m++;
		}
		
	}
	public void stop()
	{		
		this.flag=false;
	}
	
}
class Studytwo implements Runnable
{
	boolean flag=true;
	int m=0;
	public void run()
	{
		while(flag)
		{
			System.out.println("------"+m+"-------");
			m++;
		}
		
	}
	public void stop()
	{		
		this.flag=false;
	}
	
}