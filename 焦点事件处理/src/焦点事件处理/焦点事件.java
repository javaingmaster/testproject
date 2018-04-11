package 焦点事件处理;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class 焦点事件  
{
	List into=new List(10);
	JTextField jt=new JTextField("");
    JButton b1=new JButton("确定");
    public void mywin()
    {
    	JFrame jf=new JFrame();
    	jf.setTitle("测试");
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
    		into.add("暂时获得");
    	}
    	else into.add("永久获得");
    }
    public void focusLost(FocusEvent e)
    {
    	if(e.isTemporary())
    	{ into.add("暂时失去");}
    	else into.add("永久失去");
    }
    }
    public static void main(String[] args)
    {
    	焦点事件 m=new 焦点事件();
    	m.mywin();   	
    }
}
