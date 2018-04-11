package hanoitower;
import java.util.Scanner;

public class hanoitower 
{	
	public static void move(int level,char from,char help,char to)
	{
		if(level==1){    System.out.println("从"+from+"移动盘子到"+to);		}
		else
		{
			move(level-1,from,to,help);
			System.out.println("从"+from+"移动盘子到"+to);
            move(level-1,help,from,to);
		}		
	}
public static void main(String[] args)
{
	Scanner scan=new Scanner(System.in);
	System.out.println("input level");
	int a=scan.nextInt();
	if(a<1) {System.out.println("error!"); System.exit(0);}
	move(a,'A','B','C');
}
}
