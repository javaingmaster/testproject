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
		new PaintThread().start();      //�߳��ػ���Ϸ����
		
		
		
		this.enemy = enemy;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.noticeAndExplosion = noticeAndExplosion;
		this.copy = new ArrayList<Drawable>();
		
		/*
		 * ����ͼƬ��������
		 */
		background=new ArrayList<Image>();
		backgroundone=Gameimage.getimage("images/forest-01.jpg");
		background.add(backgroundone);
		
		/*
		 * �л���������
		 */
		
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
		me.drawSelf(g);
		
		//ʱ��׼��������ҷ�����ӵ��ʹ���
		
		//ʱ��׼�������л�
		
		//׼�������л�������ӵ�
		
		//ʱ�̼������������������ײ
		
		//ʱ�̼������ӵ���л�����ײ
		 
		//ʱ�̼������Ƿ�����Լ���Ϸ�Ƿ����
	}

}
