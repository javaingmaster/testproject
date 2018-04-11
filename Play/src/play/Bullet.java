package play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description The class about the bullet that the planes generate.There are
 *              two situation where the bullet will be removed from the
 *              frame:(1)The bullet is out of bounds;(2)The bullet has hit a
 *              plane.
 *
 */
public class Bullet extends MapElement implements Drawable {
	private int speedincrease=Constants.Playerbullet_SPEEDadd;
	private int speed=Constants.Playerbullet_SPEED-10;
	private int damage;// The damage of this bullet
	private List<Bullet> bullets;// The container that contains all the
									// objects need painted.
	private int style;// The style of the bullet, which decides the damage and
						// appearance.

	public Bullet(int xpos, int ypos, int damage, int style, List<Bullet> bullets) {
		super(xpos, ypos, PlaneGameUtil.getImage(style));
		this.damage = damage;
		this.bullets = bullets;
		this.style = style;
		//processStyle();
	}

	/**
	 * set the bullet fields according to the style
	 */
	/*private void processStyle() {
		switch (style) {
		case Constants.Fireone:
			
		case Constants.Firetwo:

		case 3:

		case 4:

		default:
			break;
		}
	}*/

	/**
	 * To change the location of the bullets.
	 */
	private void move() {
		switch (style) {
		case Constants.Fireone:
			move0();
			break;
		case Constants.Firetwo:
			move1();
			break;
		case Constants.enemybulletone:
			move2();
			break;
		default:
			break;
		}
	}

	/**
	 * The move style of the bullet that is of style zero.
	 */
	private void move0() {

		ypos-=speed;
		speed+=speedincrease;	
	}

	private void move1() {
		ypos-=(speed+3);
		speed+=(speedincrease+1);
	}

	private void move2() {
		ypos+=speed;
		speed+=speedincrease;	
	}

	/**
	 * remove itself when the bullet is out of bounds.
	 */
	private void outDetection() {
		if (xpos < 0 || xpos > 630) {
			bullets.remove(this);
		}
		if (ypos < 0 || ypos > 900) {
			bullets.remove(this);
		}
	}

	/**
	 * Get the rectangle of the bullet for collision detection
	 * 
	 * @return The rectangle of the bullet
	 */
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(xpos, ypos, image.getWidth(), image.getHeight());
	}

	@Override
	public void drawSelf(Graphics g) {
		g.drawImage(image, xpos-24,ypos,null);
		g.drawImage(image, xpos+9,ypos,null);
		move();
		outDetection();
	}

	/**
	 * The bullet will disappear when it efffects on the plane.
	 * 
	 * @return
	 */
	@Override
	public void affect(Plane plane) {
		plane.decreaseLife(damage);
		bullets.remove(this);
	}

}
