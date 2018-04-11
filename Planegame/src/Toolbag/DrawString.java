package Toolbag;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Play.Plane;

public class DrawString {
	
	public int score;
		
	public static void draw(Graphics g,Color c,String format,int size,double x,double y,String s,long time)
	{
		Color previous=g.getColor();
		g.setColor(c);
		Font f=new Font(format,Font.BOLD,size);
		g.setFont(f);
		g.drawString(s, (int)x,(int) y);
		g.setColor(previous);
	}
	
	public void drawdata(Graphics g,Plane player)
	{
		g.setColor(Color.red);
		Font f=new Font("����",Font.BOLD,30);
		g.setFont(f);
		if(player.life>=0){
			g.drawString("��������ֵ:  "+player.life, 680, 150);
		}else{
			g.drawString("��������ֵ:  0", 680, 150);
		}
		g.setColor(Color.BLUE);
		g.drawString("�÷�:  "+this.score, 680, 350);
	}

}
