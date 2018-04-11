package play;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Toolbag.JPanelTool;
import Toolbag.KeyListener;

public class CornFrame {
	private Plane me;
	private JFrame frame;
	private List<Plane> enemy;

	private List<Bullet> playerBullets;
	private List<Bullet> enemyBullets;
	private List<Prop> props;
	private List<Drawable> noticeAndExplosion;
	public ArrayList<Plane> Me;
	public Schedule scd;

	/**
	 * get the frame from the previous GUI
	 *  
	 * @param frame
	 */
	public void CornFrame() {
		frame=new JFrame("一场屠杀");
		
		scd=new Schedule();
		enemy = new ArrayList<Plane>();
		playerBullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		noticeAndExplosion = new ArrayList<Drawable>();
		me=new Plane(200, 800, 100, Constants.ME, Constants.Fireone, 100, Me, noticeAndExplosion,playerBullets,scd);
		Me=new ArrayList<Plane>();
		Me.add(me);
		    frame.setTitle("这是一场屠杀...");
			frame.setSize(1000, 1000);
			frame.setLocation(500,0);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanelTool MainJpanel=new JPanelTool(scd,Me,me, enemy, playerBullets, enemyBullets, props, noticeAndExplosion);        //创建游戏所在的画板
			MainJpanel.setSize(1000, 1000);
			frame.setContentPane(MainJpanel);
			frame.addKeyListener(new KeyListener(me));
			
			frame.setVisible(true);	
	}

	public void launchFrame() {
		frame.getContentPane().removeAll();
	}
	public static void main(String[] aaa)
	{
		CornFrame cf=new CornFrame();
		cf.CornFrame();
	}
}
