package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Mul;
import project.Plus;

@RunWith(Parameterized.class)
public class TestBasicMul {
    public double expect;
    public double input;


    public TestBasicMul(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=Mul.mul(2, 3);
    	double rs2=Mul.mul(0, 3);
    	double rs3=Mul.mul(4, 3);
    	double rs4=Mul.mul(12, 3);
    	double rs5=Mul.mul(7, 1);
        return Arrays.asList(new Object[][] {
                { 6, rs1 },
                { 0, rs2 },
                { 12, rs3},
                { 36, rs4 },
                { 9, rs5 }
        });
    }

	@Test
    public void test_mul() {
    	assertEquals(expect,input,0.00);
    }
}
