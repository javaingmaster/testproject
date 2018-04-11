package GUI_tool;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Adddd extends JFrame {
    private Adddd(){

    }

    //��������ķ���
    public JPanel createImage(JPanel panel)
    {
       GridBagLayout lay=new GridBagLayout();
        panel.setBackground(Color.green);//����jpanel�ı�����ɫΪ��ɫ
        panel.setLayout(null);
        GridBagConstraints c=new GridBagConstraints();//��ô���Ķ���
        c.fill=GridBagConstraints.BOTH;
        c.weightx=1;

        addButton(panel,lay,c,"��ťһ");
        addButton(panel,lay,c,"��ť��");
        addButton(panel,lay,c,"��ť��");
        
        c.weightx=0;
        c.gridwidth=GridBagConstraints.REMAINDER;//��һ�е����һ����ť
        addButton(panel,lay,c,"��ť��");
        c.gridwidth=1;
        c.gridheight=1;
        addButton(panel,lay,c,"��ť��");
        c.gridwidth=GridBagConstraints.REMAINDER;//��һ�е����һ�����
        c.gridheight=GridBagConstraints.RELATIVE;//��һ�еĵ����ڶ������
        c.weighty=1;
        c.weightx=1;
        c.gridheight=3;//���ֵ����1���У���Ҫ�ǺͰ�ť�����ֿ�����Ȼ�Ͱ�ť��һ���ĸ߶ȣ���ť��Ҳ����������
        addTextArea(panel,lay,c);
        c.gridheight=GridBagConstraints.REMAINDER;
        c.weighty=0;
        c.gridheight=1;
        addButton(panel,lay,c,"��ť��");
        return panel;
    }

    //�����ı�����
    private void addTextArea(JPanel panel, GridBagLayout lay, GridBagConstraints c) {
        JTextArea text=new JTextArea();
        lay.setConstraints(text, c);
        panel.add(text);
    }

    //���Ӱ�ť�ķ���
    private void addButton(JPanel panel,GridBagLayout lay,GridBagConstraints c,String name){
        JButton bt=new JButton(name);
        lay.setConstraints(bt, c);
        panel.add(bt);
    }

    //���ô�������
    public void initFrame(){
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();//��ȡ������Ļ�ĸ߿�ֵ
        this.setSize((int)(dim.width*0.3), (int)(dim.height*0.7));
        this.setLocation((int)(dim.width*0.4), 0);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    /*public static void main(String[] args) {
        // TODO Auto-generated method stub
    	Adddd frame=new Adddd();
        JPanel panel=new JPanel();
        frame.add(frame.createImage(panel));
        frame.initFrame();
    }*/

}