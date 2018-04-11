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
						 * ���������
						 */
						for(int j=0;j<graph.length;j++){
							if(min+graph[i][j]<graph[point][j]){
								graph[point][j]=min+graph[i][j];
							}
						}
						
						/*
						 * ���º󽫸ղű����µ�������������
						 */
						cannotbestart.addnode(i);
						System.out.println("����"+i);
					}else{
						System.out.println("��������С��");
					}
				}else{
					System.out.println("�������Ѽ�¼ֵ");
				}
			}
		}
		/*
		 * ��ӡ�����
		 */
		for(int m=0;m<graph.length;m++){
			System.out.println("��"+point+"����"+m+"��̾���Ϊ��"+graph[point][m]);
		}		
	}
	public void checkpath(int[][] graph,int start,int destination){
		/*
		 * ����·�߱�fromΪto��ǰ��
		 * fromĬ��ȫΪstart
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
						 * ���������
						 */
						for(int j=0;j<graph.length;j++){
							if(min+graph[i][j]<graph[start][j]){
								graph[start][j]=min+graph[i][j];
								pt[j].from=i;
							}
						}
						
						/*
						 * ���º󽫸ղű����µ�������������
						 */
						cannotbestart.addnode(i);
						System.out.println("����"+i);
					}else{
						System.out.println("��������С��");
					}
				}else{
					System.out.println("�������Ѽ�¼ֵ");
				}
			}
		}
		/*
		 * ���·��
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
