package 实验一;

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
						System.out.println("成功删除新表");
						//System.out.println("成功将预储存值加入到已有队列中");
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
			System.out.println("其他等价表并没有查出此值");
		if(createreference.storetable.size()==0)
		{
			createreference.storetable.add(value);
			System.out.println("已将新值加入新表中");
		}
		/*else
		{
			for(int m=0;m<createreference.storetable.size();m++)
			{
				int temp=createreference.storetable.get(m);
				if(temp==value)
				{
					System.out.println("原表中存在预加入值");
					break;
				}
				else{
					System.out.println("成功加入一个新值");
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
								System.out.println("当左值加上队列时原表中存在预加入值");
								break;
							}							
						}
						if(m==enterreference.storetable.size()){							
							enterreference.storetable.add(value);
							System.out.println("成功将左值加入到上值队列中");
							/*for(int w=0;w<allthetable.size();w++)
							{
								equaltable e=allthetable.get(w);
								for(int p=0;p<e.storetable.size();p++)
								{
									if(e.storetable.get(p).equals(value))
									{
										allthetable.remove(e);
										System.out.println("左值转移后，原表清除");
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
							System.out.println("成功在左上情况下删除一个等价表");
							
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