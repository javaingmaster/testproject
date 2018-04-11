package 图论的并行算法;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public final int max=Integer.MAX_VALUE;
	public int m,n;
	public int[][] times;
	public mylist[] list;
	
	public Main(){
		Scanner s=new Scanner(System.in);
		this.n=s.nextInt();
		this.m=s.nextInt();
		list=new mylist[n];

	    times=new int[n][n];    
	    for(int i=0;i<n;i++){
	    	list[i]=new mylist();
			list[i].a=new ArrayList<Integer>();
			
	    	for(int j=0;j<n;j++){
	    		if(i==j){
	    			times[i][j]=0;
	    		}else{
	    			times[i][j]=max;
	    		}	
	    	}
	    }  
	    for(int i=0;i<m;i++){
	    	int from=s.nextInt();
	    	int to=s.nextInt();
	    	int times=s.nextInt();
	    	if((from-1)!=n-1){
	    		list[to-1].a.add(from-1);
	    	}
	    	this.times[to-1][from-1]=this.times[from-1][to-1]=times;   	
	    } 
	    for(int i=0;i<n;i++){    
		   if(list[i].a.contains(0)){
			   for(int k=0;k<list[i].a.size();k++){
				   if(list[i].a.get(k).equals(0)){
					   list[i].a.remove(k);
					   break;
				   }
			   }		  
			   list[i].a.add(0);
		   }
	    }	    
	}
	public void process(){
		Stack<Integer> left=new Stack<Integer>();
		Stack<Integer> right=new Stack<Integer>();
		int roadmax=0,cmp=0,rightindex=0;	
		int result=max;
		left.push(n-1);
		
		while(!left.isEmpty()){
			if(rightindex<list[left.peek()].a.size()&&!list[left.peek()].a.get(rightindex).equals(0)){	
				if(!left.contains(list[left.peek()].a.get(rightindex))){
					cmp=times[left.peek()][(int)(list[left.peek()].a.get(rightindex))];		
					if(cmp>roadmax)
						roadmax=cmp;
					
					left.push((int)list[left.peek()].a.get(rightindex));
					right.push(rightindex);
					rightindex=0;
				}else{
					rightindex++;
					continue;
				}
			}else if(rightindex<list[left.peek()].a.size()&&list[left.peek()].a.get(rightindex).equals(0)){
				cmp=times[left.peek()][(int)(list[left.peek()].a.get(rightindex))];		
				if(cmp>roadmax)
					roadmax=cmp;
				
				if(roadmax<result){
					result=roadmax;
					roadmax=0;
				}
					
				int pop=left.pop();
				if(left.isEmpty())
					break;
				
				rightindex=right.pop();
				rightindex++;
				continue;
			}else{
				int pop=left.pop();
				if(left.isEmpty())
					break;
				
				rightindex=right.pop();
				rightindex++;
				continue;
			}		
		}
		System.out.println(result);
	}	
	public static void main(String[] args){
		Main d=new Main();
		d.process();
	}
		
	class mylist{
		ArrayList a;
	}
	
}
