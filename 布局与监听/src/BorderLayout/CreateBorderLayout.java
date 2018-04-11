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
	        //边界布局是frame默认的布局方式
	        Button button1=new Button("东");
	        frame.add(button1, BorderLayout.EAST);
	        
	        Button button2=new Button("西");
	        frame.add(button2, BorderLayout.WEST);
	        
	        Button button3=new Button("南");
	        frame.add(button3, BorderLayout.SOUTH);
	        
	        Button button4=new Button("北");
	        frame.add(button4, BorderLayout.NORTH);
	        
	        Button button5=new Button("中");
	        frame.add(button5, BorderLayout.CENTER);
	        
	        frame.pack();
	        frame.setVisible(true);
	    }

}
