package identify_personalinformation;
import java.util.Scanner;
public class Identify_personalinformation
{
	public static void main(String[] args)
	{
		String name="һ��ʺ";
		String opassword="someshit";
		Scanner scan=new Scanner(System.in);
		System.out.println("�����¼����");
		String username=scan.nextLine();
		System.out.println("�������룺");
		String password=scan.nextLine();
		if(!username.equals(name))
		{
			System.out.println("name wrong!");
		}
		else if(!password.equals(opassword))
		{
			System.out.println("password wrong!");
		}
	   else{ System.out.println("congratulation!");}
	}

}
