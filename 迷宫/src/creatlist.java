import java.util.ArrayList;


public class creatlist 
{
	int count;//������¼ά��
	ArrayList<Integer> list = new  ArrayList<Integer> ();
	void creat(int weishu)//����ȫ��ǽ���Թ�
	{
		count=weishu;
		//list�����洢�Թ���ÿһ��
		for(int num=0;num<weishu;num++)
		{
			for(int num1=0;num1<weishu;num1++)
			{
				list.add(1);
			}
		}

		
	}
	
	
	void liferoad()//��·
	{
		//�������Ͻǵ�һ������㣬���½����һ�����յ�
		
		zuobiao pepl=new zuobiao();
		zuobiao pepls[]=new zuobiao[10000];//������¼·��
		for(int c=0;c<10000;c++)
		{
			pepls[c]=new zuobiao();
		}
		int record=0;//������¼·��������
		pepl.x=0;
		pepl.y=0;//�������궼��Ϊ0
		boolean dec;
		list.set(pepl.y*count+pepl.x,0);
		int rand;
		while(!(pepl.y*count+pepl.x==count*count-1))
		{
			rand=Math.random()>0.5?1:0;//���������0��1
			rand+=Math.random()>0.5?1:0;//���������0��1
			rand+=Math.random()>0.5?1:0;//���������0��1
			//�����Ϊ�˴�·
			while(true)	
			{	
				if(rand==0)//������x�����ϱ任
				{		
					System.out.println("hello1");
					pepl.x++;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//����Թ��߹���λ�ã�������������������
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

						record++;//��¼һ��·��
						break;
					}
				}
				
				else if(rand==1)//������x�����ϱ任
				{		
					System.out.println("hello2");
					pepl.x--;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//����Թ��߹���λ�ã�������������������
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
						record++;//��¼һ��·��
						break;
					}
				}
				
				
				else if(rand==2)//������y�����ϱ任
				{		
					System.out.println("hello3");
					pepl.y++;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//����Թ��߹���λ�ã�������������������
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
						record++;//��¼һ��·��
						break;
					}
				}
				
				
				
				else if(rand==3)//������y�����ϱ任
				{		
					System.out.println("hello4");
					pepl.y--;
					for(int xiaoA=0;xiaoA<record;xiaoA++)
					{
						if(pepl.x==pepls[xiaoA].x&&pepl.y==pepls[xiaoA].y)//����Թ��߹���λ�ã�������������������
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
						record++;//��¼һ��·��
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
	

