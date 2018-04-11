package com.mingrisoft;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
public class InternetContentFrame extends JFrame
{
	static JTextField text=new JTextField(120);
	static JTextArea ta=new JTextArea(500,50);
	public void mywin()
	{			
		JScrollPane sp=new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		setSize(1000,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1=new JPanel();
		p1.setLayout(new BorderLayout());
		setContentPane(sp);
		setContentPane(p1);		
		JButton b1=new JButton("Ω‚ŒˆÕ¯“≥");	
		p1.add(text,"North");
		p1.add(ta,"Center");
		p1.add(b1,"South");
		ActionHandler ac=new ActionHandler();
		b1.addActionListener(ac);
		setVisible(true);
	}
	public Collection<String>getURLConnection(String urlString)
	{
		URL url=null;
		URLConnection conn=null;
		Collection<String>urlCollection=new ArrayList<String>();
		try
		{
			url=new URL(urlString);
			conn=url.openConnection();
			conn.connect();
			InputStream is=conn.getInputStream();
			InputStreamReader in=new InputStreamReader(is,"UTF-8");
			BufferedReader br=new BufferedReader(in);
			String nextline=br.readLine();
			while(nextline!=null)
			{
				urlCollection.add(nextline);
				nextline=br.readLine();
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return(urlCollection);
	}
	class ActionHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String address=text.getText().trim();
			Collection urlcollection=getURLConnection(address);
			Iterator it=urlcollection.iterator();
			while(it.hasNext())		
			{
				ta.append((String)it.next()+"\n");
				ta.append("\n");
			}	
		}
	}
	public static void main(String[] args)
	{
		InternetContentFrame test=new InternetContentFrame();
		test.mywin();
	}
}
