package zty.java.restart;

import java.math.BigDecimal;

public class aboutBigValue {
	/**
	 * BigInteger��BigDecimal���Դ���������λ�������͸�����
	 * �������������������
	 * ���Ǵ���ֵ�����㲻������ͨ��+��-��*��/��%
	 * ������add(),substract(),multiply(),divide(),mod()
	 */
	public void test(){
        BigDecimal bd=new BigDecimal(2147483647);//IntegerתBigDecimal
        BigDecimal value=new BigDecimal(1);
		System.out.println(bd.add(value));
	}
}
