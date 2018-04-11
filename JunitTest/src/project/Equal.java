package project;

import java.util.ArrayList;
import java.util.Stack;

public class Equal{
	public static ArrayList<Character> sign;
	public static ArrayList<Double> number;
		
	public static boolean equal(String processString){
		
	    int leftc = 0, rightc = 0;
	    Stack<Integer> leftr = new Stack<Integer>();

	    for (int i = 0; i < processString.length(); i++) {
	        if (processString.charAt(i) == '(') {
	            leftc++;
	            leftr.push(i);
	        }
	        if (processString.charAt(i) == ')') {
	            rightc++;
	        }
	    }
	 
	    if(leftc!=rightc){
	    	return false;
	    }

	   
	    for (int i = 0; i < processString.length(); i++) {
	        if (i + 1 < processString.length() && i - 1 >= 0 && (processString.charAt(i) == '+' || processString.charAt(i) == '-' || processString.charAt(i) == '*' || processString.charAt(i) == '/')) {
	            if ((processString.charAt(i - 1) == '+' || processString.charAt(i - 1) == '-' || processString.charAt(i - 1) == '*' || processString.charAt(i - 1) == '/') || (processString.charAt(i + 1) == '+' || processString.charAt(i + 1) == '-' || processString.charAt(i + 1) == '*' || processString.charAt(i + 1) == '/')) {
	                System.out.println("表达式符号内容异常");
	                return false;
	            }
	        } else if (i != 0 && processString.charAt(i) == '(' && i + 1 < processString.length()) {
	            if ((processString.charAt(i - 1) <= '9' && processString.charAt(i - 1) >= '0') || (processString.charAt(i - 1) == ')') || (processString.charAt(i + 1) == '+') || (processString.charAt(i + 1) == '*') || (processString.charAt(i + 1) == '/')) {
	            	System.out.println("表达式符号内容异常");
	                return false;
	            }
	        } else if (i == 0 && processString.charAt(i) == '(' && i + 1 < processString.length()) {
	            if ((processString.charAt(i + 1) == '+') || (processString.charAt(i + 1) == '*') || (processString.charAt(i + 1) == '/')) {
	            	 System.out.println("表达式符号内容异常");
	                return false;
	            }
	        } else if (processString.charAt(i) == ')' && i != processString.length() - 1 && i - 1 >= 0) {
	            if ((processString.charAt(i + 1) <= '9' && processString.charAt(i + 1) >= '0') || (processString.charAt(i + 1) == '(') || (processString.charAt(i - 1) == '+') || (processString.charAt(i - 1) == '-') || (processString.charAt(i - 1) == '*') || (processString.charAt(i - 1) == '/')) {
	            	System.out.println("表达式符号内容异常");
	                return false;
	            }
	        } else if (processString.charAt(i) == ')' && i == processString.length() - 1 && i - 1 >= 0) {
	            if ((processString.charAt(i - 1) == '+') || (processString.charAt(i - 1) == '-') || (processString.charAt(i - 1) == '*') || (processString.charAt(i - 1) == '/')) {
	            	System.out.println("表达式符号内容异常");
	                return false;
	            }
	        } else if (i != 0 && processString.charAt(i) == '.' && i + 1 < processString.length()) {
	            if ((processString.charAt(i - 1) == '.' || processString.charAt(i + 1) == '.')) {
	            	System.out.println("表达式符号内容异常");
	                return false;
	            }
	        }
	    }

	    return true;
	    
	}
		
	
}
