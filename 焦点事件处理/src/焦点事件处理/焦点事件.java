package �����¼�����;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class �����¼�  
{
	List into=new List(10);
	JTextField jt=new JTextField("");
    JButton b1=new JButton("ȷ��");
    public void mywin()
    {
    	JFrame jf=new JFrame();
    	jf.setTitle("����");
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.setSize(300, 200);  
    	jf.setVisible(true);
    	JPanel p1=new JPanel();
    	p1.setLayout(new BorderLayout());
    	jf.setContentPane(p1);
    	p1.add(into,"north");
    	p1.add(jt,"center");
    	p1.add(b1,"south");
    	FocusListener f=new Focushandler();
    	jt.addFocusListener(f); 	
    }
    class Focushandler implements FocusListener
    {
    public void focusGained(FocusEvent e)
    {
    	if(e.isTemporary())
    	{
    		into.add("��ʱ���");
    	}
    	else into.add("���û��");
    }
    public void focusLost(FocusEvent e)
    {
    	if(e.isTemporary())
    	{ into.add("��ʱʧȥ");}
    	else into.add("����ʧȥ");
    }
    }
    public static void main(String[] args)
    {
    	�����¼� m=new �����¼�();
    	m.mywin();   	
    }
}
