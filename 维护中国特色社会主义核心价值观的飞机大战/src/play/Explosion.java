package play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 10, 2017
 * @description The class to show explosion.
 *
 */
public class Explosion extends MapElement implements Drawable {
	private List<Drawable> noticeAndExplosion;

	public Explosion(int xpos, int ypos, List<Drawable> noticeAndExplosion) {
		super(xpos, ypos, null);
		this.noticeAndExplosion = noticeAndExplosion;
	}

	@Override
	public void drawSelf(Graphics g) {
		PlaneGameUtil.drawExplosion(xpos, ypos, g);
		noticeAndExplosion.remove(this);
	}

	@Override
	public Rectangle getRectangle() {
		return new Rectangle(xpos, ypos, 50, 50);
	}

	@Override
	public void affect(Plane plane) {
	}
}
