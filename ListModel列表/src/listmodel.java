import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;


public class listmodel 
{
	public void test()
	{
		JFrame jf=new JFrame();
    	jf.setTitle("测试");
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.setSize(300, 300);
    	JPanel p1=new JPanel();
    	jf.setContentPane(p1);
    	ListModel model=new DataModel();
    	JList l1=new JList(model);
    	l1.setFixedCellHeight(30);
    	l1.setFixedCellWidth(200);
    	l1.setVisibleRowCount(5);//设置一次性可见的项数
    	l1.setBorder(BorderFactory.createTitledBorder("配置一台电脑需要的组件。"));
    	p1.add(new JScrollPane(l1));  
    	jf.setVisible(true);
    	
	}
	public static void main(String[] args)
	{
		new listmodel().test();
	}
	
	class DataModel extends AbstractListModel
	{
		String[] s={"主板","显示器","内存","CPU","硬盘","电源","键盘","鼠标"};
		public Object getElementAt(int index)
		{
			return((index+1)+"."+s[index++]);
		}
		public int getSize()
		{
			return(s.length);
		}
	}

}
