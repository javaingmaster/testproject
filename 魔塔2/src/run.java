import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import oracle.jrockit.jfr.JFR;

import com.sun.imageio.plugins.common.ImageUtil;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;


public class run 
{
	player play=new player();//创建玩家
	maplist maps=new maplist();//创建地图列对象,这个对象存储了所有的地图
	map map1=new map();//用来存储单个地图
	int a=0;
	public static void main(String[] args) 
	{
//		MusicDemo mu=new MusicDemo();
//		mu.a();
		maplist m=new maplist();
		m.zouni();
		run ru=new run();
		startWin sw=ru.new startWin();
		sw.startwin();
//		Shop s=new Shop(a);
	}

	
	class startWin//用来显示开始界面
	{
		JFrame sw;
		ImageIcon img;
		Image b;
		void startwin()
		{
			sw=new JFrame();
			sw.setSize(1200,800);
			sw.setVisible(true);
			sw.setTitle("勇者斗恶龙");
			int windowWidth = sw.getWidth(); //获得窗口宽
			int windowHeight = sw.getHeight(); //获得窗口高
			Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
			Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
			int screenWidth = screenSize.width; //获取屏幕的宽
			int screenHeight = screenSize.height; //获取屏幕的高
			sw.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示	
			jpane lp=new jpane();
			final jpanf rp=new jpanf();
			sw.add(lp,BorderLayout.WEST);
			
			
			
			
			//设置lp显示左边状态,采取boxlayout的竖直方向放控件
			//lp.setBackground(Color.darkGray);
			lp.setLayout(new BoxLayout(lp,BoxLayout.Y_AXIS));
			 
			//Label l1=new Label("状态       "); 
			final Label l2=new Label("等级       "+play.level); 
			final Label l3=new Label("血量       "+play.life); 
			final Label l4=new Label("攻击力   "+play.attack); 
			final Label l5=new Label("防御力   "+play.Def); 
			final Label l6=new Label("经验值   "+play.expe); 
			final Label l7=new Label("钥匙       "+play.key); 
			final Label l8=new Label("金钱       "+play.money); 
			//JLabel jp1 = new JLabel();    //创建一个带图片的 JLabel
			try {
				Image a=ImageIO.read(new File("touxiang.jpg"));
				b=a.getScaledInstance(100,100, Image.SCALE_DEFAULT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ImageIcon ic;
			ic=new ImageIcon();
			ic.setImage(b);
			JLabel jp1 = new JLabel("用户:"+play.name);
			jp1.setIcon(ic);
			jp1.setVerticalAlignment(JLabel.BOTTOM);
			
			jp1.setFont(new Font("",1,30));
			jp1.setForeground(Color.green);
			jpane tidai=new jpane();
			tidai.setBackground(Color.darkGray);
			FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
			//fl.setVgap(20);
			tidai.setLayout(fl);
			tidai.add(jp1);    //放置这个 JLabel 到你的 JPanel 上面
			lp.add(tidai);
			//lp.add(l1);
			lp.add(l2);
			lp.add(l3);
			lp.add(l4);
			lp.add(l5);
			lp.add(l6);
			lp.add(l7);
			lp.add(l8);
			lp.setFont(new Font("", 1, 30));		
			//l1.setForeground(Color.GREEN);
			l2.setForeground(Color.GREEN);
			l3.setForeground(Color.GREEN);
			l4.setForeground(Color.GREEN);
			l5.setForeground(Color.GREEN);
			l6.setForeground(Color.GREEN);
			l7.setForeground(Color.GREEN);
			l8.setForeground(Color.GREEN);
			
		
			
			
			
			
			
			//设置rp显示右边地图
			map1=maps.list.get(0);//初始地图为第一张
			play.x=map1.x;
			play.y=map1.y;	
			rp.repa(play.x,play.y, map1);
			rp.setBackground(Color.white);			
			sw.add(rp,BorderLayout.CENTER);
			rp.requestFocus();		
			rp.addKeyListener(new KeyListener()
			{
				oper a;
				isueb is=new isueb();
				public void keyTyped(KeyEvent e) {}
			    public void keyPressed(KeyEvent e) 
			    {
			    	String s="";
			        if ( e.getKeyCode()==KeyEvent.VK_DOWN )
			        {
			        	a=new oper();
			        	is=a.move(play, map1, 2,s);
			        }
			        else if (e.getKeyCode()==KeyEvent.VK_UP)
			        {
			        	a=new oper();
			        	is=a.move(play, map1, 8,s);
			        } 
			        else if (e.getKeyCode()==KeyEvent.VK_RIGHT)
			        {
			        	a=new oper();
			        	is=a.move(play, map1, 6,s);
			        } 
			        else if (e.getKeyCode()==KeyEvent.VK_LEFT)
			        {
			        	a=new oper();
			        	is=a.move(play, map1, 4,s);	        	
			        } 	
			    	rp.requestFocus();   	
			    	//System.out.println("入口楼梯的across为"+map1.ma[12][6].across);
			    	
			    	if(is.dei==true&&is.isCh==1)//如果到上面一层，就调用重绘
		        	{ 
			    		map1=maps.list.get(is.layer);
			    		play.x=map1.l_x;
						play.y=map1.l_y;	
			    		rp.repa(play.x,play.y,map1);  
			    	}
			    	else if(is.dei==true&&is.isCh==2)//如果到下面一层
			    	{
			    		map1=maps.list.get(is.layer);
			    		play.x=map1.x;
						play.y=map1.y;
			    		rp.repa(play.x,play.y,map1);  
			    		//System.out.println("入口楼梯的across为"+map1.ma[12][6].across);
			    	}

			    	else if(is.dei==true&&is.isCh==0)
			    	{
			    		rp.repa(play.x,play.y,map1);  
			    	}
			    	if(is.isbat==true)//用来设置战斗画面
			    	{			    		
//			    		jfa jf=new jfa();
//			    		jf.w();
//			    		jf.setFocusable(true);
//			    		batj ba=new batj();
//			    		jf.add(ba);
//			    		ba.setSize(600, 600);
//			    		ba.setLocation(0, 0);
//			    		System.out.println(s);
//			    		JLabel j1=new JLabel("血量");
//			    		ba.add(j1);
//			    		ba.setLayout(null);
//			    		j1.setLocation(100,220 );
//			    		j1.setSize(100, 120);
//			    		j1.setForeground(Color.red);
//			    		j1.setFont(new Font("",1,30));
//			    		JLabel j2=new JLabel("血量");
//			    		j2.setForeground(Color.red);
//			    		j2.setLocation(400,220 );
//			    		ba.add(j2);
//			    		j2.setLocation(400,220 );
//			    		j2.setSize(100, 120);
//			    		j2.setFont(new Font("",1,30));
//			    		jl.setFont(new Font("",1,50));
//			    		ba.add(jl);
//			    		jl.setLocation(150, 60);
			    	}
			    	
			    	if(play.alive==false)
			    	{
			    		JFrame jfe=new JFrame();
			    		jfe.setSize(200, 200);
			    		JLabel j1=new JLabel("你已经死亡!!");
			    		j1.setFont(new Font("",1,30));
			    		jfe.setLocation(850, 400);
			    		jfe.add(j1,BorderLayout.CENTER);
			    		jfe.setVisible(true);
			    		JButton b1=new JButton("确定");
			    		b1.setFont(new Font("",1,30));
			    		jfe.add(b1,BorderLayout.SOUTH);
			    		b1.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								System.exit(0);
								
							}
						});
			    		
			    	}
			    	new Thread(new Runnable(){
						public void run(){
							l2.setText("等级       "+play.level);
					    	l3.setText("血量       "+play.life);
					    	l4.setText("攻击力   "+play.attack);
					    	l5.setText("防御力   "+play.Def);
					    	l6.setText("经验值   "+play.expe);
					    	l7.setText("钥匙       "+play.key);
					    	l8.setText("金钱       "+play.money);
						}
						}).start();
//			    	l2.setText("等级       "+play.level);
//			    	l3.setText("血量       "+play.life);
//			    	l4.setText("攻击力   "+play.attack);
//			    	l5.setText("防御力   "+play.Def);
//			    	l6.setText("经验值   "+play.expe);
//			    	l7.setText("钥匙       "+play.key);
//			    	l8.setText("金钱       "+play.money);
			    }
			    public void keyReleased(KeyEvent e)
			    { }
			    
			});//为panel添加监听器
			
		}
		
	}

}

