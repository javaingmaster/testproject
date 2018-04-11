package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zty.java.junit.Calculate;

public class CalculateTest {

	@Test
	public void testadd(){ //规范 test+方法名
		assertEquals(6,new Calculate().add(3, 3));//第一个参数是断言值
	}
	@Test
	public void testSubtract(){
		assertEquals(3,new Calculate().subtract(5, 2));
	}
	@Test
	public void testmul(){
		assertEquals(10,new Calculate().mul(5, 2));
	}
	@Test
	public void testdiv(){
		assertEquals(6,new Calculate().div(12, 2));
	}

}
//runs 测试方法有几个
//error抛出异常的方法
//failures失败的方法
//状态条 绿成功 红失败
//本次运行类列表