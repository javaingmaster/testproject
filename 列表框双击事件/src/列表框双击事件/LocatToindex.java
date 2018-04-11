package 列表框双击事件;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LocatToindex extends MouseAdapter
{
	JList list1=null;
	JList list2=null;
    DefaultListModel model1=null;
    DefaultListModel model2=null;
    String[] s={ "1111","2222","3333","4444","5555"};
    public void test()
    {
    	JFrame jf=new JFrame();
    	jf.setTitle("测试");
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.setSize(300, 200);  
    	JPanel p1=new JPanel();
    	p1.setLayout(new GridLayout(1,2));
    	jf.setContentPane(p1);
    	model1=new Datamodel();
    	list1=new JList(model1);
    	list1.setBorder(BorderFactory.createTitledBorder("图书种类"));
    	list1.addMouseListener(this);
    	model2=new Datamodel();
    	list2=new JList(model2);
    	list2.setBorder(BorderFactory.createTitledBorder("要添加的书"));
    	list2.addMouseListener(this);
    	p1.add(new JScrollPane(list1));
    	p1.add(new JScrollPane(list2));
    	jf.pack();
    	jf.setVisible(true);   	
    }
    public static void main(String[] args)
    {
    	new LocatToindex().test();
    }
    class Datamodel extends DefaultListModel
    {
    	void input(int flag)
    	{
    		if(flag==1)
    		{
    			for(int i=0;i<s.length;i++)
    			{
    				addElement(s[i]);
    			}
    		}
    	}
    }
    public void mouseClicked(MouseEvent e)
    {
    	int index;
    	if(e.getSource()==list1)
    	{
    		if(e.getClickCount()==2)
    		{
    			index=list1.locationToIndex(e.getPoint());
    			String tmp=(String)model1.getElementAt(index);
    			model2.addElement(tmp);
    			list2.setModel(model2);//?
    			model1.removeElementAt(index);
    			list1.setModel(model1);//?
    		}
    	}
    	if(e.getSource()==list2)
    	{
    		if(e.getClickCount()==2)
    		{
    			index=list2.locationToIndex(e.getPoint());
    			String tmp=(String)model2.getElementAt(index);
    			model1.addElement(tmp);
    			list1.setModel(model1);//?
    			model2.removeElementAt(index);
    			list2.setModel(model2);//?
    		}
    		
    	}
    }
}
