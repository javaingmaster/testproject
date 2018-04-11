package Structure.zty;

public class Mystack<type>
{
	Object[] mystack;  //栈的数组
	
	int size;  //栈的大小
	String name;//栈的名字
	int top;   //栈顶指针
	int bottom;  //栈底指针
	int StackExpand; //栈的扩张
	
	public Mystack(String name) //栈构造
	{
		this.name=name;
		this.size=10;
		mystack=new Object[size];
		this.top=0;
		this.bottom=0;
		this.StackExpand=5;
	}

	public boolean isEmpty(Mystack<type> s) //栈是否为空
	{
		if(s.top==s.bottom){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(Mystack<type> s)  //栈是否满
	{
		if(s.top==s.size){
			System.out.println(this.name+"栈满!");
			return true;
		}else{
			return false;
		}
	}
	
	public void push(type data)  //压栈
	{
		boolean isfull;
		if(!(isfull=isFull(this))){
			mystack[this.top]=data;
			this.top++;
			System.out.println("栈元素增一");
		}else{
			expand();
			System.out.println(this.name+"栈满已解决!");
			mystack[this.top]=data;
			this.top++;
		}
	}
	public type pop()  //出栈
	{
		boolean isempty;
		if(!(isempty=isEmpty(this))){
			this.top--;
			type temp=(type)mystack[this.top];	
			return temp;
		}else{
			System.out.println(this.name+"出栈失败!");
			return null;
		}
	}
	public type peek()  //获取栈顶元素，不出栈
	{
		boolean isempty;
		if(!(isempty=isEmpty(this))){
			this.top--;
			type temp=(type)mystack[this.top];	
			this.top++;
			return temp;
		}else{
			System.out.println(this.name+"栈peek获取失败!");
			return null;
		}
	}
	
	public void expand() //栈扩充
	{
		Object[] mynewstack=new Object[this.size+this.StackExpand];
		for(int i=0;i<this.size;i++)
		{
			mynewstack[i]=mystack[i];
		}
		this.size+=this.StackExpand;
		this.mystack=mynewstack;
	}
	
	public void display()  //从顶到底显示栈元素
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
