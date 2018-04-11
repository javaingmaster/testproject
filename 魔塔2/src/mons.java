import java.util.ArrayList;


public class mons 
{
	static ArrayList <monster> list=new ArrayList<monster>();
	
	public mons()
	{
		mon1();
	}
	
	void mon1()//绿史莱姆
	{
		monster mon1=new monster();
		mon1.name="绿史莱姆";
		mon1.tietu=0;
		mon1.lifemax=100;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=15;
		mon1.Def=1;
		mon1.money=1;
		mon1.exper=1;
		list.add(mon1);
		mon2();
	}
	
	
	void mon2()//红史莱姆
	{
		monster mon1=new monster();
		mon1.name="红史莱姆";
		mon1.tietu=1;
		mon1.lifemax=100;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=15;
		mon1.Def=2;
		mon1.money=2;
		mon1.exper=2;
		list.add(mon1);
		mon3();
	}
	
	void mon3()//蝙蝠
	{
		monster mon1=new monster();
		mon1.name="蝙蝠";
		mon1.tietu=2;
		mon1.lifemax=150;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=15;
		mon1.Def=5;
		mon1.money=3;
		mon1.exper=3;
		list.add(mon1);
		mon4();
	}
	
	void mon4()//骷髅人
	{
		monster mon1=new monster();
		mon1.name="骷髅人";
		mon1.tietu=3;
		mon1.lifemax=150;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=20;
		mon1.Def=5;
		mon1.money=5;
		mon1.exper=4;
		list.add(mon1);
		mon5();
	}
	
	void mon5()//黑史莱姆
	{
		monster mon1=new monster();
		mon1.name="黑史莱姆";
		mon1.tietu=4;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=25;
		mon1.Def=5;
		mon1.money=5;
		mon1.exper=5;
		list.add(mon1);
		mon6();
	}
	
	void mon6()//骷髅兵
	{
		monster mon1=new monster();
		mon1.name="骷髅兵";
		mon1.tietu=5;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=30;
		mon1.Def=15;
		mon1.money=8;
		mon1.exper=6;
		list.add(mon1);
		mon7();
	}
	
	void mon7()//大蝙蝠
	{
		monster mon1=new monster();
		mon1.name="大蝙蝠";
		mon1.tietu=6;
		mon1.lifemax=300;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=50;
		mon1.Def=25;
		mon1.money=10;
		mon1.exper=8;
		list.add(mon1);
		mon8();
	}
	
	void mon8()//初级法师
	{
		monster mon1=new monster();
		mon1.name="初级法师";
		mon1.tietu=7;
		mon1.lifemax=100;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=40;
		mon1.Def=25;
		mon1.money=10;
		mon1.exper=7;
		list.add(mon1);
		mon9();
	}
	
	void mon9()//兽面人
	{
		monster mon1=new monster();
		mon1.name="兽面人";
		mon1.tietu=8;
		mon1.lifemax=350;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=60;
		mon1.Def=45;
		mon1.money=13;
		mon1.exper=10;
		list.add(mon1);
		mon10();
	}
	
	void mon10()//初级士兵
	{
		monster mon1=new monster();
		mon1.name="初级士兵";
		mon1.tietu=9;
		mon1.lifemax=400;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=130;
		mon1.Def=90;
		mon1.money=22;
		mon1.exper=19;
		list.add(mon1);
		mon11();
	}
	
	void mon11()//红色大蝙蝠
	{
		monster mon1=new monster();
		mon1.name="红色大蝙蝠";
		mon1.tietu=10;
		mon1.lifemax=350;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=150;
		mon1.Def=70;
		mon1.money=25;
		mon1.exper=20;
		list.add(mon1);
		mon12();
	}
	
	void mon12()//史莱姆王
	{
		monster mon1=new monster();
		mon1.name="史莱姆王";
		mon1.tietu=11;
		mon1.lifemax=600;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=200;
		mon1.Def=125;
		mon1.money=32;
		mon1.exper=30;
		list.add(mon1);
		mon13();
	}
	
	void mon13()//骷髅队长
	{
		monster mon1=new monster();
		mon1.name="骷髅队长";
		mon1.tietu=12;
		mon1.lifemax=500;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=80;
		mon1.Def=45;
		mon1.money=15;
		mon1.exper=12;
		list.add(mon1);
		mon14();
	}
	
