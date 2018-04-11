import java.util.ArrayList;


public class newcreat 
{
	sbw hell=new sbw();//创建画图
	static int sx=10;
	static int sy=10;
	static int rw=500;
	static int w=15;
	newlist [][] list;//创建一个迷宫数组
	static int x,y;//设置x,y坐标
	static int as;
	static int bs;
	static int chukou;
	static int jinkou;
	static ArrayList<newlist> liward=new <newlist> ArrayList();//创建存储邻墙的数组
	static ArrayList<deadline> zhangai=new <deadline> ArrayList();//创建存储障碍的墙
	
	int  ncreat(zuobiao s)
	{
		as=s.x;
		bs=s.y;
		int c;
		list=new newlist[as][bs];
		for(int a=0;a<as;a++)
			for(int b=0;b<bs;b++)
				list[a][b]=new newlist();//为迷宫数组声明	
		c=find_road();
		return c;
	}
	
	
	int randjin()
	{
		int jinkou=(int)(Math.random()*(as));//在左边界生成一个入口,并设置为一个通路
		list[jinkou][0].lfrd=true;//把这个位置设为通路
		list[jinkou][0].left=0;//把通路的左边墙拆开，
		list[jinkou][0].x=jinkou;//设置该通路的x坐标
		list[jinkou][0].y=0;//设置该通路的y坐标
		return jinkou;
	}
	
