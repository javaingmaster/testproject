package Solar_system;

import java.awt.Color;
import java.awt.Graphics;

public class Planet extends Star
{	
	double degree;
	double speed;
	Star center;
	double longadd;
	double shortadd;
	boolean planet=true;

	public Planet(Star center,String path,double longadd, double shortadd,double speed,boolean planet)
	{	
		this.x=center.x+longadd;
		this.y=center.y;
		this.imageofstar=Gameimage.getimage(path);
		this.imageheight=imageofstar.getHeight(null);
		this.imagewidth=imageofstar.getWidth(null);
		this.longadd=longadd;
		this.shortadd=shortadd;
		this.center=center;
		this.speed=speed;
		this.planet=planet;
	}
	public void drawmyself(Graphics g)
	{
		g.drawImage(imageofstar,(int)x,(int)y,null);	
		x=center.x+center.imagewidth/2+longadd*Math.cos(degree);
		y=center.y+center.imageheight/2+shortadd*Math.sin(degree);
		degree+=speed;
	}
	public void drawtrace(Graphics g)
	{
		if(this.planet){
		Color c=g.getColor();
		g.setColor(Color.BLUE);	
		double trace_x=center.x-this.longadd+this.imagewidth/2;
		double trace_y=center.y-this.shortadd+this.imageheight/2;
		g.drawOval((int)trace_x,(int)trace_y,(int)(2*this.longadd),(int)(2*this.shortadd));
		g.setColor(c);}
	}
	

}
