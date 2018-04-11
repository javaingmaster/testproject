package 网络编程;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Testinetaddress 
{
	public static void main(String[] args) throws IOException
	{

		URL url=new URL("http://www.baidu.com");//此时默认获取主页资源
		//获取资源
		/*InputStream is=url.openStream();
		byte[] flush=new byte[1024];
		int len=0;
		while((len=is.read(flush))!=-1){
			System.out.println(new String(flush,0,len));
		}
	is.close();*/
		
		BufferedReader b=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter w=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		String m=null;
		while((m=b.readLine())!=null){
			//System.out.println(m);
			w.append(m);
			w.newLine();
		}
		w.flush();
		w.close();
		b.close();
	}

}

