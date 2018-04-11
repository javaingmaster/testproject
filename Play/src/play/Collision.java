package play;

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
	private List<Bullet> playerBullets;
	private List<Bullet> enemyBullets;
	private List<Prop> props;
	private Plane player;

	public Collision(Plane player, List<Plane> enemy, List<Bullet> playerBullets, List<Bullet> enemyBullets,
			List<Prop> props) {
		super();
		this.enemy = enemy;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.player = player;
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
		
	}

	/**
	 * Detect the collision between player and enemy plane.
	 */
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
		
		for(int j=0;j<enemyBullets.size();j++)
		{
			 Bullet b=enemyBullets.get(j);
			 if (rec.intersects(b.getRectangle())) {
					b.affect(player);				
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
					}
		 
				}
		}
	}

	/**
	 * Detect the collision between player and props.
	 */
	private void playerAndProps() {
		for(int j=0;j<props.size();j++)                         //画我打出的子弹
		{				
			ChangeFireProp cfp=(ChangeFireProp)props.get(j);		
			if (player.getRectangle().intersects(cfp.getRectangle())) {
				cfp.affect(player);
			}  
		}
	}
}
