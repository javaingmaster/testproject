import java.util.ArrayList;

//这个类用来存储所有的地图
public class maplist 
{
	static ArrayList<map> list=new ArrayList<map>();
	

	public void Chushi(map map,int a,int b,int c,int d)
	{
		for(int i=a;i<c;i++)
		{
			for(int j=b;j<d;j++)
			{
				map.ma[i][j].across=0;
			
			}
		}
	}//区域的初始化函数，填写across为0
	
	
	public void doth(map map,int a,int b,int c)
	{
		map.ma[a][b].isTh=true;
		map.ma[a][b].num2=c;
		map.ma[a][b].across=0;
		map.ma[a][b].objs(c);
	}//物品的初始化
	public void domon(map map,int a,int b,int c)
	{
		map.ma[a][b].ismon=true;
		map.ma[a][b].across=0;
		map.ma[a][b].num=c;
		map.ma[a][b].mond(c);
	}//怪物的初始化
	public maplist()
	{
	}
	
	void zouni()
	{
		this.map1();
	}
	
	
	void map1()//每个都代表一层地图
	{
		map map1=new map();
		for(int a=0;a<15;a++)
		{
			map1.ma[8][a].across=0;
		}
		map1.ma[8][5].ismon=true;
		map1.ma[8][5].mon.type=0;//设置NPC
		map1.ma[8][5].mon.name="开局小精灵";
		map1.ma[8][5].mon.x=8;
		map1.ma[8][5].mon.y=5;
		map1.ma[8][5].mon.attack=5;
		map1.ma[8][5].mon.Def=5;
		map1.ma[8][5].across=0;
		map1.ma[8][5].mon.exper=110;
		map1.ma[8][5].mon.key=1;
		map1.ma[8][5].mond(1);
		map1.ma[8][14].across=-1;
		map1.ma[8][0].across=3;
		
		map1.x=14;
		map1.y=8;
		
		map1.l_x=0;
		map1.l_y=8;
		
		list.add(map1);
		this.maps2();
	}
	
	
	void maps2()
	{
		map map2=new map();
		Chushi(map2,2,3,4,6);//区域1的初始化
	    Chushi(map2,2,7,4,9);//区域2的初始化
	    Chushi(map2,2,10,4,14);//区域3的初始化
        Chushi(map2,5,6,8,10);//区域4的初始化
        Chushi(map2,11,3,13,5);//区域5的初始化
        Chushi(map2,11,8,13,12);//区域6的初始化
		Chushi(map2,5,13,12,14);//7
		Chushi(map2,5,4,10,5);//8
		Chushi(map2,9,5,10,11);//9
		Chushi(map2,5,9,10,10);//10
				
		map2.ma[5][12].across=0;//11
		map2.ma[7][5].across=0;//12
		map2.ma[11][6].across=0;//13//通路的初始化
		
		map2.ma[4][7].across=2;
		map2.ma[4][13].across=2;
		map2.ma[10][4].across=2;
		map2.ma[10][6].across=2;
		
		map2.ma[3][6].across=2;
		
		map2.ma[10][8].across=2;//门的初始化
		
		map2.ma[12][13].across=3;
		map2.ma[12][6].across=-1;//楼梯的初始化
		
		map2.ma[2][3].isTh=true;
		map2.ma[2][3].num2=1;
		map2.ma[2][3].across=0;
		map2.ma[2][3].objs(1);

		map2.ma[2][4].across=0;
		map2.ma[2][4].isTh=true;
		map2.ma[2][4].num2=2;
		map2.ma[2][4].objs(2);
		
		map2.ma[2][5].across=0;
		map2.ma[2][5].isTh=true;
		map2.ma[2][5].num2=2;
		map2.ma[2][5].objs(2);
		
		map2.ma[2][7].across=0;
		map2.ma[2][7].isTh=true;
		map2.ma[2][7].num2=3;
		map2.ma[2][7].objs(3);
		
		map2.ma[2][8].across=0;
		map2.ma[2][8].isTh=true;
		map2.ma[2][8].num2=4;
		map2.ma[2][8].objs(4);
		
		map2.ma[2][10].across=0;
		map2.ma[2][10].isTh=true;
		map2.ma[2][10].num2=2;
		map2.ma[2][10].objs(2);
		
		map2.ma[2][11].across=0;
		map2.ma[2][11].isTh=true;
		map2.ma[2][11].num2=1;
		map2.ma[2][11].objs(1);
		
		map2.ma[2][12].across=0;
		map2.ma[2][12].isTh=true;
		map2.ma[2][12].num2=5;
		map2.ma[2][12].objs(5);
		
		map2.ma[2][13].across=0;
		map2.ma[2][13].ismon=true;
		map2.ma[2][13].num=4;
		map2.ma[2][13].mond(4);
		
		map2.ma[3][4].across=0;
		map2.ma[3][4].isTh=true;
		map2.ma[3][4].num2=4;
		map2.ma[3][4].objs(4);
		
		map2.ma[3][5].across=0;
		map2.ma[3][5].ismon=true;
		map2.ma[3][5].num=6;
		map2.ma[3][5].mond(6);
		
		map2.ma[3][7].across=0;
		map2.ma[3][7].ismon=true;
		map2.ma[3][7].num=6;
		map2.ma[3][7].mond(6);
		
		map2.ma[3][8].across=0;
		map2.ma[3][8].isTh=true;
		map2.ma[3][8].num2=2;
		map2.ma[3][8].objs(2);
		
		doth(map2,3,10,2);
		doth(map2,3,11,1);
		domon(map2,3,12,4);
		doth(map2,5,6,6);
		doth(map2,5,7,2);
		doth(map2,5,8,1);
		doth(map2,5,9,1);
		doth(map2,6,8,2);
		doth(map2,6,9,1);
		
		domon(map2,6,6,4);
		domon(map2,6,7,1);
		domon(map2,7,5,8);
		domon(map2,7,6,1);
		domon(map2,7,7,3);
		domon(map2,7,8,5);
		domon(map2,6,11,1);
		domon(map2,7,11,2);
		domon(map2,8,11,1);
		domon(map2,9,13,2);
		domon(map2,10,13,1);
		domon(map2,11,3,3);
		domon(map2,12,4,1);
		domon(map2,11,10,9);
		
		doth(map2,11,8,5);
		doth(map2,11,9,2);
		doth(map2,11,11,2);
		doth(map2,12,8,5);
		doth(map2,12,9,2);
		doth(map2,12,10,2);
		doth(map2,12,11,2);
		doth(map2,12,11,2);
		
		map2.x=6;
		map2.y=12;
		
		map2.l_x=13;
		map2.l_y=12;
		
		map2.ma[5][11].across=0;
		map2.ma[9][11].across=0;
		
		list.add(map2);
		this.map3();
	}
	
	
	void map3()
	{
		map map3=new map();
		Chushi(map3,2,3,13,4);//区域1的初始化
		Chushi(map3,2,5,13,6);//2
		Chushi(map3,8,6,9,9);//3
		Chushi(map3,2,9,4,14);//4
		Chushi(map3,2,7,7,8);//5
		Chushi(map3,5,8,6,14);//6
		Chushi(map3,10,7,9,13);//7
		Chushi(map3,9,10,13,11);//8
		Chushi(map3,9,12,13,13);//9
		Chushi(map3,7,10,8,13);//10
		Chushi(map3,6,8,7,9);//11
		
		map3.ma[4][11].across=2;
		map3.ma[6][11].across=2;
		map3.ma[7][5].across=2;
		map3.ma[7][8].across=2;
		map3.ma[8][4].across=2;
		map3.ma[8][10].across=2;
		map3.ma[8][12].across=2;
		map3.ma[9][5].across=2;
		map3.ma[9][8].across=2;//门的初始化
		
		map3.ma[2][3].across=-1;
		map3.ma[12][3].across=3;//楼梯的初始化
		
		doth(map3,2,9,5);
		doth(map3,2,10,3);
		doth(map3,2,11,2);
		doth(map3,2,12,2);
		doth(map3,2,13,2);
		doth(map3,3,7,5);
		doth(map3,3,9,5);
		doth(map3,3,10,3);
		doth(map3,3,12,2);
		doth(map3,3,13,2);
		doth(map3,4,5,3);
		doth(map3,4,7,3);
		doth(map3,5,5,2);
		doth(map3,5,9,2);
		doth(map3,5,10,4);
		doth(map3,6,5,2);
		doth(map3,10,5,2);
		doth(map3,10,7,4);
		doth(map3,10,8,1);
		doth(map3,11,5,2);
		doth(map3,11,7,4);
		doth(map3,11,8,1);
		doth(map3,12,5,5);
		doth(map3,12,7,4);
		doth(map3,12,8,1);//物品的初始化

		domon(map3,2,6,22);
		domon(map3,3,11,22);
		domon(map3,7,11,22);
		domon(map3,12,10,26);
		domon(map3,12,12,25);//怪物的初始化
		
		map3.x=3;
		map3.y=2;
		
		map3.l_x=3;
		map3.l_y=12;

		list.add(map3);
		this.map4();
	}
//	
		void map4()
	{
		map map4=new map();
		Chushi(map4,2,3,6,6);//区域1的初始化
		Chushi(map4,2,7,4,10);//2
		Chushi(map4,7,3,8,14);//3
		Chushi(map4,9,3,10,9);//4
		Chushi(map4,11,3,12,9);//5
		Chushi(map4,9,8,13,12);//6
		Chushi(map4,8,13,12,14);//7
		Chushi(map4,5,7,6,10);//8
		Chushi(map4,5,11,6,14);//9
		Chushi(map4,2,13,5,14);//10
		Chushi(map4,2,11,4,12);//11
		Chushi(map4,2,12,3,13);//12
		Chushi(map4,6,9,7,10);//13
		Chushi(map4,6,11,7,12);//14
		Chushi(map4,8,3,9,4);//15
		Chushi(map4,10,8,11,9);//16
		
		map4.ma[4][8].across=2;
		map4.ma[6][5].across=2;
		map4.ma[8][8].across=2;//门的初始化
		
		map4.ma[12][3].across=3;
		map4.ma[12][13].across=-1;//楼梯的初始化
		
		doth(map4,2,3,7);
		doth(map4,3,5,2);
		doth(map4,3,11,5);
		doth(map4,3,13,2);
		doth(map4,4,4,2);
		doth(map4,4,13,2);
		doth(map4,5,3,2);
		doth(map4,5,9,2);
		doth(map4,8,13,2);
		doth(map4,9,13,2);
		doth(map4,11,10,5);
		doth(map4,12,10,4);
		doth(map4,12,11,2);//物品的初始化
		
		domon(map4,2,4,2);
		domon(map4,2,8,25);
		domon(map4,2,11,3);
		domon(map4,3,3,3);
		domon(map4,5,5,4);
		domon(map4,5,8,4);
		domon(map4,7,12,1);
		domon(map4,7,13,3);
		domon(map4,8,3,3);
		domon(map4,9,5,1);
		domon(map4,9,6,1);
		domon(map4,9,10,2);
		domon(map4,9,11,2);
		domon(map4,10,10,3);
		domon(map4,10,11,3);
		domon(map4,11,5,3);
		domon(map4,11,6,3);//怪物的初始化
		
		map4.x=13;
		map4.y=12;
		map4.l_x=3;
		map4.l_y=12;


		list.add(map4);
		map5();
	}
	
