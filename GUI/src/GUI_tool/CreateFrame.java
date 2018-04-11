package GUI_tool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*; 
import javax.swing.*; 
public class CreateFrame 
{ 
	 Image background; 
	 JFrame jf;
	 int x,y;
	//public CreateFrame(){}
	public CreateFrame(String Framename,double width, double height,String backgroundpath,int x,int y) 
	{ 
		this.x=x;
		this.y=y;
		background=Toolkit.getDefaultToolkit().getImage(backgroundpath);
		jf=new JFrame(Framename);
	    jf.setSize((int)width,(int) height); 
	    jf.setLocation(x,y);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    Mypanel pl=new  Mypanel(); 
	    pl.setOpaque(false); 
	    jf.setContentPane(pl);    
        jf.setVisible(true); 	   
	} 
	public JFrame getframe()
	{
		return jf;
	}
	
	class Mypanel extends JPanel
	{
     public void paintComponent(Graphics g) 
	 { 
	     super.paintComponent(g); 
	     int imWidth=background.getWidth(this); 
	     int imHeight=background.getHeight(this);
	     int FWidth=getWidth(); 
	     int FHeight=getHeight();
	     int x=(FWidth-imWidth)/2; 
	     int y=(FHeight-imHeight)/2;
	     g.drawImage(background,x,y,null); 
	 } 
	}
	
} 

