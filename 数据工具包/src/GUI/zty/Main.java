package GUI.zty;

import java.util.Scanner;

public class Main {
        public int n,m;
	public final int max=Integer.MAX_VALUE;
	public int[][] graph;
	
	public Main(){
Scanner s=new Scanner(System.in);
this.n=s.nextInt();
this.m=s.nextInt();

    this.graph=new int[n][n];

    for(int i=0;i<this.n;i++){
      for(int j=0;j<this.n;j++){
           this.graph[i][j]=max;
      } 
   }

    for(int p=0;p<this.m;p++){
         int i=s.nextInt();
         int j=s.nextInt();
         int time=s.nextInt();
         
         this.graph[j-1][i-1]=this.graph[i-1][j-1]=time;
         this.graph[p][p]=0;
     }
   }

public static void main(String[] args){ 
	Main m=new Main();
	m.checkpath(m.graph);
}	
	public void checkpath(int[][] graph){
		
		MyLinkList<Integer> cannotbestart=new MyLinkList<Integer>("didit");
		cannotbestart.addnode(0);
		
		while(cannotbestart.getSize()<graph.length+1){
			
			int updateindex=0;
			int min=max;
			for(int i=0;i<graph.length;i++){
				if(cannotbestart.ishascontent(i)==0){
					if(graph[0][i]<min){
						min=graph[0][i];
						updateindex=i;
					}
				}
			}
						for(int j=0;j<graph.length;j++){
							if(j!=updateindex){
								if(graph[updateindex][j]<graph[0][j]){
									graph[0][j]=graph[updateindex][j];
								}
							}
						}
						cannotbestart.addnode(updateindex);		
		}
	
		System.out.println(graph[0][graph.length-1]);		
	}

}
class MyLinkList<type>
{
	String name;      
	int size;         
	Node<type> head;  
	
	public MyLinkList(String name)  
	{
		this.name=name;
		this.size=0;
		this.head=new Node<type>();
	}
	public int ishascontent(type data) 
	{
		int count=0;
		Node<type> throughindex=this.head;
		for(int i=0;i<this.size;i++)
		{
			if(throughindex.next!=null){
			throughindex=throughindex.next;
			if(throughindex.data==data){
				count++;
			   }
			}else{
				break;		  
			}
		}
		return count;
	}
	public void addnode(type data)  
	{
		Node<type> temp=new Node<type>(data);
		Node<type> addindex=this.head;
		for(int i=0;i<this.size;i++)
		{		
			addindex=addindex.next;
		}
		addindex.next=temp;
		temp.pre=addindex;
		this.size++;	
	}
	public int getSize() {    
		return size;
	}
	private class Node<type>{   
		  
		public  Node<type> pre;  
		public  Node<type> next;  
		public  type       data;  
		public Node(){}  	

		public Node(type data)    
		{
			this.data=data;
		}  	  	  
	}
}

