import java.util.Scanner;


public class getweishu 
{
		zuobiao imput()
		{
			zuobiao s=new zuobiao();
			System.out.print("ÇëÊäÈëÃÔ¹¬xÎ¬Êı:");
			Scanner in=new Scanner(System.in);
			s.x = in.nextInt(); 
			System.out.print("ÇëÊäÈëÃÔ¹¬yÎ¬Êı:");
			s.y = in.nextInt(); 
			return s;
		} 
}
