package 正则表达式;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreatePattern {
	public static void main(String[] aaa){
		String str="a,b,cc";
		String str2="a4b5cc";	
		System.out.println(Arrays.toString(str.split(",")));
		System.out.println(Arrays.toString(str2.split("\\d")));
	}

}
