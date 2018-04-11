package special;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Date;

import toolbag.DrawString;

public class Time_display extends DrawString//全程索取时间并提示
{
	double x,y;
	String s;
	public Time_display(){}
    public Time_display(double x,double y,String s)
    {
    	this.x=x;
    	this.y=y;  	
    	this.s=s;
    }
    
    public void drawtime(Graphics g,long thismonment,Boss bossone)
    {
    	draw(g,Color.white,"宋体",30,x,y,s,thismonment);	
		if(thismonment==15)
		{
			draw(g,Color.white,"宋体",50,50,300,"警告!发现陨石!");		
		}
		if(thismonment==35)
		{
			draw(g,Color.white,"宋体",50,50,300,"警告!Boss出现!");		
		}	
		if(bossone.life==0)
		{
			draw(g,Color.white,"宋体",30,20,300,"干得漂亮！第一关通过！");		
		}
    }
}
