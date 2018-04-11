package Toolbag;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import play.Bullet;
import play.Drawable;
import play.Plane;
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
	
	ArrayList<Plane> Me;
	Plane me;
	
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
		
		/*
		 * 背景图片加载容器
		 */
		background=new ArrayList<Image>();
		backgroundone=Gameimage.getimage("images/forest-01.jpg");
		background.add(backgroundone);
		
		/*
		 * 敌机加载容器
		 */
		
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
		me.drawSelf(g);
		
		//时刻准备画出玩家发射的子弹和大招
		
		//时刻准备画出敌机
		
		//准备画出敌机发射的子弹
		
		//时刻检测玩家与其它各类的碰撞
		
		//时刻检测玩家子弹与敌机的碰撞
		 
		//时刻检测玩家是否活着以及游戏是否结束
	}

}
