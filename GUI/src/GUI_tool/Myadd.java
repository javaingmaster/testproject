package GUI_tool;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Myadd extends JPanel
{
	public Myadd(){}
	public void myadd(Component e,JFrame destination,int x,int y,double width,double height)
	{
		e.setBounds(x, y, (int)width, (int)height);
	}
	public void Myotheradd(Component c,GridBagConstraints ct,int x,int y,int width,int height)
	{
		ct.gridx=x;
		ct.gridy=y;
		ct.gridwidth=width;
		ct.gridheight=height;
		add(c,ct);
	}
	
	public void test()
	{
		CreateFrame m=new CreateFrame("shit",700,500,"D://background.jpg",50,50);
		JFrame now=new JFrame();
		now=m.getframe();
		
		//GridBagLayout gridbag = new GridBagLayout();
        //GridBagConstraints c = new GridBagConstraints();
        now.setLayout(null);
        
		JLabel b=new JLabel("shit");
		//Myadd(b,c,100,25,30,30);
		
		myadd(b,now,600,100,50,50);
        
		
		
       /* now.add(this,BorderLayout.WEST);
        c.fill=GridBagConstraints.NONE;
        c.anchor=GridBagConstraints.EAST;
		c.weightx=3;
		c.weighty=4;
        
        c.gridheight=2;
        c.gridwidth=1;*/
        /*JButton b1=new JButton();        
        now.setLayout(new FlowLayout());
        b1.setBounds(20, 50, 30, 50);
        now.add(b1);*/
       // gridbag.setConstraints(b1, c);
       // now.add(b1);
		
		
		
	}
	public static void main(String args[]) 
	 { 
			new Myadd().test();	
	 } 
}
