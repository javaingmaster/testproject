package BorderLayout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.JFrame;
public class CreateBorderLayout 
{
	    public static void main(String[] args) {
	        JFrame frame=new JFrame("Border Layout");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //�߽粼����frameĬ�ϵĲ��ַ�ʽ
	        Button button1=new Button("��");
	        frame.add(button1, BorderLayout.EAST);
	        
	        Button button2=new Button("��");
	        frame.add(button2, BorderLayout.WEST);
	        
	        Button button3=new Button("��");
	        frame.add(button3, BorderLayout.SOUTH);
	        
	        Button button4=new Button("��");
	        frame.add(button4, BorderLayout.NORTH);
	        
	        Button button5=new Button("��");
	        frame.add(button5, BorderLayout.CENTER);
	        
	        frame.pack();
	        frame.setVisible(true);
	    }

}
