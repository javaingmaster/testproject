package toolbag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DrawString//写字符串的两种方式
{
	double x,y;
	String s;
	String format;
	int size;
	Color c;
	public DrawString(){}
	
	public DrawString(double x,double y,String s,String format,int size,Color c)
	{
		this.x=x;
		this.y=y;
		this.format=format;
		this.size=size;
		this.c=c;
		this.s=s;
	}
	
	public void draw(Graphics g,Color c,String format,int size,double x,double y,String s)
	{
		Color previous=g.getColor();
		g.setColor(c);
		Font f=new Font(format,Font.BOLD,size);
		g.setFont(f);
		g.drawString(s, (int)x,(int) y);
		g.setColor(previous);
	}
	public void draw(Graphics g,Color c,String format,int size,double x,double y,String s,long time)
	{
		Color previous=g.getColor();
		g.setColor(c);
		Font f=new Font(format,Font.BOLD,size);
		g.setFont(f);
		g.drawString(s+time, (int)x,(int) y);
		g.setColor(previous);
	}
}
