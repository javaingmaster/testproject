package Solar_system;

import java.awt.Graphics;
import java.awt.Image;

public class Solargame extends  Solar_system
{
	Image imgone=Gameimage.getimage("images/solar.jpg");
	
	private Image offScreenImage=null;  
	Star sun=new Star(250,250,"images/sun.jpg");
	Planet earth=new Planet(sun,"images/earth.jpg",150,100,0.02,true);
	Planet p1=new Planet(sun,"images/1.gif",180,140,0.04,true);
	Planet moon=new Planet(earth,"images/moon.gif",100,50,0.01,false);
	double x=100,y=100;
	public void paint(Graphics g)
	{		
		g.drawImage(imgone,0,0,null);	
		sun.drawmyself(g);		
		earth.drawmyself(g);	
		earth.drawtrace(g);
		moon.drawmyself(g);
		p1.drawmyself(g);
		p1.drawtrace(g);
	}
	public static void main (String args[])
	{
		Solargame gf=new Solargame();
		gf.launchframe(500, 500, 100, 100);
	}
	public void update(Graphics g)
    {
       if( offScreenImage==null)
       offScreenImage=this.createImage(500, 750);

       Graphics goff= offScreenImage.getGraphics();
       paint(goff);
       g.drawImage( offScreenImage, 0, 0, null);		
    }
}
