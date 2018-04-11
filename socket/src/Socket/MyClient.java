package Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient 
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		System.out.println("input your name: ");
		BufferedReader nameio=new BufferedReader(new InputStreamReader(System.in));
		String name =nameio.readLine();
		if(name.equals("")){
			return;
		}

		Socket user=new Socket("localhost",8888);
	
		/*BufferedReader reader=new BufferedReader(new InputStreamReader(user.getInputStream()));
		String read=reader.readLine();*/
		
		new Thread(new Send(user,name)).start();
		new Thread(new Receive(user)).start();
		
	
	}

}
