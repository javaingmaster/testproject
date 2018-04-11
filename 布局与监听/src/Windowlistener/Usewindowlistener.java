package Windowlistener;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Usewindowlistener extends Frame     //���ڼ���������һ�����ڽ���ĳ�ֲ�����ʱ��Ӷ�������ĳЩ�¼�
{
	private static final long serialVersionUID = 1L;
	 public Usewindowlistener() {
	        setSize(300, 200);
	        setVisible(true);
	        /*
	         * addWindowListener�����Ĳ���Ϊ�̳���WindowAdapter��������
	         * ��������ֱ��д�ڷ������ڲ�
	         * һ������º���ʹ�ã�ֻ�д����������䶯ʱ����ʱʹ�ã��Ƽ�ʹ���ڲ���
	         */
	        this.addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                setVisible(false);
	                System.exit(0);
	            }
	        });
	        
	        /*
	         * addWindowListener()�����Ĳ���ΪWindowListener����
	         * ��WindowListener��һ���ӿڣ�������6��7������windowClosing()�ķ���
	         * ���Ҫ��ʵ�ֽӿڵĻ�������Ҫʵ�ֽӿ����ÿһ������
	         * jdk�ṩ��ʵ��WinowListener�ӿڵĳ�����WindowAdapter,
	         * ��ʵWindowApdater����ʵ�ֵķ�������ʵ�ʴ���
	         * �������еķ����������ǲ���Ҫȫ��ʵ�֡�������ֻҪ��дwindowClosing()�������ɡ�
	         * monitor extends WindowAdapter implements WindowListener
	         * WindowAdapterֻ��һ���м��������һ��
	         */
	    }
	    public static void main(String[] args) {
	        new Usewindowlistener();
	    }

	
}

