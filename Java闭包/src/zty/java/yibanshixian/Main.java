package zty.java.yibanshixian;

public class Main {
	public static void main(String[] a){
		BoxOfMilk b=new BoxOfMilk(10);
		Person p=new Person();
		System.out.println(b.sum);
		p.drink(b);
		System.out.println("สฃำเ: "+b.getsum());
	}
}
