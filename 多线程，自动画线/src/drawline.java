
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;



public class drawline extends JFrame
{
	private Thread t;
	private static int[] color=new int[256];	
	private static final Random rand=new Random();
	private static int getC()
	{
		for(int m=0;m<255;m++)
		{
			color[m]=m;
		}
		return color[rand.nextInt(color.length)];
	}
	public drawline()
	{
		t=new Thread(new Runnable(){
			int x=30;
			int y=50;
			public void run()
			{
				while(true)
				{
					try{
						t.sleep(100);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					Graphics graphics=getGraphics();
					Color c=new Color(getC(),getC(), getC());
					graphics.setColor(c);
					graphics.drawLine(x, y, 100, y++);
					if(y>=80)
					{
						y=50;
					}
				}
			}
		});
		t.start();
	}
	public static void main(String[] args)
	{
		init(new drawline(),100,100);
	}
	public static void init(JFrame frame,int width,int height)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
	}
}
