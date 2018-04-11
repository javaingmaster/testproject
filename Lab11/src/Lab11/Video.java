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
		String[] prices={"100Ԫ","10Ԫ","50Ԫ","80Ԫ","60Ԫ","500Ԫ","30Ԫ","200Ԫ","1000Ԫ","10000Ԫ"};
		String[] s={"���οռ�","�����Ѻ�","����ͣ��","�����þ�","���յ�","�º�����","����ЧӦ","�˳�","�ֲ�����","���ߴ����"};

		JFrame jf=new JFrame();
		jf.setSize(220, 250);
		jf.setLocation(150, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p=new JPanel();
		jf.setContentPane(p);
		
		JLabel l1=new JLabel("���е�Ӱ: ");
		p.add(l1);
		
		films=new JComboBox();
		for(int i=0;i<s.length;i++){
			films.addItem(s[i]);
		}
		p.add(films);
		
		JLabel l2=new JLabel("��ѡ��Ӱ: ");
		p.add(l2);
		
		film=new JTextField(10);
		film.setText(s[0]);
		p.add(film);
		
		JLabel l3=new JLabel("��ѡ��Ӱ�۸�: ");
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

