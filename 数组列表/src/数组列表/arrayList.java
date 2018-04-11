package 数组列表;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class arrayList 
{
	public static void main(String[] args)
	{
		JFrame jf=new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 200);
		jf.setVisible(true);
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		jf.setContentPane(p1);
		String[] list={"徐立德","将狗子","高兴鬼","周廷宇"};
		JList l1=new JList(list);
		JTextField jt=new JTextField();
		p1.add(l1,"North");
		p1.add(jt,"South");
		while(true)
		{
			jt.setText((String)l1.getSelectedValue());
		}
	}

}
