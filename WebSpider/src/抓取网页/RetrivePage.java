package ץȡ��ҳ;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class RetrivePage {
	/*
	 * ��ҳץȡһ������
	 */
	//���ô��������
	private static HttpClient httpclient=new HttpClient();
	//�����ô����������ip�Ͷ˿�
	static{
		httpclient.getHostConfiguration().setProxy("192.168.2.1", 8080);
	}
	public static boolean downloadPage(String path) throws HttpException, IOException{
		InputStream in=null;
		OutputStream out=null;
		//�õ�post����
		PostMethod pm=new PostMethod(path);
		//����post��������
		NameValuePair[] postdata=new NameValuePair[2];
		postdata[0]=new NameValuePair("name","zty");
		postdata[1]=new NameValuePair("password","123456");
		//ִ��,����״̬��
		int statuscode=httpclient.executeMethod(pm);
		System.out.println("*******");
		//���״̬�봦��(�����200)
		
		if(statuscode==HttpStatus.SC_OK){
			System.out.println(200);
			in=pm.getResponseBodyAsStream();
			//�õ��ļ���
			String filename=path.substring(path.lastIndexOf('/')+1);
			//����ļ������
			out=new FileOutputStream(filename);
			//������ļ�
			int tempbyte=-1;
			while((tempbyte=in.read())>0){
				out.write(tempbyte);
			}
			//�ر����������
			if(in!=null){
				out.close();
			}
			return true;
		}
		else if(statuscode==HttpStatus.SC_NOT_FOUND){
			System.out.println(404);
		}
		return false;
	}
		
		/*
		 * ���Դ���
		 */
	
	public static void main(String[] aaa) throws IOException{
		//ץȡ��ҳ�����
		try{
			RetrivePage.downloadPage("http://write.blog.csdn.net/");
		}catch(HttpException e){
			e.printStackTrace();
		}
	}
	

}

