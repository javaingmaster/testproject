package ccf;

import java.util.Scanner;

public class main{
	public MyStringHandler msh;

public String[] out;

public main(){
out=new String[100];
this.msh=new MyStringHandler();
}

public void transfer(){
	
Scanner sc=new Scanner(System.in);
String line=null;
int index=0;
int m=0,n=0;
String transferred=null;

while(sc.hasNextLine()){

line=sc.nextLine();

if(line.length()!=0){
	if(line.startsWith("#")){
		n=msh.countchar(line, '#', 0);
		m=msh.countchar(line, ' ', n);

	transferred="<h"+n+">"+line.substring(n+m,line.length())+"</h"+n+">";
	out[index]=transferred;
	index++;
	m=n=0;
	}else if(line.startsWith("*")){
		
		m=msh.countchar(line, ' ', 1);

	transferred="<li>"+line.substring(m+1,line.length())+"</li>";
	out[index]=transferred;
	index++;
	m=0;
	}else if(line.indexOf("[")!=-1){
		
	transferred="<p>";
	n=line.indexOf("[");

	transferred+=line.substring(0,n);
	m=line.indexOf("]");
	int left=line.indexOf("(");
	int right=line.indexOf(")");

	transferred+="<a href=\""+line.substring(left+1,right)+"\">"+line.substring(n+1,m)+"</a>"+line.substring(right+1,line.length())+"</p>";
	out[index]=transferred;
	index++;
	m=n=0;
	}
	else{	
		if(line.indexOf("_")!=-1){			
		transferred="<p>";

		while(line.indexOf("_",m)!=-1){
		transferred+=line.substring(m,line.indexOf("_"));
		transferred+="<em>";
		m=line.indexOf("_")+1;
		transferred+=line.substring(m,line.indexOf("_",m));
		transferred+="</em>";
		m=line.indexOf("_",m)+1;
		}
		transferred+=line.substring(m,line.length());
		transferred+="</p>";

		out[index]=transferred;
		index++;
		m=0;
		}
		else{			
		//System.out.println(".........!!!");	
			out[index]=line;
			index++;
			}			
}
}else{	
	out[index]="\n";
	index++;
}
}
}

public void preout(){
	for(int i=0;i<out.length&&out[i]!=null;i++){
		System.out.println(out[i]);
	}
}

public void out(){
	int firstplus=0;
	int firststar=0;
	for(int i=0;i<out.length&&out[i]!=null;i++){
		
		if(!out[i].startsWith("<")&&(!out[i].equals("\n"))){
			int u;
			int model=this.msh.checkmodel(i, out);
			if(model==1){
				System.out.println("<p>"+out[i]+"</p>");
				i+=(model-1);
			}else if(model==2){
				System.out.println("<p>"+out[i]);
				System.out.println(out[i+1]+"</p>");
				i+=(model-1);
			}else{
				System.out.println("<p>"+out[i]);
				for(u=2; u<model;u++){
					System.out.println(out[i+u-1]);
				}
				System.out.println(out[i+u-1]+"</p>");
				i+=(model-1);
			}
		}else if((!out[i].equals("\n"))&&this.msh.isli(i, out)){
			
				int number=this.msh.numberofli(i, out);
				System.out.println("<ul>");
				System.out.println(out[i]);
				for(int p=1;p<number;p++){
					System.out.println(out[i+p]);
				}
				System.out.println("</ul>");
				i+=(number-1);
			}else{		
				if(!out[i].equals("\n")){
					System.out.println(out[i]);
				}else{
					System.out.print(out[i]);
				}
					
			}		
		}

}
			
public static void main(String[] args){

	main m=new main();
	m.transfer();
	m.out();
	
}
public class MyStringHandler {
	
	public int countchar(String s,char c,int from){
		int number=0;
		if(from<s.length()&&from>=0){
			for(int i=from;i<s.length();i++){
				if(s.charAt(i)==c){
					number++;
				}else{
					break;
				}
			}
			return number;
		}else{
			System.out.println("error in countchar()");
			return -1;
		}	
	}

	public int countchar(String s,char c,int from, int to){
		return -1;
	}

	public int checkmodel(int item,String[] out){
        int number=1;
        
		while(out[item+1]!=null){
			if(!out[item+1].equals("\n")&&!out[item+1].startsWith("<")){
				number++;
				item++;
			}else{
				break;
			}
		}
		return number;
	}
	
	public boolean isli(int item,String[] out){
		if(out[item].charAt(1)=='l'&&out[item].charAt(2)=='i'){
			return true;
		}
		return false;
	}
	public int numberofli(int item,String[] out){
		int number=1;
		
		while(out[item+1]!=null&&out[item+1].length()>3&&isli(item+1,out)){
			number++;
			item++;
		}
		return number;
	}
	
	public int numberofparagraph(int item,String[] out){
		int number=1;
		
		while(out[item+1]!=null&&!out[item+1].endsWith(".")){
			number++;
			item++;
		}
		return number;
	}
	
}

}