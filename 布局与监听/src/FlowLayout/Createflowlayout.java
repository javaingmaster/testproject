package FlowLayout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
public class Createflowlayout
{
	    public static void main(String[] args) {
	        JFrame frame=new JFrame("Flow Layout");
	        //设置窗口的布局方式为FlowLayout，元素在窗口中左对齐，元素水平间距为10，垂直间距为20
	        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        for(int i=1;i<=10;i++){
	            frame.add(new Button("按纽"+i));
	        }
	        frame.pack();
	        frame.setVisible(true);
	    }
}
