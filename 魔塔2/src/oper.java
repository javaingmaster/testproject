
public class oper//���������˶�����
{
	static int layer=0;
	isueb move(player pla,map maps,int alin,String s)
	{
		maplist mapl=new maplist();//��ȡ��Ӧ�ĵ�ͼ
		battles bat=new battles();
		
		int x=pla.y;
		int y=pla.x;//��ȡ�û�����
		
		isueb is=new isueb();//����������������û��Ƿ������ս�����Լ��Ƿ��ܹ�ͨ��
		
		if(alin==2)//�����ƶ�
		{
			if(y+1>14)
			{
				is.dei=false;
				System.out.println("�²�ȥ��");
				return is;
			}
			if(maps.ma[x][y+1].isTh==true)
			{
				if(maps.ma[x][y+1].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x][y+1].obj.atta;
				}
				else if(maps.ma[x][y+1].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x][y+1].obj.def;
				}
				else if(maps.ma[x][y+1].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x][y+1].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x][y+1].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x][y+1].obj.key;
				}
				else if(maps.ma[x][y+1].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x][y+1].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x][y+1].obj.def;
					pla.attack=pla.attack+maps.ma[x][y+1].obj.atta;
				}
				maps.ma[x][y+1].isTh=false;
			}
			
			if(maps.ma[x][y+1].ismon==true&&maps.ma[x][y+1].mon.type>=1)//�����npc������npc���ǹ���򲻽���ս��
			{
				if(maps.ma[x][y+1].mon.tietu==25)//����
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x][y+1].ismon==true&&maps.ma[x][y+1].mon.type==0)//�����npc�������ǹ���ͽ���ս��
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pla.alive=bat.bat(pla,maps.ma[x][y+1].mon,s);//��ս�������������ҵ�alive�����ս�ܣ�����ҵ�aliveΪfalse
				is.isbat=true;//�����û�������ս��
				
				if(pla.alive==true)//�����һ�����
				{
					maps.ma[x][y+1].ismon=false;
					maps.ma[x][y+1].across=0;
				}
			}
		
			if(maps.ma[x][y+1].across==0)//ͨ·
			{
				is.dei=true;
				pla.x=y+1;
				pla.y=x;
			}
			else if(maps.ma[x][y+1].across==1)//��ǽ
			{
				is.dei=false;
			}
			
			else if(maps.ma[x][y+1].across==3)//����һ��
			{
				is.dei=true;		
				pla.x=y+1;
				pla.y=x;
				is.isCh=2;
				layer++;//������һ
				is.layer=layer;
				maps=mapl.list.get(layer);//�õ�ͼָ����һ��
			}
			
			else if(maps.ma[x][y+1].across==-1)//����һ��
			{
				is.dei=true;
				pla.x=y+1;
				pla.y=x;
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
			}
			else if(maps.ma[x][y+1].across==2)//���ŵĻ�
			{
				if(pla.key>0)//�������Կ��
				{
					pla.key--;
					maps.ma[x][y+1].across=0;
					is.dei=true;
					pla.x=y+1;
					pla.y=x;
				}
				else//���û��Կ�ף��͹���ȥ 
				{
					is.dei=false;
				}
			}
		}
		
		
		else if(alin==8)//�����ƶ�
		{
			if(y-1<0)
			{
				is.dei=false;
				System.out.println("�ϲ�ȥ��");
				return is;
			}
			
			if(maps.ma[x][y-1].isTh==true)
			{
				if(maps.ma[x][y-1].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x][y-1].obj.atta;
				}
				else if(maps.ma[x][y-1].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x][y-1].obj.def;
				}
				else if(maps.ma[x][y-1].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x][y-1].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x][y-1].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x][y-1].obj.key;
				}
				else if(maps.ma[x][y-1].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x][y-1].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x][y-1].obj.def;
					pla.attack=pla.attack+maps.ma[x][y-1].obj.atta;
				}
				maps.ma[x][y-1].isTh=false;
			}
			if(maps.ma[x][y-1].ismon==true&&(maps.ma[x][y-1].mon.type>=1))//�����npc������npc���ǹ���򲻽���ս��
			{
				if(maps.ma[x][y-1].mon.tietu==25)//����
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x][y-1].ismon==true&&(maps.ma[x][y-1].mon.type==0))//����й֣��ͽ���ս��
			{
				pla.alive=bat.bat(pla,maps.ma[x][y-1].mon,s);//��ս��������������
				is.isbat=true;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pla.alive==true)
				{
					maps.ma[x][y-1].ismon=false;
					maps.ma[x][y-1].across=0;
				}
			}
			
			
			 if(maps.ma[x][y-1].across==0)//ͨ·
			{
				is.dei=true;
				pla.x=y-1;
				pla.y=x;
			}
			else if(maps.ma[x][y-1].across==1)//��ǽ
			{	is.dei=false; }
			else if(maps.ma[x][y-1].across==3)//����һ��
			{
				is.dei=true;
				pla.x=y-1;
				pla.y=x;
				System.out.println("��ʱ���ڵ�ͼ"+layer);
				if(layer>=0)
				{
					is.isCh=2;
					layer++;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
				System.out.println("��ͼ��"+mapl.list.size());
				System.out.println("��ʱ���ڵ�ͼ"+layer);
				System.out.println("���¥�ݵ�acrossΪ"+maps.ma[12][6].across);
			}
			else if(maps.ma[x][y-1].across==-1)//����һ��
			{
				is.dei=true;
				pla.x=y-1;
				pla.y=x;
				
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
			}
			else if(maps.ma[x][y-1].across==2)//����
			{
				if(pla.key>0)
				{
					pla.key--;
					maps.ma[x][y-1].across=0;
					is.dei=true;
					pla.x=y-1;
					pla.y=x;
				}
				else 
				{
					is.dei=false;
				}
			}
		}
		
		
		
		else if(alin==4)//�����ƶ�
		{
			if(x-1<0)
			{
				is.dei=false;
				System.out.println("����߲�����");
				return is;
			}
			
			if(maps.ma[x-1][y].isTh==true)
			{
				if(maps.ma[x-1][y].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x-1][y].obj.atta;
				}
				else if(maps.ma[x-1][y].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x-1][y].obj.def;
				}
				else if(maps.ma[x-1][y].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x-1][y].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x-1][y].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x-1][y].obj.key;
				}
				else if(maps.ma[x-1][y].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x-1][y].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x-1][y].obj.def;
					pla.attack=pla.attack+maps.ma[x-1][y].obj.atta;
				}
				maps.ma[x-1][y].isTh=false;
			}
			
			if(maps.ma[x-1][y].ismon==true&&maps.ma[x-1][y].mon.type>=1)
			{
				if(maps.ma[x-1][y].mon.tietu==25)//����
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x-1][y].ismon==true&&maps.ma[x-1][y].mon.type==0)//����й֣��ͽ���ս��
			{
				pla.alive=bat.bat(pla,maps.ma[x-1][y].mon,s);//��ս��������������
				is.isbat=true;
				if(pla.alive==true)
				{
					maps.ma[x-1][y].ismon=false;
					maps.ma[x-1][y].across=0;
				}
			}
			
			else if(maps.ma[x-1][y].across==0)//ͨ·
			{
				is.dei=true;
				pla.x=y;
				pla.y=x-1;
			}
			else if(maps.ma[x-1][y].across==1)//��ǽ
			{ 	is.dei=false;	}
			else if(maps.ma[x-1][y].across==3)//����һ��
			{
				is.dei=true;
				pla.x=y;
				pla.y=x-1;
				if(layer>=0)
				{
					is.isCh=2;
					layer++;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
			}
			else if(maps.ma[x-1][y].across==-1)//����һ��
			{
				is.dei=true;
				pla.x=y;
				pla.y=x-1;
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
			}
			else if(maps.ma[x-1][y].across==2)//����
			{
				if(pla.key>0)
				{
					pla.key--;
					maps.ma[x-1][y].across=0;
					is.dei=true;
					pla.x=y;
					pla.y=x-1;
				}
				else 
				{
					is.dei= false;
				}
			}
		}
		
		
		
		else if(alin==6)//�����ƶ�
		{
			if(x+1>17)
			{
				is.dei=false;
				System.out.println("�ұ��߲�����");
				return is;
			}
			
			if(maps.ma[x+1][y].isTh==true)
			{
				if(maps.ma[x+1][y].obj.type==1)
				{
					pla.attack=pla.attack+maps.ma[x+1][y].obj.atta;
				}
				else if(maps.ma[x+1][y].obj.type==2)
				{
					pla.Def=pla.Def+maps.ma[x+1][y].obj.def;
				}
				else if(maps.ma[x+1][y].obj.type==3)
				{
					pla.life=pla.life+maps.ma[x+1][y].obj.HealPots;
//					if(pla.life>=pla.maxlife)
//					{
//						pla.life=pla.maxlife;
//					}
				}
				else if(maps.ma[x+1][y].obj.type==4)
				{
					pla.key=pla.key+maps.ma[x+1][y].obj.key;
				}
				else if(maps.ma[x+1][y].obj.type==0)
				{
					pla.life=pla.life+maps.ma[x+1][y].obj.HealPots;
					pla.Def=pla.Def+maps.ma[x+1][y].obj.def;
					pla.attack=pla.attack+maps.ma[x+1][y].obj.atta;
				}
				maps.ma[x+1][y].isTh=false;
			}
			if(maps.ma[x+1][y].ismon==true&&(maps.ma[x+1][y].mon.type>=1))
			{
				if(maps.ma[x+1][y].mon.tietu==25)//����
				{
					Shop ss=new Shop(pla);					
				}
			}
			else if(maps.ma[x+1][y].ismon==true&&(maps.ma[x+1][y].mon.type==0))//����й֣��ͽ���ս��
			{
				pla.alive=bat.bat(pla,maps.ma[x+1][y].mon,s);//��ս��������������
				is.isbat=true;
				if(pla.alive==true)
				{
					maps.ma[x+1][y].ismon=false;
					maps.ma[x+1][y].across=0;
				}
			}
			
			if(maps.ma[x+1][y].across==1)//��ǽ
			{ is.dei=false;}
			else if(maps.ma[x+1][y].across==3)//����һ��
			{
				is.dei=true;
				pla.x=y;
				pla.y=x+1;
				if(layer>=0)
				{
					is.isCh=2;
					layer++;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
			}
			else if(maps.ma[x+1][y].across==-1)//����һ��
			{
				is.dei=true;
				pla.x=y;
				pla.y=x+1;
				if(layer>0)
				{
					is.isCh=1;
					layer--;
					is.layer=layer;
					maps=mapl.list.get(layer);//�õ�ͼָ����һ��
				}
			}
			else if(maps.ma[x+1][y].across==0)//ͨ·
			{
			//	System.out.print("x=="+x);
				is.dei=true;
				pla.x=y;
				pla.y=x+1;
			}
			else if(maps.ma[x+1][y].across==2)//����
			{
				if(pla.key>0)
				{
					pla.key--;
					maps.ma[x+1][y].across=0;
					is.dei=true;
					pla.x=y;
					pla.y=x+1;
				}
				else 
				{
					is.dei=false;
				}
			}
		}
		//System.out.println("x:"+pla.x+"    y:"+pla.y);
		return is;
	}
}
