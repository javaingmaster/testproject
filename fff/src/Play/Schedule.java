package Play;

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
	
	public boolean iscontinue=true;
	
	@Override
	public void run() {
		start=starttime.getTime();
	}
	
	public void checktime(){
		
		if(this.iscontinue){
		 Date processtime=new Date();	                   
         time=(processtime.getTime()-start)/1000;
		}
	}
	public int getendtime(){
		Date endtime=new Date();	                   
        long time=(endtime.getTime()-start)/1000;
		 return (int)(time);
	}
	public long getthismonment(){
		return this.time;
	}
}
