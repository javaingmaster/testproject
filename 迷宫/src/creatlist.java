import java.util.ArrayList;


public class creatlist 
{
	int count;//用来记录维数
	ArrayList<Integer> list = new  ArrayList<Integer> ();
	void creat(int weishu)//生成全是墙的迷宫
	{
		count=weishu;
		//list用来存储迷宫的每一行
		for(int num=0;num<weishu;num++)
		{
			for(int num1=0;num1<weishu;num1++)
			{
				list.add(1);
			}
		}

		
	}
	
	
	void liferoad()//打路
	{
		//假设左上角第一个是起点，右下角最后一个是终点
		
		zuobiao pepl=new zuobiao();
		zuobiao pepls[]=new zuobiao[10000];//用来记录路径
		for(int c=0;c<10000;c++)
		{
			pepls[c]=new zuobiao();
		}
		int record=0;//用来记录路径的数量
		pepl.x=0;
		pepl.y=0;//横纵坐标都设为0
		boolean dec;
		list.set(pepl.y*count+pepl.x,0);
		int rand;
		while(!(pepl.y*count+pepl.x==count*count-1))
		{
			rand=Math.random()>0.5?1:0;//产生随机数0到1
			rand+=Math.random()>0.5?1:0;//产生随机数0到1
			rand+=Math.random()>0.5?1:0;//产生随机数0到1
			//这个是为了打路
			while(true)	
			{	
				if(rand==0)//这是在x坐标上变换
				{		
					System.out.println("hello1");
					pepl.x++;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//如果迷宫走过该位置，则跳出出，重新生成
						{
							pepl.x--;
							dec=false;
							break;
						}	
						dec=true;
					}
					if(dec=false)
					{
						dec=true;
						break;
					}
					else if(pepl.x==count)
					{
						pepl.x--;
						break;
					}
					else 
					{

						list.set(pepl.y*count+pepl.x,0);
						pepls[record].x=pepl.x;
						pepls[record].y=pepl.y;

						record++;//记录一次路径
						break;
					}
				}
				
				else if(rand==1)//这是在x坐标上变换
				{		
					System.out.println("hello2");
					pepl.x--;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//如果迷宫走过该位置，则跳出出，重新生成
						{
							pepl.x++;
							dec=false;
							break;
						}	
						dec=true;
					}
					if(dec=false)
					{
						dec=true;
						break;
					}
					else if(pepl.x==count)
					{
						pepl.x++;
						break;
					}
					else if(pepl.x==-1)
					{
						rand=0;
						pepl.x++;
						break;
					}
					else 
					{
						list.set(pepl.y*count+pepl.x,0);
						pepls[record].x=pepl.x;
						pepls[record].y=pepl.y;
						record++;//记录一次路径
						break;
					}
				}
				
				
				else if(rand==2)//这是在y坐标上变换
				{		
					System.out.println("hello3");
					pepl.y++;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//如果迷宫走过该位置，则跳出出，重新生成
						{
							pepl.y--;
							dec=false;
							break;
						}	
						dec=true;
					}
					if(dec=false)
					{
						dec=true;
						break;
					}
					else if(pepl.y==count)
					{
						pepl.y--;
						break;
					}
			
					else 
					{
						list.set(pepl.y*count+pepl.x,0);
						pepls[record].x=pepl.x;
						pepls[record].y=pepl.y;
						record++;//记录一次路径
						break;
					}
				}
				
				
				
				else if(rand==3)//这是在y坐标上变换
				{		
					System.out.println("hello4");
					pepl.y--;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//如果迷宫走过该位置，则跳出出，重新生成
						{
							pepl.y++;
							dec=false;
							break;
						}	
						dec=true;
					}
					if(dec=false)
					{
						dec=true;
						break;
					}
					else if(pepl.y==count)
					{
						pepl.y++;
						break;
					}
					else if(pepl.y==-1)
					{
						pepl.y++;
						break;
					}
					else 
					{
						list.set(pepl.y*count+pepl.x,0);
						pepls[record].x=pepl.x;
						pepls[record].y=pepl.y;
						record++;//记录一次路径
						break;
					}
				}			
			}
		}
		for(int num=0;num<count*count;num++)
		{
			System.out.print(list.get(num));
			if((num+1)%count==0)
			{
				System.out.println();
			}
		}
		
	}
}
	

