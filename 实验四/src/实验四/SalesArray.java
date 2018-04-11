package สตั้หฤ;

public class SalesArray 
{
	public void f3()
	{
		int sum=0;
		int w=1;
		String[][] a={
				{" ","quarter1","quarter2","quarter3","quarter4","total"},
				{"dept.1","750","660","910","800",""},
				{"dept.2","800","700","950","900",""},
				{"dept.3","700","600","750","600",""},
				{"dept.4","850","800","1000","950",""},
				{"dept.5","900","800","960","980",""},
				{"total","","","","",""}
		};
		
		for(int i=1;i<6;i++)
		{
			for(int j=1;j<5;j++)
			{
				sum+=Integer.parseInt(a[i][j]);
			}
			a[w][5]=String.valueOf(sum);
			w++;
			sum=0;
		}
		sum=0;
		w=1;
		for(int i=1;i<5;i++)
		{
			for(int j=1;j<6;j++)
			{
				sum+=Integer.parseInt(a[j][i]);
			}
			a[6][w]=String.valueOf(sum);
			w++;
			sum=0;
		}
		
		
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<6;j++)
			{
				System.out.printf("%12.9s",a[i][j]);
			}
			System.out.println();
		}
		
	}

}
