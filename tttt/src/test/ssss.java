package test;

import java.awt.image.BufferedImage;
import java.util.Stack;

public class ssss 
{
	public static Stack <Integer>stack_i=new Stack<Integer>();
	public static Stack <Integer>stack_j=new Stack<Integer>();

	public static int[][] test=new int[10][10];
	public static int[][] test2=new int[10][10];
	public static int sign=1;
	public static int countpoint=1;
	public static void main(String[] args)
	{
			
		ssss s=new ssss();
		s.givevalue(test);
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{			
				if((test[i][j]==1)&&test2[i][j]==0)
            	{   
					countpoint=1;      		
            		s.getConnectedvalue(i,j); 
            			
			    }
				
				if(countpoint<4)        				
    			{
    				for(int p=0;p<10;p++)
    				{
    					for(int g=0;g<10;g++)
    					{
    						if(test2[p][g]==sign)
    						test[p][g]=2;          						
    					    }
    					
    				}   			  
    			   countpoint=1;
    			}	
    			else{
    				sign++;
    				 countpoint=1;
    			}
		}
		}
		/*for(int p=0;p<10;p++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(test2[p][j]);
				
			    }
			System.out.println();
		}
		for(int p=0;p<10;p++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(test[p][j]);
				
			    }
			System.out.println();
		}*/
		
		
	}
		public void getConnectedvalue(int i,int j)
		{			
			test2[i][j]=sign;		
		
			if(i-1>=0&&test[i-1][j]==1&&test2[i-1][j]==0)
			{
				countpoint++;
				System.out.println(countpoint);
				getConnectedvalue(i-1,j);
			}
			if(j+1<10&&test[i][j+1]==1&&test2[i][j+1]==0)
			{
				countpoint++;
				System.out.println(countpoint);
				getConnectedvalue(i,j+1);
			}
			if(i+1<10&&test[i+1][j]==1&&test2[i+1][j]==0)
			{
				countpoint++;
				System.out.println(countpoint);
				getConnectedvalue(i+1,j);
			}
			if(j-1>=0&&test[i][j-1]==1&&test2[i][j-1]==0)
			{
				countpoint++;
				System.out.println(countpoint);
				getConnectedvalue(i,j-1);
			}
	
			
		}
	
	
	public void givevalue(int[][] test)
	{
	
		for(int i=3;i<8;i++)
		{
			for(int j=4;j<9;j++)
			{
				test[i][j]=1;
			}
		}
		test[0][4]=1;
		test[1][4]=1;
		test[2][4]=1;
		test[1][3]=1;
		test[1][2]=1;
		test[1][1]=1;
		test[1][2]=1;
		test[1][3]=1;
		test[1][4]=1;
		test[1][5]=1;
		
	
	for(int p=0;p<10;p++)
	{
		for(int j=0;j<10;j++)
		{
			System.out.print(test[p][j]);
			
		    }
		System.out.println();
	}
	
	}
}

