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
	Date starttime=new Date();	                                                         //�����ʼʱ��
	Date endtime;                                                                        //�����Ϸ����ʱ��
	//Explode me_explode...��ը������
	static boolean iscollision=false;                                                    //�жϷɻ��Ƿ�����ʯ���ӵ���ײ
	static boolean inneriscollision=false;                                               //�жϷɻ����ӵ��Ƿ�����ʯ��ײ
	static int count=3;                                                                   //�ɻ�����ֵ
	static long gameprocess;                                                               //��ô��ڴ�����ʱ��
	private Image offScreenImage=null;                                                    //˫����
	Image background_one=Gameimage.getimage("images/background_one.jpg"); 
	
	//Image fireone=Gameimage.getimage("images/fireobjectone.png");
	//���ر���ͼƬ	
	Launchpoint one=new Launchpoint(250,375,"images/launchpoint.png");                    //�����
	Launchpoint two=new Launchpoint(450,30,"images/launchpoint.png");	
	Launchpoint enemyone=new Launchpoint(400,400,"images/launchpoint.png");
	Launchpoint enemytwo=new Launchpoint(350,400,"images/launchpoint.png");
	Launchpoint enemythree=new Launchpoint(300,400,"images/launchpoint.png");
	
	
	Plane me=new Plane(250,700,"images/me.png","plane");  
	Launchpoint three=new Launchpoint(me.x,me.y,"images/launchpoint.png");//�ɻ���ʼ��
	Plane point=new Plane(250,700,"images/me0.png","point");                                 //��ɻ��󶨵Ķ��������ֲ�ͼƬ��С����
	//Enemy e1=new Enemy(enemyone,"images/enemy1.png","plane",2,true);
	//Enemy e1point=new Enemy(enemyone,"images/me0.png","point",2,false);
	Boss bossone=new Boss(150,50,false,"images/bossone.png",20);                              //��һ��boss����
	
	Time_display timedisplayone=new Time_display(50,55,"��ǰʱ��:");                         //��Ϸȫ�̼�ʱ��
	
	
			 
	public static ArrayList<Bullet> bulletlist=new ArrayList<Bullet>();                                                 //�ӵ�����
	public static ArrayList<Aerolite> aerolite=new ArrayList<Aerolite>();                                                   //��ʯ����
	public static ArrayList <Myfire>myattack=new ArrayList<Myfire>();                                                   //me�ӵ�����
	public static ArrayList <Paidfire>myattackone=new ArrayList<Paidfire>();     
	public static ArrayList<Otherfire>  bossoneattack=new ArrayList<Otherfire>();                                                 //bossone�ӵ�����
	public static ArrayList<Enemy> enemyteam_one=new ArrayList<Enemy>();
	public static ArrayList<Fireobject> fireobject=new ArrayList<Fireobject>(); 
	
	boolean e1pointreturn;
	Enemy drawwhat;//���Ƽ�ǹ
	boolean ifcontrol=false;//���Ƽ�ǹ
	public void paint(Graphics g)                           //��ͼ��������һ�߳̿����ػ�
	{		
		//Myfire myfirelitter=null;
		g.drawImage(background_one, 0, 0, null);           //������
		me.drawmyself(g);                                  //���ɻ�
		point.drawmyself(g); 
		if(me.fireone){                                    //ʵ�ְ��������ʹ��һ���ӵ�
			addmybullet();	
		}	//�ɻ�����
		//drawenemy(g,enemyteam_one);
						 		
		me.attacktransfer(g, myattack, myattackone);		
		me.collisionwithfireone(g,enemyteam_one,myattack, myattackone);
		
		checkcollisionenemy_myfire(g,me);
		// fireobjectone.drawfireobject(g);
		if(ifcontrol)                                               //ifcontrol�������Ƽ�ǹЧ��
		{			
			drawwhat.fireone.drawfireobject(g);
			//e1pointreturn=checkcollisionbetweenmyfire_and_enemy(g,enemyteam_one);		
			e1pointreturn=true;
		}
		if(e1pointreturn)
		{
		if(!drawwhat.isfireinframe){                               //!!!!!!!!!!!!!!��ʹ��iscatched�������ƻ�����ʧ
			//drawfireobject(g,enemyteam_one);
			ifcontrol=false;
		}
		}
		
		  Date processtime=new Date();	                   //׼����ȡ��ǰʱ��
          long time=(processtime.getTime()-gameprocess)/1000;//�������Ϸ��ʼ�����ھ����˶�����
          timedisplayone.drawtime(g,time,bossone);                   //������ʱ�Լ���ʱ���йص�ͼ��                
          checkcollisionme_aerolite(g,time);
		  checkcollisionbullet_me(g);				  	
		  bossone.drawboss(g, time);                                 //����һ��boss
		  if(time>15&&time<40)
		  checkcollisionaerolite_myfire(g);
		 		
		if(time==45)bossone.setLive(true);                             //ʱ��ٿ��ӵ�����װ
		
			 if(bossone.bossonelive&&time>45)
			 {
				 addotherbullet();
			for(int j=0;j<bossoneattack.size();j++)                         //��bossone������ӵ�
			{				
			 Otherfire m=(Otherfire)bossoneattack.get(j);	
			 if(m.isinframe==false){ bossoneattack.remove(j);}
			 else{
			 m.drawmyself(g);    
			 }  		     	              
						
			 iscollision=m.collision().intersects(point.collision()); //�ж��Ƿ���У�������ξ�gameover
	           if((count<5)&&(iscollision))
	           {
	        	 count++;
	        	// System.out.println(count);
	        	 iscollision=false;
	        	 if(count==5)
	        	 {
	        		// g.drawImage(��, 100, 150, null);   
	        		 me.setLive(false);                               //set�����������жϷɻ��Ƿ񱻻���������Ϸ�����򲻻�	        		 	        		 
	        		 point.setLive(false);        		
	        		 endtime=new Date();
	        		 break;
	       		                                                       //me_explode=new Explode(...);�����
	  			  }            
	        	}
			}
			bossone.bossonelive= bossone.iscollision(myattack,bossone,g,me);
			 
			 }
			 if(!bossone.bossonelive&&bossone.life==0)
			 {
						 //���ַɻ�				 //bosstwo.live=true;
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
          if(!me.isLive())                                         //�ж���Ϸ�Ƿ�ý���
          {       	  
        	  long period=(endtime.getTime()-starttime.getTime())/1000;
        	  gameover(g,"����ˣ�",50,150,300);
        	  gameover(g,"����ʱ��:"+period+"��",30,150,400);
          }
   }                    
	

	                                            //paint��������
		
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
	
	public void checkcollisionenemy_myfire(Graphics g,Plane me) //ʹ��plane getfiretype()����
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
			        		
			        		//enemyteam_one.remove(i);          ������ɻ��������
			        		
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
		for(int i=0;i<bulletlist.size();i++)                //�ɻ��Ƿ��ӵ��Ƿ����
		{
           Bullet b=bulletlist.get(i);
           b.drawmyself(g);
           //check collision
           iscollision=b.collision().intersects(point.collision()); //�ж��Ƿ���У�������ξ�gameover
           
        if((count<5)&&(iscollision))
        {
     	 count++;
     	 //System.out.println(count);
     	 iscollision=false;
     	 if(count==5)
     	 {
     		// g.drawImage(��, 100, 150, null);   
     		 me.setLive(false);                               //set�����������жϷɻ��Ƿ񱻻���������Ϸ�����򲻻�
     		 point.setLive(false);
     		 endtime=new Date();
     		 break;
    		                                                       //me_explode=new Explode(...);�����
			  }            
     	}
		}
	}
	
	public void checkcollisionme_aerolite(Graphics g,long time)
	{
		if(time>15&&time<40)
		{
		
			for(int i=0;i<aerolite.size();i++)                         //��ʯ�Ƿ���зɻ� 
			{
				Aerolite a=null;                                           //��ʯ��
				//Myfire myfire=null;                                        //�ҵ��ӵ���
				
				 a=aerolite.get(i);
				 a.drawmyself(g,time);
				 iscollision=a.collision().intersects(point.collision());//�жϳ�ͻ������������ӵ��ж�
				 if((count<5)&&(iscollision))      //����ض�ʱ�������ʯ
		           {
		        	 count++;
		        	 iscollision=false;
		        	 if(count==5)
		        	 {
		        		// g.drawImage(��, 100, 150, null);   
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
		/*for(int j=0;j<myattack.size();j++)                         //���Ҵ�����ӵ�
		{				
		 myfire=myattack.get(j);	
		 if(myfire.isinframe==false){ myattack.remove(j);}
		 else{
		 myfire.drawmyself(g,me);    }  		
		}	*/			 
		 
		for(int i=0;i<aerolite.size();i++)                        //�ж��ҵ��ӵ��Ƿ������ʯ
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

	public void addmybullet()                                     //���¹������������������ӵ�
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
	
	public void gameover(Graphics g,String display,int size,int x,int y)//��Ϸ�������ô˺���
	{
		Color c=g.getColor();
		g.setColor(Color.WHITE);
		Font f=new Font("����",Font.BOLD,size);
		g.setFont(f);
		g.drawString(display, x, y);
		g.setColor(c);
	}
	
	
            //��������
	
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
	public static void main(String[] args)             //������
	{
		new Mainframe().launchframe();
	}	
	
	
    //˫����������	
     public void update(Graphics g)
     {
        if( offScreenImage==null)
        offScreenImage=this.createImage(500, 750);

        Graphics goff= offScreenImage.getGraphics();
        paint(goff);
        g.drawImage( offScreenImage, 0, 0, null);		
     }
	class Control extends KeyAdapter         //���������
	{		
		public void keyPressed(KeyEvent e)//����������ͬʱ���������ֵ����˿���ʵ�ֶ������
		{
			me.addmove(e);	
			point.addmove(e);
			me.attackpress(e);  //D��68
		}
		public void keyReleased(KeyEvent e)
		{			
			me.releasemove(e);
			point.releasemove(e);
			me.attackrelease(e);
		}
	}
			
}
