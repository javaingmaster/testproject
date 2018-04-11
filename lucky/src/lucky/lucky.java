package lucky;
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lucky extends Applet implements ActionListener
{
	 	Panel  pNorth=new Panel();
	 	picpanel pCenter=new picpanel();
	 	Panel pBottom=new Panel();
	 	TextField txField=new TextField(10);
	 	Label label=new Label("输入对商品价格的估计：");
	 	private int nPrice=1000;
	public lucky()
	{
		super();
		this.setLayout(new BorderLayout());
		pNorth.add(label);
		pNorth.add(txField);
		add(pNorth,BorderLayout.NORTH);
		add(pCenter,BorderLayout.CENTER);
		Button btStart=new Button("开始游戏");
		Button btOk=new Button("确定");
		Button btCancel=new Button("取消");
		btStart.setActionCommand("start");//区别与不同组件产生的按钮标志
		btStart.addActionListener(this);
		btOk.setActionCommand("ok");//区别与不同组件产生的按钮标志
		btOk.addActionListener(this);
		btCancel.setActionCommand("cancel");//区别与不同组件产生的按钮标志
		btCancel.addActionListener(this);
		pBottom.add(btStart);
		pBottom.add(btOk);
		pBottom.add(btCancel);
		add(pBottom,BorderLayout.SOUTH);
		setBackground(Color.white);		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getActionCommand().equals("start"))
		{
			pCenter.initImg();
			label.setText("请输入你对该商品的价格估计：");
			pCenter.repaint();
		}
		else if(evt.getActionCommand().equals("ok"))
		{
			int guessprice=0;
			try{
				guessprice=Integer.parseInt(txField.getText().trim());//获取所猜的double值，除去多余空格
				String guess=comparePrice(guessprice);
				new price(guess);			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
			else if(evt.getActionCommand().equals("cancel"))
			{
				txField.setText(" ");
			}
					
		}
	
	public String comparePrice(int guessprice)
	{
		if(guessprice==nPrice)
		{ return"猜对了！！！";}
		else if(guessprice>nPrice)
		{ return"猜得过高。";}
		else if(guessprice<nPrice)
		{ return"猜得过低。";}
		else{ return"输入错误";}
	}
}

