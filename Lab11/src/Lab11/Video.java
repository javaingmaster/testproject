package Lab11;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Video extends Applet{

	private JTextField film,price;
	private JComboBox films;

	public static void main(String[] args) {
	
		new Video();
	}

	public Video()
	{
		String[] prices={"100元","10元","50元","80元","60元","500元","30元","200元","1000元","10000元"};
		String[] s={"盗梦空间","记忆裂痕","生死停留","死亡幻觉","禁闭岛","穆赫兰道","蝴蝶效应","伤城","恐怖游轮","盗走达芬奇"};

		JFrame jf=new JFrame();
		jf.setSize(220, 250);
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p=new JPanel();
		jf.setContentPane(p);
		
		JLabel l1=new JLabel("现有电影: ");
		p.add(l1);
		
		films=new JComboBox();
		for(int i=0;i<s.length;i++){
			films.addItem(s[i]);
		}
		p.add(films);
		
		JLabel l2=new JLabel("所选电影: ");
		p.add(l2);
		
		film=new JTextField(10);
		film.setText(s[0]);
		p.add(film);
		
		JLabel l3=new JLabel("所选电影价格: ");
		p.add(l3);
		
		price=new JTextField(10);
		price.setText(prices[0]);
		p.add(price);
		
		films.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				film.setText((String)((JComboBox)e.getSource()).getSelectedItem());
				price.setText(prices[((JComboBox)e.getSource()).getSelectedIndex()]);

			}
	
		});
		
		
		jf.setVisible(true);
	}

}

