package Toolbag;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import Play.BackGround;
import Play.Bullet;
import Play.ChangeFireProp;
import Play.Collision;
import Play.Constants;
import Play.CornFrame;
import Play.CreateEnemy;
import Play.Drawable;
import Play.EndFrame;
import Play.GetBezierCurvesPoint;
import Play.Music;
import Play.Plane;
import Play.PlaneGameUtil;
import Play.Prop;
import Play.Schedule;

public class JPanelTool extends JPanel
{	
    public boolean never=true;
    public boolean twonever=true;
    public boolean periodone=true;
    public boolean periodtwo=true;
    public boolean changetype=true;
    public boolean allow=true;
    public boolean createbossbullet=false;
    public boolean isStop=false;
    public boolean gift=true;
    public boolean singleOneNeverLocate=true;
    public boolean singleTwoNeverLocate=true;
   // public boolean nevergetpoint=true;
	
	private List<Plane> enemy;
	private List<Plane> enemy2;
	private List<Plane> enemy3;
	private List<Plane> enemy4;
	private List<Plane> enemy5;
	
    private List<Bullet> playerBullets;
    private List<Bullet> enemyBullets;
	private List<Bullet> single;
	private List<Bullet> single2;
    private List<Prop> props;
    private List<Drawable> noticeAndExplosion;
    public ArrayList<Plane> Me;
    public Plane me;

    public Music bgm;
    public BackGround bg;
    public Collision collision;
    public Schedule scd;
    public GetBezierCurvesPoint gbcp;
    DrawString ds;
    
	public BufferedImage firechange; 
	public ChangeFireProp cfp; 
	public CreateEnemy ce;
	public CreateEnemy ce2;
	public CreateEnemy ce3;
	public CreateEnemy ce4;
	public CreateEnemy ce5;
	
	
	public JPanelTool(Schedule scd, ArrayList<Plane> Me,Plane me,List<Plane> enemy, List<Bullet> playerBullets, List<Bullet> enemyBullets, List<Prop> props,
			List<Drawable> noticeAndExplosion)
	{
		new PaintThread().start();      
		
		this.me=me;
		this.Me=Me;
		this.enemy = enemy;
		this.enemy2=new  ArrayList<Plane>();
		this.enemy3=new  ArrayList<Plane>();
		this.enemy4=new  ArrayList<Plane>();
		this.enemy5=new  ArrayList<Plane>();
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.single=new ArrayList<Bullet>();
		this.single2=new ArrayList<Bullet>();
		this.props = props;
		this.noticeAndExplosion = noticeAndExplosion;
		this.firechange=PlaneGameUtil.readImage("images/firechange.png"); 
		this.collision=new Collision(this.me, this.enemy,this.enemy2,this.enemy3,this.enemy4,this.enemy5,this.playerBullets, this.enemyBullets, this.props,this.single,this.single2);
		this.bg=new BackGround();
		this.scd=scd;
		scd.run();
		this.gbcp=new GetBezierCurvesPoint();
		this.ds=new DrawString();
		
		this.ce=new CreateEnemy(50, -10, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 200, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);	
		this.ce2=new CreateEnemy(250, 0, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 200, this.enemy2, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,2,3);
		this.ce3=new CreateEnemy(150, -20, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 200, this.enemy3, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);	
		this.ce4=new CreateEnemy(200, -20, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 200, this.enemy4, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);
		this.ce5=new CreateEnemy(500, 0, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 200, this.enemy5, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,3);	
		this.bgm=new Music("music/bgm.wav");
		bgm.playSound();
	}
	
	public class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				if(me.isOver()){
					over();
					repaint();
					repaint();
					repaint();
					break;
				}
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		scd.checktime();
		gbcp.movepoint();
		bg.drawbg(g);
		bg.drawdatabj(g);
		ds.drawdata(g, me);

		collision.run();
		checkSingleToChangeNeverLocate();
		
		me.drawSelf(g);
		me.shoot(1,0);
		
		drawplayershoot(g);	
		drawfirechange(g);
		drawExplosion(g);
		drawenemyshoot(g);
		
		if(scd.getthismonment()>=2&&scd.getthismonment()<=8){			
			
			drawenemyone(g,scd.getthismonment(),false,1);
			drawenemytwo(g,scd.getthismonment(),false);	
		}
		
