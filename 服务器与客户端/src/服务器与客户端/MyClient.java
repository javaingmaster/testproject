package 服务器与客户端;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class MyClient 
{
	public static void main(String[] args) throws IOException 
	{
		//1、创建客户端，指定输出端口号
		DatagramSocket client=new DatagramSocket(5555);
		//2、准备数据
		
		double num=66.66;
		byte[]send=convert(num);
		
		//String sendmessage="客户端编程"; //预发送的数据
		//byte[] send=sendmessage.getBytes();//预发送数据的数组
		
		//3、预发送数据打包，确定发送的地点和端口
		InetSocketAddress sendaid=new InetSocketAddress("localhost",6667);
		DatagramPacket packet=new DatagramPacket(send,send.length,sendaid);
		//4、发送
		client.send(packet);
		//5、释放资源
		client.close();
	}
	public static byte[] convert(double num) throws IOException
	{
		byte[] data=null;
		ByteArrayOutputStream b=new ByteArrayOutputStream();
		DataOutputStream d=new DataOutputStream(b);
		d.writeDouble(num);
		d.flush();
		
		data=b.toByteArray();
		d.close();
		return data;
	}

}
