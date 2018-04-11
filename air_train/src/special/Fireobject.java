package special; //被唾弃的火力

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import toolbag.Gameimage;

public class Fireobject 
{
	boolean isinframe=true;
	double x,y;
	double speed=6;
	Image fire;
	
	boolean ishasfire;
	boolean isfireinframe;
	double firemovespeed;
	public Fireobject(){}
	public Fireobject(String path,double x,double y,Enemy e)
	{
		this.x=x;
		this.y=y;
		fire=Gameimage.getimage(path);
		this.isfireinframe=e.isfireinframe;
		this.ishasfire=e.ishasfire;
		this.firemovespeed=e.firemovespeed;
	}

	public void drawfireobject(Graphics g)  //爆出火力,顺便将死亡的飞机或不在画面内的飞机清除
	{
		boolean isfiredisappear;
		if(ishasfire)
		{
		if(isfireinframe)
		{
		    g.drawImage(fire, (int)x, (int)y, null);
		//g.drawImage(fireone, (int)x	, (int)y, null);
		y+=firemovespeed;
		if(y>750){isfireinframe=false;
		/*for(int i=0;i<enemyteam_one.size();i++)
		{
			Enemy a=null; 
			a=enemyteam_one.get(i);
			if(a.isinframe==false||a.life==0){enemyteam_one.remove(i);}
		}*/
		//System.out.println("还有"+enemyteam_one.size()+"个飞机");
		}               //isfiredisappear=制作一个火力类，判断是否me捡到fire，如果是则fire消失!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		}
		
	}
	public Rectangle collision()
	{
		return(new Rectangle((int)x,(int)y,fire.getWidth(null),fire.getHeight(null)));
	}

}
