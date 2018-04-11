package Play;

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
	public CornFrame() {
		frame=new JFrame("ÍÀÉ±£¡");
		
		scd=new Schedule();
		enemy = new ArrayList<Plane>();
		playerBullets = new ArrayList<Bullet>();
		enemyBullets = new ArrayList<Bullet>();
		props = new ArrayList<Prop>();
		noticeAndExplosion = new ArrayList<Drawable>();
		me=new Plane(200, 800, 100, Constants.ME, Constants.FIRE_ONE, 1000, Me, noticeAndExplosion,playerBullets,scd,null,0,0);
		Me=new ArrayList<Plane>();
		Me.add(me);
		    frame.setTitle("Ò»³¡ÍÀÉ±£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡");
			frame.setSize(1000, 1000);
			frame.setLocation(500,0);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanelTool MainJpanel=new JPanelTool(scd,Me,me, enemy, playerBullets, enemyBullets, props, noticeAndExplosion);        //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ï·ï¿½ï¿½ï¿½ÚµÄ»ï¿½ï¿½ï¿½
			MainJpanel.setSize(1000, 1000);
			frame.setContentPane(MainJpanel);
			frame.addKeyListener(new KeyListener(me));
			
			frame.setVisible(true);	
	}

	public void launchFrame() {
		frame.getContentPane().removeAll();
	}
}
