
public class experience //与等级处理相关的类
{
	//这里写一个算法吧，每一级升级经验等于 level*100
	// 每升一级，攻击力上升5，防御力上升5，生命上限升50，血量回50，经验值结算
	
	void level_up(player play)//处理升级系统
	{
		if(play.expe>=play.level*100)
		{
			//play.expe=play.expe-play.level*100;
			play.level++;
			play.attack=play.attack+5;
			play.Def=play.Def+5;
			play.maxlife=play.maxlife+50;
			play.life=play.life+50;
		}
	}
	
	
	
}
