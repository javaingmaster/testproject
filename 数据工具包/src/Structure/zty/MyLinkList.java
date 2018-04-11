package Structure.zty;

public class MyLinkList<type>
{
	String name;      //��������
	int size;         //�����С
	Node<type> head;  //ͷ�ڵ�
	
	public MyLinkList(String name)  //����һ������ʱ����Ҫ����һ������
	{
		this.name=name;
		this.size=0;
		this.head=new Node<type>();
	}
	
	public void addnode(type data)  //Ĭ��������������һ�����
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
		System.out.println("�ɹ�����һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
	}
	
	public void addNodeWithIndex(int index,type data)// ��ָ����λ�����һ�����
	{
		if(index>this.size+1||index<=0){
			System.out.println("��������ֵ����,����ֵֻ���Ǵ�������С�ڵ��������С��һ��ֵ��");
		}else{
			if(this.head.next==null){
				Node<type> temp=new Node<type>(data);
				temp.pre=this.head;
				this.head.next=temp;
				this.size++;
				System.out.println("�ɹ�����һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
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
				System.out.println("�ɹ�����һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
				}else{
					addindex.next=temp;
					temp.pre=addindex;
					this.size++;
					System.out.println("�ɹ�����һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
				}
			} 
		}
	}
	
	public void deletenode()     //Ĭ�����������ɾ��һ�����
	{
		Node<type> deleteindex=this.head;
		for(int i=0;i<this.size;i++)
		{		
			deleteindex=deleteindex.next;
		}
		System.out.println("Ԥɾ��������Ϊ: "+deleteindex.data);
		deleteindex.pre.next=null;
		deleteindex.pre=null;
		deleteindex=null;
		this.size--;
		System.out.println("�ɹ�ɾ��һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
	}
	
	public void deleteNodeWithIndex(int index)// ɾ��ָ��λ�õĽ��
	{
		if(index>this.size||index<=0){
			System.out.println("ɾ������ֵ����,����ֵֻ���Ǵ�������С�ڵ��������С��ֵ��");
		}else{	
			Node<type> deleteindex=this.head;
			for(int i=0;i<index;i++)
			{		
				deleteindex=deleteindex.next;
			}
			if(deleteindex.next!=null){
				System.out.println("Ԥɾ��������Ϊ: "+deleteindex.data);
				deleteindex.pre.next=deleteindex.next;
				deleteindex.next.pre=deleteindex.pre;
				deleteindex.pre=null;
				deleteindex.next=null;
				deleteindex=null;
				this.size--;
				System.out.println("�ɹ�ɾ��һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
			}else{
				System.out.println("Ԥɾ��������Ϊ: "+deleteindex.data);
				deleteindex.pre.next=null;
				deleteindex.pre=null;
				deleteindex=null;
				this.size--;
				System.out.println("�ɹ�ɾ��һ���ڵ㣬�����ȸ���Ϊ: "+this.size);
			}										
		}
	}
	
	public int ishascontent(type data) //�鿴�������Ƿ���ĳ�����ݣ�����з��ظ�����û���򷵻�0
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
			System.out.println(this.getName()+"������û���������ҵ����ݡ�");
		}else{
			System.out.println(this.getName()+"�����а���"+count+"���������ҵ����ݡ�");
		}
		return count;
	}
	public void deleteNodeWithContentcore(type data) //deleteNodeWithContent�����ĺ��Ĳ���
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
	public void deleteNodeWithContent(type data)//ɾ��������ĳ��ָ�����ݵĽ��
	{
		while(this.ishascontent(data)!=0)
		{
			deleteNodeWithContentcore(data);
		}
	}
	
	public void displayNodebyindex(int index)//��ʾָ���Ľ����Ϣ
	{
		if(index>this.size||index<=0){
			System.out.println("��ʾ��������ֵ����");
		}else{
			Node<type> displayindex=this.head;
			for(int i=0;i<index;i++)
			{		
				displayindex=displayindex.next;
			}
			System.out.println(index+"�Ž�������ֵΪ: "+displayindex.data);
			System.out.println(index+"�Ž���Ԥ������ֵΪ: "+displayindex.foreseedata);
		}
	}
	
	public void displayNodeByContent(type data)//��ʾָ�����ݵĽ����Ϣ
	{
		Node<type> displayindex=this.head;
		for(int i=0;i<this.size;i++)
		{				
			displayindex=displayindex.next;
			if(displayindex.data==data){
			System.out.println(i+1+"�Ž�������ֵΪ: "+displayindex.data);
			System.out.println(i+1+"�Ž���Ԥ������ֵΪ: "+displayindex.foreseedata);
			  }	
		}
	}
	public void displayall()//��ʾ���н����Ϣ
	{
		if(this.size==0){
			System.out.println(this.getName()+"����Ϊ0�������������ʾ��");
		}else{
			Node<type> displayindex=this.head;
			for(int i=0;i<this.size;i++)
			{		
				displayindex=displayindex.next;
				System.out.println(displayindex.data);
			}
			System.out.println(this.getName()+"������������ʾ��ϡ�");
		}
	}
	
	public int getSize() {    //��ȡ�����С
		return size;
	}
	public String getName() {		//��ȡ��������
		return name;
	}
	public void displayname(){    //��ʾ��������
		System.out.println(this.name);
	}

	public void setName(String name) { //������������
		this.name = name;
	}
	
	private class Node<type>{   //��㶨��
		  
		public  Node<type> pre;  //��һ�����
		public  Node<type> next;  //��һ�����
		public  type       data;  //��ʽ����
		public  type       foreseedata;  //Ԥ��ʹ������
		public Node(){}  	

		public Node(type data)    //��㹹��
		{
			this.data=data;
		}  	  	  
	}
		
}

