package gameone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Gameair extends Frame
{
	Image img=Gameimage.getimage("images/1.jpg");
	
	
	public void launchframe()
	{
		setSize(500,500);
		setLocation(200,200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{

			public void windowClosing(WindowEvent arg0) {
			System.exit(0);
			}
			
		});
	}
	
	public void paint(Graphics g)//����Ϊ���ʣ������⻭ͼ�Σ��������ַ���,�����ɫ,�ɸı仭����ɫ,����
	{
		g.drawLine(100, 100, 200, 200);
		Color c=g.getColor();
		g.setColor(Color.BLUE);
		g.fillRect(100, 100, 50, 50);
		g.setColor(c);
		Font f=new Font("����",Font.BOLD,100);//������
		g.setFont(f);
	}

	public static void main (String args[])
	{
		Gameair gf=new Gameair();
		gf.launchframe();
	}
}
