package special;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Otherfire extends Myfire        //除了我其他物体的子弹
{
	double itwidth;
	double itheight;
	public Otherfire(){}

	public Otherfire(double x,double y,int width,int height,Image it)
	{
		super();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.degree=0;
		this.speed=15;
		this.speedincrease=0;
		this.itwidth=it.getWidth(null);
		this.itheight=it.getHeight(null);
	}
	public void drawmyself(Graphics g)
	{
		if(live)
		{
		if(isinframe){
			if(y<0||x<0||x>500||y>750)
			{
				isinframe=false;
			}
		c=g.getColor();
		g.setColor(Color.white);
		g.fillOval((int)x+2, (int)(y+itheight), (int)width, (int)height);
		g.fillOval((int)(x+itwidth), (int)(y+itheight), (int)width, (int)height);
		y+=speed;
		//speed+=speedincrease;
		g.setColor(c);
		}
		}
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
}
