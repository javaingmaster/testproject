package 实验一;


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
		
		 /*for(int i =0;i< 8 ;i++) //赋值辅助数组
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
	            	if(pi[i][j]==1&&wmnwtlcbc==0&&i==0)//第一行遇到前景色点，但算法没启动，此时启动算法
	            	{
	            		wmnwtlcbc=1;           		
	            		equaltable a=alltable.create_a_new_equaltable();
	            		alltable.enterintable(sign, a,0);  		
	            	}
	            	if(wmnwtlcbc==1&&pi[i][j]==0)//第一行算法启动后，当遇到背景色点，标志加一，首行隔断标志生效
	            	{
	            		sign++;
	            		interval_in_row_one=1;
	            	}
	            	if(pi[i][j]==1&&interval_in_row_one==1&&i==0)//首行隔断标志生效后，当遇到前景色，将此点强制标记
	            	{
	            		pi[i][j]=sign;
	            		equaltable a=alltable.create_a_new_equaltable();
	            		alltable.enterintable(sign, a,0); 
	            	}	            	
	            	if(i!=0&&pi[i][j]==1)  //不是第一行的前景色点
	            	{
	            		if(j-1<0)//若是第0列的点
	            		{
	            			if(pi[i-1][j]>0)//如果它上面的点是前景色
	            			{
	            				pi[i][j]=pi[i-1][j];//赋值
	            			}
	            			else{
	            				pi[i][j]=sign;//不是前景色就设置为sign值
	            				equaltable a=alltable.create_a_new_equaltable();
	    	            		alltable.enterintable(sign, a,0); 
	            			}
	            		}
	            		else{
	            			if(pi[i-1][j]>0&&pi[i][j-1]==0)      //讨论非首行点左上位置的像素点情况，非首行点赋值为领域中最小值（小于sign）或者sign
	            			{
	            				pi[i][j]=pi[i-1][j];
	            				System.out.println("上边为前景色点");
	            			}
	            			else if(pi[i-1][j]==0&&pi[i][j-1]>0)
	            			{
	            				pi[i][j]=pi[i][j-1];
	            				System.out.println("左边为前景色点");
	            			}else if(pi[i-1][j]==0&&pi[i][j-1]==0)
	            			{
	            				pi[i][j]=sign;
	            				System.out.println("上左边都不为前景色点");
	            				equaltable a=alltable.create_a_new_equaltable();
	    	            		alltable.enterintable(sign, a,0); 
	            			}else if(pi[i-1][j]>0&&pi[i][j-1]>0)
	            			{
	            				System.out.println("上左边都为前景色点");
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
	            				System.out.println("非首行像素点异常!");
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
