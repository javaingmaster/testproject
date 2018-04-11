package Windowlistener;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Usewindowlistener extends Frame     //窗口监听：当对一个窗口进行某种操作的时候从而引发的某些事件
{
	private static final long serialVersionUID = 1L;
	 public Usewindowlistener() {
	        setSize(300, 200);
	        setVisible(true);
	        /*
	         * addWindowListener方法的参数为继承了WindowAdapter的匿名类
	         * 该匿名类直接写在方法的内部
	         * 一般情况下很少使用，只有代码简单且无需变动时才临时使用，推荐使用内部类
	         */
	        this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                setVisible(false);
	                System.exit(0);
	            }
	        });
	        
	        /*
	         * addWindowListener()方法的参数为WindowListener对象
	         * 而WindowListener是一个接口，里面有6、7个类似windowClosing()的方法
	         * 如果要来实现接口的话，则需要实现接口里的每一个方法
	         * jdk提供了实现WinowListener接口的抽象类WindowAdapter,
	         * 其实WindowApdater类中实现的方法并无实际代码
	         * 对于类中的方法，子类是不需要全都实现。本例中只要重写windowClosing()方法即可。
	         * monitor extends WindowAdapter implements WindowListener
	         * WindowAdapter只是一个中间件，过渡一下
	         */
	    }
	    public static void main(String[] args) {
	        new Usewindowlistener();
	    }

	
}

