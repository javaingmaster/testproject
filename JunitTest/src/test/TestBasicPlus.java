package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;

import project.Plus;

@RunWith(Parameterized.class)
public class TestBasicPlus {
    public double expect;
    public double input;


    public TestBasicPlus(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=Plus.plus(2, 3);
    	double rs2=Plus.plus(3, 3);
    	double rs3=Plus.plus(4, 3);
    	double rs4=Plus.plus(12, 3);
    	double rs5=Plus.plus(7, 1);
        return Arrays.asList(new Object[][] {
                { 5, rs1 },
                { 6, rs2 },
                { 7, rs3},
                { 15, rs4 },
                { 9, rs5 }
        });
    }

	@Test
    public void test_add() {
    	assertEquals(expect,input,0.00);
    }
}
