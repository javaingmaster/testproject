package special;

import java.awt.Graphics;
import java.awt.Image;

import toolbag.Gameimage;

public class Explode     //��ը�����࣬����
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
			img[index].getWidth(null);//��������ͼ��
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
