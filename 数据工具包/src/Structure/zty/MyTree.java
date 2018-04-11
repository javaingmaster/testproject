package Structure.zty;

import java.util.Scanner;

import Structure.zty.MyTree.TreeNode;
/*
 * you can design a tree structure.
 * 
 * Besides, you can control the number of children extending an element.
 */

public class MyTree{
	
	public TreeNode root;
	public int depth;
	public int leaves;
	public int mostbranch;
	
	public TreeNode initTree(){
		this.depth=1;
		return new TreeNode(1);
	}
	
	public void CreateSubTree(TreeNode root,int number){
		
		if(number>this.mostbranch){
			this.mostbranch=number;
		}
		
		this.leaves+=number;
		
		int newdepth=root.depth+1;
		if(newdepth>this.depth){
			this.depth=newdepth;
		}
		
		root.children=new TreeNode[number];
		for(int i=0;i<number;i++){
			root.children[i]=new TreeNode();
			root.children[i].depth=root.depth+1;
		}
	}
	
	public void outputTree(TreeNode root){
		if(root!=null){
			System.out.println(root.data+"\n"+"下一深度:");
			
			if(root.children!=null){
				for(int i=0;i<root.children.length;i++){
					if(root.children[i]!=null){
						outputTree(root.children[i]);
					}else{
						continue;
					}
					
				}
			}	
			
		}
	}
	

 class TreeNode{              //树结点定义
		
		public  String data;                     //树中数据
		public int depth;
		public TreeNode[] children;
		
		public TreeNode(){}  	

		public TreeNode(int depth) {            //树结点构造
			this.depth=1;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public int getdepth() {
			return depth;
		}

		public void setdepth(int depth) {
			this.depth = depth;
		} 
		
		
	
	}
}
