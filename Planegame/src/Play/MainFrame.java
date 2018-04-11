package Play;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("all")
public class MainFrame extends JFrame implements ActionListener {
	public static final int GAME_WIDTH = 750;
	public static final int GAME_HEIGHT = 750;
	public JButton buttonStart = new JButton("开始游戏");
	public JButton buttonIntro = new JButton("婵炴挸鎲￠崹娆戞嫚鐎涙ɑ顫�");
	public JButton buttonHistory = new JButton("闁告ê妫楄ぐ鍓佹媼閺夎法绉�");
	public ImageIcon background;
	public JPanel imagePanel;

	public MainFrame() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setLocation(400, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JPanelTool MainJpanel = new JPanelTool();
		JPanel MainJpanel = new JPanel();
		MainJpanel.setSize(GAME_WIDTH, GAME_HEIGHT);
		MainJpanel.setLocation(400, 0);  
		setContentPane(MainJpanel);
		background = new ImageIcon(this.getClass().getResource("/images/flight.jpg"));
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setResizable(false);
		this.setLayout(null);
		buttonStart.setBounds(100, 300, 100, 50);
		buttonIntro.setBounds(100, 400, 100, 50);
		buttonHistory.setBounds(100, 500, 100, 50);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/bgi1.jpg") );
		buttonStart.setIcon(icon);
		buttonStart.setContentAreaFilled(false);
		ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/images/bgi2.jpg"));
		buttonIntro.setIcon(icon1);
		buttonIntro.setContentAreaFilled(false);
		ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/images/bgi3.jpg"));
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
	
	public MainFrame(JFrame frame){
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonStart)) {
			dispose();
			JFrameStart frameStart = new JFrameStart();
		}
		if (e.getSource().equals(buttonIntro)) {
			JFrameIntro frameIntro = new JFrameIntro();
			dispose();
		}
		if (e.getSource().equals(buttonHistory)) {
			JFrameHistory frameHistory = new JFrameHistory();
			dispose();
		}
	}

	public static void main(String[] aaa) {
		MainFrame f = new MainFrame();
	}

}

class JFrameStart extends JFrame{
	public JFrameStart(){
		new CornFrame().launchFrame();
	}
}

class JFrameIntro extends JFrame implements ActionListener {
	public ImagePanel introduction = new ImagePanel();
	public JPanel imagePanel;
	public JPanel imagePanel1;
	public ImageIcon background;
	public ImageIcon background1;
	public JTextArea jta;
	public JLabel intro = new JLabel("婵炴挸鎲￠崹娆戞嫚鐎涙ɑ顫�");
	public JButton btn = new JButton("閺夆晜鏌ㄥú锟�");
	public static final int Gamewidth = 750;
	public static final int Gameheight = 750;

	public JFrameIntro() {
		//jta=new JTextArea("绌烘牸鏄皠鍑伙紝绠ご涓虹Щ鍔�");
		setSize(Gamewidth, Gameheight);
		setLocation(400, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel MainJpanel = new JPanel();
		MainJpanel.setSize(Gamewidth, Gameheight);
		MainJpanel.setLocation(400, 0);
		setContentPane(MainJpanel);
		MainJpanel.setLayout(null);
		//MainJpanel.add(jta);
		//jta.setBounds(550, 350, 15, 10);
		background = new ImageIcon(this.getClass().getResource("/").getFile().toString() + "images/flight.jpg");// 闁煎啿鏈▍娆撳炊閸撗冾暬
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setResizable(false);
		introduction.setPreferredSize(new Dimension(450, 700));
		btn.setPreferredSize(new Dimension(30, 30));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/").getFile().toString() + "images/back.jpg");
		btn.setIcon(icon);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		intro.setFont(new java.awt.Font("鐎甸偊鍠涢拏瀣⒖閸涘鎷�", 1, 24));
		introduction.add(btn);
		introduction.add(intro);
		add(introduction, BorderLayout.CENTER);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn)) {
			MainFrame main = new MainFrame();
			dispose();
		}
	}
}

class JFrameHistory extends JFrame implements ActionListener {
	public ImagePanel history = new ImagePanel();
	public JPanel imagePanel;
	public ImageIcon background;
	public JLabel intro = new JLabel("闁告ê妫楄ぐ鍓佹媼閺夎法绉�");
	public JButton btn = new JButton("閺夆晜鏌ㄥú鏍ㄧ▔閺勫繐缍呴柛妤嬫嫹");
	public static final int Gamewidth = 750;
	public static final int Gameheight = 750;

	public JFrameHistory() {
		setSize(Gamewidth, Gameheight);
		setLocation(400, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel MainJpanel = new JPanel();
		MainJpanel.setSize(Gamewidth, Gameheight);
		MainJpanel.setLocation(400, 0);
		setContentPane(MainJpanel);
		background = new ImageIcon(this.getClass().getResource("/").getFile().toString() + "images/flight.jpg");// 闁煎啿鏈▍娆撳炊閸撗冾暬
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setLayout(new FlowLayout());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		setResizable(false);
		history.setPreferredSize(new Dimension(450, 700));
		btn.setPreferredSize(new Dimension(30, 30));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/").getFile().toString() + "images/back.jpg");
		intro.setFont(new java.awt.Font("鐎甸偊鍠涢拏瀣⒖閸涘鎷�", 1, 24));
		btn.setIcon(icon);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		history.add(btn);
		history.add(intro);
		add(history, BorderLayout.CENTER);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn)) {
			MainFrame main = new MainFrame();
			dispose();
		}
	}
}

class ImagePanel extends JPanel {
	ImageIcon icon;
	Image img;

	public ImagePanel() {
		icon = new ImageIcon(this.getClass().getResource("/").getFile().toString() + "images/intro.jpg");
		img = icon.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}