package Structure.zty;

public class Fibonacci {
	
	public int size;
	
	public Fibonacci(int size){
		this.size=size;
	}
	
	public int[] createfibonacciarray(){
		int[] f=new int[this.size];
	    f[0]=0;
	    f[1]=1;
	    for(int i=2;i<size;++i)
	        f[i]=f[i-1]+f[i-2];
	    
	    return f;
	}
	
	public int FibonacciSearch(int[] a, int n, int key){  //a为要查找的数组,n为要查找的数组长度,key为要查找的关键字
		  int low=0;
		  int high=n-1;	  
		  int[] f =  createfibonacciarray();
		  
		  int k=0;
		  while(n>f[k]-1)//计算n位于斐波那契数列的位置
		      ++k;

		  int[] temp;//将数组a扩展到F[k]-1的长度
		  temp=new int [f[k]-1];
		  for(int p=0;p<a.length;p++){
			  temp[p]=a[p];
		  }

		  for(int i=n;i<f[k]-1;++i)
		     temp[i]=a[n-1];
		  
		  while(low<=high)
		  {
		    int mid=low+f[k-1]-1;
		    if(key<temp[mid])
		    {
		      high=mid-1;
		      k-=1;
		    }
		    else if(key>temp[mid])
		    {
		     low=mid+1;
		     k-=2;
		    }
		    else
		    {
		       if(mid<n)
		           return mid; //若相等则说明mid即为查找到的位置
		       else
		           return n-1; //若mid>=n则说明是扩展的数值,返回n-1
		    }
		  }  
		  return -1;
		}

	public static void main(String[] aaa){
		Fibonacci f=new Fibonacci(20);
	    int a[] = {0,16,24,35,47,59,62,73,88,99};
	    int key=59;
	    int index=f.FibonacciSearch(a,a.length,key);
	    System.out.println(index);
	}
}
