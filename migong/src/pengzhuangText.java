
public class pengzhuangText 
{
	static int sx=10;
	static int sy=10;
	static int rw=500;
	static int w=15;
	static String str;
	boolean text(int dir,int x,int y,int mx,int my)//x�����꣬yҲ������ ��ͬʱ��ʱ�����x���������꣬y����������
	{
		
		newcreat te=new newcreat();//���ǽ���ϰ�	
		boolean succ=true;//�����Ƿ���ͨ��
		//System.out.println("\n�ϰ���Ϊ"+te.zhangai.size()+" dir��Ϊ"+dir);
		//System.out.println("x����Ϊ"+x+"  y����Ϊ"+y+"\n");
		if(dir==0)//��������Ϸ���
		{
			if(y-w<sy)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//�ж��Ƿ�����
			{
				if((y-w<=te.zhangai.get(i).y&&y>te.zhangai.get(i).y)&&(te.zhangai.get(i).y==te.zhangai.get(i).y_n)&&(x>=te.zhangai.get(i).x)&&(x<=te.zhangai.get(i).x_n))
				{
					//System.out.println("��������������"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
			str="����xΪ"+(x-12)/w+"  ����yΪ"+((y-w)-12)/w+"\n";
		}
		
		else if(dir==1)//��������·���
		{
			if(y+w>sy+mx*w)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//�ж��Ƿ�����
			{
				if((y+w>=te.zhangai.get(i).y&&y<te.zhangai.get(i).y)&&(te.zhangai.get(i).y==te.zhangai.get(i).y_n)&&(x>=te.zhangai.get(i).x)&&(x<=te.zhangai.get(i).x_n))
				{
					//System.out.println("��������������"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
			str="����xΪ"+(x-12)/w+"  ����yΪ"+((y+w)-12)/w+"\n";
		}
		else if(dir==2)//�����������
		{
			if(x-w<sy)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//�ж��Ƿ�����
			{
				if((x-w<=te.zhangai.get(i).x&&x>te.zhangai.get(i).x)&&(te.zhangai.get(i).x==te.zhangai.get(i).x_n)&&(y>=te.zhangai.get(i).y)&&(y<=te.zhangai.get(i).y_n))
				{
					//System.out.println("��������������"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
			str="����xΪ"+(x-w-12)/w+"  ����yΪ"+(y-12)/w+"\n";
		}
		else if(dir==3)//��������ҷ���
		{
			if(x+w>sy+my*w)
			{
				succ=false;
			}
			for(int i=0;i<te.zhangai.size();i++)//�ж��Ƿ�����
			{
				if((x+w>=te.zhangai.get(i).x&&x<te.zhangai.get(i).x)&&(te.zhangai.get(i).x==te.zhangai.get(i).x_n)&&(y>=te.zhangai.get(i).y)&&(y<=te.zhangai.get(i).y_n))
				{
					//System.out.println("��������������"+te.zhangai.get(i).x+"  "+te.zhangai.get(i).x_n+"  "+te.zhangai.get(i).y+"  "+te.zhangai.get(i).y_n+"  ");
					succ=false;
					break;
				}
			}
			if(succ==true)
				str="����xΪ"+(x+w-12)/w+"  ����yΪ"+(y-12)/w+"\n";
		}
		
		return succ;	
	}
}	
