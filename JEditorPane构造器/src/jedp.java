import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class jedp 
{
	public static void main(String[] args)
	{
		
		JEditorPane jed=null;
		try{
			URL address=new URL("http://www.google.com");
			jed=new JEditorPane(address);
		}catch(MalformedURLException e)
		{
			System.out.println("Malformed url is: "+e);
		}catch(IOException e)
		{
			System.out.println("io e is: "+e);
		}		
		jed.setEditable(false);	
		JFrame jf=new JFrame("Õ¯“≥≤‚ ‘");
		jf.setContentPane(new JScrollPane(jed));
		jf.setSize(200, 250);
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
		});
	}
}
