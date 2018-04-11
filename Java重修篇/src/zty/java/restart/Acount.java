package zty.java.restart;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Acount implements Runnable{
	
	private Lock bankLock;
	public Bank bank;
	private int acount_id;
	
	public Acount(Bank bank,int id){
		//bankLock=new ReentrantLock();
		this.bank=bank;
		this.acount_id=id;
	}

	public void transfer(int from,int to,int amount){	
		synchronized(bank){
		try{
			if(bank.acounts[from]<150){
				wait();
			}
				int sum=0;	
				System.out.println(Thread.currentThread().getName()+"线程正在执行");
				bank.acounts[from]-=amount;
				bank.acounts[to]+=amount;	
				System.out.println(Thread.currentThread().getName()+"线程从"+acount_id+"转到"+to);
				System.out.println(Thread.currentThread().getName()+"线程操作之后");
				for(int i=0;i<5;i++){
					System.out.print(bank.acounts[i]+"  ");
					sum+=bank.acounts[i];
				}
				System.out.println();
				System.out.println("总额: "+sum);
				notifyAll();
				
		}catch(Exception e){
			//System.out.println(e);
		}
	  }
	}
	
	public void run() {	
		transfer(acount_id,(int)(bank.acounts.length*Math.random()),150);
		transfer(acount_id,(int)(bank.acounts.length*Math.random()),150);
	}

}
