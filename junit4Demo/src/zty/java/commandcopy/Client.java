package zty.java.commandcopy;

public class Client {
	public static void main(String[] a){
		Receiver r=new Receiver();  //junit���Կ��
		
		Command c=new CommandImp(r); //�ͻ��Լ���д��ʵ��
		
		Invoker iv=new Invoker(c); //��ܵ�������
		iv.call();
	}
}
