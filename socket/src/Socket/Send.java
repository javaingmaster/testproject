package Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable
{
	private DataOutputStream writer;
	private BufferedReader input;
	private boolean isready=true;
	private String name;
	public Send()
	{
		this.input=new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket user,String name)
	{
		this();
		try {		
			writer=new DataOutputStream(user.getOutputStream());
			this.name=name;
			send(name);
		} catch (IOException e) {
			e.printStackTrace();
			isready=false;		
				Closeio.closeio(writer,input);		
		}
	}
	private String getinputmessage()
	{
		try {		
			return input.readLine();
		} catch (IOException e) {		
			e.printStackTrace();
			return "";
		}
	}

	public void send(String output_to_server)
	{
		if(output_to_server!=null&&!output_to_server.equals("")){
		try {
			writer.writeUTF(output_to_server);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			Closeio.closeio(writer,input);
		}
		}
	}
	@Override
	public void run() {
		while(isready)
		{
			send(getinputmessage());
		}
		
	}
	

}
