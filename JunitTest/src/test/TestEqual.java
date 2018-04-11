package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import project.Div;
import project.Equal;

@RunWith(Parameterized.class)
public class TestEqual{
    public boolean expect;
    public boolean input;


    public TestEqual(boolean expect,boolean input){
        this.expect=expect;
        this.input=input;
    }
      
    @Parameterized.Parameters
    public static Collection data() {
    	boolean rs1=Equal.equal("(3+6)*7");
    	boolean rs2=Equal.equal("(3+6)*7-1");
    	boolean rs3=Equal.equal("(3+6)*7)");
    	boolean rs4=Equal.equal("(*3+6)*7");
    	boolean rs5=Equal.equal("-(3+6)*7");
        return Arrays.asList(new Object[][] {
                { true, rs1 },
                { true, rs2 },
                { true, rs3 },
                { true, rs4 },
                { true, rs5 }
        });
    }

	@Test
    public void test_equal() {
    	assertEquals(expect,input);
    }
}

