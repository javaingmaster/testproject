import java.util.Scanner;
public class changenumber {

public static void main (String[] args)
{
	Scanner scan=new Scanner(System.in);
	System.out.println("input one");
	long a=scan.nextLong();
	System.out.println("input two");
	long b=scan.nextLong();
	System.out.println("A=");
	System.out.println(a);
	System.out.println("B=");
	System.out.println(b);
	System.out.println("÷¥––±‰¡øª•ªª°£");
	a=a^b; b=b^a; a=a^b;
	System.out.println("A=");
	System.out.println(a);
	System.out.println("B=");
	System.out.println(b);
}
}