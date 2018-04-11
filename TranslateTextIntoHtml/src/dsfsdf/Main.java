package dsfsdf;

import java.util.Scanner;

public class Main{

public String[] out;

public Main(){
out=new String[100];
}

public void transfer(){
	
Scanner sc=new Scanner(System.in);
String line=null;
int index=0;

while(sc.hasNextLine()){
line=sc.nextLine();

if(line.length()!=0){
	if(line.startsWith("#")){
	int number=0;
	while(line.startsWith("#")){
		number++;
		line.substring(1);
	}
	while(line.startsWith(" ")){
		line.substring(1);
	}
	out[index]="<h"+number+">"+line+"</h"+number+">";
	System.out.println(out[index]);
	index++;
	}else if(line.startsWith("*")){
	
	line.substring(1);
	while(line.startsWith(" ")){
		line.substring(1);
	}
	out[index]="<li>"+line+"</li>";
	System.out.println(out[index]);
	index++;
	
	}else{
		tools t=new tools();
		out[index]=t.process(line);
		System.out.println(out[index]);
		index++;
	}
}else{	
	out[index]="\n";
	System.out.print(out[index]);
	index++;
}
}
}

public void preout(){
	for(int i=0;i<out.length&&out[i]!=null;i++){
		System.out.println(out[i]);
	}
}

/*public void out(){
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

}*/
			
public static void main(String[] args){

	Main m=new Main();
	m.transfer();
	//m.out();
	//m.preout();
}

class tools{
	public String process(String s){
		
		String transferred = null;
		if(s.indexOf("[")!=-1){
		while(s.indexOf("[")!=-1){
			int n=s.indexOf("[");
			int m=s.indexOf("]");
			int left=s.indexOf("(");
			int right=s.indexOf(")");
			transferred=s.substring(0,n);		
			transferred+="<a href=\""+s.substring(left+1,right)+"\">"+s.substring(n+1,m)+"</a>"+s.substring(right+1,s.length());
		}	
	}else{
		transferred=s;
	}		
		while(transferred.indexOf("_")!=-1){			
			s.replaceFirst("_", "<em>");
			s.replaceFirst("_", "</em>");
		}
		
		return transferred;
	}
}

}