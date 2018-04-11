package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Mul;
import project.TrigonometricFunction;

@RunWith(Parameterized.class)
public class TestBasicTf{
    public double expect;
    public double input;


    public TestBasicTf(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=TrigonometricFunction.sin(Math.PI/2);
    	double rs2=TrigonometricFunction.sin(0);
    	double rs3=TrigonometricFunction.cos(0);
    	double rs4=TrigonometricFunction.cos(3.14);
    	double rs5=TrigonometricFunction.tan(3.14);
        return Arrays.asList(new Object[][] {
                { 1, rs1 },
                { 0, rs2 },
                { 1, rs3},
                { -1, rs4 },
                { 1, rs5 }
        });
    }

	@Test
    public void test_tf() {
    	assertEquals(expect,input,0.00);
    }
}

