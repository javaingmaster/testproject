package 抓取网页;

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
	 * 网页抓取一个例子
	 */
	//设置代理服务器
	private static HttpClient httpclient=new HttpClient();
	//并设置代理服务器的ip和端口
	static{
		httpclient.getHostConfiguration().setProxy("192.168.2.1", 8080);
	}
	public static boolean downloadPage(String path) throws HttpException, IOException{
		InputStream in=null;
		OutputStream out=null;
		//得到post方法
		PostMethod pm=new PostMethod(path);
		//设置post方法参数
		NameValuePair[] postdata=new NameValuePair[2];
		postdata[0]=new NameValuePair("name","zty");
		postdata[1]=new NameValuePair("password","123456");
		//执行,返回状态码
		int statuscode=httpclient.executeMethod(pm);
		System.out.println("*******");
		//针对状态码处理(先针对200)
		
		if(statuscode==HttpStatus.SC_OK){
			System.out.println(200);
			in=pm.getResponseBodyAsStream();
			//得到文件名
			String filename=path.substring(path.lastIndexOf('/')+1);
			//获得文件输出流
			out=new FileOutputStream(filename);
			//输出到文件
			int tempbyte=-1;
			while((tempbyte=in.read())>0){
				out.write(tempbyte);
			}
			//关闭输入输出流
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
		 * 测试代码
		 */
	
	public static void main(String[] aaa) throws IOException{
		//抓取网页并输出
		try{
			RetrivePage.downloadPage("http://write.blog.csdn.net/");
		}catch(HttpException e){
			e.printStackTrace();
		}
	}
	

}

