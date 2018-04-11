package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Plus;
import project.Pow;
import project.log;

@RunWith(Parameterized.class)
public class TestBasicLog {
    public double expect;
    public double input;


    public TestBasicLog(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=log.log(2, 4);
    	double rs2=log.log(3, 3);
    	double rs3=log.log(4, 16);
    	double rs4=log.log(1, 3);
    	double rs5=log.log(7, 1);
        return Arrays.asList(new Object[][] {
                { 2, rs1 },
                { 1, rs2 },
                { 2, rs3},
                { 0, rs4 },
                { 1, rs5 }
        });
    }

	@Test
    public void test_log() {
    	assertEquals(expect,input,0.00);
    }
}
