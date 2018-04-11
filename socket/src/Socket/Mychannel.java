package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Mychannel implements Runnable
{
	private DataInputStream reader;
	private DataOutputStream writer;
	private boolean isRunning=true;
	
	public Mychannel(Socket myuser)
	{
		try {
			reader=new DataInputStream(myuser.getInputStream());
			writer=new DataOutputStream(myuser.getOutputStream());
		} catch (IOException e) {
			//e.printStackTrace();
			Closeio.closeio(reader,writer);
			isRunning=false;
		}
		
	}
	
	private String receive()
	{
		String receivemsg="";
		try {
			receivemsg=reader.readUTF();
		} catch (IOException e) {
			//e.printStackTrace();
			Closeio.closeio(reader);
			isRunning=false;
		}
		return receivemsg;
	}
	
	
	public void send(String msg)
	{
		if(msg==null||msg.equals(""))
		{
			return ;
		}
		try {
			writer.writeUTF(msg);
			writer.flush();
		} catch (IOException e) {
			//e.printStackTrace();
			Closeio.closeio(writer);
			isRunning=false;
		}
	}
	
	public void run()
	{
		if(isRunning)
		{
			send(receive());
		}
	}
	
}
