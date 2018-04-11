package zty.java.restart;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.URL;

public class JavaIO {
	//JavaIO jio=new JavaIO();
			//jio.readAsCharacter("D:\\3\\test.txt");
			//jio.readAsCharacterByBuffer("D:\\3\\test.txt");
			//jio.writeDataToFile("D:\\3\\testwrite.txt");
			//File f=new File("D:\\3\\tesdt.txt");
			//System.out.println(f.exists());
			//jio.readByRandomAccessFile("D:\\3\\testwrite.txt", 50);
			//jio.readUrlByBufferToFile("http://www.qq.com", "D:\\3\\urltxt.txt");
			//jio.readAsBinary("D:\\3\\testwrite.txt");
			//jio.readAsBinaryToFile("D:\\3\\testwrite.txt", "D:\\3\\readasbinarytofile.txt", 15);
	/**
	 * ������inputstream��outputstream��һ���ֽ�Ϊ��λ��ȡ��д��
	 * ��˲����㴦��unicode����
	 * �Դˣ�������Reader��Writer�̳����ǣ�ר��������unicode����
	 * 
	 * ����˵��д�ֽ�
	 * inputstream��read���󷽷�����һ���ֽڲ����������ڽ�β���ַ���-1
	 * ������ʹ�õ�ʱ��Ҫ�Ӹ�����������ṩʵ�ù���
	 * 
	 * ����FileInputStream��read������ĳ���ļ��ж�ȡһ���ֽڣ���System.in��InputStreamһ������Ԥ�������
	 * �����Ǽ��̶�����Ϣ
	 * 
	 * �ܶ���֮��ʹ��InputStream��read�Լ���������ʱһ��Ҫ����read��
	 * 
	 * OutputStream��write������ĳ���ط����һ���ֽ�
	 * read��write��������ִ��ʱ����ֱ���ֽڱ������д����Ҳ����˵�ڸ÷��������ڻָ�����֮ǰ�����߳̿������������
	 * available���Լ�鵱ǰ�ɶ����ֽڵ���������ô�������޷����������������룺
	 * 
	 * int available=in.available();
	 * if(available>0){
	 *   byte[] data=new byte[available];
	 *   in.read(data);
	 * }
	 * 
	 * ������֮��һ��Ҫ�ر�����
	 * ��������Ϊԭ���ֽڲ�����������ϵͳ��һ��������.
	 * 
	 * �����ֽ�������InputStream��OutputStream�����࣬�����ַ�������reader��writer������ 
	 * ��Ҫ��ǿ��Ĺ���һ����Ҫǿ�������
	 * 
	 * ����Ҫ����������ȷ�����ݱ����Լ�ȥ���������
	 * ����������Ҫ��ȡһ���ļ��е����ݣ�����ļ��ϼ�¼�˺ܶ���ֵ������
	 * ͨ��������������Ҫ��FIleInputStream�������ļ��е��ֽڣ�Ȼ������DataInputStream���ֽ��ж�ȡ��ֵ������
	 * ��ΪDataInputStreamû�д��ļ���ȡ�ֽ����Ĺ��ܣ���FileInputStreamҲû�д��ֽ��ж�ȡ��ֵ�����ݵĹ���
	 * �������Ҫ���������
	 * �������£�
	 * FileInputStream fin=new FileInputStream(path);
	 * DataInputStream din=new DataInputStream(fin);
	 * double s=din.readDouble();
	 * ������Կ������ļ�������������InputStream��OutputStream�����չ
	 * ���Ƕ�ȡ�Ķ����ֽ�
	 * 
	 * ��ͨ������£�������Ҫһ�����������洢���е����ݣ���Ϊ���ǲ��ᱻ�����
	 * ���Ҫ������������������Ҫ����һ��������
	 * �������޸�����Ĵ���Ϊ������룺
	 * DataInputStream din=new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
	 * ���ǰ�DataInputStream�ŵ��������Ϊ����ϣ��ʹ��DataInputStream�Ĺ���
	 * 
	 * ��ʱ��������ҪԤ����һ��Ҫ��������ݿ����ǲ�������ĳ�����������������򲻶���
	 * ��ô������Ҫһ������Ԥ���Ļ�����PushbackInputStream
	 * �����޸�����Ĵ���:
	 * DataInputStream din=new DataInputStream(new PushbackInputStream(new BufferedInputStream(new FileInputStream(path))));
	 * �������ǿ�������������Ԥ������������Լ�����Ч����
	 * 
	 * ���������Ѿ�����˽�������ϵ������
	 * 
	 * ����������������һ��zip�ļ��е���ֵ���ݣ���������:
	 * DataInputStream din=new DataInputStream(new ZipInputStream(new FileinputStream(path)));
	 * 
	 * ����˵һ�������
	 * FileOutputStream(String name)
	 * FileOutputStream(String name,boolean append)
	 * FileOutputStream(File file)
	 * FileOutputStream(File file,boolean append)
	 * ���ַ������ļ�ָ�붼��������һ���ļ���������������������appendΪfalseʱ������������������ԭ��ͬ���ļ�ɾ��
	 * true����׷��
	 * BufferedOutputStream() ����������������֪������������ִ�ж����д��
	 * 
	 * PushbackInputStream(InputStream in)
	 * PushbackInputStream(InputStream in,int size)
	 * �������ǿ���ָ�������ֽڵĴ�Сsize
	 * ����unread����һ���ֽڣ������´ε���read�����ٱ���ȡ
	 * 
	 * �������ǽ�һ���ı��Ĵ洢��ʽ�Լ��漰�������������
	 * ����һ���ܴ�����⣬��Ϊ��ͬ���ַ��������ò�ͨ�ı��뷽ʽ
	 * ��ô�������Ҫ��ȷ�Ĵ洢��������������ַ�����ô��Ҫ֪�����ı��뷽ʽ���ٸ�����ȷ�ı��뷽ʽ������
	 * ���������ü���������Ϣ��������ת��unicode���������£�
	 * InputStreamReader in=new InputStreamReader(System.in);
	 * ����������Ķ�ȡ����ٶ�ʹ������ϵͳʹ�õ�Ĭ���ַ����뷽ʽ���������ǿ��Բ����ı���뷽ʽ�����磺
	 * ��һ���ļ�����ISO8859_5�ı��뷽ʽ����ȡ�ַ�����Ԫ:
	 * InputStreamReader in=new InputStreamReader(new FileInputStream(path,"ISO8859_5"));
	 * 
	 * ��ô����ȷ�ķ�ʽ��������֮������Ҫ���д�������أ�
	 * ���ǿ�����PrintWriter����ӡ�ı���ʽ���ַ��������֡��������ļ���
	 * PrintWriter out=new PrintWriter(path);
	 * ���д����൱��:PrintWriter out=new PrintWriter(new FileWriter(path));
	 * PrintWriter���Ǵ��л������ģ���Ҫ��������ַ�ת�����ֽ�����д���ļ��С�
	 * PrintWriter out=new PrintWriter(path,true);
	 * ����Ĵ������������Զ���ˢ���ܣ�ÿ��out����printInʱ���Ὣ�������������ݳ�ˢһ��
	 * 
	 * ���ǿ��Խ��κ�����ͨ��PrintWriter���ı��ķ�ʽд��������������ζ����ı��أ�
	 * ��������˵���Զ����Ƹ�ʽд��Ҫʹ��DataOutputStream���ı���ʽʹ��PrintWriter
	 * ��Ȼ��Scanner
	 * 
	 * ��д����������DataInputStream/DataOutputStream
	 * 
	 * ��������ļ�RandomAccessFile
	 * �����ʵ����inputstream��outputstream�ķ���
	 * ������һ���ļ��в����ļ�ָ������д����
	 * ���������˵�һ��������path֮�⣬�ڶ�������ָ��������ʽ"r":��/"rw":д
	 * seek�������Խ��ļ�ָ�����õ��ļ�����λ�ã�λ�ô�0���ļ����ֽ���
	 * getFilePointer�����ļ�ָ�뵱ǰλ��
	 * length�������Է����ļ����ֽ���
	 */
     
