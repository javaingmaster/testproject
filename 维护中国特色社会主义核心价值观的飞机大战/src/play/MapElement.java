package play;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description The map element that contains normal fields.
 *
 */
public class MapElement {
	protected int xpos;
	protected int ypos;
	protected BufferedImage image;
	
	public MapElement(int xpos, int ypos, BufferedImage image) {
		super();
		this.xpos = xpos;
		this.ypos = ypos;
		this.image = image;
	}
}
