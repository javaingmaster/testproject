package Solar_system;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Solar_system extends Frame
{
	public void launchframe(int my_width,int my_height,int x_location,int y_location)
	{
		setSize(my_width,my_height);
		setLocation(x_location,y_location);
		setVisible(true);
		
		new PaintThread().start();//启动动画线程
		addWindowListener(new WindowAdapter()
		{

			public void windowClosing(WindowEvent arg0) {
			System.exit(0);
			}
			
		});
	}
	class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
