package zty.java.restart;

public class MyThread implements Runnable{

	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName());
			}	
	}
	/*Bank bank=new Bank(5);
	Acount a0=new Acount(bank,0);
	Acount a1=new Acount(bank,1);
	Acount a2=new Acount(bank,2);
	Acount a3=new Acount(bank,3);
	Acount a4=new Acount(bank,4);
	
	Thread tbank=new Thread(bank);
	tbank.setName("bank");
	Thread t0=new Thread(a0);
	tbank.setName("a0");
	Thread t1=new Thread(a1);
	tbank.setName("a1");
	Thread t2=new Thread(a2);
	tbank.setName("a2");
	Thread t3=new Thread(a3);
	tbank.setName("a3");
	Thread t4=new Thread(a4);
	tbank.setName("a4");
	
	tbank.start();
	t0.start();
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	
	try {
		Thread.currentThread().sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	int sum=0;
	System.out.println("全部操作之后");
	for(int i=0;i<5;i++){
		System.out.print(bank.acounts[i]+"  ");
		sum+=bank.acounts[i];
	}
	System.out.println();
	System.out.println("总额: "+sum);
	    //Thread.currentThread().setPriority(5);
	   // Thread.currentThread().setName("main");
		//Runnable r=new MyThread();
		//Thread t=new Thread(r);
		//t.setPriority(10);
		//t.setName("t");
		//t.start();
			//t.sleep(1000);注意线程在执行sleep和wait调用interrupt则没有用，因为此时线程是阻塞状态
			//t.interrupt();
			/*if(t.isInterrupted()){
				System.out.println("线程"+t.getName()+"已经被中断");
			}else{
				System.out.println(t.getName()+"线程继续执行");
			}*/
		
		//t.currentThread().isInterrupted()线程是否被中断
		//t.interrupt();中断线程
		/*while(true){
		System.out.println(Thread.currentThread().getName());
		}*/
		//一个线程只有被执行yield或者被阻塞或等待时，线程才失去控制权
		//当a线程想获得b线程的锁时进入阻塞，直到他获得锁
		//线程run方法正常退出或者出错死亡后线程进入终止状态
	   //yield使线程让步，把cpu让给优先级大于等于该线程的线程
		
		//t.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
		

}
