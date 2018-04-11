package zty.java.restart;

import java.util.Iterator;
import java.util.TreeSet;

public class NumberTheroy {
	public NumberTheroy(){
	}
	
	public boolean isPrime(int number){
		if(number==2){
			return true;
		}else if(number>2){
			if(number%2==0){
				return false;
			}else{
				for(int i=3;i<number;i+=2){
					if(number%i==0){
						return false;
					}
				}
				return true;
			}
		}else{
			System.out.println("输入的不是大于等于2的数");
			return false;
		}
	}
	
	public void getPrimeNumber(int[] arr){
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(int i=0;i<arr.length;i++){
			ts.add(arr[i]);
		}
		Iterator<Integer> iter=ts.iterator();
		while(iter.hasNext()){
			if(!(isPrime(iter.next()))){
				iter.remove();
			}
		}
		iter=ts.iterator();
		while(iter.hasNext()){
		System.out.println(iter.next());
		}	
	}
	
	public int getGreatestCommonDivisor(int x,int y){
		if(x%y==0){
			return y;
		}else{
			return (getGreatestCommonDivisor(y,x%y));
		}
	}
}
