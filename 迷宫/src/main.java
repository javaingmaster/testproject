import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class main {
	
	static int j=0;
	static int i=0;
	int sx=10;
	int sy=10;
	int rw=500;
	int w=15;
	static int mx=30;
	static int my=30;
	static boolean chab=true;
	static zuobiao s=new zuobiao();
	int num=0;
	static int jinkou;
	String st1;
	String st2;
	static int sre1;
	static int sre2;
	static int huajinkou;
	static int huachukou;
	static find_road fd;
	static boolean decid=true;
	static boolean findOK=false;
	public static void main(String[] args) 
	{
		
		getweishu a=new getweishu();
		creatlist b=new creatlist();
		newcreat d=new newcreat();
		//s=a.imput();
		mx=s.x;//mx是获得的行数,也是y坐标的最大值mx*w+sx
		my=s.y;//my是获得的列数,也是x坐标的最大值my*w+sx
		
		//jinkou=d.ncreat(s);
		//System.out.println("行为"+mx+" "+"列为"+my+"\n"+"起点为"+newcreat.jinkou+"  "+"终点为"+newcreat.chukou+"\n");
		find_road fr=new find_road();
		
		//fr.find_road(mx, my, newcreat.jinkou, newcreat.chukou);
		//上面是迷宫计算代码
		
		
		
		JPanel row1 = new JPanel();  
		final JFrame ac=new JFrame();
		Button bc=new Button("提示路径");
		Button bc2=new Button("重新设置");
		Button bc3=new Button("回到起点");
		row1. setLayout(new GridLayout());
		row1.setSize(2000,2000);
		bc.setSize(100,25);
		row1.add(bc);
		row1.add(bc2);
		row1.add(bc3);
		final Label s1=new Label("x:",Label.CENTER);
		final Label s2=new Label("y:",Label.CENTER);
		  s1.setFont(new Font("",1,30));
		  s2.setFont(new Font("",1,30));
		
		  
		  ac.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		final TextField b1=new TextField();
		final TextField b2=new TextField();
		b1.setText(""+mx);
		b2.setText(""+my);
		 b1.setFont(new Font("",1,30));
		  b2.setFont(new Font("",1,30));
		b1.setSize(100, 80);
		b2.setSize(100, 80);
		row1.add(s1);
		row1.add(b1);
		row1.add(s2);
		row1.add(b2);

		final Dialog di=new Dialog(ac,"错误信息",true);
		di.setSize(500, 300);
		di.setLocation(500,300);
		Label la=new Label("error！，这里的x与y是不允许为0的",Label.CENTER);
		 la.setFont(new Font("",1,20));
		la.setText("error！，这里的x与y是不允许为0的");
		di.add(la);
		Button bs=new Button("确定");
		bs.setFont(new Font("",1,20));
		bs.setSize(100,80);
		di.add(bs);
		di.setLayout(new GridLayout(2,1));
		
		bs.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				di.setVisible(false);
			}
		});	
		
		
		
		final Label sd=new Label("此处显示坐标");
		row1.add(sd);
		//限制只能输入数字  
        b1.addKeyListener(new KeyAdapter()
        {  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        });  
        
        //限制只能输入数字  
        	b2.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        });  
		
        	
        	
        	
		ac.add(BorderLayout.NORTH,row1);
		//ac.add(BorderLayout.SOUTH,bc);
		ac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ac.setSize(2000,2000);
		ac.setTitle("迷宫");
		final sbw cc=new sbw();
		
			

		
		ac.add(BorderLayout.CENTER,cc);
		
		cc.addKeyListener(new KeyListener()
		{
			
			public void keyTyped(KeyEvent e) {
		        // TODO Auto-generated method stub

		    }

		    @Override
		    public void keyPressed(KeyEvent e) {
		        if ( e.getKeyCode()==KeyEvent.VK_DOWN )
		        {
		        	int sx=10;
		        	int sy=10;
		        	int rw=500;
		        	int w=15;
		        	pengzhuangText tex=new pengzhuangText();
		        	boolean dec=tex.text(1, sx+2+i, sy+w*jinkou+2+j,mx,my);
		        	if(dec==true)
		            {
		        		j = j+15;
		        		cc.hel(i,j);
		            }
		        	else
		        	{}
		        }
		        else if (e.getKeyCode()==KeyEvent.VK_UP)
		        {
		        	int sx=10;
		        	int sy=10;
		        	int rw=500;
		        	int w=15;
		        	pengzhuangText tex=new pengzhuangText();
		        	boolean dec=tex.text(0, sx+2+i, sy+w*jinkou+2+j,mx,my);
		        	if(dec==true)
		            {
		        		j = j-15;
		        		cc.hel(i,j);
		            }
		        	else
		        	{}  
		        } 
		        else if (e.getKeyCode()==KeyEvent.VK_RIGHT)
		        {
		        	int sx=10;
		        	int sy=10;
		        	int rw=500;
		        	int w=15;
		        	pengzhuangText tex=new pengzhuangText();
		        	boolean dec=tex.text(3, sx+2+i, sy+w*jinkou+2+j,mx,my);
		        	if(dec==true)
		            {
		        		i = i+15;
		        		cc.hel(i,j);
		            }
		        	else
		        	{}
		        } 
		        else if (e.getKeyCode()==KeyEvent.VK_LEFT)
		        {
		        	int sx=10;
		        	int sy=10;
		        	int rw=500;
		        	int w=15;
		        	pengzhuangText tex=new pengzhuangText();
		        	boolean dec=tex.text(2, sx+2+i, sy+w*jinkou+2+j,mx,my);
		        	if(dec==true)
		            {
		        		i=i-15;
		        		cc.hel(i,j);
		            }
		        	else
		        	{}
		        } 
		        else
		        { }
		        pengzhuangText sw=new pengzhuangText(); 
		        sd.setText(sw.str);
		        cc.repaint();

		    }

		    @Override
		    public void keyReleased(KeyEvent e) {

		    }
		});//为panel添加监听器
		
	
		
		
		bc2.addActionListener(new ActionListener()//重新生成接口
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Date date=new Date();
				  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  String time=format.format(date);
				  
				 System.out.println("当前时间为："+time); 
				  
				  
				String st1=b1.getText();
				String st2=b2.getText();
			
				findOK=false;
				final int sre1=Integer.parseInt(st1);
				final int sre2=Integer.parseInt(st2);//把用户输入的值当做新的x与y维度
			
				if(sre1==0||sre2==0)
				{
					di.setVisible(true);
				}
				
				zuobiao hs=new zuobiao();//重新创建坐标对象
				newcreat ncr=new newcreat();//重新创建newcreat对象
				sbw npa=new sbw();//重新创建jpanel对象
				final find_road fd=new find_road();//重新创建findroad对象
				
				ncr.liward.clear();//清空liward数组
				ncr.zhangai.clear();//清空zhangai数组
				npa.dl.clear();//清空dl数组
				npa.i=0;
				npa.j=0;
				npa.tips=false;
				fd.list.clear();//清空list数组
				mx=sre1;
				my=sre2;
				i=0;
				j=0;
				
				
			
				decid=false;
				
				hs.x=sre1;//把用户输入的值当做新的x与y维度
				hs.y=sre2;//把用户输入的值当做新的x与y维度
				
				jinkou=ncr.ncreat(hs);//并把新的维度传给newcreat
				huajinkou=ncr.jinkou;
				huachukou=ncr.chukou;
				
				
				
				Date date1=new Date();
				  DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  String time1=format1.format(date1);
				  
				 System.out.println("当前时间为："+time1); 
				 
				cc.get(hs.x,hs.y,jinkou);
				
				
				cc.repaint();//重绘
				cc.requestFocus();
				ac.setState(0);
				
				new Thread(new Runnable(){
					public void run(){
						cc.repaint();//重绘
						cc.requestFocus();
						ac.setState(0);
						findOK=false;
					}
					}).start();

					new Thread(new Runnable(){
					public void run()
					{
						decid=true;
						fd.find_road(sre1,sre2,newcreat.jinkou,newcreat.chukou);//调用findroad方法
						findOK=true;
						
					}
					}).start();
					
			
					
				//fd.find_road(sre1,sre2,newcreat.jinkou,newcreat.chukou);//调用findroad方法
				Date date2=new Date();
				DateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time2=format2.format(date2);
				System.out.println("当前时间为："+time2); 
				
			}	
		});	
		

		
		bc3.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				cc.hel(0,0);
				i=0;
				j=0;
				String st1=b1.getText();
				String st2=b2.getText();
			
				
				int sre1=Integer.parseInt(st1);
				int sre2=Integer.parseInt(st2);//把用户输入的值当做新的x与y维度
			
				if(sre1==0||sre2==0)
				{
					di.setVisible(true);
				}
				cc.repaint();
				cc.requestFocus();
				
			}
		});	
		
		
		
		
		
		cc.get(s.x, s.y,jinkou);
		cc.setBackground(Color.red);
		ac.requestFocus();
		ac.setVisible(true);
		cc.requestFocus();
		System.out.println("\n需要覆盖的线有"+sbw.dl.size());

		
		bc.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				

				String st1=b1.getText();
				String st2=b2.getText();
			
				
				int sre1=Integer.parseInt(st1);
				int sre2=Integer.parseInt(st2);//把用户输入的值当做新的x与y维度
				
				if(sre1==0||sre2==0)
				{
					di.setVisible(true);
				}
				
				find_road xvc=new find_road();
				
				if(decid==false)
				{
					xvc.find_road(sre1,sre2,huajinkou,huachukou);//调用findroad方法
					decid=true;
				}
				
				if(findOK==false)
				{
					cc.changG();
				}
				// TODO Auto-generated method stub
				if(chab==true)
				{
					cc.changT();
					chab=false;
				}
				else if(chab==false)
				{
					cc.changF();
					chab=true;
				}

				
				cc.requestFocus();
			}
		});	
	}
		
	
	
	
}
class sbw extends JPanel //同时让sbw作为监听器接口
{
	int sx=10;
	int sy=10;
	int rw=500;
	int w=15;
	static int x;
	static int y;
	static int z;
	static boolean tips=false;
	int dir;
	//用于让人物行走的坐标
	static int i=0;
	static int j=0;
	static boolean findm=false;;
	
