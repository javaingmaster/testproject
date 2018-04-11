package zty.java.restart;

public class myExtend {
	/*
	 * 对象 a instanceof 类b 表示a是否是b的一个实例
	 * getclass是返回运行时侯真实加载的类
	 * 
	 * 
	 * 在继承层次中转换的时候要使用instanceof Manager检验
	 * 例如food类是noodles的父类，现在把food转成noodles
	 * if(myfood instanceof noodles){
	 * mynoodles=(noodles)myfood;
	 * }
	 * 
	 * 
	 */
	//私有构造器
	private myExtend(){}
	//公共构造器
	public myExtend(String name){
		System.out.println(name);
	}
	//无参数方法
	public void test(){
		System.out.println("this is myextendtest");
	}
	//带参数方法
	public void test(String name){
		System.out.println(name);
	}
	//内部类
	class inner{
	}

}
