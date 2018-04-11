package สตั้หฤ;

import java.util.Scanner;

public class Lab4
{
	public static void main(String[] args)
	{
		//new Lab4().f1();
		//new Lab4().f2();
	    new SalesArray().f3();
	}
	public void f1()
	{
	
	System.out.println("input the string: ");
	Scanner scanner = new Scanner(System.in);
	String a=scanner.nextLine();
	System.out.println("length of String is: "+a.length());
	System.out.println("first 5 bytes of string are: "+a.substring(0, 5));
	
	}
	
	public void f2()
	{
		int start=0;
		int k=1;
		System.out.println("input the string: ");
		Scanner scanner = new Scanner(System.in);
		String b =scanner.nextLine();
		for(int i=0;i<b.length();i++)
		{
			if(b.charAt(i)==',')
			{
				System.out.println(b.substring(start, i));
				start=i+1;
			}
			k=0;
		}
		for(int j=start;j<b.length();j++)
		{
			System.out.print(b.charAt(j));
		}
	}

}
