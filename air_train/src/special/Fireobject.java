package special; //�������Ļ���

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

	public void drawfireobject(Graphics g)  //��������,˳�㽫�����ķɻ����ڻ����ڵķɻ����
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
		//System.out.println("����"+enemyteam_one.size()+"���ɻ�");
		}               //isfiredisappear=����һ�������࣬�ж��Ƿ�me��fire���������fire��ʧ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		}
		
	}
	public Rectangle collision()
	{
		return(new Rectangle((int)x,(int)y,fire.getWidth(null),fire.getHeight(null)));
	}

}
