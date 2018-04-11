package Structure.zty;

public class Mystack<type>
{
	Object[] mystack;  //ջ������
	
	int size;  //ջ�Ĵ�С
	String name;//ջ������
	int top;   //ջ��ָ��
	int bottom;  //ջ��ָ��
	int StackExpand; //ջ������
	
	public Mystack(String name) //ջ����
	{
		this.name=name;
		this.size=10;
		mystack=new Object[size];
		this.top=0;
		this.bottom=0;
		this.StackExpand=5;
	}

	public boolean isEmpty(Mystack<type> s) //ջ�Ƿ�Ϊ��
	{
		if(s.top==s.bottom){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(Mystack<type> s)  //ջ�Ƿ���
	{
		if(s.top==s.size){
			System.out.println(this.name+"ջ��!");
			return true;
		}else{
			return false;
		}
	}
	
	public void push(type data)  //ѹջ
	{
		boolean isfull;
		if(!(isfull=isFull(this))){
			mystack[this.top]=data;
			this.top++;
			System.out.println("ջԪ����һ");
		}else{
			expand();
			System.out.println(this.name+"ջ���ѽ��!");
			mystack[this.top]=data;
			this.top++;
		}
	}
	public type pop()  //��ջ
	{
		boolean isempty;
		if(!(isempty=isEmpty(this))){
			this.top--;
			type temp=(type)mystack[this.top];	
			return temp;
		}else{
			System.out.println(this.name+"��ջʧ��!");
			return null;
		}
	}
	public type peek()  //��ȡջ��Ԫ�أ�����ջ
	{
		boolean isempty;
		if(!(isempty=isEmpty(this))){
			this.top--;
			type temp=(type)mystack[this.top];	
			this.top++;
			return temp;
		}else{
			System.out.println(this.name+"ջpeek��ȡʧ��!");
			return null;
		}
	}
	
	public void expand() //ջ����
	{
		Object[] mynewstack=new Object[this.size+this.StackExpand];
		for(int i=0;i<this.size;i++)
		{
			mynewstack[i]=mystack[i];
		}
		this.size+=this.StackExpand;
		this.mystack=mynewstack;
	}
	
	public void display()  //�Ӷ�������ʾջԪ��
	{
		boolean isempty;
		int topcopy=this.top;
		while(!(isempty=isEmpty(this)))
		{
			this.top--;
			System.out.println(this.top);
			System.out.println(this.mystack[top]);
		}
		this.top=topcopy;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
