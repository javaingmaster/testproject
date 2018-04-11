package test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import zty.java.junit.Calculate;

public class AnotationTest {
	//@Test:�ѷ������γɲ��Է���
	
	//@Test�÷� �����쳣 ������ʱ���޶�
	@Test(expected=ArithmeticException.class)
	public void testdiv(){
		assertEquals(6,new Calculate().div(12, 0));
	}
	
	//@ignore���εķ�������������������
	@Ignore
	@Test(timeout=2000)
	public void testwhile(){
		while(true){
			System.out.println("run forever..");
		}
	}
	@Test(timeout=3000)
	public void readfile(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
