package �����¼�1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class action1 
{
	private int control=0;
	public void mywin()
	{
		JFrame jf=new JFrame("����");
		jf.setSize(300,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		jf.add(p1);
		JButton b1=new JButton("ȷ��");
		b1.setSize(100,100);
		p1.add(b1);
		ActionListener al=new ActionListenerhandler();
		b1.addActionListener(al);
	}
	class ActionListenerhandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			control++;
			if(control%2==1)
			{
			((JButton)e.getSource()).setText("ȡ��");
			}
			else
			{((JButton)e.getSource()).setText("ȷ��");}
		}
		
	}
	public static void main(String[] args)
	{
		action1 a1=new action1();
		a1.mywin();
	}
}
