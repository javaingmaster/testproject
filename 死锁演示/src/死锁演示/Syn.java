package ������ʾ;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Syn 
{
	public static void main(String[] args)
	{
		Timer t=new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("����");
			}
		}, new Date(System.currentTimeMillis()+1500),500);
		
	}

}