	static ArrayList<deadline> dl=new <deadline> ArrayList();//用于记录需要删除的线
	
	 

	
	void get(int c,int d,int  jinkou)
	{
		x=c;
		y=d;
		z=jinkou;
	}
	void getzuobiao(int ws,int h,int b)
	{
		dir=b;
		deadline s=new deadline();
		if(dir==0)//上半部分
		{
			s.y=ws;
			s.x=h;
			s.x_n=s.x+w;
			s.y_n=s.y;
		}
		else if(dir==1)//下半部分
		{
			s.y=ws+w;
			s.x=h;
			s.x_n=s.x+w;
			s.y_n=s.y;
		}
		else if(dir==2)//左半部分
		{
			s.y=ws;
			s.x=h;
			s.x_n=s.x;
			s.y_n=s.y+w;
		}
		else if(dir==3)//右半部分
		{
			s.y=ws;
			s.x=h+w;
			s.x_n=s.x;
			s.y_n=s.y+w;
		}
		dl.add(s);//把需要清除的线加入组内
		
	}
	
	void hel(int v,int cv)
	{
		i=v;
		j=cv;
		repaint();
	}
	
	void changG()
	{
		findm=true;
		repaint();
	}
	
	void changT()
	{
		tips=true;
		repaint();
	}
	
