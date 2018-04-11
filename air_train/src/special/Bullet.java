package special;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet 
{
	double x,y;
	double speed=2.5;
	double degree;
	int width;
	int height;
	Color c;
	double speedincrease=0;
	public Bullet(){}
	public Bullet(Launchpoint l,int width,int height)
	{
		this.x=l.x;//+l.point.getWidth(null)/2;
		this.y=l.y;//+l.point.getHeight(null)/2;
		this.height=height;
		this.width=width;
		this.degree=Math.random()*Math.PI*2;
	}
	public void drawmyself(Graphics g)//基本子弹运动方式
	{
		c=g.getColor();
		g.setColor(Color.WHITE);
		g.fillOval((int)x, (int)y, (int)width, (int)height);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		speed+=speedincrease;
		if(y>750-height)
		{
			degree=0-degree;
		}
		if(y<0)
		{
			degree=0-degree;
		}
		if(x>500-width)
		{
			degree=Math.PI-degree;
		}
		if(x<0)
		{
			degree=Math.PI-degree;
		}
		g.setColor(c);
	}
	public Rectangle collision()
	{
		return(new Rectangle((int)x,(int)y,width,height));
	}

}
