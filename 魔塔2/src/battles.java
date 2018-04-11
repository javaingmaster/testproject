
public class battles //这里是用来处理战斗的
{
	
	boolean bat(player pla,monster mon,String s)//这是处理战斗的方法
	{
		while(!(pla.life<=0||mon.life<=0))//战斗执行到其中一方血量为0
		{
			
			//玩家先攻
			int a=(int)Math.random()*100;//设计暴击种子
			if(a<=95)
			{
				if(pla.attack<=mon.Def)
				{
					mon.life=mon.life-1;
					s+="玩家未对怪物破防，强制造成  1  点伤害\n";
					
					System.out.println("玩家未对怪物破防，强制造成  1  点伤害");
				}
				else
				{
					mon.life=mon.life-pla.attack+mon.Def;
					s+="玩家对玩家造成   "+(pla.attack-mon.Def)+" 点伤害\n";
					System.out.println("玩家对玩家造成   "+(pla.attack-mon.Def)+" 点伤害");
				}
			}
			else//如果暴击，就造成2倍伤害
			{
				if(pla.attack<=mon.Def)
				{
					mon.life=mon.life-1;
					s+="玩家未对怪物破防，强制造成  1  点伤害\n";
					System.out.println("玩家未对怪物破防，强制造成  1  点伤害");
				}
				else
				{
					mon.life=mon.life-2*(pla.attack-mon.Def);
					s+="会心一击！ 玩家对怪物造成   "+2*(pla.attack-mon.Def)+" 点伤害\n";
					System.out.println("会心一击！ 玩家对怪物造成   "+2*(pla.attack-mon.Def)+" 点伤害");
				}
			}
			
			if(mon.life<=0)break;//如果怪物死掉了，就结束战斗
				
				
			//怪物后攻
			int b=(int)Math.random()*100;//设计暴击种子
			if(a<=98)
			{
				if(mon.attack<=pla.Def)
				{
					pla.life=pla.life-1;
					s+="怪物未对玩家破防，强制造成  1  点伤害\n";
					System.out.println("怪物未对玩家破防，强制造成  1  点伤害");
				}
				else
				{
					pla.life=pla.life-mon.attack+pla.Def;
					s+="怪物对玩家造成   "+(mon.attack-pla.Def)+" 点伤害\n";
					System.out.println("怪物对玩家造成   "+(mon.attack-pla.Def)+" 点伤害");
				}		
			}
			else//如果暴击，就造成2倍伤害
			{
				if(mon.attack<=pla.Def)
				{
					pla.life=pla.life-1;
					s+="怪物未对玩家破防，强制造成  1 点伤害\n";
					System.out.println("怪物未对玩家破防，强制造成  1 点伤害");
				}
				else
				{
					pla.life=mon.life-2*(mon.attack-pla.Def);
					s+="会心一击！ 玩家对怪物造成   "+2*(mon.attack-pla.Def)+" 点伤害\n";
					System.out.println("会心一击！ 玩家对怪物造成   "+2*(mon.attack-pla.Def)+" 点伤害");
				}
			}
		}
		
		if(pla.life<=0)//如果玩家没血了，则返回false
		{
			return false;
		}
		else if(mon.life<=0)//如果怪物没血了，则返回true，并获得经验
		{
			pla.expe=pla.expe+mon.exper;//将怪物经验值赋予用户
			
			experience ex=new experience();
			ex.level_up(pla);//上面是判断是否升级，如果升级，经验回溯
			
			pla.key=pla.key+mon.key;//将怪物携带的钥匙赋予用户
			
			if(mon.isThing==true)//如果怪物携带了道具，把道具给予用户
			{
				pla.object.add(mon.obj);
			}
			return true;
		}
		
		return true;
		
	}
}
