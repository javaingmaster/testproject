package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiServer 
{
    private List<Mychannel> all=new  ArrayList<Mychannel>();
	
	public static void main(String[] args) throws IOException
	{
		new MultiServer().start();
	}
	
	public void start() throws IOException
	{
		ServerSocket multiserver=new ServerSocket(8888);
		
		while(true)
		{
			Socket myuser=multiserver.accept();
            Mychannel channel=new Mychannel(myuser);
            all.add(channel);
            new Thread(channel).start();
	    }
	}

	
	
	
    private class Mychannel implements Runnable
	{
		private DataInputStream reader;
		private DataOutputStream writer;
		private boolean isRunning=true;
		public String name;
		
		public Mychannel(Socket myuser)
		{
			try {
				reader=new DataInputStream(myuser.getInputStream());
				writer=new DataOutputStream(myuser.getOutputStream());
				
				name=reader.readUTF();
				this.send("欢迎"+name+"加入聊天室");
				send_to_others("欢迎"+name+"加入聊天室");
				
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
				all.remove(this);
			}
			return receivemsg;
		}
		
		public void send_to_others(String msg)
		{	
			if(msg.startsWith("@"))
			{
				String towho=msg.substring(1, msg.indexOf(":"));
				String message=msg.substring(msg.indexOf(":")+1);
				System.out.println(towho+"\n"+message);
				for(Mychannel other:all){
					if(other.name.equals(towho)){
						other.send(name+"对"+other.name+"说:"+message);
					}
				}
				
			}else{
					
			for(Mychannel others:all){
				if(others==this)
					{continue;}
				else{
					others.send(name+":"+msg);
				}
			}
			
			}
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
				all.remove(this);
			}
		}
		
		public void run()
		{
			while(isRunning)
			{
				send_to_others(receive());
			}
		}
		
	}
}

