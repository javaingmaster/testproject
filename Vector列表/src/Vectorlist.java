import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class Vectorlist 
{
	public static void main(String[] args){
		animal a =new animal();
		a.bark();
		dog d=new dog();
		d.bark();
		
		animal aa=new dog();
		aa.bark();
	}

}
