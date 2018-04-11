package Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable
{
	private DataInputStream receive; 
	private boolean isreceive=true;
	
	public Receive(){
	}
	public Receive(Socket user)
	{
		try {
			receive=new DataInputStream(user.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
			isreceive=false;
			Closeio.closeio(receive);
		}
	}
	
	public void receive()
	{
		try {
			System.out.println(receive.readUTF());
		} catch (IOException e) {			
			e.printStackTrace();
			isreceive=false;
			Closeio.closeio(receive);
		}
	}
	public void run()
	{
		while(isreceive)
		{
			receive();
		}
	}

}
