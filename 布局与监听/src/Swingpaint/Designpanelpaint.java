package Swingpaint;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Designpanelpaint 
{
	public void myframe()
	{
		Mypanel p1=new Mypanel();
		JFrame  jf=new JFrame();
		JPanel p2=new JPanel();
		
		jf.setSize(800, 800);
		jf.setLocation(20, 50);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(new GridLayout(1,2,50,30));
		jf.add(p1);
		jf.add(p2);
		JTextField t=new JTextField(15);
		p2.setLayout(null);
		p2.add(t);
		t.setBounds(350, 350,50 ,50);
		

		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		Designpanelpaint test=new Designpanelpaint();
		test.myframe();
	}

}

class Mypanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		g.drawLine(50, 50, 100, 100);
	}
}
