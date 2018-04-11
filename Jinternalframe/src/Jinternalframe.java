import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Jinternalframe 
{
	public static void main(String[] args)
	{
		JFrame jf=new JFrame();
		jf.setSize(300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1=new JPanel();
		jf.setContentPane(p1);
		jf.setLayout(new FlowLayout());
		JDesktopPane dp=new JDesktopPane();
		p1.add(dp);
		dp.setLayout(new FlowLayout());
		JInternalFrame jif1=new JInternalFrame("第一个窗口",true,true,true,true);
		dp.add(jif1);
		JInternalFrame jif2=new JInternalFrame("第二个窗口",true,true,true,true);
		dp.add(jif2);
		JLabel l1=new JLabel("这是第一个窗口");
		JLabel l2=new JLabel("这是第二个窗口");
		jif1.setLayout(new FlowLayout());
		jif2.setLayout(new FlowLayout());
		jif1.setSize(new Dimension(200,200));
		jif1.add(l1);
		jif2.add(l2);
		jf.setVisible(true);
		jif1.setVisible(true);
		jif2.setVisible(true);
		
	}

}
