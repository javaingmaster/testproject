package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project.BasicCompute;
import project.ComplexCompute;
import project.Div;
import project.Equal;
import project.Ln;
import project.Mul;
import project.Plus;
import project.Pow;
import project.Sub;
import project.log;

public class MultiTest {
	  @BeforeClass
	   public static void beforeClass() {
	      System.out.println("This is multitest.");
	   }

	   @AfterClass
	   public static void  afterClass() {
	      System.out.println("multitest is over.");
	   }

	   @Before
	   public void before() {
	      System.out.println("-------------------------------------------------------------------");
	   }

	   @After
	   public void after() {
	      System.out.println("-------------------------------------------------------------------");
	   }

	   @Test
	   public void testfourarith() {
	      assertEquals(0.0,Div.div(0.0, Mul.mul(0.0, 4*Sub.sub(Plus.plus(3.5, 2.4), 8.4))),0.00);
	      assertEquals(5.0,Div.div(10.0, Mul.mul(1.5, 4*Sub.sub(Plus.plus(3.0, 2.0), -3.0))),0.00);
	      assertEquals(5.0,Div.div(10.0, Mul.mul(1.5, 4*Sub.sub(Plus.plus(4.0, 2.0), 6.0))),0.00);
	   }

	   @Test
	   public void testtr() {
	      assertEquals(5.4,Pow.pow(2.1, log.log(2.6, Ln.Ln(6.7))),0.00);
	      assertEquals(3.2,Pow.pow(2.7, log.log(5.9, Ln.Ln(9.1))),0.00);
	      assertEquals(0.00,Pow.pow(3.7, log.log(7.4, Ln.Ln(5.5))),0.00);
	   }
	   
	   @Test
	   public void testmul(){
		   String formula="(9-4*5)+1-(7*4)/2";
		   if(Equal.equal(formula)){
			   ArrayList<Character> sign=new ArrayList<Character>();
			   sign.add('-');
			   sign.add('*');
			   ArrayList<Double> number=new ArrayList<Double>();
			   number.add(9.0);
			   number.add(4.0);
			   number.add(5.0);
			   assertEquals(-11,BasicCompute.compute_withoutR(sign, 0, sign.size(), number, 0),0);		  
			   sign.clear();
			   number.clear();
			   
			   sign.add('+');
			   sign.add('-');
			   sign.add('*');
			   sign.add('/');
			   number.add(-11.0);
			   number.add(1.0);
			   number.add(7.0);
			   number.add(4.0);
			   number.add(2.0);
			   assertEquals(-24.0,BasicCompute.compute_withoutR(sign, 0, sign.size(), number, 0),0);
			   sign.clear();
			   number.clear();
			   
		       String rs1=ComplexCompute.complexcompute(sign, number, formula);
		       assertEquals("-24.0",rs1);
		   }else{
			   System.out.println("formula is error!");
		   }
	   }
}
