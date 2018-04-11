package zty.java.componentcopy;

public class Client {
		
	public static void main(String[] a){
		Leaf l1=new Leaf();
		Leaf l2=new Leaf();
		Leaf l3=new Leaf();
		Leaf l4=new Leaf();
		
		Composite c1=new Composite();
		Composite c2=new Composite();
		
		c1.add(l1);
		c1.add(l2);
		c2.add(l3);
		c2.add(l4);
		
		c1.add(c2);
		
		c1.execute();
	}
}
