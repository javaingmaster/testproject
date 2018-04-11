package zty.java.restart;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflect {

	public void reflectTest(){
Class<?> test=myExtend.class;
		
		Constructor[] ctors=test.getDeclaredConstructors();
		System.out.println("����������: ");
		for(Constructor c: ctors){
			System.out.println(c);
		}
		
		//��ȡpublic������
		Constructor[] publicctors=test.getConstructors();
		System.out.println("public����������:");
		for(Constructor c: publicctors){
			System.out.println(c);
		}
		
		
		//��ȡȫ��public����
		Method[] mtds=test.getMethods();
		System.out.println("����public��������: ");
		for(Method m:mtds){
			System.out.println(m);
		}
		
		//��ȡ������ָ������
		System.out.println("��ȡָ��������������test");
		try {
			System.out.println(test.getMethod("test", String.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡ�������ע��
		Annotation[] anns=test.getAnnotations();
		System.out.println("������ע�����£�");
		for(Annotation a:anns){
			System.out.println(a);
		}
		//���ȫ���ڲ���
		Class<?>[] inners=test.getDeclaredClasses();
		System.out.println("�����ڲ�������:");
		for(Class c:inners){
			System.out.println(c);
		}
		//ʹ��Class.forName()���������ڲ���
		try {
			Class intest=Class.forName("zty.java.restart.myExtend$inner");
			
			//ͨ��getDeclaringClass()���ʸ������ڵ��ⲿ��
			System.out.println("intest��Ӧ���ⲿ����: "+intest.getDeclaringClass());
			//��������ڵİ�
			System.out.println("test�İ���: "+test.getPackage());
			//��ȡ����
			System.out.println("test�ĸ���: "+test.getSuperclass());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
