package SerializableTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;

/**
 * 相同类中的序列化id要一致，否则不能相互序列化和反序列化
 * 也就是说我们可以用这个序列化id来控制客户端的版本、使用权
 * 
 * 测试一说明了序列化并不保存静态变量，因为序列化只保存对象，而静态变量属于类的状态
 * 
 * 对于超子类序列化问题，如果一个子类实现序列化，父类没有实现，那么父类中的属性将不被序列化
 * 如果想要父类不实现序列化接口还能被序列化，就要添加无参构造器，这里父类的属性默认为父类中定义的默认值
 * 如果想要有属性定义，则在构造器中添加
 * 
 * transient关键字可以防止某个属性不被序列化，起到保护作用
 * 
 * 测试二：用户自定义的writeObject和readObject方法可以允许用户控制序列化过程
 * 动态改变序列化数值，以此加密
 * 
 * 如果同一个对象被序列化多次到一个文件，那么这个文件大小不会加倍
 * 考虑到资源问题，java只序列化一个对象内容，同样的对象只是增加一个引用
 * 所以文件的大小增加的部分是引用等控制信息的字节数，而不是翻倍的增加
 * 
 * 如果此时读取这些同样的对象，会发现他们的引用值相等
 * 
 * 
 * 
 * @author 周廷宇
 *
 */
public class SerializableTest implements Serializable{
	
	//测试一
	/*private static final long serialVersionUID = 1L;
    public static int staticVar = 5;
    public static void main(String[] args) {
        try {
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(new SerializableTest());
            out.close();
 
            //序列化后修改为10
            SerializableTest.staticVar = 10;
 
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            SerializableTest t = (SerializableTest) oin.readObject();
            oin.close();
             
            //再读取，通过t.staticVar打印新的值
            System.out.println(t.staticVar);
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
	
	//测试二
	 private static final long serialVersionUID = 1L;
	 private String password = "pass";
	 public String getPassword() {
	     return password;
	 }
	 public void setPassword(String password) {
	     this.password = password;
	 }
	  
	 private void writeObject(ObjectOutputStream out) {
	     try {
	         PutField putFields = out.putFields();
	         System.out.println("原密码:" + password);
	         password = "encryption";//模拟加密
	         putFields.put("password", password);
	         System.out.println("加密后的密码" + password);
	         out.writeFields();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	  
	 private void readObject(ObjectInputStream in) {
	     try {
	         GetField readFields = in.readFields();
	         Object object = readFields.get("password", "");
	         System.out.println("要解密的字符串:" + object.toString());
	         password = "pass";//模拟解密,需要获得本地的密钥
	     } catch (IOException e) {
	         e.printStackTrace();
	     } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	     }
	  
	 }
	  
	 public static void main(String[] args) {
	     try {
	         ObjectOutputStream out = new ObjectOutputStream(
	                 new FileOutputStream("result.obj"));
	         out.writeObject(new SerializableTest());
	         out.close();
	  
	         ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
	                 "result.obj"));
	         SerializableTest t = (SerializableTest) oin.readObject();
	         System.out.println("解密后的字符串:" + t.getPassword());
	         oin.close();
	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	     }
	 }
}