		if(scd.getthismonment()>=3&&scd.getthismonment()<=7){
			drawenemythree(g,scd.getthismonment(),false);
			drawenemyfour(g,scd.getthismonment(),false);
		}
		if(scd.getthismonment()>=9&&scd.getthismonment()<=11){
			drawenemyfive(g,scd.getthismonment(),true);
		}
		if(scd.getthismonment()==11){
			RemoveEnemy();
			ce=new CreateEnemy(0, -50, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,2);	
			ce2=new CreateEnemy(120, -50, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy2, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,2);
			ce3=new CreateEnemy(240, -50, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy3, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,2);	
			ce4=new CreateEnemy(360, -50, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy4, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,2);
			ce5=new CreateEnemy(480, -50, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy5, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,2);
		}
		if(scd.getthismonment()>=11&&scd.getthismonment()<=21){
			drawenemyone(g,scd.getthismonment(),false,1);
			drawenemytwo(g,scd.getthismonment(),false);
			drawenemythree(g,scd.getthismonment(),false);
			drawenemyfour(g,scd.getthismonment(),false);
			drawenemyfive(g,scd.getthismonment(),false);
		}
		if(scd.getthismonment()==21){
			RemoveEnemy();
			ce=new CreateEnemy(250, 150, 10, Constants.ENEMY_TWO, Constants.ENEMY_BULLET_ONE, 500, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,2);	
			ce2=new CreateEnemy(0, 0, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 350, this.enemy2, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,2,3);
			ce3=new CreateEnemy(480, 0, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy3, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,3,3);	
			ce4=new CreateEnemy(200, 500, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy4, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,3);
			ce5=new CreateEnemy(300, 500, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 300, this.enemy5, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,3);
		}
		if(scd.getthismonment()==21){
			ds.draw(g, Color.WHITE, "宋体", 40, 250, 450, "警告!", 0);
		}
		if(scd.getthismonment()>=21&&scd.getthismonment()<=37){
			drawenemyone(g,scd.getthismonment(),false,1);
			drawenemytwo(g,scd.getthismonment(),false);
			drawenemythree(g,scd.getthismonment(),false);
			drawenemyfour(g,scd.getthismonment(),false);
			drawenemyfive(g,scd.getthismonment(),false);
		}
		if(scd.getthismonment()==37){
			RemoveEnemy();
			ce=new CreateEnemy(100, 400, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 350, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,3);	
			ce2=new CreateEnemy(350, 350, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 350, this.enemy2, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,2,3);
			ce3=new CreateEnemy(500, 100, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 350, this.enemy3, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,3,3);	
			ce4=new CreateEnemy(500, 400, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 350, this.enemy4, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,3);
			ce5=new CreateEnemy(50, 150, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 350, this.enemy5, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,3);
		}
		if(scd.getthismonment()>=37&&scd.getthismonment()<=42){
			drawenemyone(g,scd.getthismonment(),false,1);
			if(scd.getthismonment()==42)
				enemy.removeAll(enemy);
		}
        if(scd.getthismonment()>=38&&scd.getthismonment()<=44){
        	drawenemytwo(g,scd.getthismonment(),false);
        	if(scd.getthismonment()==44)
				enemy.removeAll(enemy2);
		}
        if(scd.getthismonment()>=39&&scd.getthismonment()<=46){
        	drawenemythree(g,scd.getthismonment(),false);
        	if(scd.getthismonment()==46)
				enemy.removeAll(enemy3);
		}
        if(scd.getthismonment()>=40&&scd.getthismonment()<=48){
        	drawenemyfour(g,scd.getthismonment(),false);
        	if(scd.getthismonment()==48)
				enemy.removeAll(enemy4);
        }
        if(scd.getthismonment()>=41&&scd.getthismonment()<=50){
        	drawenemyfive(g,scd.getthismonment(),false);
        	if(scd.getthismonment()==50)
				enemy.removeAll(enemy5);
        }
        if(scd.getthismonment()==50){
        	ds.draw(g, Color.WHITE, "宋体", 40, 250, 450, "警告！！！", 0);
			RemoveEnemy();
			ce=new CreateEnemy(100, 400, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 400, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,3);	
			ce2=new CreateEnemy(350, 350, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 400, this.enemy2, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,2,3);
			ce3=new CreateEnemy(500, 100, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 400, this.enemy3, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,3,3);	
			ce4=new CreateEnemy(500, 400, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 400, this.enemy4, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,3);
			ce5=new CreateEnemy(50, 150, 10, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 400, this.enemy5, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,3);
		}
        if(scd.getthismonment()>=50&&scd.getthismonment()<=65){
			drawenemyone(g,scd.getthismonment(),false,1);
			drawenemytwo(g,scd.getthismonment(),false);
			drawenemythree(g,scd.getthismonment(),false);//prop
			drawenemyfour(g,scd.getthismonment(),false);
			drawenemyfive(g,scd.getthismonment(),false);
			createsinglebullet(150,0,450,0,1);
			drawsinglebullet(g);
		}
        if(scd.getthismonment()==65){
        	ds.draw(g, Color.WHITE, "宋体！！", 40, 250, 450, "警告!!!", 0);
        	RemoveSingleBulletList();
			RemoveEnemy();
			ce=new CreateEnemy(300, 50, 20, Constants.ENEMY_ONE, Constants.ENEMY_BULLET_TWO, 1200, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,2);	
		}
        if(scd.getthismonment()>=65&&scd.getthismonment()<=90){
        	getpoint();
        	drawenemyone(g,scd.getthismonment(),true,1);

        	if(scd.getthismonment()==70){
        		enemy2.removeAll(enemy2);
        		enemy3.removeAll(enemy3);
        		enemy4.removeAll(enemy4);
        		enemy5.removeAll(enemy5);
        		ce2=new CreateEnemy(100, 50, 15, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 500, this.enemy2, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);
    			ce3=new CreateEnemy(400, 50, 15, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 500, this.enemy3, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);	
    			ce4=new CreateEnemy(250, 50, 15, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 500, this.enemy4, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);
    			ce5=new CreateEnemy(300, 50, 15, Constants.SPENEMY, Constants.ENEMY_BULLET_ONE, 500, this.enemy5, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,3);
        	}

        	if(scd.getthismonment()>=70&&scd.getthismonment()<=80){
        		drawenemytwo(g,scd.getthismonment(),false);
    			drawenemythree(g,scd.getthismonment(),false);
    			drawenemyfour(g,scd.getthismonment(),false);
    			drawenemyfive(g,scd.getthismonment(),false);
    			
    			if(scd.getthismonment()==80){
    				enemy2.removeAll(enemy2);
    				enemy3.removeAll(enemy3);
    				enemy4.removeAll(enemy4);
    				enemy5.removeAll(enemy5);
    			}
        	}
        }
        if(scd.getthismonment()==80){
        	ds.draw(g, Color.WHITE, "宋体", 40, 250, 450, "警告!", 0);
        	RemoveSingleBulletList();
			RemoveEnemy();
			ce=new CreateEnemy(350, 150, 10, Constants.ENEMY_TWO, Constants.ENEMY_BULLET_ONE, 1200, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,2);	
		}
        if(scd.getthismonment()>=80&&scd.getthismonment()<=90){//+++ 鐢诲瓙寮癸紝浼犲弬鏁�
        	
        	if(ds.score>=70&&gift){
				ds.draw(g, Color.WHITE, "宋体", 40, 250, 450, "boss出现！！！", 0);
				me.life+=100;
				gift=false;
			}
    		drawenemyone(g,scd.getthismonment(),false,2);
        }
        if(scd.getthismonment()==90){         
        	ds.draw(g, Color.WHITE, "宋体", 40, 250, 450, "警告!", 0);
        	RemoveSingleBulletList();
			RemoveEnemy();
			ce=new CreateEnemy(350, 150, 10, Constants.BOSS, Constants.ENEMY_BULLET_ONE, 14000, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,1,2);	
			
		}
        
