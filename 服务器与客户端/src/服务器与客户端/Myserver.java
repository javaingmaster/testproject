package ��������ͻ���;

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
		//1����������ˣ�ָ���������ݶ˿�
		DatagramSocket server=new DatagramSocket(6667);
		//2��׼������
		byte[] accept=new byte[1024];
		//3����װ�ɰ�
		DatagramPacket packet=new DatagramPacket(accept,accept.length);
		//4����������
		server.receive(packet);
		//5����������
	//	byte[] data=packet.getData();
	//	int len=packet.getLength();
		//System.out.println(new String(data,0,len));
		
		double data=convert(packet.getData());
		System.out.println(data);
		
		//6���ͷ���Դ
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
