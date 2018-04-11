package innerclass;

public class innerclass 
{
	int x=1;
	public void out()
	{
		System.out.println("shit!!!");
	}
	public class in
	{
		int x=2;
		public void out()
		{
			System.out.println("in shit!!!!");
		}
	}

}
class test
{
	public static void main(String[] agrs)
	{
		innerclass a=new innerclass();
		innerclass.in inone=new innerclass.in();
	}
}
