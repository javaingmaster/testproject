
public class monster  //怪物模板
{
	String name="";//定义怪物名字
	int lifemax=1000;//定义血量上限
	int life=1000;//定义生命状态
	int level=1;//定义等级
	int attack=10;//定义攻击力
	int Def=10;//定义防御力
	int money=0;//定义金钱
	int exper=0;//定义怪物携带的经验值
	boolean isThing=false;//定义怪物是否携带了道具
	int tietu;
	Thing obj=new Thing();//定义怪物携带的道具
	int key=0;//定义怪物携带钥匙数
	int x;//定义坐标
	int y;//定义坐标
	int type=0;//友好值  0表示怪物，1表示NPC，2表示商人
}
