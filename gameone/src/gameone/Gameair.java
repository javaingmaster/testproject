package gameone;

import java.awt.Graphics;
import java.awt.Image;
public class Gameair extends My_gameframe
{
	Image img=Gameimage.getimage("image/1.jpg");
	
	double x=100,y=100;
	boolean left=true,up=true;
	private double degree=3.14/3.0;
	private double speed=5.00;
	public void paint(Graphics g)//参数为画笔，可随意画图形，线条，字符串,填充颜色,可改变画笔颜色,fond字体
	{		
	/*	g.drawLine(100, 100, 200, 200);
		Color c=g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(100, 100, 50, 50);
		g.setColor(c);
		Font f=new Font("宋体",Font.BOLD,100);//字体类
		g.setFont(f);*/
		g.drawOval((int)x,(int)y,30,30);
		if(speed<0)
		{ speed=0;}else{
			speed-=0.005;
		}	
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>470)
		{
			degree=0-degree;
		}
		if(y<0)
		{
			degree=0-degree;
		}
		if(x>470)
		{
			degree=Math.PI-degree;
		}
		if(x<0)
		{
			degree=Math.PI-degree;
		}
		/*if(left)
		{
			if(up)
			{
				x+=2;y+=2;
			}else{
				x+=2;y-=2;
			}
		}else
		{
			if(up)
			{
			    x-=2;y+=2;	
			}else{
				x-=2;y-=2;
			}
		}
		if(x>=470){ left=false;}
		if(x<=30){left=true;}
		if(y>=470){ up=false;}
		if(y<=30){ up=true;}	*/
	}
//动画线程
	
	public static void main (String args[])
	{
		Gameair gf=new Gameair();
		gf.launchframe(500, 500, 100, 100);
	}
}

