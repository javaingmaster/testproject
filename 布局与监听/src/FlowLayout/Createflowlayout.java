package FlowLayout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
public class Createflowlayout
{
	    public static void main(String[] args) {
	        JFrame frame=new JFrame("Flow Layout");
	        //���ô��ڵĲ��ַ�ʽΪFlowLayout��Ԫ���ڴ���������룬Ԫ��ˮƽ���Ϊ10����ֱ���Ϊ20
	        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        for(int i=1;i<=10;i++){
	            frame.add(new Button("��Ŧ"+i));
	        }
	        frame.pack();
	        frame.setVisible(true);
	    }
}
