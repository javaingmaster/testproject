package 服务器与客户端;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Myserver 
{
	public static void main(String[] args) throws IOException
	{
		//1、创建服务端，指定接受数据端口
		DatagramSocket server=new DatagramSocket(6667);
		//2、准备容器
		byte[] accept=new byte[1024];
		//3、封装成包
		DatagramPacket packet=new DatagramPacket(accept,accept.length);
		//4、接收数据
		server.receive(packet);
		//5、分析数据
	//	byte[] data=packet.getData();
	//	int len=packet.getLength();
		//System.out.println(new String(data,0,len));
		
		double data=convert(packet.getData());
		System.out.println(data);
		
		//6、释放资源
		server.close();
				
	}

	public static double convert(byte[] data) throws IOException
	{
		DataInputStream d=new DataInputStream(new ByteArrayInputStream(data));
		double num=d.readDouble();
		d.close();
		return num;
		}
}
