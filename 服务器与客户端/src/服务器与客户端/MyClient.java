package ��������ͻ���;

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
		//1�������ͻ��ˣ�ָ������˿ں�
		DatagramSocket client=new DatagramSocket(5555);
		//2��׼������
		
		double num=66.66;
		byte[]send=convert(num);
		
		//String sendmessage="�ͻ��˱��"; //Ԥ���͵�����
		//byte[] send=sendmessage.getBytes();//Ԥ�������ݵ�����
		
		//3��Ԥ�������ݴ����ȷ�����͵ĵص�Ͷ˿�
		InetSocketAddress sendaid=new InetSocketAddress("localhost",6667);
		DatagramPacket packet=new DatagramPacket(send,send.length,sendaid);
		//4������
		client.send(packet);
		//5���ͷ���Դ
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
