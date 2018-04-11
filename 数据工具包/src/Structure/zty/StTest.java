package Structure.zty;

import java.util.Scanner;

import Structure.zty.MyTree.TreeNode;

public class StTest 
{
	public void createtree(){
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		
		System.out.println(n+"**"+k);
	}
	public static void main(String[] aaa){
		StTest st=new StTest();	
		st.createtree();
	}
}
