package menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menu0 
{
	public static void main(String[] args)
	{
		JFrame jf=new JFrame("ѧ������ϵͳ");
		jf.setSize(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar bar=new JMenuBar();
		jf.setJMenuBar(bar);
		JMenu m1=new JMenu("�ļ�");
		JMenu m2=new JMenu("�༭");
		JMenu m3=new JMenu("��ͼ");
		bar.add(m1);		
		bar.add(m2);
		bar.add(m3);
		JMenuItem i1=new JMenuItem("��");
		JMenuItem i2=new JMenuItem("����");
		JMenuItem i3=new JMenuItem("��ӡ");
		JMenuItem i4=new JMenuItem("�˳�");
		m1.add(i1);
		m1.addSeparator();
		m1.add(i2);
		m1.addSeparator();
		m1.add(i3);
		m1.addSeparator();
		m1.add(i4);
		jf.setVisible(true);
	}
	
}
