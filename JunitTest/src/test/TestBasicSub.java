package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Sub;


@RunWith(Parameterized.class)
public class TestBasicSub{
    public double expect;
    public double input;


    public TestBasicSub(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=Sub.sub(2, 3);
    	double rs2=Sub.sub(3, 3);
    	double rs3=Sub.sub(4, 3);
    	double rs4=Sub.sub(12, 3);
    	double rs5=Sub.sub(7, 1);
        return Arrays.asList(new Object[][] {
                { -1, rs1 },
                { 0, rs2 },
                { 1, rs3},
                { 9, rs4 },
                { 8, rs5 }
        });
    }

	@Test
    public void test_sub() {
    	assertEquals(expect,input,0.00);
    }
}
