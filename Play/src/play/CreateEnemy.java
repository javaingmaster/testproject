package play;

import java.util.List;

public class CreateEnemy {

	public CreateEnemy(int x,int y,int damage,int enemyimage,int enemybullet,int life,List<Plane> enemy,List<Drawable> noticeAndExplosion,List<Bullet> enemyBullets,Schedule scd,int number){
		
		for(int i=0;i<number;i++)
		{
			Plane enemyone=new Plane(x, y, damage,  enemyimage, enemybullet, life, enemy, noticeAndExplosion,enemyBullets,null);
			enemyone.shoot();
			enemy.add(enemyone);
			x-=40;                  //ÒÆ¶¯AI
			y-=40;
		}
	}
	
}
