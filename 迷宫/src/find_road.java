import java.util.ArrayList;


public class find_road 
{
	static int sx=10;
	static int sy=10;
	static int rw=500;
	static int w=15;
	static int i;
    static	ArrayList<newlist> list=new <newlist>ArrayList();//�������飬�洢·��
	newcreat nc=new newcreat();//���ڻ������
	pengzhuangText text=new pengzhuangText();
	
	void find_road(int x,int y,int jinkou,int chukou)
	{
		int [][] li=new int[x][y];//���������Թ�
		
		newlist tip=new newlist();//�Ȱ�������
		
		tip.x=jinkou;
		tip.y=0;
		tip.cross=true;//���ø�·Ϊ����
		tip.left=0;//���������Ϊ0 0��ʾ�����ߣ�1��ʾ������
		list.add(tip);//�������
		//System.out.println("\n��ʾ����"+list.get(0).left+" "+list.get(0).right+"  "+list.size());
		
		while(true)
		{
			for( i=0;i<4;i++)//����Ѱ·���򣬴������£���������
			{
				if(i==0)//����
				{
					boolean dec=text.text(0, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//�ж��Ƿ�������
					//System.out.println("dec Ϊ"+dec+"\n");
					if(dec==true&&list.get(list.size()-1).up==1)
					{
						int asize=list.size();
						list.get(asize-1).up=0;//����ȥ��һ���ǽ							
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x-1;
						tip1.y=list.get(asize-1).y;
						tip1.cross=true;//���ø�·Ϊ����
						tip1.down=0;
						list.add(tip1);
						break;
					}
					else if(dec==false)
					{
						list.get(list.size()-1).up=0;
					}
				}
				else if(i==1)//����
				{
					boolean dec=text.text(1, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//�ж��Ƿ�������
					//System.out.println("dec Ϊ"+dec);
					if(dec==true&&list.get(list.size()-1).down==1)
					{
						int asize=list.size();
						
						list.get(asize-1).down=0;//����ȥ��һ���ǽ	
						
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x+1;
						tip1.y=list.get(asize-1).y;
						tip1.cross=true;//���ø�·Ϊ����
						tip1.up=0;
						list.add(tip1);
						break;
					}
					else if(dec==false)
					{
						list.get(list.size()-1).down=0;
					}
				}
				else if(i==2)//����
				{
					boolean dec=text.text(2, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//�ж��Ƿ�������
					//System.out.println("dec Ϊ"+dec+"\n");
					if(dec==true&&list.get(list.size()-1).left==1)
					{
						int asize=list.size();
						list.get(asize-1).left=0;//����ȥ��һ���ǽ
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x;
						tip1.y=list.get(asize-1).y-1;
						tip1.cross=true;//���ø�·Ϊ����
						tip1.right=0;
						list.add(tip1);
						break;
					}
					else
					{
						list.get(list.size()-1).left=0;
					}
				}
				else if(i==3)//����
				{
					boolean dec=text.text(3, list.get(list.size()-1).y*w+sx+2,list.get(list.size()-1).x*w+sx+2 , x, y);//�ж��Ƿ�������
					//System.out.println("dec Ϊ"+dec+"\n");
					if(dec==true&&list.get(list.size()-1).right==1)
					{
						int asize=list.size();
						list.get(asize-1).right=0;//����ȥ��һ���ǽ					
						newlist tip1=new newlist();
						tip1.x=list.get(asize-1).x;
						tip1.y=list.get(asize-1).y+1;
						tip1.cross=true;//���ø�·Ϊ����
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
				list.remove(list.get(list.size()-1));//�����·��ͨ����ص���һ��
			}
		
			if((list.get(list.size()-1).x==chukou)&&(list.get(list.size()-1).y==y-1))//��������յ�,������ѭ����˵���ҵ�·��
			{
				System.out.println("��ʱ"+list.size());
				System.out.println("·��Ϊ��");
				for(int h=0;h<list.size();h++)
				{
					System.out.println("x:"+list.get(h).x+"  y:"+list.get(h).y+"---��");
				}
				break;
			}
	
		}		
		
	}	
}
		
		
