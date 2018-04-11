package jtabbedpane;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class jtabbedpane 
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){System.out.println("shit!");}
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tab=new JTabbedPane();
		jf.setContentPane(tab);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();	
		JLabel l1=new JLabel("工资3000/月"); 
		p1.setLayout(new FlowLayout());
		p1.add(l1);
		tab.addTab("panel1",p1);
		tab.setEnabledAt(0,true);	
		tab.setTitleAt(0, "个人收入");
		tab.addTab("panel2",p2);
		tab.setEnabledAt(1,true);
		tab.setTitleAt(1, "工资");
		tab.addTab("panel3",p3);
		tab.setEnabledAt(2,true);
		tab.setTitleAt(2, "奖金");
		tab.addTab("panel4",p4);
		tab.setEnabledAt(3,true);
		tab.setTitleAt(3, "津贴");
		tab.addTab("panel5",p5);
		tab.setEnabledAt(4,true);
		tab.setTitleAt(4, "社保");
		tab.setPreferredSize(new Dimension(400,200));
		tab.setTabPlacement(JTabbedPane.LEFT);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		jf.pack();
		jf.setVisible(true);
	}

}
