package 文件选取器;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class filechoose implements ActionListener
{
	JFrame jf=null;
	JLabel l1=null;
	JTextArea ta=null;
	JFileChooser filechooser;
	public void test1()
	{
		jf=new JFrame("example");
		Container contentPane=jf.getContentPane();
		ta=new JTextArea();
		JScrollPane scrol=new JScrollPane(ta);
		scrol.setPreferredSize(new Dimension(350,300));
		JPanel p1=new JPanel();
		JButton b1=new JButton("create document");
		b1.addActionListener(this);
		JButton b2=new JButton("save the file");
		b2.addActionListener(this);
		p1.add(b1);
		p1.add(b2);
		Label l1=new Label("",2);
		filechooser=new JFileChooser("D:\\");
		contentPane.add(l1,BorderLayout.NORTH);
		contentPane.add(scrol,BorderLayout.CENTER);
		contentPane.add(p1,BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter()
		{
			public void windowClosed(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) 
	{
		File file=null;
		int result;
		FileInputStream fs=null;
		if(e.getActionCommand().equals("create document"))
		{
			filechooser.setApproveButtonText("yes");
			filechooser.setDialogTitle("open the file");
			result=filechooser.showOpenDialog(jf);
			ta.setText("");
			if(result==JFileChooser.APPROVE_OPTION)
			{
				file=filechooser.getSelectedFile();	
				if(file!=null)
				{
					try{
						fs=new FileInputStream(file);
					}catch(FileNotFoundException fe)
					{
						l1.setText("not found");
						return;
					}
					int readbyte;
					try{
						while((readbyte=fs.read())!=-1)
						{
							ta.append(String.valueOf((char)readbyte));
						}
					}catch(IOException ioe)
					{
						l1.setText("read wrong!");
					}
			}
			}
			else if(result==JFileChooser.CANCEL_OPTION)
			{
				l1.setText("you have not selected the files");
			}						
					try
					{
						if(fs!=null)
							fs.close();
					}
					catch(IOException ioe2){}				
			}
		else if(e.getActionCommand().equals("save the file"))
		{		
			FileOutputStream fileout=null;
			filechooser.setApproveButtonText("yes");
			filechooser.setDialogTitle("save the file");
			result=filechooser.showSaveDialog(jf);
			if(result==JFileChooser.APPROVE_OPTION)
			{
				file=filechooser.getSelectedFile();	
					try{
						fileout=new FileOutputStream(file);
						String content=ta.getText();
						fileout.write(content.getBytes());
						System.out.println("finishing writing");
						fileout.close();
					}catch(FileNotFoundException fe)
					{
						l1.setText("file not found");
						return;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
																		
			}
			else if(result==JFileChooser.CANCEL_OPTION)
			{
				l1.setText("you have not choosed.");
			}
		}
		}
	}
class test
{
	public static void main(String[] args)
	{
		 filechoose one=new filechoose();
		 one.test1();
	}
}
