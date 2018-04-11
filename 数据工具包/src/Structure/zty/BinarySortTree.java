package Structure.zty;
/*
 * 二叉排序树实现
 */
public class BinarySortTree {  
	
	public Node root; //树根
	
	public void insertwitharr(Node root, int[] arr){  //将一个数组中的每个元素插入二叉树
		for(int i=0;i<arr.length;i++){
			insertwithkey(arr[i]);
		}
	}
	
	public void insertwithkey(int key){ //插入一个值为key的元素
		Node parent;
		int cmp;
		if(this.root==null){          //这里有必要判断插入之前是否有树，保证第一个被插入的元素为树根的值
			this.root=new Node(key);
		}
		else{
			Node current=this.root;      //如果不是树根则开始比较，如果key比当前结点值小则跟其左孩子比较，反之右孩子
			
			do{
			    cmp=cmp(key,current);
				if(cmp>=0){
					parent=current;
					current=current.lchild;
				}else{
				    parent=current;
					current=current.rchild;
				}
			}while(current!=null);
			
			Node newnode=new Node(key); //直到比较到当前引用为null时，开始为新加入的key分配内存
			current=newnode;
			current.parent=parent;
			
			if(cmp>=0){
				parent.lchild=current; //最后通过parent引用将当前结点的父节点的孩子相应赋值
			}else{
				parent.rchild=current;
			}
			
		}
	
	}
	public int cmp(int key, Node root){  //比较方法
		return (root.data-key);
	}
	/*
	 * print a tree by middle regularity
	 */
	public void lastoutput(Node root){ //后序遍历
		if(root!=null){
			if(root.lchild!=null){
				lastoutput(root.lchild);
			}
			
			if(root.rchild!=null){
				lastoutput(root.rchild);
			}
			System.out.println(root.data);
		}
	}
	
	public void middleoutput(Node root){ //中序遍历
		
		if(root!=null){
			if(root.lchild!=null){
				middleoutput(root.lchild);
			}
			System.out.println(root.data);
			if(root.rchild!=null){
				middleoutput(root.rchild);
			}
		}
		
	}
	/*
	 * print a tree by first regularity
	 */
	public void firstoutput(Node root){ //先序遍历
		if(root!=null){
			
			System.out.println(root.data);
			
			if(root.lchild!=null){
				firstoutput(root.lchild);
			}
			
			if(root.rchild!=null){
				firstoutput(root.rchild);
			}
		}
	}
	
	public Node search(int key){ // 通过对结点数据和key的比对来寻找要删除的结点
		Node start=this.root;
		
		while(start!=null){
			
			int cmp=this.cmp(key, start);
			
			if(cmp>0){
				start=start.lchild;
				System.out.println("search move to left");
			}else if(cmp<0){
				start=start.rchild;
				System.out.println("search move to right");
			}else{
				System.out.println("search move to end");
				return start;
			}
		}
		
		return null;
	}
	
	public void delete(int key){  //删除树中某个结点
		Node target=search(key);   //首先要找到被删结点在树中的位置
		
		if(target.lchild==null&&target.rchild==null){  //当被删结点无孩子时，如果它是树根，则直接清除这个树根，如果不是树根，则直接删除它
			if(target==this.root){
				this.root=null;
				target=null;
			}else{
				if(target.parent.lchild==target){
					target.parent.lchild=null;
					target.parent=null;
					System.out.println(target.data+"已经被删除");
					target=null;
				}else{
					target.parent.rchild=null;
					target.parent=null;
					System.out.println(target.data+"已经被删除");
					target=null;
				}
			}
		}else if((target.lchild==null&&target.rchild!=null)||(target.lchild!=null&&target.rchild==null)){
			if(target==this.root){                 //被删结点有一个孩子的时候，如果是树根则直接移动树根，如果不是树根，则其子树直接接入其父结点
				if(this.root.lchild!=null){
					this.root=this.root.lchild;
					this.root.parent=null;
					target.lchild=null;
					System.out.println(target.data+"已经被删除");
					target=null;
				}else{
					this.root=this.root.rchild;
					this.root.parent=null;
					target.rchild=null;
					System.out.println(target.data+"已经被删除");
					target=null;
				}
			}else{				
				if(target.parent.lchild==target){
		            if(target.rchild!=null){
		            	target.parent.lchild=target.rchild;
		            }else{
		            	target.parent.lchild=target.lchild;
		            }
				}else{
					if(target.rchild!=null){
		            	target.parent.rchild=target.rchild;
		            }else{
		            	target.parent.rchild=target.lchild;
		            }
				}
			}
		}else{ 
			/*
			 * the node being removed has two sub tree 
			 * 如果被删结点有两个孩子，如果是树根，则让其右孩子做树根，左孩子接入右孩子；
			 * 如果不是树根，为了使二叉树平衡则我们选择从被删结点的右孩子开始一直找其最后一个左孩子作为min，再找min的最后一个右孩子作为max
			 * 我们将min到max整个子树替换被删结点
			 */
			if(target==this.root){
				target.lchild.parent=target.rchild;
				target.rchild.parent=null;
				this.root=this.root.rchild;
				target.lchild=null;
				target.rchild=null;
				target=null;
			}else{
				if(target.rchild.lchild==null){
					target.rchild.parent=target.parent;
					target.lchild.parent=target.rchild;
					if(target.parent.lchild==target){
						target.parent.lchild=target.rchild;
						target.rchild.lchild=target.lchild;
						target.lchild=target.rchild=target.parent=null;
						System.out.println(target.data+"已经被删除");
						target=null;
					}else{
						target.parent.rchild=target.rchild;
						target.rchild.lchild=target.lchild;
						target.lchild=target.rchild=target.parent=null;
						System.out.println(target.data+"已经被删除");
						target=null;
					}
				}else{
					Node min=target.rchild.lchild;
					while(min.lchild!=null){
						min=min.lchild;
					}
					System.out.println("min:"+min.data);
					Node max=min;
					while(max.rchild!=null){
						max=max.rchild;
					}
					System.out.println("max:"+max.data);
					
					min.parent=target.parent;
					target.lchild.parent=min;
					if(target.parent.lchild==target){
						target.parent.lchild=min;
						min.lchild=target.lchild;
						max.rchild=target.rchild;
						target.rchild.parent=max;
						target.rchild.lchild=null;
						target.rchild=target.parent=null;
						
						System.out.println(target.data+"已经被删除");
						target=null;
					}else{
						target.parent.rchild=min;
						min.lchild=target.lchild;
						max.rchild=target.rchild;
						target.rchild.parent=max;
						target.rchild.lchild=null;
						target.rchild=target.parent=null;
						
						System.out.println(target.data+"已经被删除");
						target=null;
					}
				}
			}
		}
	}
	
 public class Node{ // 结点，包括数据、父节点、左孩子、右孩子
	   
	   public Node(int key){
		   this.data=key;
	   }
	   
	   int data;
	   Node parent;
	   Node lchild;
	   Node rchild;
   }

}
