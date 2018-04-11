package 飞机;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class MainFrame extends JFrame implements ActionListener
{
	public static final int Gamewidth=750;
	public static final int Gameheight=750;
	public JButton buttonStart =new JButton("寮�濮嬫父鎴�");
	public JButton buttonIntro =new JButton("娓告垙璇存槑");
	public JButton buttonHistory =new JButton("鍘嗗彶璁板綍");
	public ImageIcon background;
	public JPanel imagePanel;
	public MainFrame()
	{		
			setSize(Gamewidth, Gameheight);
			setLocation(400,0);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanelTool MainJpanel=new JPanelTool();
			MainJpanel.setSize(Gamewidth, Gameheight);
			MainJpanel.setLocation(400, 0);
			setContentPane(MainJpanel);
			background = new ImageIcon("/Users/apple/eclipse/frame/flight.jpg");// 鑳屾櫙鍥剧墖
			JLabel label = new JLabel(background);
			label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
			imagePanel = (JPanel) this.getContentPane();
			imagePanel.setOpaque(false);
			imagePanel.setLayout(new FlowLayout());
			getLayeredPane().setLayout(null);
			getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			setResizable(false);
			this.setLayout(null);
			buttonStart.setBounds(100,300,100,50);
			buttonIntro.setBounds(100,400,100,50);
			buttonHistory.setBounds(100,500,100,50);
			ImageIcon icon = new ImageIcon("/Users/apple/eclipse/frame/bgi1.jpg");  
			buttonStart.setIcon(icon);  
			buttonStart.setContentAreaFilled(false); 
			ImageIcon icon1 = new ImageIcon("/Users/apple/eclipse/frame/bgi2.jpg");  
			buttonIntro.setIcon(icon1);  
			buttonIntro.setContentAreaFilled(false); 
			ImageIcon icon2 = new ImageIcon("/Users/apple/eclipse/frame/bgi3.jpg");  
			buttonHistory.setIcon(icon2);  
			buttonHistory.setContentAreaFilled(false); 
			buttonStart.addActionListener(this);
			buttonIntro.addActionListener(this);
			buttonHistory.addActionListener(this);
			add(buttonStart);
			add(buttonIntro);
			add(buttonHistory);
			
			setVisible(true);	
	}
	public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(buttonStart)){
        	JFrameStart frameStart = new JFrameStart();
        	dispose();
        }
        if(e.getSource().equals(buttonIntro)){
        	JFrameIntro frameIntro = new JFrameIntro();
        	dispose();
        }
        if(e.getSource().equals(buttonHistory)){
        	JFrameHistory frameHistory = new JFrameHistory();
        	dispose();
        }
    }
	public static void main(String[] aaa)
	{
		MainFrame f=new MainFrame();
	}
	
	
}
class JFrameStart extends JFrame implements KeyListener,ActionListener{
	public JPanel game = new JPanel();
	public JPanel score = new JPanel();
	public JPanel life = new JPanel();
	public JPanel method = new JPanel();
	public JPanel contain = new JPanel();
	public JPanel imagePanel;
	public ImageIcon background;
	public JLabel s = new JLabel("  寰楀垎");
	public JLabel l = new JLabel("  鐢熷懡");
	public JLabel m = new JLabel("  澶ф嫑");
	public JLabel extra = new JLabel("  ");
	public JButton btn = new JButton("杩斿洖涓昏彍鍗�");
	public static final int Gamewidth=750;
	public static final int Gameheight=750;
	public JFrameStart(){
		setSize(Gamewidth, Gameheight);
		setLocation(400,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanelTool MainJpanel=new JPanelTool();
		MainJpanel.setSize(Gamewidth, Gameheight);
		MainJpanel.setLocation(400, 0);
		setContentPane(MainJpanel);
		background = new ImageIcon("/Users/apple/eclipse/frame/flight.jpg");// 鑳屾櫙鍥剧墖
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setResizable(false);
		contain.setPreferredSize(new Dimension(610,700));
		game.setPreferredSize(new Dimension(450,700));
		score.setPreferredSize(new Dimension(150,700));
		btn.setPreferredSize(new Dimension(120,70));
		ImageIcon icon = new ImageIcon("/Users/apple/eclipse/frame/bgibtn.jpg");  
		btn.setIcon(icon);  
		btn.setContentAreaFilled(false); 
		Border etchedBorder;
		etchedBorder = BorderFactory.createEtchedBorder();
		game.setBorder(etchedBorder);
		score.setBorder(etchedBorder);
		score.setLayout(new GridLayout(5,1));
		score.add(s);
		score.add(l);
		score.add(m);
		btn.addActionListener(this);
		score.add(btn);
		score.add(extra);
		contain.add(game);
		contain.add(score);
		add(contain);
		setVisible(true);	
	}
	public void keyPressed(KeyEvent e) {  
        switch(e.getKeyCode())  
        {  
            case KeyEvent.VK_UP:  
                
                break;  
            case KeyEvent.VK_DOWN:  
                
                break;  
            case KeyEvent.VK_LEFT:  
               
                break;  
            case KeyEvent.VK_RIGHT:  
                
                break;  
        }
	}
	public void keyReleased(KeyEvent e) {  
        //  
    }  
  
    public void keyTyped(KeyEvent e) {  
        // 
    } 
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(btn)){
        	MainFrame main = new MainFrame();
        	dispose();
        }
    }
}
class JFrameIntro extends JFrame implements ActionListener{
	public ImagePanel introduction = new ImagePanel();
	public JPanel imagePanel;
	public JPanel imagePanel1;
	public ImageIcon background;
	public ImageIcon background1;
	public JLabel intro = new JLabel("娓告垙璇存槑");
	public JButton btn = new JButton("杩斿洖");
	public static final int Gamewidth=750;
	public static final int Gameheight=750;
	public JFrameIntro(){
		setSize(Gamewidth, Gameheight);
		setLocation(400,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanelTool MainJpanel=new JPanelTool();
		MainJpanel.setSize(Gamewidth, Gameheight);
		MainJpanel.setLocation(400, 0);
		setContentPane(MainJpanel);
		background = new ImageIcon("/Users/apple/eclipse/frame/flight.jpg");// 鑳屾櫙鍥剧墖
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setResizable(false);
		introduction.setPreferredSize(new Dimension(450,700));
		btn.setPreferredSize(new Dimension(30,30));
		ImageIcon icon = new ImageIcon("/Users/apple/eclipse/frame/back.jpg");  
		btn.setIcon(icon);  
		btn.setContentAreaFilled(false); 
		btn.addActionListener(this);
		intro.setFont(new java.awt.Font("寰蒋闆呴粦", 1, 24));
		introduction.add(btn);
		introduction.add(intro);
		add(introduction, BorderLayout.CENTER);
		setVisible(true);	
	}
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(btn)){
        	MainFrame main = new MainFrame();
        	dispose();
        }
    }
}
class JFrameHistory extends JFrame implements ActionListener{
	public ImagePanel history = new ImagePanel();
	public JPanel imagePanel;
	public ImageIcon background;
	public JLabel intro = new JLabel("鍘嗗彶璁板綍");
	public JButton btn = new JButton("杩斿洖涓昏彍鍗�");
	public static final int Gamewidth=750;
	public static final int Gameheight=750;
	public JFrameHistory(){
		setSize(Gamewidth, Gameheight);
		setLocation(400,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanelTool MainJpanel=new JPanelTool();
		MainJpanel.setSize(Gamewidth, Gameheight);
		MainJpanel.setLocation(400, 0);
		setContentPane(MainJpanel);
		background = new ImageIcon("/Users/apple/eclipse/frame/flight.jpg");// 鑳屾櫙鍥剧墖
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setResizable(false);
		history.setPreferredSize(new Dimension(450,700));
		btn.setPreferredSize(new Dimension(30,30));
		ImageIcon icon = new ImageIcon("/Users/apple/eclipse/frame/back.jpg"); 
		intro.setFont(new java.awt.Font("寰蒋闆呴粦", 1, 24));
		btn.setIcon(icon);  
		btn.setContentAreaFilled(false); 
		btn.addActionListener(this);
		history.add(btn);
		history.add(intro);
		add(history, BorderLayout.CENTER);
		setVisible(true);	
	}
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(btn)){
        	MainFrame main = new MainFrame();
        	dispose();
        }
    }
}
class ImagePanel extends JPanel {  
    ImageIcon icon;  
    Image img;  
    public ImagePanel() {    
        icon=new ImageIcon("/Users/apple/eclipse/frame/intro.jpg");  
        img=icon.getImage();  
    }  
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);  
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);  
    }  
  
}  