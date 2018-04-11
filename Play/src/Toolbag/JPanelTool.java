package Toolbag;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import play.BackGround;
import play.Bullet;
import play.ChangeFireProp;
import play.Collision;
import play.Constants;
import play.CreateEnemy;
import play.Drawable;
import play.Plane;
import play.PlaneGameUtil;
import play.Prop;
import play.Schedule;

public class JPanelTool extends JPanel
{	
	
	public boolean never=true;//����װ������
	
	private List<Plane> enemy;
    private List<Bullet> playerBullets;
    private List<Bullet> enemyBullets;
    private List<Prop> props;
    private List<Drawable> noticeAndExplosion;
    public ArrayList<Plane> Me;// �������
    public Plane me;

    public BackGround bg;//����
    public Collision collision;//��ײ
    public Schedule scd;
    
	public BufferedImage firechange; //���Ե���
	public ChangeFireProp cfp; //�����л�����
	public CreateEnemy ce;

	public JPanelTool(){}
	
	public JPanelTool(Schedule scd, ArrayList<Plane> Me,Plane me,List<Plane> enemy, List<Bullet> playerBullets, List<Bullet> enemyBullets, List<Prop> props,
			List<Drawable> noticeAndExplosion)
	{
		new PaintThread().start();      //�߳��ػ���Ϸ����
		
		this.me=me;
		this.Me=Me;
		this.enemy = enemy;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.noticeAndExplosion = noticeAndExplosion;
		this.firechange=PlaneGameUtil.readImage("images/firechange.png"); //���Ե���
		this.ce=new CreateEnemy(200, 200, 10, Constants.enemyone, Constants.enemybulletone, 100, this.enemy, this.noticeAndExplosion,this.enemyBullets,null,5);
		this.collision=new Collision(this.me, this.enemy, this.playerBullets, this.enemyBullets, this.props);
		this.bg=new BackGround();
		this.scd=scd;
		scd.run();
		
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
		scd.checktime();
		bg.drawbg(g);

		collision.run();
		
		me.drawSelf(g);
		me.shoot();
		drawplayershoot(g);	
		drawfirechange(g);
		
		drawenemyone(g);
		drawenemyoneshoot(g);
		
		/*if(scd.getthismonment()>=5&&scd.getthismonment()<=8){
			
		}*/
		
		
		
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
		for(int j=0;j<enemyBullets.size();j++)                  //�����˴�����ӵ�
		{				
			Bullet b=enemyBullets.get(j);		
			b.drawSelf(g);  
		}
	}
	public void drawfirechange(Graphics g)
	{
		for(int j=0;j<props.size();j++)                         //���ӵ�װ��
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