	int randchu()
	{
		int chukou=(int)(Math.random()*(as));//在右边界生成一个出口，并设置为通路
		list[chukou][bs-1].right=0;//把通路的右边墙拆开	
		list[chukou][bs-1].x=chukou;
		list[chukou][bs-1].y=bs-1;
		return chukou;
	}
	
	
	
	
	
	
	int find_road()//这个是用来生成迷宫的
	{
		jinkou=randjin();//获取起点
		chukou=randchu();//获取终点
	//	System.out.println(jinkou);
		int Asize;//记录邻墙的数组的长度
		int random1,random2;//随机数
		
		newlist net=new newlist();//用于获取从Arryalist中取出的对象
		
		liward.add(list[jinkou][0]);//先把邻墙加进去
		
		hell.getzuobiao(sx+jinkou*w,sx, 2);
		hell.getzuobiao(sx+chukou*w,sx+(bs-1)*w,3);

		
		while(true)		
		{
			Asize=liward.size();//获取墙壁数组长度
			random1=(int)(Math.random()*Asize);
			net=liward.get(random1);//获取随机的格子位置
			
			
			//这是生成路径的总算法
			while(true)
			{	
				random2=(int)(Math.random()*4);//获取随机的格子内部的位置,上下左右
				
				//System.out.println("random1="+random1);
				//System.out.println("random2="+random2);
				//System.out.println("选择的坐标为:x="+net.x+"  y="+net.y);
				//System.out.println(net.up+" "+net.down+" "+net.left+" "+net.right);
				//System.out.println("");
				
				if(random2==0)//向上方向
				{
					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
					{ liward.remove(net);break;}
					
					if(net.x==0)//如果已经顶到墙了，则重新生成随机
					{
						net.up=0;
						//这里是存储墙的
					}
				
					else if(net.up==0)//如果墙不存在，则重新随机
					{}
					else if(net.up==1&&net.x>0)//如果墙存在的同时，这个地方没有顶到墙
					{
						if(list[net.x-1][net.y].lfrd==false)//如果不是通路
						{
							net.up=0;//移除这个墙，并且把下一个路径也存入
							
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,0);

							list[net.x-1][net.y].cross=true;//把下一条路径设为经过了
							list[net.x-1][net.y].lfrd=true;//把下一个路径设置为通路
							list[net.x-1][net.y].x=net.x-1;
							list[net.x-1][net.y].y=net.y;
							list[net.x-1][net.y].down=0;//打通后，把上面那条路的下路也设为0
							
							liward.add(list[net.x-1][net.y]);//把下一个路径存入
						//	System.out.println("新得到的路径点为x="+(net.x-1)+",y="+net.y+"此时liward的大小为"+liward.size());
							//System.out.println("");
							
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
						
						else if(list[net.x-1][net.y].lfrd==true)//如果是通路
						{
							net.up=0;//把墙撤销
							
							//这里是存储墙的
							deadline zhang=new deadline();
							//System.out.println("这里有变化");
							zhang.y=sx+net.x*w;
							zhang.x=sx+net.y*w;
							zhang.y_n=zhang.y;
							zhang.x_n=zhang.x+w;
							zhang.dir=0;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
					}
				
				}
		
		
				
		
				else if(random2==1)//向下方向
				{

					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
					{ liward.remove(net);break;}
					
					if(net.x==as-1)//如果已经顶到墙了，则设置为0
					{
						net.down=0;
						//这里是存储墙的
					}
				
					else if(net.down==0)//如果该方向已经没有墙了，则跳出
					{}
					else if(net.down==1&&net.x<as-1)//如果，即没有顶到边缘，同时墙存在
					{
						if(list[net.x+1][net.y].lfrd==false)//如果不是通路
						{
							net.down=0;//移除这个墙，并且把下一个路径也存入
							
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,1);
							
							list[net.x+1][net.y].cross=true;//把改路径设置为经过
							list[net.x+1][net.y].lfrd=true;//把下一个路径设置为通路
							list[net.x+1][net.y].x=net.x+1;
							list[net.x+1][net.y].y=net.y;
							list[net.x+1][net.y].up=0;//打通后，把上面那条路上路也设为0
							liward.add(list[net.x+1][net.y]);//把下一个路径存入
						//	System.out.println("新得到的路径点为x="+(net.x+1)+",y="+net.y+"此时liward的大小为"+liward.size());
						//	System.out.println("");
							
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
						
						
						else if(list[net.x+1][net.y].lfrd==true)//如果是通路
						{
							net.down=0;//把墙消去
							
							//这里是存储墙的
							deadline zhang=new deadline();
						//	System.out.println("这里有变化");
							zhang.y=sx+net.x*w+w;
							zhang.x=sx+net.y*w;
							zhang.y_n=zhang.y;
							zhang.x_n=zhang.x+w;
							zhang.dir=1;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
					}
						
				}
				
		
		
				else if(random2==2)//向左方向
				{

					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
					{ liward.remove(net);break;}
					
					 if(net.y==0)//如果已经顶到墙了，则设置为0
					{
						
						net.left=0;
					}
				
					else if(net.left==0)
					{}
					else if(net.left==1&&net.y>0)
					{
						if(list[net.x][net.y-1].lfrd==false)//如果不是通路
						{
							net.left=0;//移除这个墙，并且把下一个路径也存入
				
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,2);
						
							list[net.x][net.y-1].cross=true;
							list[net.x][net.y-1].lfrd=true;//把下一个路径设置为通路
							list[net.x][net.y-1].x=net.x;
							list[net.x][net.y-1].y=net.y-1;
							list[net.x][net.y-1].right=0;//打通后，把左边那条路的右路也设为0
							liward.add(list[net.x][net.y-1]);//把下一个路径存入
						//	System.out.println("新得到的路径点为x="+(net.x)+",y="+(net.y-1)+"此时liward的大小为"+liward.size());
						//	System.out.println("");
							
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
						else if(list[net.x][net.y-1].lfrd==true)//如果是通路
						{
							net.left=0;
							
							//这里是存储墙的
							deadline zhang=new deadline();
							//System.out.println("这里有变化");
							
							zhang.y=sx+net.x*w;
							zhang.x=sx+net.y*w;
							zhang.y_n=zhang.y+w;
							zhang.x_n=zhang.x;
							zhang.dir=2;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
					}
						
				}
		
		
		
				else if(random2==3)//向右方向
				{

					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
					{ liward.remove(net);break;}
					
					if(net.y==bs-1)//如果已经顶到墙了，则设置为0
					{
					
						net.right=0;
					}
					else if(net.right==0)
					{}
					else if(net.right==1&&net.y<bs-1)
					{
						if(list[net.x][net.y+1].lfrd==false)//如果不是通路
						{
							net.right=0;//移除这个墙，并且把下一个路径也存入
							
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,3);
							
							list[net.x][net.y+1].cross=true;
							list[net.x][net.y+1].lfrd=true;//把下一个路径设置为通路
							list[net.x][net.y+1].left=0;//打通后，把右边那条路的左路也设为0
							list[net.x][net.y+1].x=net.x;
							list[net.x][net.y+1].y=net.y+1;
							liward.add(list[net.x][net.y+1]);//把下一个路径存入
						//	System.out.println("新得到的路径点为x="+(net.x)+",y="+(net.y+1)+"此时liward的大小为"+liward.size());
							System.out.println("");
						//	
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
						else if(list[net.x][net.y+1].lfrd==true)//如果是通路
						{
							net.right=0;
							
							//这里是存储墙的
							deadline zhang=new deadline();
							//System.out.println("这里有变化");
							zhang.y=sx+net.x*w;
							zhang.x=sx+net.y*w+w;
							zhang.y_n=zhang.y+w;
							zhang.x_n=zhang.x;
							zhang.dir=3;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//如果这个路径没有邻墙了，则从邻墙列表删除这个路径
							{ liward.remove(net);}
							break;
						}
					}
					
				}
			
			}//找路的内层while
		
			if(liward.size()==0)//如果到达了终点的同时，列表里也没有墙了，则判断生成了
			{
			//	System.out.println("墙的个数为:"+zhangai.size());
				//System.out.println(zhangai.get(0).x+" "+zhangai.get(0).y);
				//System.out.println(zhangai.get(1).x+" "+zhangai.get(1).y);
				break;
			}
		}//找路的外层while
		return jinkou;
			
	}
	
}