	void changF()
	{
		tips=false;
		repaint();
	}
	
	public void paintComponent (Graphics g)
	{ 
		super.paintComponent(g);
		this.setBackground(Color.white);
		g.setColor(Color.black);
		 for(int i = 0; i <=y; i ++) //绘制竖线
		  g.drawLine(sx + (i * w), sy, sx + (i * w), sy+x*w);
		 for(int i = 0; i <=x; i ++) //绘制横线
           g.drawLine(sx, sy + (i * w), sx+y*w, sy + (i * w));
		
		 for(int nu=0;nu<dl.size();nu++)
		 {
			 g.setColor(Color.white);
			 g.drawLine(dl.get(nu).x,dl.get(nu).y, dl.get(nu).x_n,dl.get(nu).y_n);
		 }
		 find_road frd=new find_road();
		 
		 g.setColor(Color.black);
		 g.drawLine(sx , sy, sx, sy+x*w);
		 g.drawLine(sx+y*w , sy, sx + y*w, sy+x*w);
		 g.drawLine(sx , sy, sx + y*w, sy);
		 g.drawLine(sx , sy+x*w, sx + y*w, sy+x*w);
		 g.setColor(Color.white);
		 g.drawLine(dl.get(0).x,dl.get(0).y, dl.get(0).x_n,dl.get(0).y_n);
		 g.drawLine(dl.get(1).x,dl.get(1).y, dl.get(1).x_n,dl.get(1).y_n);
		
		 if(tips==true)
		 {
			 for(int i=0;i<find_road.list.size();i++)
			 {
				 if(findm==true)
				 {
					 g.setColor(Color.yellow);
					 findm=false;
				 }
				 else if(findm==false)
				 {
					 g.setColor(Color.green);
				 }
				// g.drawLine(frd.list.get(i).y*w+sx+3,frd.list.get(i).x*w+sx+3,frd.list.get(i).y*w+sx+9,frd.list.get(i).x*w+sx+3);
				 g.fillOval(find_road.list.get(i).y*w+sx+3,find_road.list.get(i).x*w+sx+3,8,8);
			 }
		 }
		 g.setColor(Color.red);
		 g.fillRect(sx+2+i, sy+w*z+2+j, 10, 10);

	}	
 }
		


