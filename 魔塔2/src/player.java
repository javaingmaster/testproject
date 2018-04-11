import java.util.ArrayList;


public class player //用户状态
{
	String name="勇者";//定义用户名字
	boolean alive=true;//这是判断用户是否存活，如果是true则代表存活，如果是false则代表死亡
	int maxlife=1000;//定义生命上限
	int life=1000;//定义生命状态
	int level=1;//定义等级
	int attack=10;//定义攻击力
	int Def=10;//定义防御力
	int expe=0;//定义经验值
    int key=1;//定义随身钥匙
	int money=0;//定义金钱
	int x;//用户当前位置
	int y;//用户当前位置
	ArrayList <Thing> object=new ArrayList<Thing>();//创建一个数组用来存储道具
}
