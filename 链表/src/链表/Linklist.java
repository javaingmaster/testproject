package 链表;

public class Linklist 
{
	Node first;
	Node last;
	int size;
	
	public void additem(Object e)
	{
		Node node=new Node();
		if(first==null)
		{
			
			first=node;
			last=node;
			node.data=e;
			node.next=null;
			node.previous=null;
		}
		else{
			
			node.setPrevious(last);
			node.setData(e);
			node.setNext(null);
			
			last.setNext(node);
			last=node;
		}
		size++;
	}
	public int getsize()
	{
		return size;
	}
	
	public void Checkoverflow(int index)
	{
		if((index<0)||(index>=size))
		{
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public Object getitem(int index)
	{
		Checkoverflow(index);
		Node temp=null;
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++)
			{
				temp=temp.next;
			}			
		}else
		{
			System.out.println("空链表无法获取对象.");
		}
		System.out.println("you get the data: "+temp.data);
		return temp.data;
	}
	public void remove(int index)
	{
		Node temp=null;
		if(first!=null){
			temp=first;
			for(int i=0;i<index;i++)
			{
				temp=temp.next;
			}	
			temp.previous.next=temp.next;
			temp.next.previous=temp.previous;
			System.out.println("you removed the data: "+temp.data);
		}else
		{
			System.out.println("空链表无法获取对象.");
		}
	}

	public void insertion(int index,Object e)
	{
		Node temp=first;
		Node newnode=new Node();
		newnode.data=e;
		
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		if(temp.next!=null){
		temp.next.previous=newnode;
		newnode.next=temp.next;
		newnode.previous=temp;
		temp.next=newnode;
		}else
		{
			temp.next=newnode;
			newnode.previous=temp;
			newnode.next=null;
		}
	}
	public static void main(String[] args)
	{
		Linklist l=new Linklist();
		l.additem("aaa");
		l.additem("bbb");
		l.additem("ccc");
		l.getitem(1);
		l.remove(1);
		l.getitem(1);
		l.insertion(1, "shit");
		l.getitem(2);
	}
}
