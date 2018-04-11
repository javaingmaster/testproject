package play;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import Toolbag.JPanelTool;
import Toolbag.KeyListener;

public class CornFrame {
	private Plane me;
	private JFrame frame;
	private List<Plane> enemy;// The container that contains enemy plane and
	// aerolite
	private List<Bullet> playerBullets;
	private List<Bullet> enemyBullets;
	private List<Prop> props;
	private List<Drawable> noticeAndExplosion;


	/**
	 * get the frame from the previous GUI
	 * 
	 * @param frame
	 */
	public void CornFrame() {
		frame=new JFrame("一场屠杀");
		me=new Plane(200, 800, 50, Constants.ME, 1, 100, enemy, noticeAndExplosion);
		enemy = new ArrayList<Plane>();
		playerBullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		noticeAndExplosion = new ArrayList<Drawable>();
		
		    frame.setTitle("这是一场屠杀...");
			frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
			frame.setLocation(500,0);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanelTool MainJpanel=new JPanelTool(me, enemy, enemyBullets, enemyBullets, props, noticeAndExplosion);        //创建游戏所在的画板
			MainJpanel.setSize(Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
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
