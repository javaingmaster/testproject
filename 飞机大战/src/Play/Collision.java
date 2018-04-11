package Play;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 10, 2017
 * @description The class that detects the collision between map elements.
 *
 */
public class Collision implements Runnable {
	private List<Plane> enemy;// The container that contains enemy plane and
								// aerolite
	private List<Plane> enemy2;
	private List<Plane> enemy3;
	private List<Plane> enemy4;
	private List<Plane> enemy5;
	private List<Bullet> playerBullets;
	private List<Bullet> enemyBullets;
	private List<Bullet> single;
	private List<Bullet> single2;
	private List<Prop> props;
	private Plane player;

	public Collision(Plane player, List<Plane> enemy, List<Plane> enemy2, List<Plane> enemy3, List<Plane> enemy4, List<Plane> enemy5, List<Bullet> playerBullets, List<Bullet> enemyBullets,
			List<Prop> props,List<Bullet> single,List<Bullet> single2) {
		super();
		this.enemy = enemy;
		this.enemy2=enemy2;
		this.enemy3=enemy3;
		this.enemy4=enemy4;
		this.enemy5=enemy5;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.player = player;
		this.single=single;
		this.single2=single2;
	}

	@Override
	public void run() {
		
			//PlaneGameUtil.getListCopy(playerBullets, playerBulletsCopy);
			//PlaneGameUtil.getListCopy(enemyBullets, enemyBulletsCopy);
			//PlaneGameUtil.getListCopy(enemy, enemyCopy);
			//PlaneGameUtil.getListCopy(props, propsCopy);
			playerAndEnemyPlane();
			playerAndEnemyBullets();
			playerBulletsAndEnemyPlane();
			playerAndProps();
		    playerAndsinglebullet();
	}

	/**
	 * Detect the collision between player and enemy plane.
	 */
	private void playerAndsinglebullet()
	{
        Rectangle rec = player.getRectangle();
		
		for(int j=0;j<single.size();j++)
		{
			 Bullet b=single.get(j);
			 if (rec.intersects(b.getRectangle())) {
					b.affect(player);	
					new Music("src/music/hit.wav").playSound();
				}
		}
		for(int j=0;j<single2.size();j++)
		{
			 Bullet b=single2.get(j);
			 if (rec.intersects(b.getRectangle())) {
					b.affect(player);	
					new Music("src/music/hit.wav").playSound();
				}
		}
	}
	private void playerAndEnemyPlane() {
		Rectangle rec = player.getRectangle();
		for(int j=0;j<enemy.size();j++)
		{
			 Plane p=enemy.get(j);
			 if (rec.intersects(p.getRectangle())) {
					p.affect(player);
					player.affect(p);
				}
		}
	}

	/**
	 * Detect the collision between player and enemy bullets.
	 */
	private void playerAndEnemyBullets() {
		
		Rectangle rec = player.getRectangle();
		//rec.setRect(player.xpos, player.ypos, 10, 11);
		
		for(int j=0;j<enemyBullets.size();j++)
		{
			 Bullet b=enemyBullets.get(j);
			 //System.out.println(b.getRectangle().getWidth());
			// System.out.println(b.getRectangle().getHeight());
			 if (rec.intersects(b.getRectangle())) {
					b.affect(player);	
					new Music("src/music/hit.wav").playSound();
				}
		}
		
	}

	/**
	 * Detect the collision between player bullets and enemy.
	 */
	private void playerBulletsAndEnemyPlane() {
	
		for(int j=0;j<playerBullets.size();j++)
		{
			 Bullet b=playerBullets.get(j);
			 
			 for(int m=0;m<enemy.size();m++)
				{
				 Plane e=enemy.get(m);
		
				 if(b.getRectangle().intersects(e.getRectangle())) {
						b.affect(e);
						new Music("src/music/hit.wav").playSound();
					}
		 
				}
			 for(int m=0;m<enemy2.size();m++)
				{
				 Plane e=enemy2.get(m);
		
				 if(b.getRectangle().intersects(e.getRectangle())) {
						b.affect(e);
						new Music("src/music/hit.wav").playSound();
					}
		 
				}
			 for(int m=0;m<enemy3.size();m++)
				{
				 Plane e=enemy3.get(m);
		
				 if(b.getRectangle().intersects(e.getRectangle())) {
						b.affect(e);
						new Music("src/music/hit.wav").playSound();
					}
		 
				}
			 for(int m=0;m<enemy4.size();m++)
				{
				 Plane e=enemy4.get(m);
		
				 if(b.getRectangle().intersects(e.getRectangle())) {
						b.affect(e);
						new Music("src/music/hit.wav").playSound();
					}
		 
				}
			 for(int m=0;m<enemy5.size();m++)
				{
				 Plane e=enemy5.get(m);
		
				 if(b.getRectangle().intersects(e.getRectangle())) {
						b.affect(e);
						new Music("src/music/hit.wav").playSound();
					}
		 
				}
		}
	}

	/**
	 * Detect the collision between player and props.
	 */
	private void playerAndProps() {
		for(int j=0;j<props.size();j++)                         //锟斤拷锟揭达拷锟斤拷锟斤拷拥锟�
		{				
			ChangeFireProp cfp=(ChangeFireProp)props.get(j);		
			if (player.getRectangle().intersects(cfp.getRectangle())) {
				cfp.affect(player);
				new Music("src/music/getprop.wav").playSound();
			}  
		}
	}
}
