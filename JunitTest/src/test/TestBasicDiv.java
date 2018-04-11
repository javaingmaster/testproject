package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Div;

@RunWith(Parameterized.class)
public class TestBasicDiv{
    public double expect;
    public double input;


    public TestBasicDiv(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	double rs1=Div.div(2, 3);
    	double rs2=Div.div(3, 3);
    	double rs3=Div.div(4, 3);
    	BigDecimal bd=new BigDecimal(rs3);
    	rs3=bd.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    	double rs4=Div.div(12, 3);
    	double rs5=Div.div(7, 2);
        return Arrays.asList(new Object[][] {
                { 1.5, rs1 },
                { 1, rs2 },
                { 1.33, rs3},
                { 4, rs4 },
                { 3.4, rs5 }
        });
    }

	@Test
    public void test_div() {
    	assertEquals(expect,input,0.00);
    }
}
