package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.ComplexCompute;
import project.Pow;

@RunWith(Parameterized.class)
public class TestComplexCompute{
    public String expect;
    public String input;


    public TestComplexCompute(String expect,String input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	ArrayList<Character> sign=new ArrayList<Character>();
    	ArrayList<Double> number=new ArrayList<Double>();
    	String display="(3-(5*4)/2)+1";
    	
    	String rs1=ComplexCompute.complexcompute(sign, number, display);
    	System.out.println(rs1);
    	
        return Arrays.asList(new Object[][] {
                { "-6.0", rs1 } ,            
        });
    }

	@Test
    public void test_cc() {
    	assertEquals(expect,input);
    }
}
