package Play;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import Toolbag.DrawString;


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
	public int bulletStyle;// The style of the bullets this plane generates
	public int life;// The life number of this plane;
	protected List<Plane> planes;
	protected List<Drawable> noticeAndExplosion;
	protected List<Bullet> bullets;
	protected Schedule scd;
	protected DrawString ds;
	
	protected boolean neverover=true;
	public boolean isAIshoot;
	protected int endtime;
	public int movetype;
	
	protected int bcx1=0;
	protected int bcx2=598;
	protected int bcx3;
	protected int bcy1;
	protected int bcy2;
	protected int bcy3;
	
	public int frequency;

	public Plane(int xpos, int ypos, int damage, int style, int bulletStyle, int life,
			List<Plane> planes,List<Drawable> noticeAndExplosion,List<Bullet> bullets,Schedule scd,DrawString ds,int frequency,int movetype) {
		super(xpos, ypos, PlaneGameUtil.getImage(style));
		this.damage = damage;
		this.style = style;
		this.frequency=frequency;
		this.bulletStyle = bulletStyle;
		this.life = life;
		this.planes = planes;
		this.noticeAndExplosion = noticeAndExplosion;
		this.bullets=bullets;	
		this.scd=scd;
		this.ds=ds;
		this.movetype=movetype;
	}

	/**
	 * A basic function of a plane to shoot the enemy. Then a new bullet will be
	 * generated.
	 */
	public void shoot(int type,int number) {
		int move=5;

		if(this.style==Constants.ME)
		{
			
		if(fire){
			if(this.bulletStyle==Constants.FIRE_ONE){
				Bullet b=new Bullet(this.xpos,this.ypos,10,this.bulletStyle,bullets,false);
				bullets.add(b);
				new Music("music/fire.wav").playSound();
			}else if(this.bulletStyle==Constants.FIRE_TWO){
				Bullet b=new Bullet(this.xpos,this.ypos,20,this.bulletStyle,bullets,false);
				bullets.add(b);
				new Music("music/fire.wav").playSound();
			}	else{//this.bulletStyle==Constants.Firethree
				Bullet b=new Bullet(this.xpos,this.ypos,50,this.bulletStyle,bullets,false);
				bullets.add(b);
			}	/*else if(this.bulletStyle==Constants.FireFour){
				Bullet b=new Bullet(this.xpos,this.ypos,50,this.bulletStyle,bullets,false);
				bullets.add(b);
				//System.out.println("閿熸枻鎷蜂剑閿熸枻鎷烽敓鏂ゆ嫹鎷ラ敓锟�");
			}	*/	
		}	
		}else{
			if(type==1){  //鏉╂瑩鍣烽惃鍓噛pe娴犲懏鏁奸崣妯虹摍瀵鏆熼柌锟�
				for(int i=0;i<number;i++)
				{
				Bullet b=new Bullet(this.xpos+60,this.ypos+70,10,this.bulletStyle,bullets,false);
				bullets.add(b);
				}
			}
			else if(type==2){  //鏉╂瑩鍣烽惃鍓噛pe娴犲懏鏁奸崣妯虹摍瀵鏆熼柌锟�
				for(int i=0;i<number;i++)
				{
				Bullet b=new Bullet(this.xpos+60,this.ypos+70,25,this.bulletStyle,bullets,false);
				bullets.add(b);
				}
			}
		}
	}

	/**
	 * the method processing the keycode from keyboard for reaction.
	 * 
	 * @param keyCode
	 */

	public void move()
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
			if(this.style==Constants.ENEMY_ONE)
			{
				if(xpos<598&&ypos<900)
				{
					xpos=(int)(0.25*this.bcx3+0.5*this.bcx1+0.25*this.bcx2);
					ypos=(int)(0.25*this.bcy3+0.5*this.bcy1+0.25*this.bcy2);
				}
				else{
					planes.remove(this);
				}
			}else{
				if(xpos<598&&ypos<900)
				{
					simplemove();
				}
				else{
					planes.remove(this);
				}
			}
		}
	}
	
	public void simplemove()
	{
		if(movetype==1){
			if(new Random().nextInt(10)==1){
				xpos-=8;
			}else if(new Random().nextInt(10)==2){
				xpos+=1;	
			}else{
				ypos+=1;
			}
		}else if(movetype==2){
			xpos+=6;
			ypos+=6;
		}else if(movetype==3){
			xpos-=6;
			ypos-=6;
		}else if(movetype==4){
			ypos+=20;
		}else if(movetype==5){
			ypos-=3;
		}else if(movetype==6){
			if(new Random().nextInt(2)==1){
				xpos-=8;
			}else{
				xpos+=8;
			}
		}else if(movetype==7){
			ypos+=7;
		}else{
			
		}
		
	}
	
	public void getpoint(GetBezierCurvesPoint gbcp,Plane player)
	{
		this.bcy1=gbcp.gety1();
		this.bcy2=gbcp.gety2();
		this.bcx3=player.xpos;
		this.bcy3=player.ypos;
		this.xpos=(int)(0.25*this.bcx3+0.5*this.bcx1+0.25*this.bcx2);
		this.ypos=(int)(0.25*this.bcy3+0.5*this.bcy1+0.25*this.bcy2);
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
	public void attackpress(KeyEvent e)//閿熺即浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹
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
		if(this.isOver()&&neverover){
			if(this.style==Constants.ME){
				this.noticeAndExplosion.add(this);
				new Music("music/boom.wav").playSound();
				endtime=scd.getendtime();
				neverover=false;	
			}else{
				this.noticeAndExplosion.add(this);
				new Music("music/boom.wav").playSound();
				if(this.style==Constants.SPENEMY){
					this.ds.score+=5;
				}else if(this.style==Constants.ENEMY_ONE){
					this.ds.score+=30;
				}else if(this.style==Constants.ENEMY_TWO){
					this.ds.score+=45;
				}else if(this.style==Constants.BOSS){
					this.ds.score+=100;
				}
				
				planes.remove(this);
			}	
		}else{
			if(!this.isOver()){
			g.drawImage(image, xpos, ypos, null);
			move();
			}else{
				 DrawString.draw(g, Color.red, "闅朵功", 40, 250, 450, "浣犳寕浜嗭紒鐢熷瓨鏃堕棿锛�"+endtime, 0);
				 new Music("music/boom.wav").playSound();
			}
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
