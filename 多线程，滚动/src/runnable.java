import java.awt.Container;
import java.io.File;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class runnable extends JFrame 
{
	private JLabel l1=new JLabel();                          //������ǩ
	private static Thread t;                                //�����߳�
	private int count=0;
	private Container containner=getContentPane();          //��������
	public void SwingandThread()
	{
		setBounds(300,200,250,100);
		containner.setLayout(null);
		URL url=runnable.class.getResource("D:\timg.gif");
		Icon icon=new ImageIcon(url);
		l1.setIcon(icon);                                   //ͼ����ڱ�ǩ�У����ҷ�������ˣ�׼�����ҹ���
		l1.setHorizontalAlignment(SwingConstants.LEFT);
		l1.setBounds(10, 10, 200, 50);
		l1.setOpaque(true);
		t=new Thread(new Runnable(){
			public void run()                                //ͼ���ڱ�ǩ�й���
			{
				while(count<=200)
				{
					l1.setBounds(count, 10, 200, 50);
					try
					{
						t.sleep(1000);
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					count+=4;
					if(count==200)
					{
						count=10;
					}
				}
			}
		});
		t.start();
		containner.add(l1);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   //���ӻ�
	}
	public static void main(String[] args)
	{
		new runnable().SwingandThread();;
	}
}
