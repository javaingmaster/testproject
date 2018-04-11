package getinfo;

public class getinfo 
{
	public void fun()
	{
		System.out.println("oh! shit!");
	}
}

class getinfotwo extends getinfo
{
	public void fun()
	{
		System.out.println("oh! some shit!");
		super.fun();
	}
}
class test
{
	public static void main(String[] agrs)
	{
		getinfotwo a=new getinfotwo();
		a.fun();
	}
}