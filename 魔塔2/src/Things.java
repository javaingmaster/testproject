import java.util.ArrayList;

public class Things 
{
	static ArrayList <Thing> list2 =new ArrayList <Thing>();

	public Things()
	{
		Things1();
	}
	void Things1()
	{
		Thing Thing1=new Thing();
		Thing1.type=3;
		Thing1.HealPots=200;
		Thing1.tietu=1;
		list2.add(Thing1);
		Thing2();
	}
	void Thing2()
	{
		Thing Thing2=new Thing();
		Thing2.type=4;
		Thing2.key=1;
		Thing2.tietu=2;
		list2.add(Thing2);
		Thing3();
	}
	void Thing3()
	{
		Thing Thing3= new Thing();
		Thing3.type=2;
		Thing3.def=3;
		Thing3.tietu=3;
		list2.add(Thing3);
		Thing4();
	}
	void Thing4()
	{
		Thing Thing4=new Thing();
		Thing4.type=3;
		Thing4.HealPots=500;
		Thing4.tietu=4;
		list2.add(Thing4);
		Thing5();
	}
	void Thing5()
	{
		Thing Thing5=new Thing();
		Thing5.type=1;
		Thing5.atta=5;
		Thing5.tietu=5;
		list2.add(Thing5);
		Thing6();
	}
	void Thing6()
	{
		Thing Thing6=new Thing();
		Thing6.type=2;
		Thing6.def=10;
		Thing6.tietu=6;
		list2.add(Thing6);
		Thing7();
	}
	void Thing7()
	{
		Thing Thing7=new Thing();
		Thing7.type=1;
		Thing7.atta=10;
		Thing7.tietu=7;
		list2.add(Thing7);
		Thing8();
	}
	
	void Thing8()
	{
		Thing Thing8=new Thing();
		Thing8.type=0;
		Thing8.atta=9999;
		Thing8.def=9999;
		Thing8.HealPots=9999;
		Thing8.tietu=8;
		list2.add(Thing8);
	}
}