        if(scd.getthismonment()>91){   	
        	drawenemyone(g,scd.getthismonment(),false,2);
        
        	if(allow){
        		if(this.getbosslife(enemy)<=12000){ //periodone
            		if(periodone){
            			enemy.get(0).bulletStyle++;
            			ce2=new CreateEnemy(100, 100, 20, Constants.ENEMY_ONE, Constants.ENEMY_BULLET_TWO, 1200, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,6,2);	
            			ce3=new CreateEnemy(350, 100, 20, Constants.SPENEMY, Constants.ENEMY_BULLET_TWO, 600, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,1,this.ds,7,2);	
            			periodone=false;
            			periodtwo=true;
            			allow=false;
            		}	
            	}
        	}
        	
        	
        	if(periodtwo){     //periodtwo
        		getpointfore2();
        		drawenemytwo(g,scd.getthismonment(),false);  
        		drawenemythree(g,scd.getthismonment(),false); 
        	}
        	if(this.enemy.size()!=0&&this.enemy.get(0).xpos<=100){
        		this.setLocationAndChangeMovetype(enemy, 400, 250, 5);
        		this.changetype=true;
        	}
        	if(this.enemy.size()!=0&&this.enemy.get(0).ypos<0){
        		this.setLocationAndChangeMovetype(enemy, 200, 200, 2);
        		this.changetype=true;
        	}
        	if(this.enemy.size()!=0&&this.enemy.get(0).xpos>550){
        		this.setLocationAndChangeMovetype(enemy, 350,50 , 7);
        		this.changetype=true;
        	}
        	if(this.enemy.size()!=0&&this.enemy.get(0).ypos>700){
        		this.setLocationAndChangeMovetype(enemy, 350,350 , 10);
        		this.changetype=true;
        		createbossbullet=true;
        	}
        	if(createbossbullet){
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		this.createsinglebulletanywhere(Constants.SPECIAL_BULLET3);
        		enemy.get(0).movetype=1;
        		createsinglebullet(150,0,450,0,2);	
        		createbossbullet=false;
        	}
        	this.drawsinglebullet(g);
        	drawsinglebullet(g);
    		   	
        	if(enemy.size()==0){
        		me.life=-1;
        		ds.draw(g, Color.WHITE, "宋体", 40, 250, 450, "过关!", 0);
        	}
        }
			
	}
	public void drawfirechange(Graphics g)
	{
		for(int j=0;j<props.size();j++)                         
		{				
			ChangeFireProp cfp=(ChangeFireProp)props.get(j);		
			cfp.drawSelf(g);  
		}
	}
	public void drawplayershoot(Graphics g)
	{
		for(int j=0;j<playerBullets.size();j++)                  
		{				
			Bullet b=playerBullets.get(j);		
			b.drawSelf(g);  
		}
	}
	
	public void drawenemyone(Graphics g,long time,boolean ishasprop,int type)
	{
		for(int j=0;j<enemy.size();j++)                        
		{				
			Plane p=enemy.get(j);		
			if(p.life<=0&&ishasprop){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
			}
			p.drawSelf(g); 
			
			if(time%p.frequency==1) 
			p.shoot(type,5);
		}
	}
	public void drawenemytwo(Graphics g,long time,boolean ishasprop)
	{
		for(int j=0;j<enemy2.size();j++)                         
		{				
			Plane p=enemy2.get(j);		
			if(p.life<=0&&ishasprop){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
			}
			p.drawSelf(g); 
			
			if(time%p.frequency==1) 
			p.shoot(1,5);
		}
	}
	public void drawenemythree(Graphics g,long time,boolean ishasprop)
	{
		for(int j=0;j<enemy3.size();j++)                         
		{				
			Plane p=enemy3.get(j);		
			if(p.life<=0&&ishasprop){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
			}
			p.drawSelf(g); 
			
			if(time%p.frequency==1) 
			p.shoot(1,5);
		}
	}
	public void drawenemyfour(Graphics g,long time,boolean ishasprop)
	{
		for(int j=0;j<enemy4.size();j++)                        
		{				
			Plane p=enemy4.get(j);		
			if(p.life<=0&&ishasprop){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
			}
			p.drawSelf(g); 
			
			if(time%p.frequency==1) 
			p.shoot(1,5);
		}
	}
	public void drawenemyfive(Graphics g,long time,boolean ishasprop)
	{
		for(int j=0;j<enemy5.size();j++)                         
		{				
			Plane p=enemy5.get(j);		
			if(p.life<=0&&ishasprop){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
			}
			p.drawSelf(g); 
			
			if(time%p.frequency==1) 
			p.shoot(1,5);
		}
	}
	public void drawenemyshoot(Graphics g)
	{
		for(int j=0;j<enemyBullets.size();j++)                 
		{				
			Bullet b=enemyBullets.get(j);	
			b.getplayerlocation(me);
			b.drawSelf(g);  
		}
	}
	public void getpoint()
	{
		for(int j=0;j<enemy.size();j++)                         
		{				
			Plane p=enemy.get(j);
		    p.getpoint(gbcp,me);
		}
	}
	public void getpointfore2()
	{
		for(int j=0;j<enemy2.size();j++)                         
		{				
			Plane p=enemy2.get(j);
		    p.getpoint(gbcp,me);
		}
	
	}

	public void drawExplosion(Graphics g)
	{
		for(int j=0;j<noticeAndExplosion.size();j++)                         
		{				
			Plane p=(Plane)(noticeAndExplosion.get(j));
		    PlaneGameUtil.drawExplosion(p, g,this.noticeAndExplosion);
		}
	}
	public void drawsinglebullet(Graphics g)
	{	
		for(int j=0;j<single.size();j++)                
		{				
			Bullet b=single.get(j);	
			 b.getplayerlocation(me);
			 singleOneNeverLocate=false;	
			b.drawSelf(g);  
		}
		for(int j=0;j<single2.size();j++)                
		{				
			Bullet b=single2.get(j);
				 b.getplayerlocation(me);
				 singleTwoNeverLocate=false;
			b.drawSelf(g);  
		}
	}
	public void checkSingleToChangeNeverLocate()
	{
		if(single.size()==0){
			singleOneNeverLocate=true;
		}
		if(single2.size()==0){
			singleTwoNeverLocate=true;
		}
	}
	public void createsinglebulletanywhere(int style)
	{
		Bullet sb=new Bullet(new Random().nextInt(1000), new Random().nextInt(1000), 20, style, this.single, true);
		single.add(sb);
		Bullet sb2=new Bullet(new Random().nextInt(1000), new Random().nextInt(1000), 20, style, this.single2, true);
		single2.add(sb2);
	}
	public void createsinglebullet(int sbx,int sby,int sb2x,int sb2y,int type)
	{
		if(type==1){
			if(never){
				Bullet sb=new Bullet(sbx, sby, 30, Constants.SPECIAL_BULLET2, this.single, true);
				single.add(sb);
				Bullet sb2=new Bullet(sb2x, sb2y, 30, Constants.SPECIAL_BULLET2, this.single2, true);
				single2.add(sb2);
				never=false;
				}
		}else{
			Bullet sb=new Bullet(sbx, sby, 30, Constants.SPECIAL_BULLET2, this.single, true);
			single.add(sb);
			Bullet sb2=new Bullet(sb2x, sb2y, 30, Constants.SPECIAL_BULLET2, this.single2, true);
			single2.add(sb2);
		}
		
	}
	public void recovernever(){
		never=true;
	}
	public void RemoveSingleBulletList()
	{	
		single.removeAll(single);
		single2.removeAll(single2);
	}
	public void RemoveEnemy()
	{	
		enemy.removeAll(enemy);
		enemy2.removeAll(enemy2);
		enemy3.removeAll(enemy3);
		enemy4.removeAll(enemy4);
		enemy5.removeAll(enemy5);
	}
	
	public int getbosslife(List<Plane> enemy){
		return enemy.get(0).life;
	}

	public void over(){
		if(me.isOver()){
			noticeAndExplosion.add(me);	
			isStop=true;
			int option=EndFrame.showDialog(this, scd.getendtime(), ds.score);
			if(option==EndFrame.YES_OPTION){
				bgm.stopSound();
				new CornFrame().launchFrame();
			}else{
				System.exit(0);
			}
		}
	}
	
	public void setLocationAndChangeMovetype(List<Plane> enemy,int xpos, int ypos, int movetype){
		if(changetype){
			enemy.get(0).xpos=xpos;
			enemy.get(0).ypos=ypos;
			enemy.get(0).movetype=movetype;
			changetype=false;
	     }
	}
	
}
