package Play;

import java.util.List;

import Toolbag.DrawString;

public class CreateEnemy {

	public CreateEnemy(int x,int y,int damage,int enemyimage,int enemybullet,int life,List<Plane> enemy,List<Drawable> noticeAndExplosion,List<Bullet> enemyBullets,Schedule scd,int number,DrawString ds,int movetype,int frequency){
		for(int i=0;i<number;i++)
		{
			Plane enemyone=new Plane(x, y, damage,  enemyimage, enemybullet, life, enemy, noticeAndExplosion,enemyBullets,null,ds,frequency,movetype);
			enemy.add(enemyone);
		}
	}
		
}
