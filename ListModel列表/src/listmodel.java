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
    	jf.setTitle("����");
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jf.setSize(300, 300);
    	JPanel p1=new JPanel();
    	jf.setContentPane(p1);
    	ListModel model=new DataModel();
    	JList l1=new JList(model);
    	l1.setFixedCellHeight(30);
    	l1.setFixedCellWidth(200);
    	l1.setVisibleRowCount(5);//����һ���Կɼ�������
    	l1.setBorder(BorderFactory.createTitledBorder("����һ̨������Ҫ�������"));
    	p1.add(new JScrollPane(l1));  
    	jf.setVisible(true);
    	
	}
	public static void main(String[] args)
	{
		new listmodel().test();
	}
	
	class DataModel extends AbstractListModel
	{
		String[] s={"����","��ʾ��","�ڴ�","CPU","Ӳ��","��Դ","����","���"};
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
