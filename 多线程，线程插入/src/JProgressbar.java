import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class JProgressbar extends JFrame
{
	private Thread one;
	private Thread two;
	final JProgressBar bar1=new JProgressBar();
	final JProgressBar bar2=new JProgressBar();
	int count=0;
	public static void main(String[] args)
	{
		init(new JProgressbar(),100,100);
	}
	public JProgressbar()
	{
		super();
		getContentPane().add(bar1,BorderLayout.NORTH);
		getContentPane().add(bar2,BorderLayout.SOUTH);
		bar1.setStringPainted(true);
		bar2.setStringPainted(true);
		one=new Thread(new Runnable(){
		int count=0;
		public void run()
		{
			while(true)
			{			
				bar1.setValue(++count);
				if(count==45)
				{
					try{			
					one.sleep(100);
					two.join();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				}
				else{continue;}
			}
		}
		});
		one.start();
		two=new Thread(new Runnable(){
		int count=0;
		public void run()
		{
			while(true)
			{
				bar2.setValue(++count);
				try{
					two.sleep(100);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				if(count==100)
				{
					break;
				}
			}
		}
		});
		two.start();
	}
	public static void init(JFrame frame,int width,int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
	}
}
