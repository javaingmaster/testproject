package 实验三;

import java.util.Scanner;

public class Lab3 
{
	public void average()
	{
		int sum=0;
		int sum2=0;
		int count=0;
		for(int i=0;i<50;i++)
		{
			sum+=(i+1);
		}
		double average=sum/50.0;
		System.out.println("average is: "+average);
		
		while(count<50)
		{
			sum2+=count+1;
			count++;
		}
		double average2=sum2/50.0;
		System.out.println("average is: "+average2);
	}
	
	public void function2()
	{
		String[] name={"aaa","bbb","ccc"};          
		System.out.println("input the name: ");
		Scanner scanner = new Scanner(System.in);
		String str=scanner.nextLine();
		for(int i=0;i<name.length;i++)
		{
			if(name[i].equals(str))
			{
				System.out.println("查有此人。");
				break;
			}else
			{
				System.out.println("查无此人。");
				break;
			}
		}
	}
	
	public void function3()
	{
		int count=10;
		for(int i=0;i<count;i++)
		{
			if(i==5)
			{
				break;
			}
			if(i==4)
			{
				System.out.println("break in: "+(i+1));
				break;
			}
			System.out.println(i+1);
		}
	}	
	
	public void function4()
	{
		int count=10;
		for(int i=0;i<count;i++)
		{
			if(i==4)
			{
				continue;
			}
			System.out.println(i+1);
		}
		System.out.println("continue in 5.");
	}
	
	public static void main(String[] args)
	{
		Lab3 a=new Lab3();
		a.average();
		System.out.println();
		a.function2();
		System.out.println();
		a.function3();
		System.out.println();
		a.function4();
	}

}
