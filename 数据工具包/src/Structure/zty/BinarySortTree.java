package Structure.zty;
/*
 * ����������ʵ��
 */
public class BinarySortTree {  
	
	public Node root; //����
	
	public void insertwitharr(Node root, int[] arr){  //��һ�������е�ÿ��Ԫ�ز��������
		for(int i=0;i<arr.length;i++){
			insertwithkey(arr[i]);
		}
	}
	
	public void insertwithkey(int key){ //����һ��ֵΪkey��Ԫ��
		Node parent;
		int cmp;
		if(this.root==null){          //�����б�Ҫ�жϲ���֮ǰ�Ƿ���������֤��һ���������Ԫ��Ϊ������ֵ
			this.root=new Node(key);
		}
		else{
			Node current=this.root;      //�������������ʼ�Ƚϣ����key�ȵ�ǰ���ֵС��������ӱȽϣ���֮�Һ���
			
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
			
			Node newnode=new Node(key); //ֱ���Ƚϵ���ǰ����Ϊnullʱ����ʼΪ�¼����key�����ڴ�
			current=newnode;
			current.parent=parent;
			
			if(cmp>=0){
				parent.lchild=current; //���ͨ��parent���ý���ǰ���ĸ��ڵ�ĺ�����Ӧ��ֵ
			}else{
				parent.rchild=current;
			}
			
		}
	
	}
	public int cmp(int key, Node root){  //�ȽϷ���
		return (root.data-key);
	}
	/*
	 * print a tree by middle regularity
	 */
	public void lastoutput(Node root){ //�������
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
	
	public void middleoutput(Node root){ //�������
		
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
	public void firstoutput(Node root){ //�������
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
	
	public Node search(int key){ // ͨ���Խ�����ݺ�key�ıȶ���Ѱ��Ҫɾ���Ľ��
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
	
	public void delete(int key){  //ɾ������ĳ�����
		Node target=search(key);   //����Ҫ�ҵ���ɾ��������е�λ��
		
		if(target.lchild==null&&target.rchild==null){  //����ɾ����޺���ʱ�����������������ֱ�����������������������������ֱ��ɾ����
			if(target==this.root){
				this.root=null;
				target=null;
			}else{
				if(target.parent.lchild==target){
					target.parent.lchild=null;
					target.parent=null;
					System.out.println(target.data+"�Ѿ���ɾ��");
					target=null;
				}else{
					target.parent.rchild=null;
					target.parent=null;
					System.out.println(target.data+"�Ѿ���ɾ��");
					target=null;
				}
			}
		}else if((target.lchild==null&&target.rchild!=null)||(target.lchild!=null&&target.rchild==null)){
			if(target==this.root){                 //��ɾ�����һ�����ӵ�ʱ�������������ֱ���ƶ����������������������������ֱ�ӽ����丸���
				if(this.root.lchild!=null){
					this.root=this.root.lchild;
					this.root.parent=null;
					target.lchild=null;
					System.out.println(target.data+"�Ѿ���ɾ��");
					target=null;
				}else{
					this.root=this.root.rchild;
					this.root.parent=null;
					target.rchild=null;
					System.out.println(target.data+"�Ѿ���ɾ��");
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
			 * �����ɾ������������ӣ�������������������Һ��������������ӽ����Һ��ӣ�
			 * �������������Ϊ��ʹ������ƽ��������ѡ��ӱ�ɾ�����Һ��ӿ�ʼһֱ�������һ��������Ϊmin������min�����һ���Һ�����Ϊmax
			 * ���ǽ�min��max���������滻��ɾ���
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
						System.out.println(target.data+"�Ѿ���ɾ��");
						target=null;
					}else{
						target.parent.rchild=target.rchild;
						target.rchild.lchild=target.lchild;
						target.lchild=target.rchild=target.parent=null;
						System.out.println(target.data+"�Ѿ���ɾ��");
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
						
						System.out.println(target.data+"�Ѿ���ɾ��");
						target=null;
					}else{
						target.parent.rchild=min;
						min.lchild=target.lchild;
						max.rchild=target.rchild;
						target.rchild.parent=max;
						target.rchild.lchild=null;
						target.rchild=target.parent=null;
						
						System.out.println(target.data+"�Ѿ���ɾ��");
						target=null;
					}
				}
			}
		}
	}
	
 public class Node{ // ��㣬�������ݡ����ڵ㡢���ӡ��Һ���
	   
	   public Node(int key){
		   this.data=key;
	   }
	   
	   int data;
	   Node parent;
	   Node lchild;
	   Node rchild;
   }

}
