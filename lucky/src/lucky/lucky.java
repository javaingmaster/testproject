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
	 	Label label=new Label("�������Ʒ�۸�Ĺ��ƣ�");
	 	private int nPrice=1000;
	public lucky()
	{
		super();
		this.setLayout(new BorderLayout());
		pNorth.add(label);
		pNorth.add(txField);
		add(pNorth,BorderLayout.NORTH);
		add(pCenter,BorderLayout.CENTER);
		Button btStart=new Button("��ʼ��Ϸ");
		Button btOk=new Button("ȷ��");
		Button btCancel=new Button("ȡ��");
		btStart.setActionCommand("start");//�����벻ͬ��������İ�ť��־
		btStart.addActionListener(this);
		btOk.setActionCommand("ok");//�����벻ͬ��������İ�ť��־
		btOk.addActionListener(this);
		btCancel.setActionCommand("cancel");//�����벻ͬ��������İ�ť��־
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
			label.setText("��������Ը���Ʒ�ļ۸���ƣ�");
			pCenter.repaint();
		}
		else if(evt.getActionCommand().equals("ok"))
		{
			int guessprice=0;
			try{
				guessprice=Integer.parseInt(txField.getText().trim());//��ȡ���µ�doubleֵ����ȥ����ո�
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
		{ return"�¶��ˣ�����";}
		else if(guessprice>nPrice)
		{ return"�µù��ߡ�";}
		else if(guessprice<nPrice)
		{ return"�µù��͡�";}
		else{ return"�������";}
	}
}

