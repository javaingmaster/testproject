package zty.acm.demo;

public class SimpleSort {
	
	public void simpleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int u=0;u<arr.length;u++){
			System.out.print(arr[u]+" ");
		}
	}
	
	public static void main(String[] aaa){
		int[] a={2,6,8,4,1,65,0,97,5};
		SimpleSort s=new SimpleSort();
		s.simpleSort(a);
	}

}