class jpanf extends JPanel //这个是用来为右边整个地图画图的
{
	Image img;
	Image img1;
	Image img2;
	Image img3;
	Image img4;
	Image img5;
	Image img6;
	Image img7;
	map m1=new map();
	int x=8;
	int y=14;

	 void repa(int xs,int ys,map maps)
	{
		x=ys;
		y=xs;
		m1=maps;
		repaint();
	}
	 
	void res()
	{
		repaint();
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(Color.black);
		try 
		{
			img = ImageIO.read(new File("wall.png"));
			img1=ImageIO.read(new  File("ground1.png"));
			img2=ImageIO.read(new  File("back.jpeg"));
			img3=ImageIO.read(new  File("player.png"));
			img4=ImageIO.read(new  File("npc1.png"));
			
			img5=ImageIO.read(new  File("floor.png"));
			img6=ImageIO.read(new  File("door.png"));
			img7=ImageIO.read(new  File("ground1.png"));
		} 
		catch (IOException e) 
		{
			System.out.print("error!\n");
			
			
		}
		g.drawImage(img2, 0, 0, getSize().width,getSize().height, this);// 图片会自动缩放
		
		for(int i=0;i<18;i++)
			for(int j=0;j<15;j++)
			{
				if(m1.ma[i][j].across==1)//如果是墙的话
				{
					g.drawImage(img, i*50, j*50, 50,50, this);
				}
				else if(m1.ma[i][j].across!=1)//如果是陆地的话
				{
					g.drawImage(img1, i*50, j*50, 50,50, this);
				}
				
				
				if(m1.ma[i][j].across==2)//如果是门的话
				{
					g.drawImage(img1, i*50, j*50, 50,50, this);
					g.drawImage(img6, i*50, j*50, 50,50, this);
				}
				else if(m1.ma[i][j].across==3)//如果是下一层的话
				{
					g.drawImage(img5, i*50, j*50, 50,50, this);
				}
				else if(m1.ma[i][j].across==-1)//如果是上一层的话
				{
					g.drawImage(img5, i*50, j*50, 50,50, this);
				}
				
				if(m1.ma[i][j].ismon==true)
				{
					String s=m1.ma[i][j].mon.tietu+".png";
					try {
						img4=ImageIO.read(new  File(s));
						g.drawImage(img4,i*50,j*50, 50,50, this);
					} catch (IOException e) {
					}
				}
				if(m1.ma[i][j].isTh==true)
				{
					String s="t"+m1.ma[i][j].obj.tietu+".png";
					System.out.println(s);
					try {
						img4=ImageIO.read(new  File(s));
						g.drawImage(img4,i*50,j*50, 50,50, this);
					} catch (IOException e) {
						System.out.println("error");
					}
				}
			}
		g.drawImage(img3,x*50+5,y*50, 40,40, this);
		
	}
}
	
