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
		

			int k=20;
		    this.setLayout(null);
		    
		    
		    for(int p=0;p<count-1;p++)//   验证不粘连图像分割
		    {			    	
		    ImageIcon c=new ImageIcon();
			JLabel l=new JLabel();
			c.setImage(sub[p]);
			l.setIcon(c);
			this.add(l);
			l.setBounds(k,50,250,250);
			k+=90;			
		    }
	    
		
		this.setSize(1600, 800);
		this.setLocation(50, 50);
		this.setVisible(true);
	}

	
}
