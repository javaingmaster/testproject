package Actionlistener;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class monitorTF implements ActionListener{ //����ԭ����ͬ����
    @Override
    /**
     * ���ڰ�Ŧ��˵Ĭ�ϵĶ����¼��ǵ������ı���Ĭ���¼����ǰ��س���,
     * ��Щ�¼�ִ��ʱ��ϵͳ���Զ�����actionPerformed����
     * ������Ҫ�ڼ�������Ҫ��д�÷���,ActionListener�ӿ���Ҳֻ����һ������
     */
    public void actionPerformed(ActionEvent e) {
        TextField tf1=(TextField)(e.getSource());
        System.out.println(tf1.getText());
        tf1.setText("");
    }
}
public class UseActionlistener { //����������ť

    public static void main(String[] args) {
        new Frame2();
    }

}

class Frame2 extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public Frame2() {
        super("Event Listener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Button button1 = new Button("button");
        Button button2 = new Button("button");
        button1.setActionCommand("button1");
        button2.setActionCommand("button2");
        //button1��button2����ͬһ��������,�������?
        button1.addActionListener(new monitor());
        button2.addActionListener(new monitor());
        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}

class monitor implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Button button=(Button)e.getSource();
        //����Ҫ�õ��¼�Դ����,��getSource()���ص���Object,��ǿ��ת��ΪButton
        String actionCommand=button.getActionCommand();
        /**
         * Button��getLabel()�����õ��ǰ�Ŧ�ϵ�����,�п���������Ŧ���ı���һ��,�籾��
         * Button��getName()�õ����ǰ�Ŧ��name,���nameֵ����ϵͳ������,��1��Button��name��button0
         * ���ʹ��getActionCommand()�����������ִ���
         */
        if(actionCommand.equals("button1")){
            System.out.println("�㰴����button1��Ŧ");
        }else if(actionCommand.equals("button2")){
            System.out.println("�㰴����button2��Ŧ");
        }
    }
}
