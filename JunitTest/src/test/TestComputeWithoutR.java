package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.BasicCompute;
import project.Mul;

@RunWith(Parameterized.class)
public class TestComputeWithoutR {
    public double expect;
    public double input;


    public TestComputeWithoutR(double expect,double input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	ArrayList<Character> l=new ArrayList<Character>();
    	ArrayList<Double> b=new ArrayList<Double>();
    	l.add('+');
    	l.add('*');
    	b.add(5.0);
    	b.add(6.0);
    	b.add(3.0);
    	double rs1=BasicCompute.compute_withoutR(l, 0, l.size(), b, 0);
    	l.removeAll(l);
    	b.removeAll(b);
    	
    	l.add('*');
    	l.add('/');
    	l.add('-');
    	b.add(5.0);
    	b.add(6.0);
    	b.add(3.0);
    	b.add(-7.0);
    	double rs2=BasicCompute.compute_withoutR(l, 0, l.size(), b, 0);
    	l.removeAll(l);
    	b.removeAll(b);
    
    	l.add('*');
    	l.add('/');
    	l.add('-');
    	b.add(0.0);
    	b.add(6.0);
    	b.add(0.0);
    	b.add(7.0);
    	double rs3=BasicCompute.compute_withoutR(l, 0, l.size(), b, 0);

        return Arrays.asList(new Object[][] {
                { 23.0, rs1 },
                { 17.0, rs2 },
                { 7.0, rs3},
        });
    }

	@Test
    public void test_withoutR() {
    	assertEquals(expect,input,0.00);
    }
}
