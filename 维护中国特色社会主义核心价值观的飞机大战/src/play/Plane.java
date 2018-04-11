package play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 5, 2017
 * @description The class of planes
 *
 */
public class Plane extends MapElement implements Drawable {
	protected int damage;// The damage when the plane is crashing at the other
							// plane.
	protected int style;// The style of the plane to choose the plane image.
	protected int bulletStyle;// The style of the bullets this plane generates
	protected int life;// The life number of this plane;
	protected List<Plane> planes;
	protected List<Drawable> noticeAndExplosion;

	public Plane(int xpos, int ypos, int damage, int style, int bulletStyle, int life,
			List<Plane> planes,List<Drawable> noticeAndExplosion) {
		super(xpos, ypos, PlaneGameUtil.getImage(style));
		this.damage = damage;
		this.style = style;
		this.bulletStyle = bulletStyle;
		this.life = life;
		this.planes = planes;
		this.noticeAndExplosion = noticeAndExplosion;
	}

	/**
	 * A basic function of a plane to shoot the enemy. Then a new bullet will be
	 * generated.
	 */
	public void shoot() {

		System.out.println("shoot!");
	}

	/**
	 * the method processing the keycode from keyboard for reaction.
	 * 
	 * @param keyCode
	 */
	/*public void act(int keyCode) {
		// The space key is for shooting
		if (keyCode == KeyEvent.VK_SPACE) {
			shoot();
			return;
		}

		// Otherwise it is for moving
		move(keyCode);
	}*/

	/**
	 * the move action according to the keyboard
	 * 
	 * @param keyCode
	 */
	public void move(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			ypos = (ypos - Constants.PLANE_SPEED) >= 0 ? ypos - Constants.PLANE_SPEED : ypos;
			break;
		case KeyEvent.VK_DOWN:
			ypos = (ypos + Constants.PLANE_SPEED + image.getHeight()) < Constants.GAME_HEIGHT
					? ypos + Constants.PLANE_SPEED : ypos;
			break;
		case KeyEvent.VK_LEFT:
			xpos = (xpos - Constants.PLANE_SPEED) >= 0 ? xpos - Constants.PLANE_SPEED : xpos;
			break;
		case KeyEvent.VK_RIGHT:
			xpos = (xpos + Constants.PLANE_SPEED + image.getWidth()) < Constants.GAME_WIDTH
					? xpos + Constants.PLANE_SPEED : xpos;
			break;
		case KeyEvent.VK_SPACE:
			shoot();
			break;
		default:
			break;
		}
	}

	/**
	 * The method to be used when the plane is shoot.Then the life will be
	 * decreased.
	 * 
	 * @param damage
	 *            The damage to cause the life change.
	 */
	public void decreaseLife(int damage) {
		life -= damage;
	}

	@Override
	public void drawSelf(Graphics g) {
		if(isOver()){
			
		}
		g.drawImage(image, xpos, ypos, null);
	}

	/**
	 * Get the rectangle of the plane on the panel.The rectangle of player is
	 * smaller that enemy.
	 */
	@Override
	public Rectangle getRectangle() {
		int width = image.getWidth();
		int height = image.getHeight();
		int xpos = this.xpos;
		int ypos = this.ypos;
		if (style == Constants.ME) {
			width = (int) (width * Constants.RATIO);
			height = (int) (height * Constants.RATIO);
			xpos = xpos + (image.getWidth() - width) / 2;
			ypos = ypos + (image.getHeight() - height) / 2;
		}
		return new Rectangle(xpos, ypos, width, height);
	}

	@Override
	public void affect(Plane plane) {
		plane.decreaseLife(damage);
	}

	/**
	 * Indicate whether the plane is over
	 * 
	 * @return
	 */
	public boolean isOver() {
		return life > 0;
	}
}
