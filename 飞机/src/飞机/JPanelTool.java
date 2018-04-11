package 飞机;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import play.Bullet;
import play.ChangeFireProp;
import play.Collision;
import play.Constants;
import play.Drawable;
import play.Plane;
import play.PlaneGameUtil;
import play.Prop;

public class JPanelTool extends JPanel
{	
	private List<Plane> enemy;// The container that contains enemy plane and
	// aerolite
    private List<Bullet> playerBullets;
    private List<Bullet> enemyBullets;
    private List<Prop> props;
    private List<Drawable> noticeAndExplosion;
    private List<Drawable> copy;
	ArrayList<Image> background; 
	Image backgroundone;
	BufferedImage firechange; //测试道具
	
	public boolean never=true;
	
	 public Collision collision;
	
	ArrayList<Plane> Me;

	Plane me;
	
	ChangeFireProp cfp; //测试切换火力
	
	public JPanelTool(Plane me,List<Plane> enemy, List<Bullet> playerBullets, List<Bullet> enemyBullets, List<Prop> props,
			List<Drawable> noticeAndExplosion)
	{
		new PaintThread().start();      //线程重绘游戏画板
		
		
		
		this.enemy = enemy;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.noticeAndExplosion = noticeAndExplosion;
		this.copy = new ArrayList<Drawable>();
		this.firechange=PlaneGameUtil.readImage("images/firechange.png"); //测试道具
		
		this.collision=new Collision(me, enemy, playerBullets, enemyBullets, props);
		
		/*
		 * 背景图片加载容器
		 */
		background=new ArrayList<Image>();
		backgroundone=Gameimage.getimage("images/forest-01.jpg");
		background.add(backgroundone);
		
		/*
		 * 敌机加载容器
		 */
		int x=200,y=200;         //敌机测试
		for(int i=0;i<5;i++)
		{
			Plane enemyone=new Plane(x, y, 10, Constants.enemyone, Constants.enemybulletone, 100, enemy, noticeAndExplosion,enemyBullets);
			enemyone.shoot();
			enemy.add(enemyone);
			x-=40;
			y-=40;
		}
		
		/*
		 * 陨石类加载容器
		 */
		
		/*
		 * boss加载容器
		 */
		
		/*
		 * 玩家飞机加载容器
		 */
		Me=new ArrayList<Plane>();
		this.me=me;
		Me.add(me);
		/*
		 * 计时器启动
		 */
		
		/*
		 * 敌机子弹加载容器
		 */
		
		/*
		 * 玩家子弹加载容器
		 */
		
		/*
		 * 玩家子弹种类加载容器
		 */
	}
	
	public class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public void paintComponent(Graphics g) // 游戏核心重绘函数
	{
		super.paintComponent(g);
		g.drawImage(background.get(0), 0, 0, 667, 950, null);  //画游戏背景
		
		//画玩家飞机，以及设置碰撞体积
		collision.run();
		
		me.drawSelf(g);
		me.shoot();
		drawplayershoot(g);	
		
		drawenemyone(g);
		drawenemyoneshoot(g);
		
		drawfirechange(g);
		
		
		//时刻准备画出玩家发射的子弹和大招
		
		//时刻准备画出敌机
		
		//准备画出敌机发射的子弹
		
		//时刻检测玩家与其它各类的碰撞
		
		//时刻检测玩家子弹与敌机的碰撞
		 
		//时刻检测玩家是否活着以及游戏是否结束
	}
	public void drawplayershoot(Graphics g)
	{
		for(int j=0;j<playerBullets.size();j++)                  //画我打出的子弹
		{				
			Bullet b=playerBullets.get(j);		
			b.drawSelf(g);  
		}
	}
	public void drawenemyoneshoot(Graphics g)
	{
		for(int j=0;j<enemyBullets.size();j++)                  //画我打出的子弹
		{				
			Bullet b=enemyBullets.get(j);		
			b.drawSelf(g);  
		}
	}
	public void drawfirechange(Graphics g)
	{
		for(int j=0;j<props.size();j++)                         //画我打出的子弹
		{				
			ChangeFireProp cfp=(ChangeFireProp)props.get(j);		
			cfp.drawSelf(g);  
		}
	}
	public void drawenemyone(Graphics g)
	{
		for(int j=0;j<enemy.size();j++)                         //画我打出的子弹
		{				
			Plane p=enemy.get(j);
			if(p.life<=0&&never){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
				System.out.println("已经装载");
				never=false;
			}
			p.drawSelf(g);  
		}
	}

}
