package Socket;

import java.io.Closeable;
import java.io.IOException;

public class Closeio 
{
	public static void closeio(Closeable... io) //关闭流的工具
	{
		for(Closeable temp:io){    //遍历所有流
			if(temp!=null){
				try {
					temp.close();     //不为空则关闭
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}
