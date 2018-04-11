package zty.java.restart;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflect {

	public void reflectTest(){
Class<?> test=myExtend.class;
		
		Constructor[] ctors=test.getDeclaredConstructors();
		System.out.println("构造器如下: ");
		for(Constructor c: ctors){
			System.out.println(c);
		}
		
		//获取public构造器
		Constructor[] publicctors=test.getConstructors();
		System.out.println("public构造器如下:");
		for(Constructor c: publicctors){
			System.out.println(c);
		}
		
		
		//获取全部public方法
		Method[] mtds=test.getMethods();
		System.out.println("所有public方法如下: ");
		for(Method m:mtds){
			System.out.println(m);
		}
		
		//获取类里面指定方法
		System.out.println("获取指定方法带参数的test");
		try {
			System.out.println(test.getMethod("test", String.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取类的所有注释
		Annotation[] anns=test.getAnnotations();
		System.out.println("类所有注释如下：");
		for(Annotation a:anns){
			System.out.println(a);
		}
		//获得全部内部类
		Class<?>[] inners=test.getDeclaredClasses();
		System.out.println("所有内部类如下:");
		for(Class c:inners){
			System.out.println(c);
		}
		//使用Class.forName()方法加载内部类
		try {
			Class intest=Class.forName("zty.java.restart.myExtend$inner");
			
			//通过getDeclaringClass()访问该类所在的外部类
			System.out.println("intest对应的外部类是: "+intest.getDeclaringClass());
			//获得类所在的包
			System.out.println("test的包是: "+test.getPackage());
			//获取父类
			System.out.println("test的父类: "+test.getSuperclass());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
