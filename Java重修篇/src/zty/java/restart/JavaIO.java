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
	 * 抽象类inputstream和outputstream以一个字节为单位读取和写入
	 * 因此不方便处理unicode编码
	 * 对此，抽象类Reader和Writer继承他们，专门来处理unicode编码
	 * 
	 * 先来说读写字节
	 * inputstream的read抽象方法读入一个字节并返回它，在结尾部分返回-1
	 * 在真正使用的时候要从覆盖这个方法提供实用功能
	 * 
	 * 比如FileInputStream的read方法从某个文件中读取一个字节，（System.in是InputStream一个子类预定义对象）
	 * 但是是键盘读入信息
	 * 
	 * 总而言之在使用InputStream的read以及其他方法时一定要覆盖read。
	 * 
	 * OutputStream的write方法向某个地方输出一个字节
	 * read和write方法会在执行时阻塞直到字节被读入或写出，也就是说在该方法的流在恢复可用之前，该线程可以做别的事情
	 * available可以检查当前可读入字节的数量，那么以下是无法阻塞的输入流代码：
	 * 
	 * int available=in.available();
	 * if(available>0){
	 *   byte[] data=new byte[available];
	 *   in.read(data);
	 * }
	 * 
	 * 流操作之后一定要关闭数据
	 * 以上所讲为原生字节操作，下面来系统讲一下流家族.
	 * 
	 * 处理字节则是用InputStream和OutputStream的子类，处理字符则是用reader和writer的子类 
	 * 想要更强大的功能一定是要强大的子类
	 * 
	 * 我们要用流读入正确的数据必须自己去组合输入流
	 * 比如我现在要读取一个文件中的数据，这个文件上记录了很多数值的数据
	 * 通过分析，我们先要用FIleInputStream来读入文件中的字节，然后再用DataInputStream从字节中读取数值的数据
	 * 因为DataInputStream没有从文件读取字节流的功能，而FileInputStream也没有从字节中读取数值型数据的功能
	 * 因此我们要这样组合流
	 * 代码如下：
	 * FileInputStream fin=new FileInputStream(path);
	 * DataInputStream din=new DataInputStream(fin);
	 * double s=din.readDouble();
	 * 这里可以看出对文件操作的流都是InputStream和OutputStream类的扩展
	 * 它们读取的都是字节
	 * 
	 * 但通常情况下，我们需要一个缓冲区来存储流中的数据，因为流是不会被缓存的
	 * 如果要缓冲流数据我们则需要用另一个构造器
	 * 以下是修改上面的代码为缓冲代码：
	 * DataInputStream din=new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
	 * 我们把DataInputStream放到最后是因为我们希望使用DataInputStream的功能
	 * 
	 * 有时候我们需要预览下一个要读入的数据看看是不是满足某种情况，如果不满足则不读入
	 * 那么我们需要一个用于预览的回推流PushbackInputStream
	 * 以下修改上面的代码:
	 * DataInputStream din=new DataInputStream(new PushbackInputStream(new BufferedInputStream(new FileInputStream(path))));
	 * 以上我们可以用这个组合来预览读入的数字以及回推效果。
	 * 
	 * 现在我们已经大概了解了流组合的灵活多变
	 * 
	 * 比如我们现在想获得一个zip文件中的数值数据，代码如下:
	 * DataInputStream din=new DataInputStream(new ZipInputStream(new FileinputStream(path)));
	 * 
	 * 下面说一下输出流
	 * FileOutputStream(String name)
	 * FileOutputStream(String name,boolean append)
	 * FileOutputStream(File file)
	 * FileOutputStream(File file,boolean append)
	 * 用字符串和文件指针都可以来对一个文件来创建输出流，但是如果append为false时，所创建的输出流会把原来同名文件删除
	 * true则是追加
	 * BufferedOutputStream() 缓冲的输出输入流是知道缓冲区满才执行读入或写出
	 * 
	 * PushbackInputStream(InputStream in)
	 * PushbackInputStream(InputStream in,int size)
	 * 回推流是可以指定回推字节的大小size
	 * 方法unread回推一个字节，并且下次调用read可以再被获取
	 * 
	 * 下面我们讲一下文本的存储方式以及涉及到的输出和输入
	 * 这是一个很大的问题，因为不同的字符可能所用不通的编码方式
	 * 那么如果我们要正确的存储再输入输出这种字符，我么就要知道它的编码方式，再根据正确的编码方式来操作
	 * 比如我们用键盘输入信息，并让他转成unicode，代码如下：
	 * InputStreamReader in=new InputStreamReader(System.in);
	 * 这个输入流的读取器会假定使用主机系统使用的默认字符编码方式，但是我们可以参数改变编码方式，例如：
	 * 在一个文件中以ISO8859_5的编码方式来读取字符数据元:
	 * InputStreamReader in=new InputStreamReader(new FileInputStream(path,"ISO8859_5"));
	 * 
	 * 那么以正确的方式读入数据之后，我们要如何写出数据呢？
	 * 我们可以用PrintWriter来打印文本格式的字符串、数字、甚至是文件。
	 * PrintWriter out=new PrintWriter(path);
	 * 这行代码相当于:PrintWriter out=new PrintWriter(new FileWriter(path));
	 * PrintWriter（是带有缓冲区的）将要被输出的字符转换成字节最终写入文件中。
	 * PrintWriter out=new PrintWriter(path,true);
	 * 上面的代码则是启动自动冲刷功能，每次out调用printIn时都会将缓冲区所有数据冲刷一次
	 * 
	 * 我们可以将任何数据通过PrintWriter以文本的方式写出，但是我们如何读入文本呢？
	 * 上面我们说过以二进制格式写出要使用DataOutputStream而文本格式使用PrintWriter
	 * 当然是Scanner
	 * 
	 * 读写二进制数据DataInputStream/DataOutputStream
	 * 
	 * 随机访问文件RandomAccessFile
	 * 这个类实现了inputstream和outputstream的方法
	 * 可以在一个文件中操纵文件指针来读写数据
	 * 构造器除了第一个参数是path之外，第二个参数指定操作方式"r":读/"rw":写
	 * seek方法可以将文件指针设置到文件任意位置，位置从0到文件总字节数
	 * getFilePointer返回文件指针当前位置
	 * length方法可以返回文件总字节数
	 */
     
	/**
	 * 读取字符流
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
      * 缓冲字符流,适用于频繁io操作中
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
      * 依据InputStreamReader将输入转成字符流，然后利用缓冲流读取再写入文件
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
      * 随机文件应用RandomAccessFile
      */
     public void readByRandomAccessFile(String filepath,int startposition){
    	 RandomAccessFile randomfile=null;
    	 
    	 try {
			randomfile=new RandomAccessFile(filepath,"rw");
			long filelength=randomfile.length();
            if(filelength<startposition){
            	System.out.println("文件指针位置超越了文件大小!");
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
      * url流
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
      * 字节流
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
      * 字节缓冲高效流
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
