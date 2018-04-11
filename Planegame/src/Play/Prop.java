package Play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description The props that the player can get.
 *
 */
public class Prop extends MapElement implements Drawable {
	protected List<Prop> props;

	public Prop(int xpos, int ypos, BufferedImage image) {
		super(xpos, ypos, image);
	}

	/**
	 * Change the location of the props.
	 */
	public void move(){
		this.ypos += Constants.AEROLITE_SPEED;
		if (ypos >= Constants.GAME_HEIGHT) {
			props.remove(this);
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

	@Override
	public void affect(Plane plane) {
	}
}
