package lucky;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class price extends Frame implements ActionListener
{
	Label label =new Label();
	public price(String strMsg)
	{
		super();
		setTitle("猜的结果");
		Panel p=new Panel();
		add(p);
		p.add(label);
		label.setText(strMsg);
		setSize(150,100);
		setLocation(300,200);
		Button btOk=new Button("确定");
		btOk.addActionListener((ActionListener) this);
		p.add(btOk);
		show();
	}

	public void actionPerformed(ActionEvent evt)
	{
		this.dispose();
	}

}
