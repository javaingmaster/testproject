import java.util.ArrayList;


public class find_road 
{
	static int sx=10;
	static int sy=10;
	static int rw=500;
	static int w=15;
	static int i;
    static	ArrayList<newlist> list=new <newlist>ArrayList();//创建数组，存储路径
	newcreat nc=new newcreat();//用于获得数据
	pengzhuangText text=new pengzhuangText();
	
	void find_road(int x,int y,int jinkou,int chukou)
	{
		int [][] li=new int[x][y];//用来定义迷宫
		
		newlist tip=new newlist();//先把起点加入
		
		tip.x=jinkou;
		tip.y=0;
		tip.cross=true;//设置该路为经过
		tip.left=0;//并设置左边为0 0表示不能走，1表示可以走
		list.add(tip);//加入起点
		//System.out.println("\n提示这里"+list.get(0).left+" "+list.get(0).right+"  "+list.size());
		
		while(true)
		{
			for( i=0;i<4;i++)//设置寻路方向，从上忘下，从左往右
			{
				if(i==0)//向上
				{
					boolean dec=text.text(0, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//判断是否能往上
					//System.out.println("dec 为"+dec+"\n");
					if(dec==true&&list.get(list.size()-1).up==1)
					{
						int asize=list.size();
						list.get(asize-1).up=0;//用来去上一层的墙							
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x-1;
						tip1.y=list.get(asize-1).y;
						tip1.cross=true;//设置该路为经过
						tip1.down=0;
						list.add(tip1);
						break;
					}
					else if(dec==false)
					{
						list.get(list.size()-1).up=0;
					}
				}
				else if(i==1)//向下
				{
					boolean dec=text.text(1, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//判断是否能往下
					//System.out.println("dec 为"+dec);
					if(dec==true&&list.get(list.size()-1).down==1)
					{
						int asize=list.size();
						
						list.get(asize-1).down=0;//用来去上一层的墙	
						
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x+1;
						tip1.y=list.get(asize-1).y;
						tip1.cross=true;//设置该路为经过
						tip1.up=0;
						list.add(tip1);
						break;
					}
					else if(dec==false)
					{
						list.get(list.size()-1).down=0;
					}
				}
				else if(i==2)//向左
				{
					boolean dec=text.text(2, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//判断是否能往下
					//System.out.println("dec 为"+dec+"\n");
					if(dec==true&&list.get(list.size()-1).left==1)
					{
						int asize=list.size();
						list.get(asize-1).left=0;//用来去上一层的墙
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x;
						tip1.y=list.get(asize-1).y-1;
						tip1.cross=true;//设置该路为经过
						tip1.right=0;
						list.add(tip1);
						break;
					}
					else
					{
						list.get(list.size()-1).left=0;
					}
				}
				else if(i==3)//向右
				{
					boolean dec=text.text(3, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//判断是否能往下
					//System.out.println("dec 为"+dec+"\n");
					if(dec==true&&list.get(list.size()-1).right==1)
					{
						int asize=list.size();
						list.get(asize-1).right=0;//用来去上一层的墙					
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x;
						tip1.y=list.get(asize-1).y+1;
						tip1.cross=true;//设置该路为经过
						tip1.left=0;
						list.add(tip1);
						break;
					}
					else
					{
						list.get(list.size()-1).right=0;
					}
				}
				else
				{}
			
			}
			if(i==4)
			{
				//System.out.println("fhauiif");
				list.remove(list.get(list.size()-1));//如果此路不通，则回到上一层
			}
		
			if((list.get(list.size()-1).x==chukou)&&(list.get(list.size()-1).y==y-1))//如果到了终点,则跳出循环，说明找到路了
			{
				System.out.println("此时"+list.size());
				System.out.println("路径为：");
				for(int h=0;h<list.size();h++)
				{
					System.out.println("x:"+list.get(h).x+"  y:"+list.get(h).y+"---》");
				}
				break;
			}
	
		}		
		
	}	
}
		
		
