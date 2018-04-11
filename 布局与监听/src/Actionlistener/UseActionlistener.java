package Actionlistener;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class monitorTF implements ActionListener{ //本类原理相同于下
    @Override
    /**
     * 对于按纽来说默认的动作事件是单击，文本框默认事件的是按回车键,
     * 这些事件执行时，系统回自动调用actionPerformed方法
     * 所以需要在监听器里要重写该方法,ActionListener接口里也只有这一个方法
     */
    public void actionPerformed(ActionEvent e) {
        TextField tf1=(TextField)(e.getSource());
        System.out.println(tf1.getText());
        tf1.setText("");
    }
}
public class UseActionlistener { //区分所按按钮

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
        //button1和button2加入同一个监听器,如何区分?
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
        //首先要得到事件源对象,因getSource()返回的是Object,需强制转换为Button
        String actionCommand=button.getActionCommand();
        /**
         * Button的getLabel()方法得到是按纽上的文字,有可能两个按纽的文本会一样,如本例
         * Button的getName()得到的是按纽的name,这个name值是由系统命名的,第1个Button的name是button0
         * 最好使用getActionCommand()方法进行区分处理
         */
        if(actionCommand.equals("button1")){
            System.out.println("你按下了button1按纽");
        }else if(actionCommand.equals("button2")){
            System.out.println("你按下了button2按纽");
        }
    }
}
