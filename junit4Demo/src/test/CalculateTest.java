package test;

import static org.junit.Assert.*;

import org.junit.Test;

import zty.java.junit.Calculate;

public class CalculateTest {

	@Test
	public void testadd(){ //�淶 test+������
		assertEquals(6,new Calculate().add(3, 3));//��һ�������Ƕ���ֵ
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
//runs ���Է����м���
//error�׳��쳣�ķ���
//failuresʧ�ܵķ���
//״̬�� �̳ɹ� ��ʧ��
//�����������б