		void map5()
		{
			map map5=new map();
			
			Chushi(map5,2,6,5,9);//区域1的初始化
			Chushi(map5,2,10,6,11);//2
			Chushi(map5,6,5,8,12);//3
			Chushi(map5,9,5,12,10);//4
			Chushi(map5,7,12,11,13);//5
			Chushi(map5,8,8,9,12);//6
			Chushi(map5,10,10,12,12);//7
			Chushi(map5,7,4,9,5);//8
			Chushi(map5,8,5,9,7);//9
			Chushi(map5,10,4,11,5);//10
			
			map5.ma[11][6].across=-1;
			map5.ma[5][7].across=2;
			
			for(int a=9;a<12;a++)
			{
				for(int b=5;b<10;b++)
				{
					doth(map5,a,b,4);
				}
			}
//			doth(map5,8,6,8);
//			doth(map5,8,8,8);
			doth(map5,2,10,8);
			
			for(int a=5;a<10;a++)
			{
				domon(map5,7,a,19);
			}
	        domon(map5,6,6,21);
	        domon(map5,6,8,21);
	        domon(map5,4,8,20);
	        domon(map5,3,8,20);
	        domon(map5,2,8,20);
	        domon(map5,3,7,20);
	        domon(map5,3,6,20);
	        map5.x=6;
	        map5.y=11;
			list.add(map5);
//			map6();
		}

//	
//	void map6()
//	{
//		map map6=new map();
//		list.add(map6);
//		map7();
//	}
//	
//	void map7()
//	{
//		map map7=new map();
//		list.add(map7);
//		map8();
//	}
//	
//	void map8()
//	{
//		map map8=new map();
//		list.add(map8);
//		map9();
//	}
//	
//	void map9()
//	{
//		map map9=new map();
//		list.add(map9);
//		map10();
//	}
//	
//	void map10()
//	{
//		map map10=new map();
//		list.add(map10);
//	}
	
	

}
