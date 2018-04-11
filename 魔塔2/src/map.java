import java.util.ArrayList;

//这其实就是地图类

public class map //在这里 第一维相当于 图中的x坐标即横线往右   第二维相当于图中的y坐标即竖线往下
{
	block [][] ma=new block[18][15];//创建一个存储二进制的数组。
	int x;//定义每张图里玩家的起始x坐标
	int y;//定义每张图里玩家的起始y坐标
	int l_x;//定义每张图里玩家的起始x坐标
	int l_y;//定义每张图里玩家的起始y坐标
	public map()//为二维数组创建实例
	{
		for(int i=0;i<18;i++)
			for(int j=0;j<15;j++)
			{
				ma[i][j]=new block();
			}
	}
}
