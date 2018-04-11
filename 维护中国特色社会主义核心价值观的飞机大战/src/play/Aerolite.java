package play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description The aerolite can be regarded as a plane that is not able to
 *              control.
 *
 */
public class Aerolite extends Plane {
	public Aerolite(int xpos, int ypos, BufferedImage image, int damage, int life, List<Plane> objects,
			List<Drawable> noticeAndExplosion) {
		super(xpos, ypos, damage, Constants.AEROLITE, -1, life, objects, noticeAndExplosion);
	}

	/**
	 * Change the location of the aerolite
	 */
	private void move() {
		ypos += Constants.AEROLITE_SPEED;
		if (ypos >= Constants.GAME_HEIGHT) {
			planes.remove(this);
		}
	}

	@Override
	public void drawSelf(Graphics g) {
		g.drawImage(image, xpos, ypos, null);
		move();
	}

	@Override
	public Rectangle getRectangle() {
		return new Rectangle(xpos, ypos, image.getWidth(), image.getHeight());
	}
}
