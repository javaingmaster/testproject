package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
    	List<Result> l=new ArrayList<Result>();
    	
        Result resultplus = JUnitCore.runClasses(TestBasicPlus.class);
        Result resultsub = JUnitCore.runClasses(TestBasicSub.class);
        Result resultmul = JUnitCore.runClasses(TestBasicMul.class);
        Result resultdiv = JUnitCore.runClasses(TestBasicDiv.class);
        Result resultpow = JUnitCore.runClasses(TestBasicPow.class);
        Result resultlog = JUnitCore.runClasses(TestBasicLog.class);
        Result resultln = JUnitCore.runClasses(TestBasicLn.class);
        Result resulttf = JUnitCore.runClasses(TestBasicTf.class);
        Result resultequal = JUnitCore.runClasses(TestEqual.class);
        Result resultwithout = JUnitCore.runClasses(TestComputeWithoutR.class);
        Result multitest = JUnitCore.runClasses(MultiTest.class);
        Result complexcompute = JUnitCore.runClasses(TestComplexCompute.class);
        l.add(resultplus);
        l.add(resultsub);
        l.add(resultmul);
        l.add(resultdiv);
        l.add(resultpow);
        l.add(resultlog);
        l.add(resultln);
        l.add(resulttf);
        l.add(resultequal);
        l.add(resultwithout);
        l.add(multitest);
        l.add(complexcompute);
        
        for(int i=0;i<l.size();i++){
        	Result r=l.get(i);
        	for (Failure failure : r.getFailures()) {
                System.out.println(failure.toString());
            }
        	System.out.println(r.wasSuccessful());
        	System.out.println();
        } 
    }
}
