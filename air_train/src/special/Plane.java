package special;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import toolbag.Gameimage;

public class Plane 
{
	public boolean simplefire=true;
	public boolean isfireone;
	public boolean isfiretwo;
	public boolean isfirethree;
	public boolean isfirefour;
	public boolean isfirefive;
	double x,y,speed=10;
	boolean left,up,down,right;
	Image plane;
	String name;
	boolean live;
	Myfire myfire;
	Paidfire myfireone;
	boolean fireone;
	boolean iscoll;
	public Plane(){}
	public Plane(double x,double y,String path,String s)
	{
		super();
		this.x=x;
		this.y=y;
		this.plane=Gameimage.getimage(path);
		name=s;
		this.live=true;
	}
	public void drawmyself(Graphics g)
	{
		if(live)
		{
			if(name=="point")               //�Ż��߽�
			{
				Image im=plane.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
				plane=im;
			}
			
			g.drawImage(plane,(int) x,(int) y, null);
			move();
		}		
	}
	public void attacktransfer( Graphics g,ArrayList <Myfire> myattack,ArrayList <Paidfire> myattackone)//ת������
	{
		if(simplefire)
		{
		for(int j=0;j<myattack.size();j++)                         //���Ҵ�����ӵ�
		{				
		 myfire=myattack.get(j);	
		 if(myfire.isinframe==false){ myattack.remove(j);}
		 else{
		 myfire.drawmyself(g,this);    }  		
		}		
		}
		if(isfireone)
		{
		for(int j=0;j<myattackone.size();j++)                         //���Ҵ�����ӵ�
		{				
			myfireone=myattackone.get(j);	
		 if(myfireone.isinframe==false){ myattackone.remove(j);}
		 else{
			 myfireone.drawmyself(g,this);    }  		
		}		
		}
	}
	public void move()//�ɻ��ƶ�����
	{
		if(left&&x>0){
			x-=speed;
		}
		if(right&&x<490){
			x+=speed;
		}
		if(up&&y>0){
			y-=speed;
		}
		if(down&&y<740){
			y+=speed;
		}
	}
	public void addmove(KeyEvent e)// �ɻ��ƶ������趨
	{
		switch(e.getKeyCode())
		{
		case 38:
			up=true;
		    break;
		case 40:
			down=true;
	        break;
		case 37:
			left=true;
			break;
		case 39:
			right=true;
			break;
		    default: break;
		}
	}
	public void releasemove(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case 38:
			up=false;
	        break;
		case 40:
			down=false;
		    break;
		case 37:
			left=false;
		    break;
		case 39:
			right=false;
		    break;
		    default: break;
		}			
	}
	public void attackpress(KeyEvent e)//�ɻ���������
	{
		//System.out.println(e.getKeyCode());
		switch(e.getKeyCode())
		{
		
		case 68:
			fireone=true;
		    break;
		    
		    default: break;
		}
		
	}
	public void attackrelease(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		
		case 68:
			fireone=false;
		    break;
		    
		    default: break;
		}
		
	}
	public void collisionwithfireone(Graphics g,ArrayList<Enemy> enemyteam_one,ArrayList <Myfire> myattack,ArrayList <Paidfire> myattackone)//�ɻ��Ƿ��ĳ�����������ĳ��жϻ������࣡
	{
		for(int p=0;p<enemyteam_one.size();p++)
		{
			 Enemy a=enemyteam_one.get(p);				 //�Ժ�����Ƿ�����remove���
				
		if(iscoll=a.collision().intersects(this.collision()))
		{
			a.fireone.isfireinframe=false;
            //��ײɾ��
			if(simplefire)
			{
				for(int i=0;i<myattack.size();i++)
				{
					myattack.remove(i);
				}
			}
			if(isfireone)
			{
				for(int i=0;i<myattackone.size();i++)
				{
					myattackone.remove(i);
				}
			}
			System.out.println("shit");
			simplefire=false;
			isfireone=true;
			isfiretwo=false;
			isfirethree=false;
			isfirefour=false;
			isfirefive=false;
		}	
		}
	}
	public Rectangle collision() //���طɻ�����λ��
	{
		return(new Rectangle((int)x,(int)y,plane.getWidth(null),plane.getHeight(null)));
	}
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public String getfiretype()
	{
		if(simplefire){ return "simplefire";}
		if(isfireone){ return "isfireone";}
		if(isfiretwo){ return "isfiretwo";}
		if(isfirethree){ return "isfirethree";}
		if(isfirefour){ return "isfirefour";}
		if(isfirefive){ return "isfirefive";}
		return "error!";
	}
	
}