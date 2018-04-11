package Structure.zty;

public class MyLinkList<type>
{
	String name;      //链表名字
	int size;         //链表大小
	Node<type> head;  //头节点
	
	public MyLinkList(String name)  //构造一个链表时必须要附上一个名字
	{
		this.name=name;
		this.size=0;
		this.head=new Node<type>();
	}
	
	public void addnode(type data)  //默认在链表最后添加一个结点
	{
		Node<type> temp=new Node<type>(data);
		Node<type> addindex=this.head;
		for(int i=0;i<this.size;i++)
		{		
			addindex=addindex.next;
		}
		addindex.next=temp;
		temp.pre=addindex;
		this.size++;
		System.out.println("成功插入一个节点，链表长度更改为: "+this.size);
	}
	
	public void addNodeWithIndex(int index,type data)// 在指定的位置添加一个结点
	{
		if(index>this.size+1||index<=0){
			System.out.println("插入索引值错误,索引值只能是大于零且小于等于链表大小加一的值！");
		}else{
			if(this.head.next==null){
				Node<type> temp=new Node<type>(data);
				temp.pre=this.head;
				this.head.next=temp;
				this.size++;
				System.out.println("成功插入一个节点，链表长度更改为: "+this.size);
			}else{
				Node<type> temp=new Node<type>(data);
				Node<type> addindex=this.head;
				for(int i=0;i<index-1;i++){
					addindex=addindex.next;
				}
				if(addindex.next!=null){
				addindex.next.pre=temp;
				temp.next=addindex.next;
				addindex.next=temp;
				temp.pre=addindex;
				this.size++;
				System.out.println("成功插入一个节点，链表长度更改为: "+this.size);
				}else{
					addindex.next=temp;
					temp.pre=addindex;
					this.size++;
					System.out.println("成功插入一个节点，链表长度更改为: "+this.size);
				}
			} 
		}
	}
	
	public void deletenode()     //默认在链表最后删除一个结点
	{
		Node<type> deleteindex=this.head;
		for(int i=0;i<this.size;i++)
		{		
			deleteindex=deleteindex.next;
		}
		System.out.println("预删除的数据为: "+deleteindex.data);
		deleteindex.pre.next=null;
		deleteindex.pre=null;
		deleteindex=null;
		this.size--;
		System.out.println("成功删除一个节点，链表长度更改为: "+this.size);
	}
	
	public void deleteNodeWithIndex(int index)// 删除指定位置的结点
	{
		if(index>this.size||index<=0){
			System.out.println("删除索引值错误,索引值只能是大于零且小于等于链表大小的值！");
		}else{	
			Node<type> deleteindex=this.head;
			for(int i=0;i<index;i++)
			{		
				deleteindex=deleteindex.next;
			}
			if(deleteindex.next!=null){
				System.out.println("预删除的数据为: "+deleteindex.data);
				deleteindex.pre.next=deleteindex.next;
				deleteindex.next.pre=deleteindex.pre;
				deleteindex.pre=null;
				deleteindex.next=null;
				deleteindex=null;
				this.size--;
				System.out.println("成功删除一个节点，链表长度更改为: "+this.size);
			}else{
				System.out.println("预删除的数据为: "+deleteindex.data);
				deleteindex.pre.next=null;
				deleteindex.pre=null;
				deleteindex=null;
				this.size--;
				System.out.println("成功删除一个节点，链表长度更改为: "+this.size);
			}										
		}
	}
	
	public int ishascontent(type data) //查看链表中是否有某个数据，如果有返回个数，没有则返回0
	{
		int count=0;
		Node<type> throughindex=this.head;
		for(int i=0;i<this.size;i++)
		{
			if(throughindex.next!=null){
			throughindex=throughindex.next;
			if(throughindex.data==data){
				count++;
			   }
			}else{
				break;		  
			}
		}
		if(count==0){
			System.out.println(this.getName()+"链表中没有您所查找的内容。");
		}else{
			System.out.println(this.getName()+"链表中包含"+count+"个您所查找的内容。");
		}
		return count;
	}
	public void deleteNodeWithContentcore(type data) //deleteNodeWithContent函数的核心部分
	{
		Node<type> deleteindex=this.head;
		for(int i=0;i<this.size;i++)
		{
			if(deleteindex.next!=null){
				deleteindex=deleteindex.next;
			if(deleteindex.data==data){
				deleteNodeWithIndex(i+1);
				break;
			   }
			}else{
				break;		  
			}
		}		
	}
	public void deleteNodeWithContent(type data)//删除链表中某个指定数据的结点
	{
		while(this.ishascontent(data)!=0)
		{
			deleteNodeWithContentcore(data);
		}
	}
	
	public void displayNodebyindex(int index)//显示指定的结点信息
	{
		if(index>this.size||index<=0){
			System.out.println("显示结点的索引值错误！");
		}else{
			Node<type> displayindex=this.head;
			for(int i=0;i<index;i++)
			{		
				displayindex=displayindex.next;
			}
			System.out.println(index+"号结点的数据值为: "+displayindex.data);
			System.out.println(index+"号结点的预备数据值为: "+displayindex.foreseedata);
		}
	}
	
	public void displayNodeByContent(type data)//显示指定内容的结点信息
	{
		Node<type> displayindex=this.head;
		for(int i=0;i<this.size;i++)
		{				
			displayindex=displayindex.next;
			if(displayindex.data==data){
			System.out.println(i+1+"号结点的数据值为: "+displayindex.data);
			System.out.println(i+1+"号结点的预备数据值为: "+displayindex.foreseedata);
			  }	
		}
	}
	public void displayall()//显示所有结点信息
	{
		if(this.size==0){
			System.out.println(this.getName()+"长度为0，因此无数据显示。");
		}else{
			Node<type> displayindex=this.head;
			for(int i=0;i<this.size;i++)
			{		
				displayindex=displayindex.next;
				System.out.println(displayindex.data);
			}
			System.out.println(this.getName()+"的所有数据显示完毕。");
		}
	}
	
	public int getSize() {    //获取链表大小
		return size;
	}
	public String getName() {		//获取链表名称
		return name;
	}
	public void displayname(){    //显示链表名字
		System.out.println(this.name);
	}

	public void setName(String name) { //设置链表名字
		this.name = name;
	}
	
	private class Node<type>{   //结点定义
		  
		public  Node<type> pre;  //上一个结点
		public  Node<type> next;  //下一个结点
		public  type       data;  //正式数据
		public  type       foreseedata;  //预备使用数据
		public Node(){}  	

		public Node(type data)    //结点构造
		{
			this.data=data;
		}  	  	  
	}
		
}

