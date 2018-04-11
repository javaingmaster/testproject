package 清空文本;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class event1
{
	static JTextField text=new JTextField(20);
	
	public static void main(String[] args)
	{
		JFrame jf=new JFrame("测试程序");
		jf.setSize(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		jf.setContentPane(p1);
		JButton b1=new JButton("清空文本");
		p1.add(text,"North");
		p1.add(b1,"South");
		ActionHandler ac=new ActionHandler();
		b1.addActionListener(ac);
		jf.setVisible(true);
	}	
}
class ActionHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		new event1().text.setText("");
	}
	
}

