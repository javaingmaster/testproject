package special;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;

import toolbag.DrawString;
import toolbag.Gameimage;
import toolbag.My_gameframe;
import toolbag.My_gameframe.PaintThread;

public class Mainframe extends My_gameframe
{
	
	public static final int Gamewidth=500;
	public static final int Gameheight=750;
	Date starttime=new Date();	                                                         //获得起始时间
	Date endtime;                                                                        //活得游戏结束时间
	//Explode me_explode...爆炸类待设计
	static boolean iscollision=false;                                                    //判断飞机是否与陨石和子弹碰撞
	static boolean inneriscollision=false;                                               //判断飞机的子弹是否与陨石相撞
	static int count=3;                                                                   //飞机生命值
	static long gameprocess;                                                               //获得窗口创建的时刻
	private Image offScreenImage=null;                                                    //双缓冲
	Image background_one=Gameimage.getimage("images/background_one.jpg"); 
	
	//Image fireone=Gameimage.getimage("images/fireobjectone.png");
	//加载背景图片	
	Launchpoint one=new Launchpoint(250,375,"images/launchpoint.png");                    //发射点
	Launchpoint two=new Launchpoint(450,30,"images/launchpoint.png");	
	Launchpoint enemyone=new Launchpoint(400,400,"images/launchpoint.png");
	Launchpoint enemytwo=new Launchpoint(350,400,"images/launchpoint.png");
	Launchpoint enemythree=new Launchpoint(300,400,"images/launchpoint.png");
	
	
	Plane me=new Plane(250,700,"images/me.png","plane");  
	Launchpoint three=new Launchpoint(me.x,me.y,"images/launchpoint.png");//飞机初始化
	Plane point=new Plane(250,700,"images/me0.png","point");                                 //与飞机绑定的对象，用来弥补图片大小问题
	//Enemy e1=new Enemy(enemyone,"images/enemy1.png","plane",2,true);
	//Enemy e1point=new Enemy(enemyone,"images/me0.png","point",2,false);
	Boss bossone=new Boss(150,50,false,"images/bossone.png",20);                              //第一个boss加载
	
	Time_display timedisplayone=new Time_display(50,55,"当前时间:");                         //游戏全程计时类
	
	
			 
	public static ArrayList<Bullet> bulletlist=new ArrayList<Bullet>();                                                 //子弹容器
	public static ArrayList<Aerolite> aerolite=new ArrayList<Aerolite>();                                                   //陨石容器
	public static ArrayList <Myfire>myattack=new ArrayList<Myfire>();                                                   //me子弹容器
	public static ArrayList <Paidfire>myattackone=new ArrayList<Paidfire>();     
	public static ArrayList<Otherfire>  bossoneattack=new ArrayList<Otherfire>();                                                 //bossone子弹容器
	public static ArrayList<Enemy> enemyteam_one=new ArrayList<Enemy>();
	public static ArrayList<Fireobject> fireobject=new ArrayList<Fireobject>(); 
	
