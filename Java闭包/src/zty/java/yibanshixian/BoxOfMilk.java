package zty.java.yibanshixian;

public class BoxOfMilk {
	public int sum;
	public Milk[] m;
	
	public BoxOfMilk(int sum){
		this.sum=sum;
		m=new Milk[this.sum];
	}

	public int getsum(){
		return this.sum;
	}
}
