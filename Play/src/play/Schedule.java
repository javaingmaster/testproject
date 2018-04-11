package play;

import java.util.Date;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 10, 2017
 * @description The class to manage the things that will take place in the game
 *              by the time.
 *
 */
public class Schedule implements Runnable {
	
	Date starttime=new Date();
	
	static long start;
	static long end;
	static long time;
	
	@Override
	public void run() {
		start=starttime.getTime();
	}
	
	public void checktime(){
		
		 Date processtime=new Date();	                   
         time=(processtime.getTime()-start)/1000;
         System.out.println(time); 
	}
	
	public void getendtime(){
		Date endtime=new Date();	                   
        long time=(endtime.getTime()-start)/1000;
       // System.out.println("this time is: "+time);
	}
	
	public long getthismonment(){
		return this.time;
	}
}
