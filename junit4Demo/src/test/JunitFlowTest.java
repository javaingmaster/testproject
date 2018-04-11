package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitFlowTest {
    //���з�������ǰ���У������౻���غ�ͻ�����
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before");
	}
	//ͨ��������Դ�����ر����ݿ������
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after");
	}

	//up down��ÿһ������ǰ���ִ��һ��
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
