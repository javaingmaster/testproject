package test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import zty.java.junit.Calculate;

public class AnotationTest {
	//@Test:把方法修饰成测试方法
	
	//@Test用法 断言异常 对运行时间限定
	@Test(expected=ArithmeticException.class)
	public void testdiv(){
		assertEquals(6,new Calculate().div(12, 0));
	}
	
	//@ignore修饰的方法被测试运行器忽略
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
