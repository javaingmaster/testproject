package hush;
import java.util.Random;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class PrisonersDilemma 
{
	public Node enter;
	public Node leftup;
	public Node rightup;
	public Node leftdown;
	public Node rightdown;
	public int size;
	private final int dd=0;
	private final int cd=0;
	private final int cc=1;
	private final double dc;
	
	public PrisonersDilemma(int size,double dc){
		this.size=size;
		 this.dc=dc;
	}
	
	
	public int[] randomdata(int size){
		
		int values[] = new int[size];    
		   int temp1,temp2,temp3;     
		        Random r = new Random();     
		        //初始化数组  
		        for(int i = 0;i < values.length;i++){  
		            values[i] = i + 1;  
		        }  
		          
		        //随机交换values.length次     
		        for(int i = 0;i < values.length;i++){  
		             temp1 = Math.abs(r.nextInt()) % (values.length-1); //随机产生一个位置     
		             temp2 = Math.abs(r.nextInt()) % (values.length-1); //随机产生另一个位置     
		             if(temp1 != temp2){  
		                 temp3 = values[temp1];     
		                 values[temp1] = values[temp2];     
		                 values[temp2] = temp3;  
		             }  
		        }  	        
		        return values;
	}
	
	public void createweb(){
		/*
		 * 生成入口
		 */
		this.enter=new Node(0,0);
		this.leftup=this.enter;
		
		/*
		 * 第一排建立
		 */
		Node tool=this.enter;
		int firstrowindex=this.size-1;
		for(int i=0;i<firstrowindex;i++){
			Node newnode=new Node(tool.row,tool.col+1);
			tool.right=newnode;
			newnode.left=tool;
			tool=newnode;
			newnode=null;
		}
		tool.right=this.leftup;
		this.rightup=tool;
		tool=this.enter;
		this.leftup.left=this.rightup;
		/*
		 * 补全建立
		 */
		Node tt = null;
		int firstcolindex=this.size-1;
		for(int i=0;i<firstcolindex;i++){
			Node newnode=new Node(tool.row+1,tool.col);
			tool.down=newnode;
			newnode.up=tool;
			tool=newnode;
			newnode=null;
			Node tooltool=tool;
			Node rowconn=tool.up.right;
			for(int j=0;j<firstcolindex;j++){
				Node newcolnode=new Node(tooltool.row,tooltool.col+1);
				tooltool.right=newcolnode;
				newcolnode.left=tooltool;
				tooltool=newcolnode;
				newcolnode=null;
				tooltool.up=rowconn;
				rowconn.down=tooltool;
				rowconn=rowconn.right;
			}
			tooltool.right=tool;
			tool.left=tooltool;
			tt=tooltool;
		}	
		/*
		 * 补全第一排以及最后一排上下引用
		 */
		Node n=this.leftup;
		while(tool!=tt){
			tool.down=n;
			n.up=tool;
			tool=tool.right;
			n=n.right;
		}
		tool.down=n;
		n.up=tool;
	}
	/*
	 * 获取收益值
	 */
	public double getprofit(Node n){
		double profit=0;
		/*
		 * up
		 */
	if(n.up.value==1){
		if(n.value==1){
			profit+=dd;
		}else{
			profit+=cd;
		}		
	}else{
        if(n.value==1){
			profit+=dc;
		}else{
			profit+=cc;
		}	
	}
	/*
	 * down
	 */
if(n.down.value==1){
	if(n.value==1){
		profit+=dd;
	}else{
		profit+=cd;
	}		
}else{
    if(n.value==1){
		profit+=dc;
	}else{
		profit+=cc;
	}	
}
/*
 * left
 */
if(n.left.value==1){
if(n.value==1){
	profit+=dd;
}else{
	profit+=cd;
}		
}else{
if(n.value==1){
	profit+=dc;
}else{
	profit+=cc;
}	
}
/*
 * right
 */
if(n.right.value==1){
if(n.value==1){
	profit+=dd;
}else{
	profit+=cd;
}		
}else{
if(n.value==1){
	profit+=dc;
}else{
	profit+=cc;
}	
}
return profit/4.0;
	
}
	/*
	 * a是否学习他的合作者？ 利用一个概率p来反映a的感知能力,p越大感知能力越强，1>p>0
	 */
	public void learn(Node a){
		if((getprofit(a)<getprofit(a.up))&&1/(1+Math.pow(Math.E, Math.abs(getprofit(a.up)-getprofit(a)))*10)>Math.random()){
			a.value=a.up.value;
		}
		if((getprofit(a)<getprofit(a.down))&&1/(1+Math.pow(Math.E, Math.abs(getprofit(a.down)-getprofit(a)))*10)>Math.random()){
			a.value=a.down.value;
		}
		if((getprofit(a)<getprofit(a.left))&&1/(1+Math.pow(Math.E, Math.abs(getprofit(a.left)-getprofit(a)))*10)>Math.random()){
			a.value=a.left.value;
		}
		if((getprofit(a)<getprofit(a.right))&&1/(1+Math.pow(Math.E, Math.abs(getprofit(a.right)-getprofit(a)))*10)>Math.random()){
			a.value=a.right.value;
		}
	}
	public double getRatioOfCooperation(){
		Node n=this.enter;
		int cooperator=0;
		for(int i=0;i<this.size;i++){
			for(int j=0;j<this.size;j++){
				if(n.value==0){
					cooperator++;
				}
				n=n.right;
			}
			n=n.down;		
		}
		return cooperator/(double)(this.size*this.size);
	}
	public static void main(String[] args) throws IOException{
		
	
		
		 OutputStream os=new FileOutputStream("D:\\PrisonersDilemma.xlsx");
	        WritableWorkbook workbook = null;			
			workbook = Workbook.createWorkbook(os);		
			WritableSheet sheet = workbook.createSheet("Name Sheet",0);
			int line=0;
			double sum = 0;
			
			for(double dc=1.01;dc<=2.0;dc+=0.01){
				  
				for(int loop=0;loop<100;loop++){
					PrisonersDilemma pd=new PrisonersDilemma(20,dc);
					pd.createweb();
					int[] randompoint=pd.randomdata(pd.size*pd.size/2);
					
					for(int u=0;u<randompoint.length;u++){
						Node n=pd.enter;
						for(int i=0;i<pd.size;i++){
							for(int j=0;j<pd.size;j++){
								if(i*pd.size+j==randompoint[u]){
									pd.learn(n);
									break;
								}
								n=n.right;
							}
							n=n.down;		
						}
					}
					     	
					sum+=pd.getRatioOfCooperation();
					System.out.println(sum);
				}
				Label l= new Label(line,0,String.valueOf(sum/100.0));
		     	try {
					sheet.addCell(l);					
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}     		      	
				line++;
				sum=0;
			}

		try {
			 workbook.write();
			workbook.close();
			os.close();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		
	}

	public class Node {  
		
		public Node(int row,int col){
			this.row=row;
			this.col=col;
			this.value=Math.random()>0.5?1:0;
		}
	      /*
	       * value=1表示背叛
	       * value=0表示合作
	       */
	      int row, col;    
	      int value;    
	      
	       Node up;
	       Node down;
	       Node left;
	       Node right;                
	}  
	/*public static final String empty=" ";
	class table
	{
		int modvalue;
		int length;
		String[] data0;
		String[] data1;
		String[] data2;
		String[] data3;
		String[] data4;
	}
	table one=new table();
	int sign_control=1,pow=1,pow_control=1;
	Scanner input=new Scanner(System.in);
	double index_change=0;
	public void hushtable()
	{		
		one.length=50;
		one.data0=new String[one.length];
		one.data1=new String[one.length];
		one.data2=new String[one.length];
		one.data3=new String[one.length];
		one.data4=new String[one.length];
		one.modvalue=47;
	}
	public void quadratic_rehash(int x,String s0,String s1,String s2,String s3,String s4)
	{		
		index_change=Math.pow(pow, 2);
		if((sign_control%2)==0)
		{
			index_change=0-index_change;
		}
		if(one.data0[(int) (x+index_change)].equals(empty))
		{
			one.data0[(int) (x+index_change)]=s0;
			one.data1[(int) (x+index_change)]=s1;
			one.data2[(int) (x+index_change)]=s2;
			one.data3[(int) (x+index_change)]=s3;
			one.data4[(int) (x+index_change)]=s4;
			sign_control=1;
			pow=1;
			pow_control=1;
			index_change=0;
		}
		else
		{
			sign_control++;
			if((pow_control%2)==0)
			{
				pow++;
			}
			pow_control++;
			quadratic_rehash(x,s0,s1,s2,s3,s4);
		}
	}
	public void insertion() throws RowsExceededException, WriteException, IOException
	{
		for(int i=0;i<one.length;i++)
		{
			one.data0[i]=empty;
			one.data1[i]=empty;
			one.data2[i]=empty;
			one.data3[i]=empty;
			one.data4[i]=empty;
		}		
		int control=0,index;
		System.out.println("please input the name,number,sex,major,mark: ");
		while(control!=30)
		{
			String name=input.nextLine();
			if(name.equals("exit"))
			{
				break;
			}
			else{
			String number=input.nextLine();		
			String sex=input.nextLine();
			String major=input.nextLine();
			String mark=input.nextLine();						
			String array0=String.valueOf(name);
		    char[] helparray0 = array0.toCharArray();
		    String array1=String.valueOf(number);
		    char[] helparray1 = array1.toCharArray();
		    String array2=String.valueOf(sex);
		    char[] helparray2= array2.toCharArray();
		    String array3=String.valueOf(major);
		    char[] helparray3 = array3.toCharArray();
		    String array4=String.valueOf(mark);
		    char[] helparray4 = array4.toCharArray();
		    index=(helparray0[0]*helparray0[1])%one.modvalue;
		    if(one.data0[index].equals(empty))
		    {
		    one.data0[index]=name;
		    one.data1[index]=number;
		    one.data2[index]=sex;
		    one.data3[index]=major;
		    one.data4[index]=mark;
		    control++;}
		    else
		    {
		      quadratic_rehash(index,name,number,sex,major,mark);
		      control++;
		    }
		    }
		}		
		    OutputStream os=new FileOutputStream("D:\\name.xlsx");
	        WritableWorkbook workbook = null;			
			workbook = Workbook.createWorkbook(os);		
			WritableSheet sheet = workbook.createSheet("Name Sheet",0);
	        for(int i=0;i<one.length;i++)
	        {
	        	Cell cell=sheet.getCell(0, i);
	        	String option=cell.getContents();
	        	if(option.equals(""))
	        	{
	        		Label namewrite0 = new Label(0,i,one.data0[i]);
	     	        sheet.addCell(namewrite0);
	     	        Label namewrite1 = new Label(1,i,one.data1[i]);
	     	        sheet.addCell(namewrite1);
	     	        Label namewrite2 = new Label(2,i,one.data2[i]);
	     	        sheet.addCell(namewrite2);
	     	        Label namewrite3 = new Label(3,i,one.data3[i]);
	     	        sheet.addCell(namewrite3);
	     	        Label namewrite4 = new Label(4,i,one.data4[i]);
	     	        sheet.addCell(namewrite4);      		
	        	}     
	        	else
	        	{
	        		Label namewrite0 = new Label(0,i+50,one.data0[i]);
	     	        sheet.addCell(namewrite0);
	     	        Label namewrite1 = new Label(1,i+50,one.data1[i]);
	     	        sheet.addCell(namewrite1);
	     	        Label namewrite2 = new Label(2,i+50,one.data2[i]);
	     	        sheet.addCell(namewrite2);
	     	        Label namewrite3 = new Label(3,i+50,one.data3[i]);
	     	        sheet.addCell(namewrite3);
	     	        Label namewrite4 = new Label(4,i+50,one.data4[i]);
	     	        sheet.addCell(namewrite4);   
	        	}
	        }	        
	        workbook.write();
	        workbook.close();
	        os.close();	    
	}
	public void search()
	{
		while(true)
		{
		int output_control=0;
		System.out.println("\n");
		System.out.println("请输入查询人的名字：");
		String compare=input.nextLine();
		String compare0=String.valueOf(compare);
	    char[] comparearray= compare0.toCharArray();
	    int checkindex=(comparearray[0]*comparearray[1])%one.modvalue;
	    if(one.data0[checkindex].equals(compare))
	    {
	    	System.out.println(" ");
	    	System.out.print(one.data0[checkindex]);
	    	System.out.print(" ");
	    	System.out.print(one.data1[checkindex]);
	    	System.out.print(" ");
	    	System.out.print(one.data2[checkindex]);
	    	System.out.print(" ");
	    	System.out.print(one.data3[checkindex]);
	    	System.out.print(" ");
	    	System.out.print(one.data4[checkindex]);
	    }
	    else
	    {
	    	while((checkindex>=0)&&(checkindex<=one.data0.length))
	    	{
	    		index_change=Math.pow(pow, 2);
	    		if((sign_control%2)==0)
	    		{
	    			index_change=0-index_change;
	    		}
	    		checkindex=(int) (checkindex+index_change);
	    		if((checkindex>=0)&&(checkindex<=one.data0.length)){;}
	    		else{break;}
	    		if(one.data0[checkindex].equals(compare))
	    		{
	    			System.out.println("\n");
	    	    	System.out.print(one.data0[checkindex]);
	    	    	System.out.print("  ");
	    	    	System.out.print(one.data1[checkindex]);
	    	    	System.out.print("  ");
	    	    	System.out.print(one.data2[checkindex]);
	    	    	System.out.print("  ");
	    	    	System.out.print(one.data3[checkindex]);
	    	    	System.out.print("  ");
	    	    	System.out.print(one.data4[checkindex]);	    	    
	    	    	sign_control=1;
	    			pow=1;
	    			pow_control=1;
	    			index_change=0;
	    	    	output_control=1;
	    	    	break;
	    		}	
	    		else{	    		
	    				sign_control++;
	    				if((pow_control%2)==0)
	    				{
	    					pow++;
	    				}
	    				pow_control++;
	    		}	    		
	    	}
	    	if(output_control==0)
	    	{System.out.println("查无此人。");}
	    }
		}
	}
	public static void main(String[] args) throws RowsExceededException, WriteException, IOException
	{	
		hushtab test=new hushtab();
		test.hushtable();
		test.insertion();	
		test.search();
	}*/
}
