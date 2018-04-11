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
	        //frame默认的布局为BorderLayout
	        frame.setLayout(new GridLayout(2, 3));
	        for(int i=1;i<=5;i++){
	            frame.add(new Button("按纽"+i));
	        }
	        //setSize只指定窗口的大小，位置在原点(0,0)
	        //setBound既可指定位置，又可指定大小
//	        frame.setSize(300,200);
	        //pack会将窗口中的组件正好包裹起来，即大小自适应
	        frame.pack();
	        frame.setVisible(true);
	    }

		
}