	void mon14()//白色卫兵
	{
		monster mon1=new monster();
		mon1.name="红色大蝙蝠";
		mon1.tietu=13;
		mon1.lifemax=700;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=250;
		mon1.Def=150;
		mon1.money=40;
		mon1.exper=35;
		list.add(mon1);
		mon15();
	}
	
	void mon15()//石头人
	{
		monster mon1=new monster();
		mon1.name="石头人";
		mon1.tietu=14;
		mon1.lifemax=350;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=115;
		mon1.Def=65;
		mon1.money=15;
		mon1.exper=15;
		list.add(mon1);
		mon16();
	}
	
	void mon16()//中级法师
	{
		monster mon1=new monster();
		mon1.name="中级法师";
		mon1.tietu=15;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=120;
		mon1.Def=70;
		mon1.money=20;
		mon1.exper=17;
		list.add(mon1);
		mon17();
	}
	
	void mon17()//高级法师
	{
		monster mon1=new monster();
		mon1.name="高级法师";
		mon1.tietu=16;
		mon1.lifemax=400;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=350;
		mon1.Def=250;
		mon1.money=47;
		mon1.exper=45;
		list.add(mon1);
		mon18();
	}
	
	void mon18()//兽人武士
	{
		monster mon1=new monster();
		mon1.name="兽人武士";
		mon1.tietu=17;
		mon1.lifemax=1000;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=400;
		mon1.Def=300;
		mon1.money=50;
		mon1.exper=50;
		list.add(mon1);
		mon19();
	}
	
	void mon19()//红衣魔王
	{
		monster mon1=new monster();
		mon1.name="红衣魔王";
		mon1.tietu=18;
		mon1.lifemax=1000;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=900;
		mon1.Def=900;
		mon1.money=100;
		mon1.exper=100;
		list.add(mon1);
		mon20();
	}
	
	void mon20()//魔龙
	{
		monster mon1=new monster();
		mon1.name="魔龙";
		mon1.tietu=19;
		mon1.lifemax=99999;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=1999;
		mon1.Def=500;
		mon1.money=0;
		mon1.exper=0;
		list.add(mon1);
		mon21();
	}
	
	void mon21()//红衣法师
	{
		monster mon1=new monster();
		mon1.name="红衣法师";
		mon1.tietu=20;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=170;
		mon1.Def=100;
		mon1.money=30;
		mon1.exper=25;
		list.add(mon1);
		mon22();
	}
	
	void mon22()//钢铁武士
	{
		monster mon1=new monster();
		mon1.name="钢铁武士";
		mon1.tietu=21;
		mon1.lifemax=1000;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=300;
		mon1.Def=250;
		mon1.money=45;
		mon1.exper=40;
		list.add(mon1);
		mon23();
	}
	
	void mon23()//红甲魔神
	{
		monster mon1=new monster();
		mon1.name="红甲魔神";
		mon1.tietu=22;
		mon1.lifemax=3000;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=600;
		mon1.Def=600;
		mon1.money=70;
		mon1.exper=75;
		list.add(mon1);
		mon24();
	}
	
	void mon24()//大法师
	{
		monster mon1=new monster();
		mon1.name="大法师";
		mon1.tietu=23;
		mon1.lifemax=1000;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=1300;
		mon1.Def=700;
		mon1.money=130;
		mon1.exper=130;
		list.add(mon1);
		mon25();
	}
	
	void mon25()//商人
	{
		monster mon1=new monster();
		mon1.name="商人";
		mon1.tietu=24;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.attack=170;
		mon1.Def=100;
		mon1.money=30;
		mon1.exper=25;
		mon1.type=2;
		list.add(mon1);
		mon26();
	}
	
	void mon26()//npc
	{
		monster mon1=new monster();
		mon1.name="npc";
		mon1.tietu=25;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.type=1;
		list.add(mon1);
		mon27();
	}
	
	void mon27()//npc
	{
		monster mon1=new monster();
		mon1.name="npc";
		mon1.tietu=26;
		mon1.lifemax=200;//定义血量上限
		mon1.life=mon1.lifemax;
		mon1.type=1;
		list.add(mon1);
	}
	
}
