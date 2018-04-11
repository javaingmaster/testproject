package Structure.zty;

public class DijkstraGraph {
	public final int max=Integer.MAX_VALUE;
	int[][] graph;
	
	public DijkstraGraph(){}
	
	public int[][] creategraph(){
		int[][] graph=		
			{				
					{0  ,max,1  ,3  ,max},
					{3  ,0  ,max,max,2  },
					{max,1  ,0  ,6  ,max},
					{max,max,max,0  ,2  },
					{max,max,2  ,max,0  }
			};
		
		return graph;
	}
	
	public void checkbestroute(int[][] graph,int point){
		
		MyLinkList<Integer> cannotbestart=new MyLinkList<Integer>("didit");
		cannotbestart.addnode(point);
		while(cannotbestart.getSize()!=graph.length){
			int updateindex;
			int min=max;
			for(int i=0;i<graph.length;i++){
				if(cannotbestart.ishascontent(i)!=1){
					if(graph[point][i]<min){
						min=graph[point][i];
						updateindex=i;
						
						/*
						 * 更新起点行
						 */
						for(int j=0;j<graph.length;j++){
							if(min+graph[i][j]<graph[point][j]){
								graph[point][j]=min+graph[i][j];
							}
						}
						
						/*
						 * 更新后将刚才被更新的行数加入链表
						 */
						cannotbestart.addnode(i);
						System.out.println("加入"+i);
					}else{
						System.out.println("非行中最小数");
					}
				}else{
					System.out.println("链表中已记录值");
				}
			}
		}
		/*
		 * 打印距离表
		 */
		for(int m=0;m<graph.length;m++){
			System.out.println("点"+point+"到点"+m+"最短距离为："+graph[point][m]);
		}		
	}
	public void checkpath(int[][] graph,int start,int destination){
		/*
		 * 创建路线表，from为to的前驱
		 * from默认全为start
		 */
		PathTable[] pt=new PathTable[graph.length];
		for(int i=0;i<graph.length;i++){
			pt[i]=new PathTable();
			pt[i].from=start;
			pt[i].to=i;
		}
		
		MyLinkList<Integer> cannotbestart=new MyLinkList<Integer>("didit");
		cannotbestart.addnode(start);
		while(cannotbestart.getSize()!=graph.length){
			int updateindex;
			int min=max;
			for(int i=0;i<graph.length;i++){
				if(cannotbestart.ishascontent(i)!=1){
					if(graph[start][i]<min){
						min=graph[start][i];
						updateindex=i;
						
						/*
						 * 更新起点行
						 */
						for(int j=0;j<graph.length;j++){
							if(min+graph[i][j]<graph[start][j]){
								graph[start][j]=min+graph[i][j];
								pt[j].from=i;
							}
						}
						
						/*
						 * 更新后将刚才被更新的行数加入链表
						 */
						cannotbestart.addnode(i);
						System.out.println("加入"+i);
					}else{
						System.out.println("非行中最小数");
					}
				}else{
					System.out.println("链表中已记录值");
				}
			}
		}
		/*
		 * 输出路径
		 */
		Mystack<Integer> s=new Mystack<Integer>("path");
		s.push(destination);
		while(pt[destination].from!=start){
			s.push(pt[destination].from);
			destination=pt[destination].from;
		}
		s.push(start);
		while(!s.isEmpty(s)){
			System.out.println(s.pop()+" ");
		}
		
	}
	
	class PathTable{
		int to;
		int from;
	}
}
