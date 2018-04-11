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
 * ��ͬ���е����л�idҪһ�£��������໥���л��ͷ����л�
 * Ҳ����˵���ǿ�����������л�id�����ƿͻ��˵İ汾��ʹ��Ȩ
 * 
 * ����һ˵�������л��������澲̬��������Ϊ���л�ֻ������󣬶���̬�����������״̬
 * 
 * ���ڳ��������л����⣬���һ������ʵ�����л�������û��ʵ�֣���ô�����е����Խ��������л�
 * �����Ҫ���಻ʵ�����л��ӿڻ��ܱ����л�����Ҫ����޲ι����������︸�������Ĭ��Ϊ�����ж����Ĭ��ֵ
 * �����Ҫ�����Զ��壬���ڹ����������
 * 
 * transient�ؼ��ֿ��Է�ֹĳ�����Բ������л����𵽱�������
 * 
 * ���Զ����û��Զ����writeObject��readObject�������������û��������л�����
 * ��̬�ı����л���ֵ���Դ˼���
 * 
 * ���ͬһ���������л���ε�һ���ļ�����ô����ļ���С����ӱ�
 * ���ǵ���Դ���⣬javaֻ���л�һ���������ݣ�ͬ���Ķ���ֻ������һ������
 * �����ļ��Ĵ�С���ӵĲ��������õȿ�����Ϣ���ֽ����������Ƿ���������
 * 
 * �����ʱ��ȡ��Щͬ���Ķ��󣬻ᷢ�����ǵ�����ֵ���
 * 
 * 
 * 
 * @author ��͢��
 *
 */
public class SerializableTest implements Serializable{
	
	//����һ
	/*private static final long serialVersionUID = 1L;
    public static int staticVar = 5;
    public static void main(String[] args) {
        try {
            //��ʼʱstaticVarΪ5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(new SerializableTest());
            out.close();
 
            //���л����޸�Ϊ10
            SerializableTest.staticVar = 10;
 
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            SerializableTest t = (SerializableTest) oin.readObject();
            oin.close();
             
            //�ٶ�ȡ��ͨ��t.staticVar��ӡ�µ�ֵ
            System.out.println(t.staticVar);
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
	
	//���Զ�
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
	         System.out.println("ԭ����:" + password);
	         password = "encryption";//ģ�����
	         putFields.put("password", password);
	         System.out.println("���ܺ������" + password);
	         out.writeFields();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }
	 }
	  
	 private void readObject(ObjectInputStream in) {
	     try {
	         GetField readFields = in.readFields();
	         Object object = readFields.get("password", "");
	         System.out.println("Ҫ���ܵ��ַ���:" + object.toString());
	         password = "pass";//ģ�����,��Ҫ��ñ��ص���Կ
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
	         System.out.println("���ܺ���ַ���:" + t.getPassword());
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
