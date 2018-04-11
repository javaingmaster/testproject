package special;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import toolbag.Gameimage;

public class Enemy extends Plane
{
	int life;
	boolean ishasfire;
	boolean isinframe=true;
	boolean iscatched;
    boolean control_moveimage=true;
	boolean isfireinframe=true;//为是否含有击毙奖励的属性
	double firemovespeed=6;
	Fireobject fireone;
	
	public Enemy(){}
	
	public Enemy(Launchpoint l,String path,String s,int life,boolean ishasfire)
	{
		super();
		this.life=life;
		this.x=l.x;
		this.y=l.y;
		this.plane=Gameimage.getimage(path);
		name=s;
		this.live=true;
		this.ishasfire=ishasfire;
		fireone=new Fireobject("images/fireobjectone.png",this.x,this.y,this);
	}
	
	
	public Rectangle collision(Fireobject fireone)
	{
		return(new Rectangle((int)x,(int)y,fireone.fire.getWidth(null),fireone.fire.getHeight(null)));
	}
	
/*	public void moveimage(Graphics g, Image fireone)//被唾弃的方法
	{
		if(control_moveimage){
		g.drawImage(fireone, 600, 800, null);
		control_moveimage=false;
		}
	}*/
	public void drawmyself(Graphics g)
	{
		if(live)
		{
			if(isinframe){
		
			if(y<0||y>750||x>500||x<0)
			{
				isinframe=false;			
			}
			if(name=="point")
			{
				Image im=plane.getScaledInstance(15, 15, Image.SCALE_DEFAULT);
				plane=im;
			}
			
			g.drawImage(plane,(int) x,(int) y, null);
			//move();
		}		
	}
	}
	/*public void move()
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
	}*/
	/*public boolean iscollision(ArrayList<Myfire> myfirelist,ArrayList<Enemy>enemyteam_one,Graphics g)//传容器  point参数方便回收，和boss一样待改成活力判断，传数组有利于删碰撞效果！！！
	{
		Myfire myfire; //带更改
		Enemy t;
		/*for(int w=0;w<myfirelist.size();w++)                         //被注释代码与plane活力转换函数重复
		{				
		 myfire=myfirelist.get(w);	
		 if(myfire.isinframe==false){  myfirelist.remove(w);}
		 else{
		 myfire.drawmyself(g);    }  		
		}	
		for(int i=0;i<enemyteam_one.size();i++)
		{
			t=enemyteam_one.get(i);
		
		for(int j=0;j<myfirelist.size();j++)
		{
			 myfire=myfirelist.get(j);
		  boolean isdeletemyfire=myfire.collision().intersects(t.collision());
		 if(isdeletemyfire)
         {        	
       	   myfirelist.remove(j);
       	   life--;
           if(life==0)
           {
        	   t.setLive(false);
        	   this.setLive(false);
        	   if(it.ishasfire)
        	   {       		  
        		   it.drawfireobject(g);
        	   }
        	   //it=null;
        	   //point=null;
        	   return false;    	  
           }
 		 }  
		 
		}
		 return true;
		}
	}*/

	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
}
