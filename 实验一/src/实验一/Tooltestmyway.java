package ʵ��һ;

import java.util.ArrayList;



public class Tooltestmyway 
{
	ArrayList<equaltable> allthetable=new ArrayList<equaltable>();
	int tablesize=0;
	equaltable createreference;
	equaltable enterreference;
	boolean ifbreak;
	boolean ifgo_on=true;
	
	public equaltable create_a_new_equaltable()
	{
		createreference=new equaltable();
		allthetable.add(createreference);
		tablesize++;
		return  createreference;
	}
	public void enterintable(int value,equaltable createreference,int com)
	{
		if(com==0)
		{
		for(int i=0;i<allthetable.size();i++)
		{
			enterreference=allthetable.get(i);
			for(int j=0;j<enterreference.storetable.size();j++)
			{
				//int compare=enterreference.storetable.get(j);
				if(enterreference.storetable.get(j).equals(value))
				{										
						//enterreference.storetable.add(value);
						allthetable.remove(createreference);	                 tablesize--;            																		
						System.out.println("�ɹ�ɾ���±�");
						//System.out.println("�ɹ���Ԥ����ֵ���뵽���ж�����");
						ifbreak=true;
						ifgo_on=false;
				}
				if(ifbreak)
				{break;}
			}
			if(ifbreak)
			{break;}
		}
		ifbreak=false;
		
		if(ifgo_on)
		{
			System.out.println("�����ȼ۱�û�в����ֵ");
		if(createreference.storetable.size()==0)
		{
			createreference.storetable.add(value);
			System.out.println("�ѽ���ֵ�����±���");
		}
		/*else
		{
			for(int m=0;m<createreference.storetable.size();m++)
			{
				int temp=createreference.storetable.get(m);
				if(temp==value)
				{
					System.out.println("ԭ���д���Ԥ����ֵ");
					break;
				}
				else{
					System.out.println("�ɹ�����һ����ֵ");
					createreference.storetable.add(value);
				}
			}
		}*/
		}
		}
		else
		{
			int m=0;
			for(int i=0;i<allthetable.size();i++)
			{
				enterreference=allthetable.get(i);
				for(int j=0;j<enterreference.storetable.size();j++)
				{
					//int compare=enterreference.storetable.get(j);
					
					/*if(enterreference.storetable.get(j).equals(value))//???????????????????????????????????????????????????????
					{	
						allthetable.remove(enterreference);
						break;
					}*/
					
					
					
					if(enterreference.storetable.get(j).equals(com))
					{				
							
						for(m=0;m<enterreference.storetable.size();m++)
						{
							//int temp=enterreference.storetable.get(m);
							if(enterreference.storetable.get(m).equals(value))
							{
								System.out.println("����ֵ���϶���ʱԭ���д���Ԥ����ֵ");
								break;
							}							
						}
						if(m==enterreference.storetable.size()){							
							enterreference.storetable.add(value);
							System.out.println("�ɹ�����ֵ���뵽��ֵ������");
							/*for(int w=0;w<allthetable.size();w++)
							{
								equaltable e=allthetable.get(w);
								for(int p=0;p<e.storetable.size();p++)
								{
									if(e.storetable.get(p).equals(value))
									{
										allthetable.remove(e);
										System.out.println("��ֵת�ƺ�ԭ�����");
										ifbreak=true;
										break;
									}
								}
								if(ifbreak)
								{break;}
							}
							ifbreak=false;*/
						}					
							allthetable.remove(createreference);               tablesize--;
							System.out.println("�ɹ������������ɾ��һ���ȼ۱�");
							
							ifbreak=true;
					}
					if(ifbreak)
					{break;}
				}
				if(ifbreak)
				{break;}
			}
		}
	}
}