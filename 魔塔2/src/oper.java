
public class oper//操作人物运动的类
{
	static int layer=0;
	isueb move(player pla,map maps,int alin,String s)
	{
		maplist mapl=new maplist();//获取对应的地图
		battles bat=new battles();
		
		int x=pla.y;
		int y=pla.x;//获取用户坐标
		
		isueb is=new isueb();//这个类是用来定义用户是否进行了战斗，以及是否能够通过
		
		if(alin==2)//向下移动
		{
			if(y+1>14)
			{
				is.dei=false;
				System.out.println("下不去了");
				return is;
			}
			if(maps.ma[x][y+1].isTh==true)
			{
				if(maps.ma[x][y+1].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x][y+1].obj.atta;
				}
				else if(maps.ma[x][y+1].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x][y+1].obj.def;
				}
				else if(maps.ma[x][y+1].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x][y+1].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x][y+1].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x][y+1].obj.key;
				}
				else if(maps.ma[x][y+1].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x][y+1].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x][y+1].obj.def;
					pla.attack=pla.attack+maps.ma[x][y+1].obj.atta;
				}
				maps.ma[x][y+1].isTh=false;
			}
			
			if(maps.ma[x][y+1].ismon==true&&maps.ma[x][y+1].mon.type>=1)//如果有npc，但是npc并非怪物，则不进行战斗
			{
				if(maps.ma[x][y+1].mon.tietu==25)//商人
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x][y+1].ismon==true&&maps.ma[x][y+1].mon.type==0)//如果有npc，并且是怪物，就进行战斗
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pla.alive=bat.bat(pla,maps.ma[x][y+1].mon,s);//把战斗结果返还给玩家的alive，如果战败，则玩家的alive为false
				is.isbat=true;//定义用户进行了战斗
				
				if(pla.alive==true)//如果玩家还活着
				{
					maps.ma[x][y+1].ismon=false;
					maps.ma[x][y+1].across=0;
				}
			}
		
			if(maps.ma[x][y+1].across==0)//通路
			{
				is.dei=true;
				pla.x=y+1;
				pla.y=x;
			}
			else if(maps.ma[x][y+1].across==1)//有墙
			{
				is.dei=false;
			}
			
			else if(maps.ma[x][y+1].across==3)//到下一层
			{
				is.dei=true;		
				pla.x=y+1;
				pla.y=x;
				is.isCh=2;
				layer++;//层数加一
				is.layer=layer;
				maps=mapl.list.get(layer);//让地图指向下一层
			}
			
			else if(maps.ma[x][y+1].across==-1)//到上一层
			{
				is.dei=true;
				pla.x=y+1;
				pla.y=x;
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向上一层
				}
			}
			else if(maps.ma[x][y+1].across==2)//有门的话
			{
				if(pla.key>0)//如果还有钥匙
				{
					pla.key--;
					maps.ma[x][y+1].across=0;
					is.dei=true;
					pla.x=y+1;
					pla.y=x;
				}
				else//如果没有钥匙，就过不去 
				{
					is.dei=false;
				}
			}
		}
		
		
		else if(alin==8)//向上移动
		{
			if(y-1<0)
			{
				is.dei=false;
				System.out.println("上不去了");
				return is;
			}
			
			if(maps.ma[x][y-1].isTh==true)
			{
				if(maps.ma[x][y-1].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x][y-1].obj.atta;
				}
				else if(maps.ma[x][y-1].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x][y-1].obj.def;
				}
				else if(maps.ma[x][y-1].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x][y-1].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x][y-1].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x][y-1].obj.key;
				}
				else if(maps.ma[x][y-1].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x][y-1].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x][y-1].obj.def;
					pla.attack=pla.attack+maps.ma[x][y-1].obj.atta;
				}
				maps.ma[x][y-1].isTh=false;
			}
			if(maps.ma[x][y-1].ismon==true&&(maps.ma[x][y-1].mon.type>=1))//如果有npc，但是npc并非怪物，则不进行战斗
			{
				if(maps.ma[x][y-1].mon.tietu==25)//商人
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x][y-1].ismon==true&&(maps.ma[x][y-1].mon.type==0))//如果有怪，就进行战斗
			{
				pla.alive=bat.bat(pla,maps.ma[x][y-1].mon,s);//把战斗结果返还给玩家
				is.isbat=true;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pla.alive==true)
				{
					maps.ma[x][y-1].ismon=false;
					maps.ma[x][y-1].across=0;
				}
			}
			
			
			 if(maps.ma[x][y-1].across==0)//通路
			{
				is.dei=true;
				pla.x=y-1;
				pla.y=x;
			}
			else if(maps.ma[x][y-1].across==1)//有墙
			{	is.dei=false; }
			else if(maps.ma[x][y-1].across==3)//到下一层
			{
				is.dei=true;
				pla.x=y-1;
				pla.y=x;
				System.out.println("此时是在地图"+layer);
				if(layer>=0)
				{
					is.isCh=2;
					layer++;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向下一层
				}
				System.out.println("地图有"+mapl.list.size());
				System.out.println("此时是在地图"+layer);
				System.out.println("入口楼梯的across为"+maps.ma[12][6].across);
			}
			else if(maps.ma[x][y-1].across==-1)//到上一层
			{
				is.dei=true;
				pla.x=y-1;
				pla.y=x;
				
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向上一层
				}
			}
			else if(maps.ma[x][y-1].across==2)//有门
			{
				if(pla.key>0)
				{
					pla.key--;
					maps.ma[x][y-1].across=0;
					is.dei=true;
					pla.x=y-1;
					pla.y=x;
				}
				else 
				{
					is.dei=false;
				}
			}
		}
		
		
		
		else if(alin==4)//向左移动
		{
			if(x-1<0)
			{
				is.dei=false;
				System.out.println("左边走不动了");
				return is;
			}
			
			if(maps.ma[x-1][y].isTh==true)
			{
				if(maps.ma[x-1][y].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x-1][y].obj.atta;
				}
				else if(maps.ma[x-1][y].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x-1][y].obj.def;
				}
				else if(maps.ma[x-1][y].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x-1][y].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x-1][y].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x-1][y].obj.key;
				}
				else if(maps.ma[x-1][y].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x-1][y].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x-1][y].obj.def;
					pla.attack=pla.attack+maps.ma[x-1][y].obj.atta;
				}
				maps.ma[x-1][y].isTh=false;
			}
			
			if(maps.ma[x-1][y].ismon==true&&maps.ma[x-1][y].mon.type>=1)
			{
				if(maps.ma[x-1][y].mon.tietu==25)//商人
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x-1][y].ismon==true&&maps.ma[x-1][y].mon.type==0)//如果有怪，就进行战斗
			{
				pla.alive=bat.bat(pla,maps.ma[x-1][y].mon,s);//把战斗结果返还给玩家
				is.isbat=true;
				if(pla.alive==true)
				{
					maps.ma[x-1][y].ismon=false;
					maps.ma[x-1][y].across=0;
				}
			}
			
			else if(maps.ma[x-1][y].across==0)//通路
			{
				is.dei=true;
				pla.x=y;
				pla.y=x-1;
			}
			else if(maps.ma[x-1][y].across==1)//有墙
			{ 	is.dei=false;	}
			else if(maps.ma[x-1][y].across==3)//到下一层
			{
				is.dei=true;
				pla.x=y;
				pla.y=x-1;
				if(layer>=0)
				{
					is.isCh=2;
					layer++;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向上一层
				}
			}
			else if(maps.ma[x-1][y].across==-1)//到上一层
			{
				is.dei=true;
				pla.x=y;
				pla.y=x-1;
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向上一层
				}
			}
			else if(maps.ma[x-1][y].across==2)//有门
			{
				if(pla.key>0)
				{
					pla.key--;
					maps.ma[x-1][y].across=0;
					is.dei=true;
					pla.x=y;
					pla.y=x-1;
				}
				else 
				{
					is.dei= false;
				}
			}
		}
		
		
		
		else if(alin==6)//向右移动
		{
			if(x+1>17)
			{
				is.dei=false;
				System.out.println("右边走不动了");
				return is;
			}
			
			if(maps.ma[x+1][y].isTh==true)
			{
				if(maps.ma[x+1][y].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x+1][y].obj.atta;
				}
				else if(maps.ma[x+1][y].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x+1][y].obj.def;
				}
				else if(maps.ma[x+1][y].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x+1][y].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x+1][y].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x+1][y].obj.key;
				}
				else if(maps.ma[x+1][y].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x+1][y].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x+1][y].obj.def;
					pla.attack=pla.attack+maps.ma[x+1][y].obj.atta;
				}
				maps.ma[x+1][y].isTh=false;
			}
			if(maps.ma[x+1][y].ismon==true&&(maps.ma[x+1][y].mon.type>=1))
			{
				if(maps.ma[x+1][y].mon.tietu==25)//商人
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x+1][y].ismon==true&&(maps.ma[x+1][y].mon.type==0))//如果有怪，就进行战斗
			{
				pla.alive=bat.bat(pla,maps.ma[x+1][y].mon,s);//把战斗结果返还给玩家
				is.isbat=true;
				if(pla.alive==true)
				{
					maps.ma[x+1][y].ismon=false;
					maps.ma[x+1][y].across=0;
				}
			}
			
			if(maps.ma[x+1][y].across==1)//有墙
			{ is.dei=false;}
			else if(maps.ma[x+1][y].across==3)//到下一层
			{
				is.dei=true;
				pla.x=y;
				pla.y=x+1;
				if(layer>=0)
				{
					is.isCh=2;
					layer++;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向上一层
				}
			}
			else if(maps.ma[x+1][y].across==-1)//到上一层
			{
				is.dei=true;
				pla.x=y;
				pla.y=x+1;
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//让地图指向上一层
				}
			}
			else if(maps.ma[x+1][y].across==0)//通路
			{
			//	System.out.print("x=="+x);
				is.dei=true;
				pla.x=y;
				pla.y=x+1;
			}
			else if(maps.ma[x+1][y].across==2)//有门
			{
				if(pla.key>0)
				{
					pla.key--;
					maps.ma[x+1][y].across=0;
					is.dei=true;
					pla.x=y;
					pla.y=x+1;
				}
				else 
				{
					is.dei=false;
				}
			}
		}
		//System.out.println("x:"+pla.x+"    y:"+pla.y);
		return is;
	}
}
