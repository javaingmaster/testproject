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
	
	private static BufferedImage enemybulletone;
	
	private static BufferedImage firechange;
	private static BufferedImage fireone;
	private static BufferedImage firetwo;
	
	private static BufferedImage enemyone;
 
	static {
		// Here are not images now.So the url may get exceptions.
		me = PlaneGameUtil.readImage("images/me0.png");
		firechange=PlaneGameUtil.readImage("images/firechange.png");
		fireone=PlaneGameUtil.readImage("images/paidfireone.png");
		firetwo=PlaneGameUtil.readImage("images/paidfiretwo.png");
		
		enemyone = PlaneGameUtil.readImage("images/enemyone.png");
		
		enemybulletone=PlaneGameUtil.readImage("images/enemybulletone.png");
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
		case Constants.Fireone:
			return fireone;
		case Constants.Firetwo:
			return firetwo;
		case Constants.Firechange:
			return firechange;
		case Constants.enemyone:
			return enemyone;
		case Constants.enemybulletone:
			return enemybulletone;
		}
		return null;
	}
}
