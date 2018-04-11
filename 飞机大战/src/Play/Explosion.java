package Play;

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
	private Plane p;

	public Explosion(Plane p, List<Drawable> noticeAndExplosion) {
		super(p.xpos, p.ypos, null);
		this.noticeAndExplosion = noticeAndExplosion;
		this.p=p;
	}

	@Override
	public void drawSelf(Graphics g) {
		PlaneGameUtil.drawExplosion(p, g,this.noticeAndExplosion);
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
