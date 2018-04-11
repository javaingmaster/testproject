
	import java.applet.Applet;
    import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JTextField;

	public class Lab12 extends Applet
	{
		public Lab12(){}
		
		public void Frame()
		{
			JFrame jf=new JFrame();
			jf.setSize(250,500);
			jf.setLayout(new FlowLayout(FlowLayout.TRAILING));
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JTextField text=new JTextField(15);
			jf.add(text);

			JButton up=new JButton("Sort low to high");
			jf.add(up);
			
			JButton down=new JButton("Sort high to low");
			jf.add(down);
			
			JTextField text2=new JTextField(15);
			jf.add(text2);
			
			JButton exitit=new JButton("Exit Program ");
			jf.add(exitit);
			
			up.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String output="";
					String temp=text.getText();
					int[] tempnumber=new int[temp.length()];
					for(int i=0;i<temp.length();i++)
					{
						tempnumber[i]=(int)(temp.charAt(i)-'0');
					}			
					bubbleSort(tempnumber);
					for(int i=0;i<temp.length();i++)
					{
						output+=(char)(tempnumber[i]+'0');
					}	
					text2.setText(output);
				}
				
			});
			
			down.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					String output="";
					String temp=text.getText();
					int[] tempnumber=new int[temp.length()];
					for(int i=0;i<temp.length();i++)
					{
						tempnumber[i]=(int)(temp.charAt(i)-'0');
					}			
					bubbleSort0(tempnumber);
					for(int i=0;i<temp.length();i++)
					{
						output+=(char)(tempnumber[i]+'0');
					}	
					text2.setText(output);
				}
				
			});
			
			exitit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					jf.dispose();
					System.exit(0);
				}
				
			});
			
			jf.pack();
			jf.setVisible(true);
		}
		
		public static void bubbleSort(  int array2[] )
	    {   
		for ( int pass = 1; pass < array2.length; pass++ )
		    {
			for ( int element = 0; element < (array2.length - 1); element++ )
			    {
				if ( array2[ element ] > array2[ element + 1 ] )  
				    {     
					swap( array2, element, element + 1 );
				    } 
			    }
		    } 
	    }
		public static void bubbleSort0(  int array2[] )
	    {   
		for ( int pass = 1; pass < array2.length; pass++ )
		    {
			for ( int element = 0; element < (array2.length - 1); element++ )
			    {
				if ( array2[ element ] < array2[ element + 1 ] )  
				    {     
					swap( array2, element, element + 1 );
				    } 
			    }
		    } 
	    }
	    
	    
	    // method swap (to be used in conjunction with bubbleSort)
	    public static void swap( int array3[], int first, int second )
	    {
	        int hold;
	        
	        hold  = array3[ first ];
	        array3[ first ]  = array3[ second ];
	        array3[ second ] = hold;
		
	    }

		
		public static void main(String[] aaa)
		{
			new Lab12().Frame();
		}

	}