	/**
	 * ��ȡ�ַ���
	 * @throws IOException 
	 */
     public void readAsCharacter(String filepath){
    	 InputStreamReader in=null;
    	 try {
			in=new InputStreamReader(new FileInputStream(filepath));
			int temp;
			char[] buffer=new char[100];
			
			while((temp=in.read(buffer))!=-1){
				for(int i=0;i<temp;i++){
					if(buffer[i]!='\n')
					System.out.print((char)buffer[i]+" ");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{	
				try {
					if(in!=null)
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
     }
     
     /**
      * �����ַ���,������Ƶ��io������
      */
     public void readAsCharacterByBuffer(String filepath){
    	 BufferedReader reader=null;
    	 try {
			reader=new BufferedReader(new FileReader(filepath));
			String line=null;
			
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
     }
     
     /**
      * ����InputStreamReader������ת���ַ�����Ȼ�����û�������ȡ��д���ļ�
      */
     public void writeDataToFile(String filepath){
    	 File f=new File(filepath);    
    	 
    	 BufferedReader reader=null;
    	 BufferedWriter writer=null;
    	 
    	 reader=new BufferedReader(new InputStreamReader(System.in));
    	 try {
			writer=new BufferedWriter(new FileWriter(filepath,f.exists()));
			
			String line=null;
			while((line=reader.readLine())!=null){
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
     }
     
     /**
      * ����ļ�Ӧ��RandomAccessFile
      */
     public void readByRandomAccessFile(String filepath,int startposition){
    	 RandomAccessFile randomfile=null;
    	 
    	 try {
			randomfile=new RandomAccessFile(filepath,"rw");
			long filelength=randomfile.length();
            if(filelength<startposition){
            	System.out.println("�ļ�ָ��λ�ó�Խ���ļ���С!");
            	//randomfile.writeDouble(17.3);
            	//randomfile.writeChars("sssss");
            }else{
            	randomfile.seek(startposition);
            	
    			byte[] bytes=new byte[10];
    			int temp;
    			while((temp=randomfile.read(bytes))!=-1){
    				System.out.println(new String(bytes,0,temp));
    			} 
    			//randomfile.writeDouble(17.3);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				randomfile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	 
     }
     
     
     /**
      * url��
      */
     public void readUrlByBufferToFile(String urlpath,String destfile){
    	 BufferedReader reader=null;
    	 BufferedWriter writer=null;
    	   	 
    	 try {
    		 URL url=new URL(urlpath);
			reader=new BufferedReader(new InputStreamReader(url.openStream()));
			writer=new BufferedWriter(new FileWriter(destfile,true));
			
			String line=null;
			
			while((line=reader.readLine())!=null){
				writer.write(line);
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{			
			try {
				writer.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
     }
     /**
      * �ֽ���
      */
     public void readAsBinary(String filepath){
    	 InputStream in=null;
    	 try {
			in=new FileInputStream(filepath);
			
			byte[] bytes=new byte[10];
			int temp;
			while((temp=in.read(bytes))!=-1){
				System.out.print(new String(bytes,0,temp)+" ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
     }
     
     /**
      * �ֽڻ����Ч��
      */
     public void readAsBinaryToFile(String filepath,String destfile,int buffersize){
    	 BufferedInputStream in=null;
    	 BufferedOutputStream out=null;
    	 
    	 try {
			in=new BufferedInputStream((new FileInputStream(filepath)),buffersize);
			out=new BufferedOutputStream(new FileOutputStream(destfile,true));
			byte[] bytes=new byte[10];
			int temp;
			
			while((temp=in.read(bytes))!=-1){
				out.write(bytes,0,temp);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
     }
}
