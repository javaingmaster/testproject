package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Pow;


@RunWith(Parameterized.class)
public class TestBasicPow{
    public double expect;
    public double input;


    public TestBasicPow(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=Pow.pow(2, 3);
    	double rs2=Pow.pow(3, 3);
    	double rs3=Pow.pow(4, 3);
    	double rs4=Pow.pow(12, 2);
    	double rs5=Pow.pow(7, 1);
        return Arrays.asList(new Object[][] {
                { 8, rs1 },
                { 27, rs2 },
                { 64, rs3},
                { 144, rs4 },
                { 9, rs5 }
        });
    }

	@Test
    public void test_pow() {
    	assertEquals(expect,input,0.00);
    }
}
