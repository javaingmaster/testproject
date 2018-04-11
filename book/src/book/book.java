package book;

public class book 
{
	private String title;
	private String author;
	private double price;
	
	public String getTitle()
	{
		return(title);
	}
	public String author()
	{
		return(author);
	}
	public double price()
	{
		return(price);
	}

	public book(String title,String author,double price)
	{
		this.title=title;
		this.author=author;
		this.price=price;
	}
}
class test
{
	public static void main(String[] args)
	{
		book bookone=new book("aaa","sss",66.6);
		System.out.println("书名："+bookone.getTitle());
		System.out.println("作者："+bookone.author());
		System.out.println("价格："+bookone.price()+"元");
	}
}

