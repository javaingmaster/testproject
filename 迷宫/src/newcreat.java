import java.util.ArrayList;


public class newcreat 
{
	sbw hell=new sbw();//������ͼ
	static int sx=10;
	static int sy=10;
	static int rw=500;
	static int w=15;
	newlist [][] list;//����һ���Թ�����
	static int x,y;//����x,y����
	static int as;
	static int bs;
	static int chukou;
	static int jinkou;
	static ArrayList<newlist> liward=new <newlist> ArrayList();//�����洢��ǽ������
	static ArrayList<deadline> zhangai=new <deadline> ArrayList();//�����洢�ϰ���ǽ
	
	int  ncreat(zuobiao s)
	{
		as=s.x;
		bs=s.y;
		int c;
		list=new newlist[as][bs];
		for(int a=0;a<as;a++)
			for(int b=0;b<bs;b++)
				list[a][b]=new newlist();//Ϊ�Թ���������	
		c=find_road();
		return c;
	}
	
	
	int randjin()
	{
		int jinkou=(int)(Math.random()*(as));//����߽�����һ�����,������Ϊһ��ͨ·
		list[jinkou][0].lfrd=true;//�����λ����Ϊͨ·
		list[jinkou][0].left=0;//��ͨ·�����ǽ�𿪣�
		list[jinkou][0].x=jinkou;//���ø�ͨ·��x����
		list[jinkou][0].y=0;//���ø�ͨ·��y����
		return jinkou;
	}
	
