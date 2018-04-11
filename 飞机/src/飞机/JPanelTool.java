package �ɻ�;

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
	BufferedImage firechange; //���Ե���
	
	public boolean never=true;
	
	 public Collision collision;
	
	ArrayList<Plane> Me;

	Plane me;
	
	ChangeFireProp cfp; //�����л�����
	
	public JPanelTool(Plane me,List<Plane> enemy, List<Bullet> playerBullets, List<Bullet> enemyBullets, List<Prop> props,
			List<Drawable> noticeAndExplosion)
	{
		new PaintThread().start();      //�߳��ػ���Ϸ����
		
		
		
		this.enemy = enemy;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.noticeAndExplosion = noticeAndExplosion;
		this.copy = new ArrayList<Drawable>();
		this.firechange=PlaneGameUtil.readImage("images/firechange.png"); //���Ե���
		
		this.collision=new Collision(me, enemy, playerBullets, enemyBullets, props);
		
		/*
		 * ����ͼƬ��������
		 */
		background=new ArrayList<Image>();
		backgroundone=Gameimage.getimage("images/forest-01.jpg");
		background.add(backgroundone);
		
		/*
		 * �л���������
		 */
		int x=200,y=200;         //�л�����
		for(int i=0;i<5;i++)
		{
			Plane enemyone=new Plane(x, y, 10, Constants.enemyone, Constants.enemybulletone, 100, enemy, noticeAndExplosion,enemyBullets);
			enemyone.shoot();
			enemy.add(enemyone);
			x-=40;
			y-=40;
		}
		
		/*
		 * ��ʯ���������
		 */
		
		/*
		 * boss��������
		 */
		
		/*
		 * ��ҷɻ���������
		 */
		Me=new ArrayList<Plane>();
		this.me=me;
		Me.add(me);
		/*
		 * ��ʱ������
		 */
		
		/*
		 * �л��ӵ���������
		 */
		
		/*
		 * ����ӵ���������
		 */
		
		/*
		 * ����ӵ������������
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
	
	public void paintComponent(Graphics g) // ��Ϸ�����ػ溯��
	{
		super.paintComponent(g);
		g.drawImage(background.get(0), 0, 0, 667, 950, null);  //����Ϸ����
		
		//����ҷɻ����Լ�������ײ���
		collision.run();
		
		me.drawSelf(g);
		me.shoot();
		drawplayershoot(g);	
		
		drawenemyone(g);
		drawenemyoneshoot(g);
		
		drawfirechange(g);
		
		
		//ʱ��׼��������ҷ�����ӵ��ʹ���
		
		//ʱ��׼�������л�
		
		//׼�������л�������ӵ�
		
		//ʱ�̼������������������ײ
		
		//ʱ�̼������ӵ���л�����ײ
		 
		//ʱ�̼������Ƿ�����Լ���Ϸ�Ƿ����
	}
	public void drawplayershoot(Graphics g)
	{
		for(int j=0;j<playerBullets.size();j++)                  //���Ҵ�����ӵ�
		{				
			Bullet b=playerBullets.get(j);		
			b.drawSelf(g);  
		}
	}
	public void drawenemyoneshoot(Graphics g)
	{
		for(int j=0;j<enemyBullets.size();j++)                  //���Ҵ�����ӵ�
		{				
			Bullet b=enemyBullets.get(j);		
			b.drawSelf(g);  
		}
	}
	public void drawfirechange(Graphics g)
	{
		for(int j=0;j<props.size();j++)                         //���Ҵ�����ӵ�
		{				
			ChangeFireProp cfp=(ChangeFireProp)props.get(j);		
			cfp.drawSelf(g);  
		}
	}
	public void drawenemyone(Graphics g)
	{
		for(int j=0;j<enemy.size();j++)                         //���Ҵ�����ӵ�
		{				
			Plane p=enemy.get(j);
			if(p.life<=0&&never){
				this.cfp=new ChangeFireProp(p.xpos,p.ypos,firechange,props);
				props.add(cfp);
				System.out.println("�Ѿ�װ��");
				never=false;
			}
			p.drawSelf(g);  
		}
	}

}
