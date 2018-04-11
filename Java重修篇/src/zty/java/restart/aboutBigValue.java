package zty.java.restart;

import java.math.BigDecimal;

public class aboutBigValue {
	/**
	 * BigInteger和BigDecimal可以处理任意数位的整数和浮点数
	 * 用来处理数据溢出问题
	 * 但是大数值得运算不能用普通的+、-、*、/、%
	 * 而是用add(),substract(),multiply(),divide(),mod()
	 */
	public void test(){
        BigDecimal bd=new BigDecimal(2147483647);//Integer转BigDecimal
        BigDecimal value=new BigDecimal(1);
		System.out.println(bd.add(value));
	}
}
