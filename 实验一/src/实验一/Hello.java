package ʵ��һ;


public class Hello 
{
	public static Tooltestmyway alltable=new Tooltestmyway();
	int[][] pi=new int[8][11];
	boolean ifbreak;
	public void hello()
	{
		pi[0][1]=1;
		pi[0][2]=1;
		pi[0][3]=1;
		pi[0][5]=1;
		pi[0][7]=1;
		pi[1][1]=1;
		pi[1][5]=1;
		pi[1][4]=1;
		pi[1][9]=1;
		pi[1][10]=1;
		pi[2][0]=1;
		pi[2][1]=1;
		pi[2][2]=1;
		pi[2][3]=1;
		pi[2][5]=1;
		pi[2][8]=1;
		pi[2][9]=1;
		pi[2][10]=1;
		pi[3][5]=1;
		pi[3][3]=1;
		pi[3][6]=1;
		pi[3][7]=1;
		pi[3][9]=1;
		pi[3][10]=1;
		pi[4][0]=1;
		pi[4][1]=1;
		pi[4][2]=1;
		pi[4][3]=1;
		pi[4][5]=1;
		pi[4][6]=1;
		pi[4][8]=1;
		pi[4][9]=1;
		pi[4][10]=1;
		pi[5][0]=1;
		pi[5][1]=1;
		pi[5][4]=1;
		pi[5][6]=1;
		pi[5][10]=1;
		pi[6][1]=1;
		pi[6][2]=1;
		pi[6][3]=1;
		pi[6][4]=1;
		pi[6][6]=1;
		pi[6][10]=1;
		pi[7][2]=1;
		pi[7][3]=1;
		pi[7][10]=1;
		int sign=1;
		int interval_in_row_one=0;
		int wmnwtlcbc=0;
		
		 /*for(int i =0;i< 8 ;i++) //��ֵ��������
	        {  
	            for(int j = 0;j < 11 ;j++)  
	            {
	            	System.out.print(a[i][j]+"  ");	        	            	
	            }
	            System.out.println();	
	        }*/
		
		 for(int i = 0;i< 8 ;i++) 
	        {  
	            for(int j = 0;j < 11 ;j++)  
	            {
	            	if(pi[i][j]==1&&wmnwtlcbc==0&&i==0)//��һ������ǰ��ɫ�㣬���㷨û��������ʱ�����㷨
	            	{
	            		wmnwtlcbc=1;           		
	            		equaltable a=alltable.create_a_new_equaltable();
	            		alltable.enterintable(sign, a,0);  		
	            	}
	            	if(wmnwtlcbc==1&&pi[i][j]==0)//��һ���㷨�����󣬵���������ɫ�㣬��־��һ�����и��ϱ�־��Ч
	            	{
	            		sign++;
	            		interval_in_row_one=1;
	            	}
	            	if(pi[i][j]==1&&interval_in_row_one==1&&i==0)//���и��ϱ�־��Ч�󣬵�����ǰ��ɫ�����˵�ǿ�Ʊ��
	            	{
	            		pi[i][j]=sign;
	            		equaltable a=alltable.create_a_new_equaltable();
	            		alltable.enterintable(sign, a,0); 
	            	}	            	
	            	if(i!=0&&pi[i][j]==1)  //���ǵ�һ�е�ǰ��ɫ��
	            	{
	            		if(j-1<0)//���ǵ�0�еĵ�
	            		{
	            			if(pi[i-1][j]>0)//���������ĵ���ǰ��ɫ
	            			{
	            				pi[i][j]=pi[i-1][j];//��ֵ
	            			}
	            			else{
	            				pi[i][j]=sign;//����ǰ��ɫ������Ϊsignֵ
	            				equaltable a=alltable.create_a_new_equaltable();
	    	            		alltable.enterintable(sign, a,0); 
	            			}
	            		}
	            		else{
	            			if(pi[i-1][j]>0&&pi[i][j-1]==0)      //���۷����е�����λ�õ����ص�����������е㸳ֵΪ��������Сֵ��С��sign������sign
	            			{
	            				pi[i][j]=pi[i-1][j];
	            				System.out.println("�ϱ�Ϊǰ��ɫ��");
	            			}
	            			else if(pi[i-1][j]==0&&pi[i][j-1]>0)
	            			{
	            				pi[i][j]=pi[i][j-1];
	            				System.out.println("���Ϊǰ��ɫ��");
	            			}else if(pi[i-1][j]==0&&pi[i][j-1]==0)
	            			{
	            				pi[i][j]=sign;
	            				System.out.println("����߶���Ϊǰ��ɫ��");
	            				equaltable a=alltable.create_a_new_equaltable();
	    	            		alltable.enterintable(sign, a,0); 
	            			}else if(pi[i-1][j]>0&&pi[i][j-1]>0)
	            			{
	            				System.out.println("����߶�Ϊǰ��ɫ��");
	            				if(pi[i-1][j]<=pi[i][j-1])
	            				{
	            					pi[i][j]=pi[i-1][j];
	            				}else
	            				{
	            					pi[i][j]=pi[i][j-1];
	            				}
	            				
	            				if(pi[i-1][j]!=pi[i][j-1])
	            				{
	            					if(pi[i-1][j]<pi[i][j-1])
	            					{
	            						equaltable a=alltable.create_a_new_equaltable();
		    	            		    alltable.enterintable(pi[i][j-1], a,pi[i-1][j]);
	            					}
	            					else{
	            						equaltable a=alltable.create_a_new_equaltable();
		    	            		    alltable.enterintable(pi[i-1][j], a,pi[i][j-1]);
	            					}
	            				}
	            			}
	            			else{
	            				System.out.println("���������ص��쳣!");
	            			}
	            		}
	            	}
	            	
	            }
	            sign++;
	        }
		
		 for(int i =0;i< 8 ;i++) 
	        {  
	            for(int j =0;j <11 ;j++)  
	            {
	            	
	            		System.out.print(pi[i][j]+"   ");
	            		        	            	
	            }
	            System.out.println();
	            System.out.println();
	        }
		 
		
		 for(int index=0;index<alltable.allthetable.size();index++)
		 {
			 equaltable e0=alltable.allthetable.get(index);		
			 if(e0.storetable.size()==1)
			 {		 
				 
		 for(int i=0;i<alltable.allthetable.size();i++)
			{
				equaltable e=alltable.allthetable.get(i);
				for(int j=0;j<e.storetable.size();j++)
				{
				
					if(e!=e0&&e0.storetable.get(0).equals(e.storetable.get(j)))
					{
						alltable.allthetable.remove(e0);
						index--;
						ifbreak=true;
						break;
					}
				}
				if(ifbreak)
				{break;}
				
			}
		 ifbreak=false;
		 
			 }
		 
		 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		    for(int i=0;i<alltable.allthetable.size();i++)
			{
				equaltable e=alltable.allthetable.get(i);
				for(int j=0;j<e.storetable.size();j++)
				{
					System.out.print(e.storetable.get(j)+"**");
				}
				System.out.println();
			}
		
	}
	public static void main(String[] args)
	{
		new Hello().hello();
	}

}
