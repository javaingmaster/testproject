import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class log_in extends JPanel
{
	private static final long serialVisionuid =1L;
	JFrame jf;
	public void add(Component c,GridBagConstraints ct,int x,int y,int w,int h)
	{
		ct.gridx=x;
		ct.gridy=y;
		ct.gridwidth=w;
		ct.gridheight=h;
		add(c,ct);
	}
	void test()
	{
		jf=new JFrame("example");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout lay=new GridBagLayout();
		setLayout(lay);
		jf.add(this,BorderLayout.WEST);
		jf.setSize(300, 150);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;
		int x=(width-300)/2;
		int y=(height-150)/2;
		jf.setLocation(x,y);
		JButton ok=new JButton("��½");
		JButton cancel=new JButton("ȡ��");
		JLabel l1=new JLabel("��½����");
		JLabel l2=new JLabel("�û���");
		JLabel l3=new JLabel("����");
		final JTextField nameinput=new JTextField(15);
		final JTextField passwordinput=new JTextField(15);
		GridBagConstraints ct=new GridBagConstraints();
		ct.fill=GridBagConstraints.NONE;
		ct.anchor=GridBagConstraints.EAST;
		ct.weightx=3;
		ct.weighty=4;
		add(l1,ct,0,0,2,1);
		add(l2,ct,0,1,1,1);
		add(l3,ct,0,2,1,1);
		add(nameinput,ct,2,1,1,1);
		add(passwordinput,ct,2,2,1,1);
		add(ok,ct,0,3,1,1);
		add(cancel,ct,2,3,1,1);
		jf.setResizable(false);
		jf.setVisible(true);
		ok.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent Event)
			{
				String name=nameinput.getText();
				String password=passwordinput.getText();
				String str=new String(password);
				boolean x=(name.equals("zhoutingyu"));
				boolean y=(str.equals("19970304"));
				boolean z=(x&&y);
				if(z==true)
				{
					jf.dispose();
				}
				else if(z==false)
				{
					nameinput.setText("");
					passwordinput.setText("");
				}
			}
		});
	}
	public static void main(String[] args)
	{
		log_in one=new log_in();
		one.test();
	}
}
