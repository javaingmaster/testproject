package Socket;

import java.io.Closeable;
import java.io.IOException;

public class Closeio 
{
	public static void closeio(Closeable... io) //�ر����Ĺ���
	{
		for(Closeable temp:io){    //����������
			if(temp!=null){
				try {
					temp.close();     //��Ϊ����ر�
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}