	int randchu()
	{
		int chukou=(int)(Math.random()*(as));//���ұ߽�����һ�����ڣ�������Ϊͨ·
		list[chukou][bs-1].right=0;//��ͨ·���ұ�ǽ��	
		list[chukou][bs-1].x=chukou;
		list[chukou][bs-1].y=bs-1;
		return chukou;
	}
	
	
	
	
	
	
	int find_road()//��������������Թ���
	{
		jinkou=randjin();//��ȡ���
		chukou=randchu();//��ȡ�յ�
	//	System.out.println(jinkou);
		int Asize;//��¼��ǽ������ĳ���
		int random1,random2;//�����
		
		newlist net=new newlist();//���ڻ�ȡ��Arryalist��ȡ���Ķ���
		
		liward.add(list[jinkou][0]);//�Ȱ���ǽ�ӽ�ȥ
		
		hell.getzuobiao(sx+jinkou*w,sx, 2);
		hell.getzuobiao(sx+chukou*w,sx+(bs-1)*w,3);

		
		while(true)		
		{
			Asize=liward.size();//��ȡǽ�����鳤��
			random1=(int)(Math.random()*Asize);
			net=liward.get(random1);//��ȡ����ĸ���λ��
			
			
			//��������·�������㷨
			while(true)
			{	
				random2=(int)(Math.random()*4);//��ȡ����ĸ����ڲ���λ��,��������
				
				//System.out.println("random1="+random1);
				//System.out.println("random2="+random2);
				//System.out.println("ѡ�������Ϊ:x="+net.x+"  y="+net.y);
				//System.out.println(net.up+" "+net.down+" "+net.left+" "+net.right);
				//System.out.println("");
				
				if(random2==0)//���Ϸ���
				{
					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
					{ liward.remove(net);break;}
					
					if(net.x==0)//����Ѿ�����ǽ�ˣ��������������
					{
						net.up=0;
						//�����Ǵ洢ǽ��
					}
				
					else if(net.up==0)//���ǽ�����ڣ����������
					{}
					else if(net.up==1&&net.x>0)//���ǽ���ڵ�ͬʱ������ط�û�ж���ǽ
					{
						if(list[net.x-1][net.y].lfrd==false)//�������ͨ·
						{
							net.up=0;//�Ƴ����ǽ�����Ұ���һ��·��Ҳ����
							
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,0);

							list[net.x-1][net.y].cross=true;//����һ��·����Ϊ������
							list[net.x-1][net.y].lfrd=true;//����һ��·������Ϊͨ·
							list[net.x-1][net.y].x=net.x-1;
							list[net.x-1][net.y].y=net.y;
							list[net.x-1][net.y].down=0;//��ͨ�󣬰���������·����·Ҳ��Ϊ0
							
							liward.add(list[net.x-1][net.y]);//����һ��·������
						//	System.out.println("�µõ���·����Ϊx="+(net.x-1)+",y="+net.y+"��ʱliward�Ĵ�СΪ"+liward.size());
							//System.out.println("");
							
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
						
						else if(list[net.x-1][net.y].lfrd==true)//�����ͨ·
						{
							net.up=0;//��ǽ����
							
							//�����Ǵ洢ǽ��
							deadline zhang=new deadline();
							//System.out.println("�����б仯");
							zhang.y=sx+net.x*w;
							zhang.x=sx+net.y*w;
							zhang.y_n=zhang.y;
							zhang.x_n=zhang.x+w;
							zhang.dir=0;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
					}
				
				}
		
		
				
		
				else if(random2==1)//���·���
				{

					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
					{ liward.remove(net);break;}
					
					if(net.x==as-1)//����Ѿ�����ǽ�ˣ�������Ϊ0
					{
						net.down=0;
						//�����Ǵ洢ǽ��
					}
				
					else if(net.down==0)//����÷����Ѿ�û��ǽ�ˣ�������
					{}
					else if(net.down==1&&net.x<as-1)//�������û�ж�����Ե��ͬʱǽ����
					{
						if(list[net.x+1][net.y].lfrd==false)//�������ͨ·
						{
							net.down=0;//�Ƴ����ǽ�����Ұ���һ��·��Ҳ����
							
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,1);
							
							list[net.x+1][net.y].cross=true;//�Ѹ�·������Ϊ����
							list[net.x+1][net.y].lfrd=true;//����һ��·������Ϊͨ·
							list[net.x+1][net.y].x=net.x+1;
							list[net.x+1][net.y].y=net.y;
							list[net.x+1][net.y].up=0;//��ͨ�󣬰���������·��·Ҳ��Ϊ0
							liward.add(list[net.x+1][net.y]);//����һ��·������
						//	System.out.println("�µõ���·����Ϊx="+(net.x+1)+",y="+net.y+"��ʱliward�Ĵ�СΪ"+liward.size());
						//	System.out.println("");
							
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
						
						
						else if(list[net.x+1][net.y].lfrd==true)//�����ͨ·
						{
							net.down=0;//��ǽ��ȥ
							
							//�����Ǵ洢ǽ��
							deadline zhang=new deadline();
						//	System.out.println("�����б仯");
							zhang.y=sx+net.x*w+w;
							zhang.x=sx+net.y*w;
							zhang.y_n=zhang.y;
							zhang.x_n=zhang.x+w;
							zhang.dir=1;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
					}
						
				}
				
		
		
				else if(random2==2)//������
				{

					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
					{ liward.remove(net);break;}
					
					 if(net.y==0)//����Ѿ�����ǽ�ˣ�������Ϊ0
					{
						
						net.left=0;
					}
				
					else if(net.left==0)
					{}
					else if(net.left==1&&net.y>0)
					{
						if(list[net.x][net.y-1].lfrd==false)//�������ͨ·
						{
							net.left=0;//�Ƴ����ǽ�����Ұ���һ��·��Ҳ����
				
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,2);
						
							list[net.x][net.y-1].cross=true;
							list[net.x][net.y-1].lfrd=true;//����һ��·������Ϊͨ·
							list[net.x][net.y-1].x=net.x;
							list[net.x][net.y-1].y=net.y-1;
							list[net.x][net.y-1].right=0;//��ͨ�󣬰��������·����·Ҳ��Ϊ0
							liward.add(list[net.x][net.y-1]);//����һ��·������
						//	System.out.println("�µõ���·����Ϊx="+(net.x)+",y="+(net.y-1)+"��ʱliward�Ĵ�СΪ"+liward.size());
						//	System.out.println("");
							
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
						else if(list[net.x][net.y-1].lfrd==true)//�����ͨ·
						{
							net.left=0;
							
							//�����Ǵ洢ǽ��
							deadline zhang=new deadline();
							//System.out.println("�����б仯");
							
							zhang.y=sx+net.x*w;
							zhang.x=sx+net.y*w;
							zhang.y_n=zhang.y+w;
							zhang.x_n=zhang.x;
							zhang.dir=2;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
					}
						
				}
		
		
		
				else if(random2==3)//���ҷ���
				{

					if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
					{ liward.remove(net);break;}
					
					if(net.y==bs-1)//����Ѿ�����ǽ�ˣ�������Ϊ0
					{
					
						net.right=0;
					}
					else if(net.right==0)
					{}
					else if(net.right==1&&net.y<bs-1)
					{
						if(list[net.x][net.y+1].lfrd==false)//�������ͨ·
						{
							net.right=0;//�Ƴ����ǽ�����Ұ���һ��·��Ҳ����
							
							hell.getzuobiao(net.x*w+sx,net.y*w+sx,3);
							
							list[net.x][net.y+1].cross=true;
							list[net.x][net.y+1].lfrd=true;//����һ��·������Ϊͨ·
							list[net.x][net.y+1].left=0;//��ͨ�󣬰��ұ�����·����·Ҳ��Ϊ0
							list[net.x][net.y+1].x=net.x;
							list[net.x][net.y+1].y=net.y+1;
							liward.add(list[net.x][net.y+1]);//����һ��·������
						//	System.out.println("�µõ���·����Ϊx="+(net.x)+",y="+(net.y+1)+"��ʱliward�Ĵ�СΪ"+liward.size());
							System.out.println("");
						//	
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
						else if(list[net.x][net.y+1].lfrd==true)//�����ͨ·
						{
							net.right=0;
							
							//�����Ǵ洢ǽ��
							deadline zhang=new deadline();
							//System.out.println("�����б仯");
							zhang.y=sx+net.x*w;
							zhang.x=sx+net.y*w+w;
							zhang.y_n=zhang.y+w;
							zhang.x_n=zhang.x;
							zhang.dir=3;
							zhangai.add(zhang);
							if((net.up==0)&&(net.down==0)&&(net.left==0)&&(net.right==0))//������·��û����ǽ�ˣ������ǽ�б�ɾ�����·��
							{ liward.remove(net);}
							break;
						}
					}
					
				}
			
			}//��·���ڲ�while
		
			if(liward.size()==0)//����������յ��ͬʱ���б���Ҳû��ǽ�ˣ����ж�������
			{
			//	System.out.println("ǽ�ĸ���Ϊ:"+zhangai.size());
				//System.out.println(zhangai.get(0).x+" "+zhangai.get(0).y);
				//System.out.println(zhangai.get(1).x+" "+zhangai.get(1).y);
				break;
			}
		}//��·�����while
		return jinkou;
			
	}
	
}