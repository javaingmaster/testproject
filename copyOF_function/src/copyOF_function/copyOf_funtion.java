
package copyOF_function;
import java.util.Arrays;
public class copyOf_funtion
{
	public static void main(String[] args)
	{
	String a[]={"shit","laji","feizi"};
	int add[]={1,2,3,4,5};
	int index=0;
	while(index<a.length)
	{
		System.out.println(a[index]);
	}
    int b[]=Arrays.copyOf(a,6);
    index=0;
    while(index<b.length)
	{
		System.out.println(b[index]);
	}
	}
}
