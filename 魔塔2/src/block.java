
public class block //设置每一个方块的属性
{
	int across=1;//设置方块属性， 0是可以通过，1是墙，即不能通过，2是门，即可以通过钥匙打开,默认为墙，3是下一层，-1是上一层
	int num=1,num2=1;//设置怪物的种类，默认为1，物品种类默认为1
	Thing obj=new Thing();//设置方块掉落物品
	boolean isTh=false;//设置是否会掉落物品
	boolean ismon=false;//设置是否存在怪物，如果是false则表示不存在怪物，如果是true则表示存在怪物	如果存在怪物的时候，默认设置across为0
	monster mon=new monster();//如果有怪物的话，这里是设置怪物属性
	mons ml=new mons();
	Things tl=new Things();
	void mond(int count)
	{
		mon=ml.list.get(count);
	}
	
	void objs(int count)
	{
		obj=tl.list2.get(count-1);
	}
	
	
}
