import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class swingone
{
	static final int width=300;
	static final int height=200;
	
	JFrame a=new JFrame("信息管理");
	a.setDefaultCloseOperation()
	
	public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)
	{
		constraints.gridx=x;
		constraints.gridy=y;
		constraints.gridwidth=w;
		constraints.gridheight=h;
		
	}

	

}
