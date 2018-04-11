package 列表选取事件;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class listselection implements ListSelectionListener
{
	JList list1=null;
	JLabel label1=null;
    String[] name={"美国","中国","日本","俄罗斯","韩国"};
    public void test()
    {
    	JFrame jf=new JFrame();
    	jf.setTitle("测试");
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.setSize(300, 200);  
    	JPanel p1=new JPanel();
    	p1.setLayout(new BorderLayout());
    	jf.setContentPane(p1);
    	list1=new JList(name);
    	label1=new JLabel();
    	list1.setVisibleRowCount(5);
    	list1.setBorder(BorderFactory.createTitledBorder("你喜欢到那个国家玩？"));
    	list1.addListSelectionListener(this);
    	p1.add(label1,"North");
    	p1.add(new JScrollPane(list1),"Center");
    	jf.pack();
    	jf.setVisible(true);
    }
    public static void main(String[] args)
    {
    	new listselection().test();
    }
    public void valueChanged(ListSelectionEvent e)
    {
    	int a=0;
    	String s="您目前所选：";
    	int[] index=list1.getSelectedIndices();
    	for(int i=0;i<index.length;i++)
    	{
    		a=index[i];
    		s=s+name[a];
    	}
    	label1.setText(s);
    }
}
