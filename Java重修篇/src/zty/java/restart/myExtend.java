package zty.java.restart;

public class myExtend {
	/*
	 * ���� a instanceof ��b ��ʾa�Ƿ���b��һ��ʵ��
	 * getclass�Ƿ�������ʱ����ʵ���ص���
	 * 
	 * 
	 * �ڼ̳в����ת����ʱ��Ҫʹ��instanceof Manager����
	 * ����food����noodles�ĸ��࣬���ڰ�foodת��noodles
	 * if(myfood instanceof noodles){
	 * mynoodles=(noodles)myfood;
	 * }
	 * 
	 * 
	 */
	//˽�й�����
	private myExtend(){}
	//����������
	public myExtend(String name){
		System.out.println(name);
	}
	//�޲�������
	public void test(){
		System.out.println("this is myextendtest");
	}
	//����������
	public void test(String name){
		System.out.println(name);
	}
	//�ڲ���
	class inner{
	}

}
