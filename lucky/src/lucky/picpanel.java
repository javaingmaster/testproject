package lucky;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.net.URL;

public class picpanel extends Panel
{
	public picpanel()
	{
		initImg();
	}
	String fileName="D:\\java first set\\lucky\\3.jpg";//图片名
	Image img;//图片对象
	public void initImg()//图片装载到对象中
	{
		URL url=null;
		try
		{
			url=Class.forName("lucky.lucky").getResource("3.jpg");
		}catch(Exception e){System.out.println("number one."+e);}//try可以防止图片加载延迟
		img=getToolkit().getImage(url);//指定图像路
		MediaTracker mt=new MediaTracker(this);//缩放图片跟踪
		mt.addImage(img, 1);//付优先级，小数先加载
		try
		{	
			mt.checkAll();//确保图片加载完毕
		}catch(Exception e){System.out.println("number two.");}
	}
	public void paint(Graphics g)//绘图
	{
		g.drawImage(img,450,100,500,500,this);//绘制图像
	}

}
