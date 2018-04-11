package play;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Zheng Mofang
 * @date Jun 5, 2017
 * @description The class of planes
 *
 */
public class Plane extends MapElement implements Drawable {
	protected boolean left,right,up,down,fire;
	protected int damage;// The damage when the plane is crashing at the other
							// plane.
	protected int style;// The style of the plane to choose the plane image.
	protected int bulletStyle;// The style of the bullets this plane generates
	public int life;// The life number of this plane;
	protected List<Plane> planes;
	protected List<Drawable> noticeAndExplosion;
	protected List<Bullet> bullets;
	protected Schedule scd;

	public Plane(int xpos, int ypos, int damage, int style, int bulletStyle, int life,
			List<Plane> planes,List<Drawable> noticeAndExplosion,List<Bullet> bullets,Schedule scd) {
		super(xpos, ypos, PlaneGameUtil.getImage(style));
		this.damage = damage;
		this.style = style;
		this.bulletStyle = bulletStyle;
		this.life = life;
		this.planes = planes;
		this.noticeAndExplosion = noticeAndExplosion;
		this.bullets=bullets;	
		this.scd=scd;
	}

	/**
	 * A basic function of a plane to shoot the enemy. Then a new bullet will be
	 * generated.
	 */
	public void shoot() {

		if(this.style==Constants.ME)
		{
			
		if(fire){
			if(this.bulletStyle==Constants.Fireone){
				Bullet b=new Bullet(this.xpos,this.ypos,10,this.bulletStyle,bullets);
				bullets.add(b);
				//System.out.println("添加一号子弹");
			}else if(this.bulletStyle==Constants.Firetwo){
				Bullet b=new Bullet(this.xpos,this.ypos,20,this.bulletStyle,bullets);
				bullets.add(b);
				//System.out.println("添加二号子弹");
			}						
		}	
		}else if(this.style==Constants.enemyone){
			int y=5;
			for(int i=0;i<5;i++)
			{
			Bullet b=new Bullet(this.xpos,this.ypos+y,10,this.bulletStyle,bullets);
			bullets.add(b);
			y+=15;
			}
		}
	}

	/**
	 * the method processing the keycode from keyboard for reaction.
	 * 
	 * @param keyCode
	 */

	public void move()//飞机移动规则
	{
		if(this.style==Constants.ME)
		{
		if(left&&xpos>0){
			xpos-=Constants.PLANE_SPEED;
		}
		if(right&&xpos<598){
			xpos+=Constants.PLANE_SPEED;
		}
		if(up&&ypos>0){
			ypos-=Constants.PLANE_SPEED;
		}
		if(down&&ypos<880){
			ypos+=Constants.PLANE_SPEED;
		}
		}else{
			if(this.style==Constants.enemyone)
			{
				if(xpos>0&&xpos<598&&ypos>0&&ypos<880)
				{
					xpos+=6;
					ypos+=6;
				}
				else{
					planes.remove(this);
				}
			}
		}
	}
	/**
	 * the move action according to the keyboard
	 * 
	 * @param keyCode
	 */
	public void addmove(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case 38:
			up=true;
		    break;
		case 40:
			down=true;
	        break;
		case 37:
			left=true;
			break;
		case 39:
			right=true;
			break;
		default:
			break;
		}
	}

	public void releasemove(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		case 38:
			up=false;
	        break;
		case 40:
			down=false;
		    break;
		case 37:
			left=false;
		    break;
		case 39:
			right=false;
		    break;
		    default: break;
		}			
	}
	public void attackpress(KeyEvent e)//飞机攻击监听
	{
		//System.out.println(e.getKeyCode());
		switch(e.getKeyCode())
		{
		
		case KeyEvent.VK_SPACE:
			fire=true;
		    break;
		    
		    default: break;
		}
		
	}
	public void attackrelease(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
		
		case KeyEvent.VK_SPACE:
			fire=false;
		    break;
		    
		    default: break;
		}
		
	}
	/**
	 * The method to be used when the plane is shoot.Then the life will be
	 * decreased.
	 * 
	 * @param damage
	 *            The damage to cause the life change.
	 */
	public void decreaseLife(int damage) {
		life -= damage;
	}

	@Override
	public void drawSelf(Graphics g) {
		if(this.isOver()){
			if(this.style==Constants.ME){
				scd.getendtime();
				System.out.println("game over!");		//改成提示字符串
			}else{
				System.out.println("摧毁一架敌机!");
				planes.remove(this);
			}	
		}else{
			g.drawImage(image, xpos, ypos, null);
			move();
		}	
	}

	/**
	 * Get the rectangle of the plane on the panel.The rectangle of player is
	 * smaller that enemy.
	 */
	@Override
	public Rectangle getRectangle() {
		int width = image.getWidth();
		int height = image.getHeight();
		int xpos = this.xpos;
		int ypos = this.ypos;
		if (style == Constants.ME) {
			width = (int) (width * Constants.RATIO);
			height = (int) (height * Constants.RATIO);
			xpos = xpos + (image.getWidth() - width) / 2;
			ypos = ypos + (image.getHeight() - height) / 2;
		}
		return new Rectangle(xpos, ypos, width, height);
	}

	@Override
	public void affect(Plane plane) {
		plane.decreaseLife(damage);
	}

	/**
	 * Indicate whether the plane is over
	 * 
	 * @return
	 */
	public boolean isOver() {
		if(this.life>0)
		return false;
		
		return true;
	}
	
}
