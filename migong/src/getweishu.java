import java.util.Scanner;


public class getweishu 
{
		zuobiao imput()
		{
			zuobiao s=new zuobiao();
			System.out.print("�������Թ�xά��:");
			Scanner in=new Scanner(System.in);
			s.x = in.nextInt(); 
			System.out.print("�������Թ�yά��:");
			s.y = in.nextInt(); 
			return s;
		} 
}
