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
	private List<Plane> enemyCopy;// To copy the enemy container
	private List<Bullet> playerBulletsCopy;
	private List<Bullet> enemyBulletsCopy;
	private List<Prop> propsCopy;
	private Plane player;

	public Collision(Plane player, List<Plane> enemy, List<Bullet> playerBullets, List<Bullet> enemyBullets,
			List<Prop> props) {
		super();
		this.enemy = enemy;
		this.playerBullets = playerBullets;
		this.enemyBullets = enemyBullets;
		this.props = props;
		this.player = player;
		enemyCopy = new ArrayList<Plane>();
		enemyBulletsCopy = new ArrayList<Bullet>();
		playerBulletsCopy = new ArrayList<Bullet>();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(Constants.COLLISION_DECTION_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			PlaneGameUtil.getListCopy(playerBullets, playerBulletsCopy);
			PlaneGameUtil.getListCopy(enemyBullets, enemyBulletsCopy);
			PlaneGameUtil.getListCopy(enemy, enemyCopy);
			PlaneGameUtil.getListCopy(props, propsCopy);
			playerAndEnemyPlane();
			playerAndEnemyBullets();
			playerBulletsAndEnemyPlane();
			playerAndProps();
		}
	}

	/**
	 * Detect the collision between player and enemy plane.
	 */
	private void playerAndEnemyPlane() {
		Rectangle rec = player.getRectangle();
		for (Plane plane : enemyCopy) {
			if (rec.intersects(plane.getRectangle())) {
				player.affect(plane);
				plane.affect(player);
			}
		}
	}

	/**
	 * Detect the collision between player and enemy bullets.
	 */
	private void playerAndEnemyBullets() {
		Rectangle rec = player.getRectangle();
		for (Bullet bullet : enemyBulletsCopy) {
			if (rec.intersects(bullet.getRectangle())) {
				bullet.affect(player);
			}
		}
	}

	/**
	 * Detect the collision between player bullets and enemy.
	 */
	private void playerBulletsAndEnemyPlane() {
		for (Bullet playerBullet : playerBulletsCopy) {
			for (Plane enemy : enemyCopy) {
				if (playerBullet.getRectangle().intersects(enemy.getRectangle())) {
					playerBullet.affect(enemy);
				}
			}
		}
	}

	/**
	 * Detect the collision between player and props.
	 */
	private void playerAndProps() {
		for (Prop prop : props) {
			if (player.getRectangle().intersects(prop.getRectangle())) {
				prop.affect(player);
			}
		}
	}
}
