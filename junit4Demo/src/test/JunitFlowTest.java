package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitFlowTest {
    //所有方法调用前进行，测试类被加载后就会运行
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before");
	}
	//通常用作资源清理，关闭数据库库连接
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after");
	}

	//up down在每一个方法前后各执行一次
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("down");
	}

	@Test
	public void test() {
		System.out.println("test");
	}
	@Test
	public void test2(){
		System.out.println("mytest");
	}

}
