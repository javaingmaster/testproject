package test;

public class test
{
	public static void main(String[] args)
	{
		Object a=new Object();
		Object b=new Object();
		Situationone s1=new Situationone(a,b);
		Situationtwo s2=new Situationtwo(a,b);
		Thread one=new Thread(s1);
		Thread two=new Thread(s2);
		one.start();
		two.start();
	}
	
}
class Situationone implements Runnable{

	Object a;
	Object b;
	public Situationone(Object a,Object b)
	{
		this.a=a;
		this.b=b;
	}
	public void run()
	{
		while(true)
		{
			go();
		}
	}
	public void go()
	{
		synchronized(a){
		try{
			Thread.sleep(500);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		synchronized(b){			
		}
	}
	System.out.println("没有被死锁");
}
}
class Situationtwo implements Runnable{

		Object a;
		Object b;
		public Situationtwo(Object a,Object b)
		{
			this.a=a;
			this.b=b;
		}
		public void run()
		{
			while(true)
			{
				go();
			}
		}
		public void go()
		{
			synchronized(b){
			try{
				Thread.sleep(500);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			synchronized(a){			
			}
		}
		System.out.println("没有被死锁");
	}
	}
