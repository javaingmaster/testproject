package Play;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

/**
 * 
 * @author Zheng Mofang
 * @date Jun 8, 2017
 * @description The class about the bullet that the planes generate.There are
 *              two situation where the bullet will be removed from the
 *              frame:(1)The bullet is out of bounds;(2)The bullet has hit a
 *              plane.
 *
 */
public class Bullet extends MapElement implements Drawable {
	private int leftx=xpos-54,rightx= xpos+39,leftxx=leftx-26,rightxx=rightx+26;
	private int speedincrease=Constants.PLAYER_BULLET_SPEED_ADD;
	private int speed=Constants.PLAYER_BULLET_SPEED-10;
	private int damage;// The damage of this bullet
	private List<Bullet> bullets;// The container that contains all the
									// objects need painted.
	private int style;// The style of the bullet, which decides the damage and
						// appearance.
	private Plane player;
	private boolean single;
	public Bullet(int xpos, int ypos, int damage, int style, List<Bullet> bullets,boolean single) {
		super(xpos, ypos, PlaneGameUtil.getImage(style));
		this.damage = damage;
		this.bullets = bullets;
		this.style = style;
		//processStyle();
		this.single=single;
		
	}

	/**
	 * To change the location of the bullets.
	 */
	private void move() {
		switch (style) {
		case Constants.FIRE_ONE:
			move0();
			break;
		case Constants.FIRE_TWO:
			move1();
			break;
		case Constants.FIRE_THREE:
			move1();
			break;
		case Constants.ENEMY_BULLET_ONE:
			move2();
			break;
		case Constants.ENEMY_BULLET_TWO:
			move2();
			break;
		case Constants.SPECIAL_BULLET:
			specialmove();
			break;
		case Constants.SPECIAL_BULLET2:
			singlebulletmove();
			break;
		default:
			break;
		}
	}
	/**
	 * The move style of the bullet that is of style zero.
	 */
	private void move0() {

		ypos-=speed;
		speed+=speedincrease;	
	}

	private void move1() {
		ypos-=(speed+3);
		speed+=(speedincrease+1);
		this.leftx-=4;
		this.rightx+=4;
	}

	private void move2() {
		ypos+=speed;
		speed+=speedincrease;	
	}
	private void specialmove()
	{
		xpos+=speed*(player.xpos-this.xpos)/Math.sqrt(Math.pow((player.xpos-this.xpos), 2)+Math.pow((player.ypos-this.ypos),2));
		ypos+=speed*(player.ypos-this.ypos)/Math.sqrt(Math.pow((player.xpos-this.xpos), 2)+Math.pow((player.ypos-this.ypos),2));
	}
	private void singlebulletmove()
	{
		xpos+=(speed+5)*(player.xpos-this.xpos)/Math.sqrt(Math.pow((player.xpos-this.xpos), 2)+Math.pow((player.ypos-this.ypos),2));
		ypos+=(speed+5)*(player.ypos-this.ypos)/Math.sqrt(Math.pow((player.xpos-this.xpos), 2)+Math.pow((player.ypos-this.ypos),2));
	}

	/**
	 * remove itself when the bullet is out of bounds.
	 */
	private void outDetection() {
		if (xpos < 0 || xpos > 630) {
			bullets.remove(this);
		}
		if (ypos < 0 || ypos > 900) {
			bullets.remove(this);
		}
	}

	/**
	 * Get the rectangle of the bullet for collision detection
	 * 
	 * @return The rectangle of the bullet
	 */
	@Override
	public Rectangle getRectangle() {
		return new Rectangle(xpos, ypos, image.getWidth(), image.getHeight());
	}

	public void drawSelf(Graphics g) {
		if(single){
			g.drawImage(image, xpos,ypos,null);
			move();
			outDetection();
		}else{        
			if(this.style==Constants.FIRE_ONE){
				g.drawImage(image, xpos-24,ypos,null);
				g.drawImage(image, xpos+9,ypos,null);
				move();
				outDetection();
			}else if(this.style==Constants.FIRE_TWO){
				g.drawImage(image, xpos-4,ypos,null);
				g.drawImage(image, xpos+29,ypos,null);
				g.drawImage(image,this.leftx+20 ,ypos,null);
				g.drawImage(image,this.rightx+20,ypos,null);
				move();
				outDetection();
			}else if(this.style==Constants.FIRE_THREE){
				g.drawImage(image, xpos+1,ypos,null);
				g.drawImage(image, xpos+34,ypos,null);
				g.drawImage(image,this.leftx+25 ,ypos,null);
				g.drawImage(image,this.rightx+25,ypos,null);
				g.drawImage(image,this.leftxx+25 ,ypos,null);
				g.drawImage(image,this.rightxx+25,ypos,null);
				move();
				outDetection();
			}else if(this.style==Constants.ENEMY_BULLET_ONE){
				g.drawImage(image, xpos-24,ypos,null);
				g.drawImage(image, xpos+9,ypos,null);
				move();
				outDetection();
			}
			else if(this.style==Constants.ENEMY_BULLET_TWO){
				g.drawImage(image, xpos-24,ypos,null);
				g.drawImage(image, xpos+9,ypos,null);
				g.drawImage(image, xpos-40,ypos,null);
				g.drawImage(image, xpos+25,ypos,null);
				move();
				outDetection();
			}
			
		}
		
	}

	/**
	 * The bullet will disappear when it efffects on the plane.
	 * 
	 * @return
	 */
	@Override
	public void affect(Plane plane) {
		plane.decreaseLife(damage);
		bullets.remove(this);
	}
	
	public void getplayerlocation(Plane player)
	{
		this.player=player;
	}

}
