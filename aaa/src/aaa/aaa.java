package aaa;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class aaa 
{
	public static void main(String[] args) throws IOException
	{
		  int[]   buf={0,1,2,3,4,5,6,7,8,10000}; 
		  		  
		    OutputStream fos = new FileOutputStream("d:\\tes.txt");
		    DataOutputStream dos = new DataOutputStream(fos); 
		    
		    //for(int i=0;i<buf.length;i++){
		     dos.write(convert(123),0,1);
		    //}
		    dos.flush();
		    dos.close();
	}
	public static  byte[] convert(int num) throws IOException
	{
		byte[] data=null;
		ByteArrayOutputStream b=new ByteArrayOutputStream();
		DataOutputStream d=new DataOutputStream(b);
		d.writeInt(num);
		d.flush();
		
		data=b.toByteArray();
		d.close();
		return data;
	}

}
