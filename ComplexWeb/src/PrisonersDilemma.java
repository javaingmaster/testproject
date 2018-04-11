import java.awt.Label;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;

import jxl.Cell;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PrisonersDilemma {
	
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
		        //��ʼ������  
		        for(int i = 0;i < values.length;i++){  
		            values[i] = i + 1;  
		        }  
		          
		        //�������values.length��     
		        for(int i = 0;i < values.length;i++){  
		             temp1 = Math.abs(r.nextInt()) % (values.length-1); //�������һ��λ��     
		             temp2 = Math.abs(r.nextInt()) % (values.length-1); //���������һ��λ��     
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
		 * �������
		 */
		this.enter=new Node(0,0);
		this.leftup=this.enter;
		
		/*
		 * ��һ�Ž���
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
		 * ��ȫ����
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
		 * ��ȫ��һ���Լ����һ����������
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
	 * ��ȡ����ֵ
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
	 * a�Ƿ�ѧϰ���ĺ����ߣ� ����һ������p����ӳa�ĸ�֪����,pԽ���֪����Խǿ��1>p>0
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
	public static void main(String[] args){
		
	
		double dc=Math.random()+1;
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
	        	}     
	        }	        
	        workbook.write();
	        workbook.close();
	        os.close();	    
		
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
			System.out.println(pd.getRatioOfCooperation());
		}
		
	}

	public class Node {  
		
		public Node(int row,int col){
			this.row=row;
			this.col=col;
			this.value=Math.random()>0.5?1:0;
		}
	      /*
	       * value=1��ʾ����
	       * value=0��ʾ����
	       */
	      int row, col;    
	      int value;    
	      
	       Node up;
	       Node down;
	       Node left;
	       Node right;                
	}  
}
