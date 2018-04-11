package play;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 10, 2017
 * @description The class that is used to manage the images.
 *
 */
public class ImageManager {
	private static BufferedImage me;
	private static BufferedImage planeTwo;
	private static BufferedImage planeThree;
 
	static {
		// Here are not images now.So the url may get exceptions.
		me = PlaneGameUtil.readImage("images/me0.png");
	}

	/**
	 * Get the image according to the image style.
	 * 
	 * @param imageStyle
	 * @return
	 */
	public static BufferedImage getImage(int imageStyle) {
		switch (imageStyle) {
		case Constants.ME:
			return me;
		case Constants.PLANE_STYLE_TWO:
			return planeTwo;
		case Constants.PLANE_STYLE_THREE:
			return planeThree;
		}
		return null;
	}
}