	boolean e1pointreturn;
	Enemy drawwhat;//控制捡枪
	boolean ifcontrol=false;//控制捡枪
	public void paint(Graphics g)                           //画图函数，另一线程控制重画
	{		
		//Myfire myfirelitter=null;
		g.drawImage(background_one, 0, 0, null);           //画背景
		me.drawmyself(g);                                  //画飞机
		point.drawmyself(g); 
		if(me.fireone){                                    //实现按攻击键就打出一颗子弹
			addmybullet();	
		}	//飞机辅助
		//drawenemy(g,enemyteam_one);
						 		
		me.attacktransfer(g, myattack, myattackone);		
		me.collisionwithfireone(g,enemyteam_one,myattack, myattackone);
		
		checkcollisionenemy_myfire(g,me);
		// fireobjectone.drawfireobject(g);
		if(ifcontrol)                                               //ifcontrol变量控制捡枪效果
		{			
			drawwhat.fireone.drawfireobject(g);
			//e1pointreturn=checkcollisionbetweenmyfire_and_enemy(g,enemyteam_one);		
			e1pointreturn=true;
		}
		if(e1pointreturn)
		{
		if(!drawwhat.isfireinframe){                               //!!!!!!!!!!!!!!待使用iscatched参数控制火力消失
			//drawfireobject(g,enemyteam_one);
			ifcontrol=false;
		}
		}
		
		  Date processtime=new Date();	                   //准备获取当前时刻
          long time=(processtime.getTime()-gameprocess)/1000;//计算从游戏开始到现在经历了多少秒
          timedisplayone.drawtime(g,time,bossone);                   //画出计时以及和时间有关的图像                
          checkcollisionme_aerolite(g,time);
		  checkcollisionbullet_me(g);				  	
		  bossone.drawboss(g, time);                                 //画第一个boss
		  if(time>15&&time<40)
		  checkcollisionaerolite_myfire(g);
		 		
		if(time==45)bossone.setLive(true);                             //时间操控子弹待封装
		
			 if(bossone.bossonelive&&time>45)
			 {
				 addotherbullet();
			for(int j=0;j<bossoneattack.size();j++)                         //画bossone打出的子弹
			{				
			 Otherfire m=(Otherfire)bossoneattack.get(j);	
			 if(m.isinframe==false){ bossoneattack.remove(j);}
			 else{
			 m.drawmyself(g);    
			 }  		     	              
						
			 iscollision=m.collision().intersects(point.collision()); //判断是否击中，击中五次就gameover
	           if((count<5)&&(iscollision))
	           {
	        	 count++;
	        	// System.out.println(count);
	        	 iscollision=false;
	        	 if(count==5)
	        	 {
	        		// g.drawImage(抠, 100, 150, null);   
	        		 me.setLive(false);                               //set方法，用来判断飞机是否被画出，若游戏结束则不画	        		 	        		 
	        		 point.setLive(false);        		
	        		 endtime=new Date();
	        		 break;
	       		                                                       //me_explode=new Explode(...);待设计
	  			  }            
	        	}
			}
			bossone.bossonelive= bossone.iscollision(myattack,bossone,g,me);
			 
			 }
			 if(!bossone.bossonelive&&bossone.life==0)
			 {
						 //出现飞机				 //bosstwo.live=true;
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
          if(!me.isLive())                                         //判断游戏是否该结束
          {       	  
        	  long period=(endtime.getTime()-starttime.getTime())/1000;
        	  gameover(g,"别抠了！",50,150,300);
        	  gameover(g,"生存时间:"+period+"秒",30,150,400);
          }
   }                    
	

	                                            //paint函数结束
		
	/*public void drawfireobject(Graphics g,ArrayList<Enemy>enemyteam_one)
	{	
		Enemy a=enemyteam_one.get(0);	
		a.drawfireobject(g,enemyteam_one);					
	}*/

	/*public boolean checkcollisionbetweenmyfire_and_enemy(Graphics g,ArrayList<Enemy>enemyteam_one)
	{
		boolean controlvalue;
		for(int i=0;i<enemyteam_one.size();i++)
		{
			Enemy a=enemyteam_one.get(i);	
			controlvalue=a.iscollision(myattack,a,g);
			return controlvalue;
		}
		return true;
	}
	public void drawenemy(Graphics g,ArrayList<Enemy> enemyteam_one)
	{
		Enemy a;
		for(int i=0;i<enemyteam_one.size();i++)
		{				
			 a=enemyteam_one.get(i);				 
			 a.drawmyself(g);    
		}
	}*/
	
	public void checkcollisionenemy_myfire(Graphics g,Plane me) //使用plane getfiretype()函数
	{
		Enemy a=null;
		Myfire myfire; 
		if(me.getfiretype()=="simplefire")
		{
			for(int i=0;i<enemyteam_one.size();i++)                       
			{	
				a=enemyteam_one.get(i);
				if(a.isinframe==false||(!a.isLive())){ enemyteam_one.remove(i);}
				 else{
				 a.drawmyself(g);    
				 }  		     	   
				for(int j=0;j<myattack.size();j++) 
				{	
					//check collision
					 myfire=myattack.get(j);
			           inneriscollision=myfire.collision().intersects(a.collision());
			           
			           if(inneriscollision)
			          {        		        	   
			        	myattack.remove(j);
			        	a.life--;
			        	if(a.life==0){
			        		
			        		//a.drawfireobject(g,a);
			        		a.setLive(false);
			        		drawwhat=a;
			        		ifcontrol=true;
			        		
			        		//enemyteam_one.remove(i);          最后加入飞机清除函数
			        		
			        	 inneriscollision=false;
			        	}
			  		 }     		     
				}
			}	
		}
		//if(me.getfiretype()=="isfireone")
		//if(me.getfiretype()=="isfiretwo")
		//if(me.getfiretype()=="isfirethree")
		//if(me.getfiretype()=="isfirefour")
		//if(me.getfiretype()=="isfirefive")
		
		
			
	}
	
	
	
	
	
	
	
	
	public void checkcollisionbullet_me(Graphics g)
	{
		for(int i=0;i<bulletlist.size();i++)                //飞机是否被子弹是否击中
		{
           Bullet b=bulletlist.get(i);
           b.drawmyself(g);
           //check collision
           iscollision=b.collision().intersects(point.collision()); //判断是否击中，击中五次就gameover
           
        if((count<5)&&(iscollision))
        {
     	 count++;
     	 //System.out.println(count);
     	 iscollision=false;
     	 if(count==5)
     	 {
     		// g.drawImage(抠, 100, 150, null);   
     		 me.setLive(false);                               //set方法，用来判断飞机是否被画出，若游戏结束则不画
     		 point.setLive(false);
     		 endtime=new Date();
     		 break;
    		                                                       //me_explode=new Explode(...);待设计
			  }            
     	}
		}
	}
	
	public void checkcollisionme_aerolite(Graphics g,long time)
	{
		if(time>15&&time<40)
		{
		
			for(int i=0;i<aerolite.size();i++)                         //陨石是否击中飞机 
			{
				Aerolite a=null;                                           //陨石类
				//Myfire myfire=null;                                        //我的子弹类
				
				 a=aerolite.get(i);
				 a.drawmyself(g,time);
				 iscollision=a.collision().intersects(point.collision());//判断冲突，类似上面的子弹判断
				 if((count<5)&&(iscollision))      //设计特定时间出现陨石
		           {
		        	 count++;
		        	 iscollision=false;
		        	 if(count==5)
		        	 {
		        		// g.drawImage(抠, 100, 150, null);   
		        		 me.setLive(false);
		        		 point.setLive(false);
		        		 endtime=new Date();
		        		 break;
		        		                                                 //me_explode=new Explode(...);
		  			 }	            
		        	}
			}
			
		}
		if(time<42&&time>40)
		{
			for(int i=0;i<aerolite.size();i++)
			{
				Aerolite a=null; 
				a=aerolite.get(i);
				aerolite.remove(i);
			}
		}		
	}
	public void checkcollisionaerolite_myfire(Graphics g)
	{	
		Myfire myfire=null;
		Aerolite a=null;
		/*for(int j=0;j<myattack.size();j++)                         //画我打出的子弹
		{				
		 myfire=myattack.get(j);	
		 if(myfire.isinframe==false){ myattack.remove(j);}
		 else{
		 myfire.drawmyself(g,me);    }  		
		}	*/			 
		 
		for(int i=0;i<aerolite.size();i++)                        //判断我的子弹是否击中陨石
		{	
			a=aerolite.get(i);
			for(int j=0;j<myattack.size();j++) 
			{	
				//check collision
				 myfire=myattack.get(j);
		           inneriscollision=myfire.collision().intersects(a.collision());
		           
		           if(inneriscollision)
		          {        	
		        	myattack.remove(j);
		        	aerolite.remove(i);
		        	 inneriscollision=false;
		  		 }     		     
			}
		}
	}

	public void addmybullet()                                     //按下攻击键后向容器添加子弹
	{
		if(me.simplefire)
		{
		 Myfire b=new Myfire(me,3,3);
		myattack.add(b);
		}
		if(me.isfireone)
		{
			Paidfire b=new Paidfire(me,"images/paidfireone.png");
			myattackone.add(b);
		}
	}
	public void addotherbullet()                                     //
	{
		Otherfire fire=new Otherfire(bossone.x,bossone.y,10,10,bossone.bossone);
		bossoneattack.add(fire);
	}
	
	public void gameover(Graphics g,String display,int size,int x,int y)//游戏结束调用此函数
	{
		Color c=g.getColor();
		g.setColor(Color.WHITE);
		Font f=new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(display, x, y);
		g.setColor(c);
	}
	
	
            //启动窗口
	
		public void launchframe()
		{		
			super.launchframe();
			addKeyListener(new Control());
			
			for(int i=0;i<5;i++)
			{
				Bullet b=new Bullet(one,5,5);
				bulletlist.add(b);
			}
			for(int i=0;i<30;i++)
			{
				Aerolite a=new Aerolite(two,5,5);
				aerolite.add(a);
			}
			for(int i=0;i<1;i++)
			{
				Enemy a=new Enemy(enemyone,"images/enemy1.png","plane",2,true);
				Enemy b=new Enemy(enemytwo,"images/enemy1.png","plane",2,true);
				Enemy c=new Enemy(enemythree,"images/enemy1.png","plane",2,true);
				enemyteam_one.add(a);
				enemyteam_one.add(b);
				enemyteam_one.add(c);
			}
		
		  gameprocess=starttime.getTime();
		  	  
		}
	public static void main(String[] args)             //主函数
	{
		new Mainframe().launchframe();
	}	
	
	
    //双缓冲解决屏闪	
     public void update(Graphics g)
     {
        if( offScreenImage==null)
        offScreenImage=this.createImage(500, 750);

        Graphics goff= offScreenImage.getGraphics();
        paint(goff);
        g.drawImage( offScreenImage, 0, 0, null);		
     }
	class Control extends KeyAdapter         //定义监听器
	{		
		public void keyPressed(KeyEvent e)//监听器可以同时监听多个键值，因此可以实现多键控制
		{
			me.addmove(e);	
			point.addmove(e);
			me.attackpress(e);  //D：68
		}
		public void keyReleased(KeyEvent e)
		{			
			me.releasemove(e);
			point.releasemove(e);
			me.attackrelease(e);
		}
	}
			
}

