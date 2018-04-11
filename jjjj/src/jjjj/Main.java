package jjjj;

import java.util.Scanner;

public class Main{
	public String line,pre;
	
	public Main(){
		Scanner sc=new Scanner(System.in);
	    pre=line=null;
		
	    while(sc.hasNextLine()){
	    	line=sc.nextLine();
	    	
	    	if(line==null||line.length()==0){
	    		if(pre==null)
	    		continue;
	    	
	    		if(pre.contains("<h")){
	    			System.out.print(pre);
	    		}else if(pre.contains("<ul>")){
	    			System.out.print(pre+"\n"+"</ul>"+"\n");
	    		}else if(pre.contains("<p>")){
	    			System.out.print(pre+"</p>"+"\n");
	    		}
	    		pre=null;
	    		continue;
	    	}    	
	    	while(line.indexOf("_")!=-1){			
    			line=line.replaceFirst("_", "<em>");
    			line=line.replaceFirst("_", "</em>");
    		}
	    		while(line.indexOf("[")!=-1){
	    			int n=line.indexOf("[");
	    			int m=line.indexOf("]");
	    			int left=line.indexOf("(");
	    			int right=line.indexOf(")");
	    			String temp=line.substring(0,n);		
	    			temp+="<a href=\""+line.substring(left+1,right)+"\">"+line.substring(n+1,m)+"</a>"+line.substring(right+1,line.length());
	    			line=temp;
	    		}	    		
	    	if(line.startsWith("#")){
	    		int number=0;
	    		while(line.startsWith("#")&&number<6){
	    			number++;
	    			line=line.substring(1);
	    		}   		
	    		while(line.startsWith(" ")){
	    			line=line.substring(1);
	    		}
	    		pre="<h"+number+">"+line+"</h"+number+">"+"\n";
	    		}
	    	    else if(line.startsWith("*")){    		
	    		line=line.substring(1);
	    		while(line.startsWith(" ")){
	    			line=line.substring(1);
	    		}
	    		if(pre==null){
	    			pre="<ul>"+"\n"+"<li>"+line+"</li>";
	    		}else{
	    			pre+="\n"+"<li>"+line+"</li>";
	    		}
	    }else{
	    	if(pre==null){
	    		pre="<p>"+line;
	    	}else{
	    		pre+="\n"+line;
	    	}
	    }
	    	
	    }
	    if(pre.contains("<h")){
			System.out.print(pre);
		}else if(pre.contains("<ul>")){
			System.out.print(pre+"\n"+"</ul>"+"\n");
		}else if(pre.contains("<p>")){
			System.out.print(pre+"</p>"+"\n");
		}
	}
	public static void main(String[] args){
		Main m=new Main();
	}

}
