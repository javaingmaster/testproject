package zty.java.restart;

import java.util.Arrays;

public final class JavaUnionFind {
	public int size;
	protected int[] pre;
	public JavaUnionFind(int size){
		this.size=size;
		this.pre=new int[size];
		pre[0]=0;
		pre[1]=0;
		pre[2]=1;
		pre[3]=3;
	}
	public int find(int point){
		int root=point;
		while(pre[root]!=root){
			root=pre[root];
		}
		int current=point;
		int process=point;
		
		while(current!=root){
			current=pre[current];
			pre[process]=root;
			process=current;
		}
		return root;
	}
	public void join(int pointone,int pointtwo){
		int rootone=find(pointone);
		int roottwo=find(pointtwo);
		if(rootone==roottwo){
			System.out.println(pointone+" 和 "+pointtwo+"是联通的");
		}else{
			pre[rootone]=roottwo;
		}
	}
	public void showPre(){
		System.out.println(Arrays.toString(pre));
	}
}
