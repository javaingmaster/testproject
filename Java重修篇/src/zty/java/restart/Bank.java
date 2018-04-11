package zty.java.restart;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank implements Runnable{

	public int[] acounts;
	public int sum;
	
	public Bank(int numbers){
		acounts=new int[numbers];
		for(int i=0;i<5;i++){
			acounts[i]=150;
		}
		sum=500*numbers;
	}
	@Override
	public void run() {			
	}

}
