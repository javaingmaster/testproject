package GridLayout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JFrame;
public class CreateGridlayout
{

	    public static void main(String[] args) {
	        JFrame frame=new JFrame("Grid Layout");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //frameĬ�ϵĲ���ΪBorderLayout
	        frame.setLayout(new GridLayout(2, 3));
	        for(int i=1;i<=5;i++){
	            frame.add(new Button("��Ŧ"+i));
	        }
	        //setSizeָֻ�����ڵĴ�С��λ����ԭ��(0,0)
	        //setBound�ȿ�ָ��λ�ã��ֿ�ָ����С
//	        frame.setSize(300,200);
	        //pack�Ὣ�����е�������ð�������������С����Ӧ
	        frame.pack();
	        frame.setVisible(true);
	    }

		
}
