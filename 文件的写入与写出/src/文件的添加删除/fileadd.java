package �ļ������ɾ��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileadd 
{
	public static void main(String[] args)
	{
		File fileone=new File("D:/javatest","tset.txt");
		if(fileone.exists())
		{
			String name=fileone.getName();
			long length=fileone.length();
			boolean hidden=fileone.isHidden();
			System.out.println("name is "+name+" and length is "+length+" and the file is "+hidden+" ����");
	  	}
		else
		{
			try
			{
				fileone.createNewFile();	
				System.out.println("create it.");
				FileOutputStream out= new FileOutputStream(fileone);
				byte buy[]="�Ͽ�ѽſ٣�����".getBytes();
				out.write(buy);
				out.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
				FileInputStream in=new FileInputStream(fileone);
				byte message[]=new byte[1024];
				int len=in.read(message);
				System.out.println("�ļ�����Ϣ��:"+new String(message,0,len));
				in.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
