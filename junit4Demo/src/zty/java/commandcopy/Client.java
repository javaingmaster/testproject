package zty.java.commandcopy;

public class Client {
	public static void main(String[] a){
		Receiver r=new Receiver();  //junit测试框架
		
		Command c=new CommandImp(r); //客户自己编写的实例
		
		Invoker iv=new Invoker(c); //框架调用用例
		iv.call();
	}
}
