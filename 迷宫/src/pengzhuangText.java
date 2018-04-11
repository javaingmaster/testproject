
public class pengzhuangText 
{
	static int sx=10;
	static int sy=10;
	static int rw=500;
	static int w=15;
	static String str;
	boolean text(int dir,int x,int y,int mx,int my)//x是坐标，y也是坐标 ，同时这时候传入的x当做横坐标，y当做纵坐标
	{
		
		newcreat te=new newcreat();//获得墙的障碍	
		boolean succ=true;//定义是否能通过
		//System.out.println("\n障碍数为"+te.zhangai.size()+" dir数为"+dir);
		//System.out.println("x坐标为"+x+"  y坐标为"+y+"\n");
		if(dir==0)//如果是向上方向
		{
			if(y-w<sy)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//判断是否能走
			{
				if((y-w<=te.zhangai.get(i).y&&y>te.zhangai.get(i).y)&&(te.zhangai.get(i).y==te.zhangai.get(i).y_n)&&(x>=te.zhangai.get(i).x)&&(x<=te.zhangai.get(i).x_n))
				{
					//System.out.println("看起来并不能走"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
			str="坐标x为"+(x-12)/w+"  坐标y为"+((y-w)-12)/w+"\n";
		}
		
		else if(dir==1)//如果是向下方向
		{
			if(y+w>sy+mx*w)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//判断是否能走
			{
				if((y+w>=te.zhangai.get(i).y&&y<te.zhangai.get(i).y)&&(te.zhangai.get(i).y==te.zhangai.get(i).y_n)&&(x>=te.zhangai.get(i).x)&&(x<=te.zhangai.get(i).x_n))
				{
					//System.out.println("看起来并不能走"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
			str="坐标x为"+(x-12)/w+"  坐标y为"+((y+w)-12)/w+"\n";
		}
		else if(dir==2)//如果是向左方向
		{
			if(x-w<sy)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//判断是否能走
			{
				if((x-w<=te.zhangai.get(i).x&&x>te.zhangai.get(i).x)&&(te.zhangai.get(i).x==te.zhangai.get(i).x_n)&&(y>=te.zhangai.get(i).y)&&(y<=te.zhangai.get(i).y_n))
				{
					//System.out.println("看起来并不能走"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
			str="坐标x为"+(x-w-12)/w+"  坐标y为"+(y-12)/w+"\n";
		}
		else if(dir==3)//如果是向右方向
		{
			if(x+w>sy+my*w)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//判断是否能走
			{
				if((x+w>=te.zhangai.get(i).x&&x<te.zhangai.get(i).x)&&(te.zhangai.get(i).x==te.zhangai.get(i).x_n)&&(y>=te.zhangai.get(i).y)&&(y<=te.zhangai.get(i).y_n))
				{
					//System.out.println("看起来并不能走"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
				str="坐标x为"+(x+w-12)/w+"  坐标y为"+(y-12)/w+"\n";
		}
		
		return succ;	
	}
}	
