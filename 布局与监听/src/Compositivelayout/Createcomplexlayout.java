package Compositivelayout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JFrame;

public class Createcomplexlayout {

    public static void main(String[] args) {
        JFrame frame=new JFrame("MutiLayout");
        //窗口分成2行1列,分上下两个panel
        frame.setLayout(new GridLayout(2, 1,20,20));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //第1个panel采用BorderLayout
        Panel p1=new Panel();
        p1.setLayout(new BorderLayout());
        Button b11=new Button("ButtonWest");
        Button b12=new Button("ButtonEast");
        //CENTER部分再使用panel并采用GridLayout
        Panel p11=new Panel();
        p11.setLayout(new GridLayout(2, 1));
        Button b13=new Button("ButtonUp");
        Button b14=new Button("ButtonDown");
        p11.add(b13);
        p11.add(b14);
        p1.add(b11, BorderLayout.EAST);
        p1.add(b12, BorderLayout.WEST);
        p1.add(p11, BorderLayout.CENTER);
        
        //第2个panel采用BorderLayout
        Panel p2=new Panel();
        p2.setLayout(new BorderLayout());
        Button b21=new Button("ButtonWest");
        Button b22=new Button("ButtonEast");
        //CENTER部分再使用panel并采用GridLayout
        Panel p21=new Panel();
        p21.setLayout(new GridLayout(2, 2));
        for(int i=1;i<=4;i++){
            p21.add(new Button("Button"));
        }
        p2.add(b21, BorderLayout.EAST);
        p2.add(b22, BorderLayout.WEST);
        p2.add(p21, BorderLayout.CENTER);
        
        frame.add(p1);
        frame.add(p2);
        frame.setSize(300,200);;
        frame.setVisible(true);
    }

}
