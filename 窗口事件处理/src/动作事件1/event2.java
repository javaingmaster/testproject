package 动作事件1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class event2 
{
	public void test()
	{
		JFrame jf=new JFrame("测试");		
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		WindowListener wh=new windowhandler();		
		jf.addWindowListener(wh);
		jf.setSize(300,400);
		jf.setVisible(true);
	}

    class windowhandler extends WindowAdapter 
	{
		public void windowClosed(WindowEvent e)
		{
			JButton b1=new JButton("确定");
			JButton b2=new JButton("取消");
			JLabel l1=new JLabel("确定要关闭？");
			JDialog d=new JDialog((JFrame)e.getSource(),"系统出错了！",true);
			d.setSize(200,100);
			d.setLocation(100,100);
			JPanel p=new JPanel();
			p.setLayout(new GridLayout());
			d.add(p,BorderLayout.SOUTH);
			d.add(l1,BorderLayout.CENTER);
			p.add(b1);
			p.add(b2);
			d.setVisible(true);
			b1.setVisible(true);
			b2.setVisible(true);
			l1.setVisible(true);	
	
		}	
		
	}
    public static void main(String[] args)
    {
    	event2 me=new event2();	
    	me.test();
    }
}
