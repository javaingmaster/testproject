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
	String fileName="D:\\java first set\\lucky\\3.jpg";//ͼƬ��
	Image img;//ͼƬ����
	public void initImg()//ͼƬװ�ص�������
	{
		URL url=null;
		try
		{
			url=Class.forName("lucky.lucky").getResource("3.jpg");
		}catch(Exception e){System.out.println("number one."+e);}//try���Է�ֹͼƬ�����ӳ�
		img=getToolkit().getImage(url);//ָ��ͼ��·
		MediaTracker mt=new MediaTracker(this);//����ͼƬ����
		mt.addImage(img, 1);//�����ȼ���С���ȼ���
		try
		{	
			mt.checkAll();//ȷ��ͼƬ�������
		}catch(Exception e){System.out.println("number two.");}
	}
	public void paint(Graphics g)//��ͼ
	{
		g.drawImage(img,450,100,500,500,this);//����ͼ��
	}

}
