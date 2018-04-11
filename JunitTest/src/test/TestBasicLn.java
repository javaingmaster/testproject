package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Ln;
import project.log;

@RunWith(Parameterized.class)
public class TestBasicLn {
    public double expect;
    public double input;


    public TestBasicLn(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=Ln.Ln(Math.E);
    	double rs2=Ln.Ln(Math.E*Math.E);
    	double rs3=Ln.Ln(Math.E*Math.E*Math.E);
    	double rs4=Ln.Ln(Math.E*Math.E*Math.E*Math.E);
    	double rs5=Ln.Ln(2*Math.E*Math.E);
        return Arrays.asList(new Object[][] {
                { 1, rs1 },
                { 2, rs2 },
                { 3, rs3},
                { 4, rs4 },
                { 2, rs5 }
        });
    }

	@Test
    public void test_ln() {
    	assertEquals(expect,input,0.00);
    }
}
