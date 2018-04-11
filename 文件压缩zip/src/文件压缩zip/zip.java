package 文件压缩zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class zip 
{
	private void zip(String zipFileName,File inputFile)throws Exception
	{
		ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out,inputFile,"");
		System.out.println("压缩中..");
		out.close();
	}
	private void zip(ZipOutputStream out, File f,String base)throws Exception
	{
		if(f.isDirectory())
		{
			File[] fl=f.listFiles();
			out.putNextEntry(new ZipEntry(base+"/"));
			base=base.length()==0?"":base+"/";
			for(int i=0;i<fl.length;i++)
			{
				zip(out,fl[i],base+fl[i]);
			}
		}
		else
		{
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in=new FileInputStream(f);
			int b;
			System.out.println(base);
			while((b=in.read())!=-1)
			{
				out.write(b);
			}
			in.close();
		}
	}

	public static void main(String[] temp)
	{
		zip book=new zip();
		try
		{
			book.zip("D:/java.zip",new File("D:/javatest"));
			System.out.println("压缩完成！");
		}catch (Exception ex){			
		}
	}
}
