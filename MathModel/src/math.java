import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class math {
	List<List<mission>> allbag;
	
	public math(){
		allbag=new ArrayList<List<mission>>();
	}
	public static void main(String[] aa) throws BiffException, IOException{
		math m=new math();
		try {
			m.process();
			m.compute();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void process() throws BiffException, IOException{
		int index=0;
		boolean first=true,jmp=false;;
		mission present;
		FileInputStream fis = new FileInputStream("mmm.xls");     
		jxl.Workbook rwb = Workbook.getWorkbook(fis);   
		 Sheet sheet = rwb.getSheet(0);   
		              
		//扫描	
		   for (index = 0; index < sheet.getRows(); index++) {   
				                    Cell[] cells = sheet.getRow(index);                      			               
				                    present=new mission(Double.parseDouble(cells[0].getContents()),Double.parseDouble(cells[1].getContents()));
				                    
				                    if(first){
				        				List<mission> newbag=new ArrayList<mission>();
				        				newbag.add(present);
				        				allbag.add(newbag);			        			
				        				first=false;
				        				present=null;					        				
				        			}
				                    else{
				        			for(int i=0;i<allbag.size();i++){
				        				List bag=allbag.get(i);
				        				for(int j=0;j<bag.size();j++){
				        					mission dest=(mission)bag.get(j);
				        					
				        					if(cmpdistance(present,dest)&&bag.size()<50){
				        						bag.add(present);
				        						//System.out.println(present.x+"****"+present.y+"入旧包");
				        						jmp=true;
				        					    break;
				        					}
				        						
				        					
				        				}
				        				if(jmp){
				        					break;
				        				}
				        				
				        			}
				        			
				        			if(!jmp){
				        				List<mission> newbag=new ArrayList<mission>();
		        						newbag.add(present);
		        						allbag.add(newbag);
		        						//System.out.println(present.x+"****"+present.y+"入新包");
				        			}
				        			jmp=false;
				        			
	        						
				                 } 				                 				                    
		   }
			
			fis.close();
    		rwb.close();			
	}
	
	class mission{
		double x,y;
		
		public mission(double x, double y){
			this.x=x;
			this.y=y;
		}
	}
	
	
	public boolean cmpdistance(mission present,mission dest){
		double distance=500;	
		if(Math.pow(Math.pow((present.x-dest.x), 2)+Math.pow((present.y-dest.y), 2), 0.5)<distance){
			return true;
		}else{
			return false;
		}
	}                             
	public void compute(){
		double sum=0;  
		ArrayList <Double>l =new ArrayList<Double>();
		for(int i=0;i<allbag.size();i++){
			List bag=allbag.get(i);
			for(int j=0;j<bag.size();j++){
				mission dest=(mission)bag.get(j);
				
				sum+=(2.903*dest.x+0.7987*dest.y-88.5246);	
		    }
			sum=sum*0.8;
			l.add(sum);
	}
		
		for(int y=0;y<l.size();y++){
			System.out.println(l.get(y));
		}
	}
}
