import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;


public class jlayeredpane extends JFrame implements ActionListener
{
	
	JLayeredPane lp=new JLayeredPane();
	static JButton b1=new JButton("确定");
	static JButton b2=new JButton("取消");
	public void test()
	{
		super.setContentPane(lp);		
	}
	public static void main(String[] args)
	{
		
	}

}
