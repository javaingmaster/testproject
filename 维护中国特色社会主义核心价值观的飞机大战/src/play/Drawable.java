package play;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 5, 2017
 * @description An interface that all objects need to implement
 *
 */
public interface Drawable {
	/**
	 * for the subclass of the interface to draw itself in the frame.
	 * 
	 * @param g
	 */
	void drawSelf(Graphics g);

	/**
	 * Get the rectangle of the object
	 * 
	 * @return
	 */
	Rectangle getRectangle();

	/**
	 * Get the damage of the object.
	 * 
	 * @return
	 */
	void affect(Plane plane);
}
