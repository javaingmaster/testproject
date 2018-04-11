package ttt;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Newframe extends JFrame
{
	BufferedImage[] sub;
	int count;
	
	public Newframe(BufferedImage[] sub,int count)
	{
		this.sub=sub;
		this.count=count;
		
		for(int i=0;i<count;i++)
	    {
	    	JLabel l=new JLabel();
	    	l.setIcon(new ImageIcon(sub[i]));
	    	l.setVisible(true);
	    }
		
		this.setSize(1600, 800);
		this.setLocation(50, 50);
		this.setVisible(true);
	}

	
}
