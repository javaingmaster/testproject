package Play;

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
	private static BufferedImage enemybullettwo;
	private static BufferedImage specialbullet;
	private static BufferedImage specialbullet2;
	private static BufferedImage specialbullet3;
	
	private static BufferedImage firechange;
	private static BufferedImage fireone;
	private static BufferedImage firetwo;
	private static BufferedImage firethree;
	
	private static BufferedImage enemyone;
	private static BufferedImage enemytwo;
	private static BufferedImage spenemy;
	private static BufferedImage boss;
	
	private static BufferedImage ep1;
	private static BufferedImage ep2;
	private static BufferedImage ep3;
	private static BufferedImage ep4;
	private static BufferedImage ep5;
	private static BufferedImage ep6;
 
	static {
		// Here are not images now.So the url may get exceptions.
		me = PlaneGameUtil.readImage("images/me0.png");
		firechange=PlaneGameUtil.readImage("images/firechange.png");
		fireone=PlaneGameUtil.readImage("images/paidfireone.png");
		firetwo=PlaneGameUtil.readImage("images/paidfiretwo.png");
		firethree=PlaneGameUtil.readImage("images/paidfirethree.png");
		
		enemyone = PlaneGameUtil.readImage("images/enemyone.png");
		enemytwo = PlaneGameUtil.readImage("images/enemytwo.png");
		spenemy = PlaneGameUtil.readImage("images/spenemy.png");
		boss = PlaneGameUtil.readImage("images/boss.png");
		
		enemybulletone=PlaneGameUtil.readImage("images/enemybulletone.png");
		enemybullettwo=PlaneGameUtil.readImage("images/enemybullettwo.png");
		specialbullet=PlaneGameUtil.readImage("images/specialbullet.png");
		specialbullet2=PlaneGameUtil.readImage("images/specialbullet2.png");
		specialbullet3=PlaneGameUtil.readImage("images/specialbullet3.png");
		
		ep1 = PlaneGameUtil.readImage("images/ep1.png");
		ep2 = PlaneGameUtil.readImage("images/ep2.png");
		ep3 = PlaneGameUtil.readImage("images/ep3.png");
		ep4 = PlaneGameUtil.readImage("images/ep4.png");
		ep5 = PlaneGameUtil.readImage("images/ep5.png");
		ep6 = PlaneGameUtil.readImage("images/ep6.png");
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
		case Constants.FIRE_ONE:
			return fireone;
		case Constants.FIRE_TWO:
			return firetwo;
		case Constants.FIRE_THREE:
			return firethree;
		case Constants.FIRE_CHANGE:
			return firechange;
		case Constants.ENEMY_ONE:
			return enemyone;
		case Constants.ENEMY_TWO:
			return enemytwo;
		case Constants.SPENEMY:
			return spenemy;
		case Constants.BOSS:
			return boss;
		case Constants.ENEMY_BULLET_ONE:
			return enemybulletone;
		case Constants.ENEMY_BULLET_TWO:
			return enemybullettwo;
		case Constants.SPECIAL_BULLET:
			return specialbullet;
		case Constants.SPECIAL_BULLET2:
			return specialbullet2;
		case Constants.SPECIAL_BULLET3:
			return specialbullet3;
		case Constants.EXPLOSION_ONE:
			return ep1;
		case Constants.EXPLOSION_TWO:
			return ep2;
		case Constants.EXPLOSION_THREE:
			return ep3;
		case Constants.EXPLOSION_FOUR:
			return ep4;
		case Constants.EXPLOSION_FIVE:
			return ep5;
		case Constants.EXPLOSION_SIX:
			return ep6;
		}
		return null;
	}
}
