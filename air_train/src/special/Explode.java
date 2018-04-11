package special;

import java.awt.Graphics;
import java.awt.Image;

import toolbag.Gameimage;

public class Explode     //爆炸生成类，待用
{
	double x,y;
	int size;
	Image[] img=new Image[size];
	
	public Explode(){}
	public Explode(double x,double y,int size,String name)
	{
		this.x=x;
		this.y=y;
		this.size=size;
		int index;
		for(index=0;index<size;index++)
		{
			img[index]=Gameimage.getimage(name+index);
			img[index].getWidth(null);//辅助加载图像
		}
	}
	public void drawexplode(Graphics g)
	{
		for(int i=0;i<size;i++)
		{
			g.drawImage(img[i], (int)x, (int)y, null);
		}
	}

}
