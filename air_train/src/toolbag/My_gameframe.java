package toolbag;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class My_gameframe extends Frame ////生成窗口和线程
{
	//public Leftpanel pleft;
	//public Rightpanel pright;
	public static final int Gamewidth=500;
	public static final int Gameheight=750;;
	public void launchframe()
	{
		setSize(Gamewidth, Gameheight);
		setLocation(400,0);
		//setLayout(new BorderLayout());
		//add(pleft,"LEFT");
		//add(pright,BorderLayout.CENTER);
		//add(pleft,BorderLayout.CENTER);
		//setResizable(false);
		setVisible(true);
		
		new PaintThread().start();//启动动画线程
		addWindowListener(new WindowAdapter()
		{

			public void windowClosing(WindowEvent arg0) {
			System.exit(0);
			}
			
		});
	}
	/*public class Leftpanel extends JPanel{
	
	public Leftpanel(){
	try {
		img=ImageIO.read(this.getClass().getResourceAsStream("/cn/pis/warrior.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	j11=new JLabel();
	ic=new ImageIcon(img);
	j11.setIcon(ic);
	j0=new JLabel("名字:"+player.name);
	j10=new JLabel("等级:"+player.rank);
	j1=new JLabel("生命:"+player.life);
	j2=new JLabel("攻击:"+player.atk);
	j3=new JLabel("防御:"+player.def);
	j4=new JLabel("黄钥匙:"+player.yk);
	j5=new JLabel("蓝钥匙:"+player.bk);
	j6=new JLabel("红钥匙:"+player.rk);
	j7=new JLabel("金钱:"+player.money);
	j8=new JLabel("经验:"+player.exp);
	j9=new JLabel("层数:"+player.piles);	
	j0.setFont(new Font("", 20, 30));
	j10.setFont(new Font("", 20, 30));
	j1.setFont(new Font("", 20, 30));
	j2.setFont(new Font("", 20, 30));
	j3.setFont(new Font("", 20, 30));
	j4.setFont(new Font("", 20, 30));
	j5.setFont(new Font("", 20, 30));
	j6.setFont(new Font("", 20, 30));
	j7.setFont(new Font("", 20, 30));
	j8.setFont(new Font("", 20, 30));
	j9.setFont(new Font("", 20, 30));
	j0.setForeground(Color.GREEN);
	j10.setForeground(Color.GREEN);
	j1.setForeground(Color.GREEN);
	j2.setForeground(Color.GREEN);
	j3.setForeground(Color.GREEN);		
	j4.setForeground(Color.GREEN);
	j5.setForeground(Color.GREEN);
	j6.setForeground(Color.GREEN);
	j7.setForeground(Color.GREEN);
	j8.setForeground(Color.GREEN);
	j9.setForeground(Color.GREEN);
	this.add(j11);
	this.add(j11);
	this.add(j0);
	this.add(j10);
	this.add(j1);
	this.add(j2);
	this.add(j3);
	this.add(j4);
	this.add(j5);
	this.add(j6);
	this.add(j7);
	this.add(j8);
	this.add(j9);
	this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
}

public class Rightpanel extends JPanel{
	

	public Rightpanel(){
		
	}
			
	public void paint (Graphics g){
		mp.draw(g);
		player.draw(g);
	}
	

	
		
}*/
	public class PaintThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