class jpane extends JPanel//这个是用来为右边整个地图画背景图的
{
	Image img;
	public void paintComponent(Graphics g)
	{
		 super.paintComponent(g);  
		try {
			img = ImageIO.read(new File("back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
		
	}
}

class jfa extends JFrame //这个是整个顶层容器的子类
{
	void w()
	{
		this.setSize(600, 600);
		this.setLocation(400, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

}

class batj extends JPanel//这个是战斗画面绘制
{
	
	public void paintComponent(Graphics g)
	{
		
		setLayout(null);
		Image im1 = null;
		Image im2=null;
		Image im3=null;
		Image Scim3=null;
		Image Scim1=null;
		Image Scim2=null;
		try 
		{
			im1=ImageIO.read(new File("renwu1.png"));
			im2=ImageIO.read(new File("renwu2.png"));
			im3=ImageIO.read(new File("beijing.jpg"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		Scim3=im3.getScaledInstance(600,600, Image.SCALE_DEFAULT);
		g.drawImage(Scim3, 0,0, 600,600, this);
		
		Scim1=im1.getScaledInstance(150,150, Image.SCALE_DEFAULT);
		g.drawImage(Scim1, 60,60, 150,150, this);
		Scim2=im2.getScaledInstance(150,150, Image.SCALE_DEFAULT);
		g.drawImage(Scim2,350 ,60, 150,150, this);
		g.setColor(Color.red);
		g.setFont(new Font("",1,70));		
		g.drawString("vs", 250, 140);
	}	
}






class  Shop
{
	player pla;
	public  Shop(player play)
	{
		pla=play;
		dialog dia=new dialog();
		Jpan jp=new Jpan();
		dia.setContentPane(jp);
		jp.setLayout(new GridBagLayout());
		final JLabel jt=new JLabel("这里显示了物品介绍                   ");
		Jpan1 p1=new Jpan1();
		p1.setBackground(Color.red);
		Grid ge=new Grid(0, 0,3,8,10,3);
		jp.add(p1,ge);
		
		Jpan2 p2=new Jpan2();
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.white);
		Grid ge1=new Grid(3, 0,2, 2);
		jp.add(p2,ge1);
		JLabel JL1=new JLabel("商店物品",JLabel.CENTER);
		JL1.setSize(100, 100);
		JL1.setFont(new Font("",1,30));
		JL1.setForeground(Color.blue);
		p2.add(JL1,BorderLayout.NORTH);
		String obj[]={"血瓶     10ex","大血瓶  30ex","长剑     50ex","布甲     50ex"};
		
		final JList js=new JList(obj);
		js.setFont(new Font("",0,15));
		p2.add(js,BorderLayout.CENTER);
		js.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				String s=(String)js.getSelectedValue();
				if(e.getValueIsAdjusting())
				{
					if(s.equals("血瓶     10ex"))
					{
						jt.setText("血瓶：可以增加你的100点血量");
					}
					else if(s.equals("大血瓶  30ex"))
					{
						jt.setText("大血瓶：可以增加你500点血量 ");
					}
					else if(s.equals("长剑     50ex"))
					{
						jt.setText("长剑：可以增加你的100点攻击");
					}
					else if(s.equals("布甲     50ex"))
					{
						jt.setText("布甲：可以增加你的100点防御");
					}
				}
			}
		});
		
		
		Jpan3 p3=new Jpan3();
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.blue);
		Grid ge2=new Grid(3, 3,2, 1);
		jp.add(p3,ge2);
		jt.setOpaque(true);
		p3.add(jt,BorderLayout.CENTER);
		
		JButton b1=new JButton("购买");
		p3.add(b1,BorderLayout.SOUTH);
		dia.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				String s=jt.getText();
				char c=s.charAt(0);
				if(c=='血')
				{
					if(pla.expe>=10)
					{
						pla.expe=pla.expe-10;
						pla.life=pla.life+100;
//						if(pla.life>pla.maxlife)
//						{
//							pla.life=pla.maxlife;
//						}
					}
					else
					{
						jt.setText("我很遗憾，你是个穷鬼");
					}
				}	
				else if(c=='大')
				{
					if(pla.expe>=30)
					{
						pla.expe=pla.expe-30;
						pla.life=pla.life+500;
//						if(pla.life>pla.maxlife)
//						{
//							pla.life=pla.maxlife;
//						}
					}
					else
					{
						jt.setText("我很遗憾，你是个穷鬼");
					}
				}
				else if(c=='长')
				{
					if(pla.expe>=50)
					{
						pla.expe=pla.expe-50;
						pla.attack=pla.attack+100;
					}
					else
					{
						jt.setText("我很遗憾，你是个穷鬼");
					}
				}
				else if(c=='布')
				{
					if(pla.expe>=50)
					{
						pla.expe=pla.expe-50;
						pla.Def=pla.Def+100;
					}
					else
					{
						jt.setText("我很遗憾，你是个穷鬼");
					}	
				}
			
				
			}
		});
	}
	
	
	
}


class dialog extends JFrame//这个窗口是对话窗口
{
	public dialog()
	{
	   //toFront();//置于顶层
		setAlwaysOnTop(true);    
		setTitle("神秘商人");
		setSize(600,500);
		setLocation(700, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}

class Grid extends GridBagConstraints
{
	public Grid(int x,int y,int width,int height)
	{
		gridx=x;
		gridy=y;
		gridwidth=width;
		gridheight=height;
		fill=BOTH;
		anchor=CENTER;
		weightx=3;
		weighty=3;
	}
	
	public Grid(int x,int y,int width,int height,int wx,int wy)
	{
		gridx=x;
		gridy=y;
		gridwidth=width;
		gridheight=height;
		fill=BOTH;
		anchor=CENTER;
		weightx=wx;
		weighty=wy;
	}
}

class Jpan extends JPanel//这个是对话窗口的中间容器
{}


class Jpan1 extends JPanel//这个是商人的左边人物图形
{
	public void paintComponent(Graphics g)
	{
		Image im1;
		try {
			im1 = ImageIO.read(new File("NPC.jpg"));
			im1=im1.getScaledInstance(300,500, Image.SCALE_DEFAULT);
			g.drawImage(im1, 0, 0,300, 500,this);
			g.setFont(new Font("",1,20));
			g.setColor(Color.blue);
			g.drawString("看看要点什么", 50, 50);
			g.drawString("老哥", 120, 100);
		} catch (IOException e) {
		}
		
	}
}

class Jpan2 extends JPanel//这个是商人的右上边的货物展示
{
	
}

class Jpan3 extends JPanel//这个是商人的右下边的是否购买界面
{
	
}



