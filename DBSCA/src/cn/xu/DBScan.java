package cn.xu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvWriter;



public class DBScan {
	 private static final double EARTH_RADIUS = 6378137;  
	static final int LONG=1;
	static final int LAT=2;
	float Eps1=600;
	float Eps2=800;
	float Eps3=1000;
	float minPts1=150;
	float minPts2=150;
	float minPts3=150;
	int num;
	String[] data;
	double lng1,lng2,lat1,lat2;
	List<Point> position=new ArrayList();
	List<Point> core=new ArrayList();
	List<String> status=new ArrayList();
	List<List<Point>> Cluster= new ArrayList();
	List<List<Point>> adjacent=new ArrayList();
	
	ConSQL cl;
	int[] visited;
	public DBScan() {
//		 cl=new ConSQL();
		// TODO Auto-generated constructor stub
//		System.out.println(getDistance(102.712311, 25.02951,102.723522,25.016978));
		readData();
		firstStep();
		secondStep();
//		deleteTheIndex();
//		test();
		output();
//		writeData();
	}
	public void readData() {
		int lineNum=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("D://3//finalData2.csv")));//鏋勯�犱竴涓狟ufferedReader绫绘潵璇诲彇鏂囦欢
            String s = null;
          
            while((s = br.readLine())!=null){//浣跨敤readLine鏂规硶锛屼竴娆¤涓�琛�
            	System.out.println(s);
            		lineNum++;
            		if(lineNum!=1) {
            		String	input[]=s.split(",",-1);
            		String status=input[2];
            		double lng=Double.parseDouble(input[0]);
            		double lat=Double.parseDouble(input[1]);
            		position.add(new Point(lng,lat,0,status));
            		}
//            		dealData(s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        visited=new int[lineNum-1];
	}
	public void dealData(String s) {
	
		String[] input;
		input=s.split(",",-1);

		if(!input[5].equals("")&&!input[11].equals("")&&!input[12].equals("")) {
		String status=input[5];
		double lng=Double.parseDouble(input[11]);
		double lat=Double.parseDouble(input[12]);
		position.add(new Point(lng,lat,0,status));
		}
	}
	public void writeData() {
			String csvFilePath = "/Users/mac/Documents/澶ф暟鎹疄楠�/finalData.csv";  
		    try {  
		        // 鍒涘缓CSV鍐欏璞� 渚嬪:CsvWriter(鏂囦欢璺緞锛屽垎闅旂锛岀紪鐮佹牸寮�);  
		        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));  
		        // 鍐欒〃澶�  
		        String[] csvHeaders = { "Long", "Lat", "status" };  
		        csvWriter.writeRecord(csvHeaders);  
		        // 鍐欏唴瀹�  
		        for (int i = 0; i < core.size(); i++) {  
		        		
		            String[] csvContent = {Double.toString(core.get(i).Lng),Double.toString(core.get(i).Lat),core.get(i).status };  
		            csvWriter.writeRecord(csvContent);  
		        }  
		        
		        
		        csvWriter.close();  
		        System.out.println("--------CSV鏂囦欢宸茬粡鍐欏叆--------");  
		    } catch (IOException e) {  
		        e.printStackTrace();
		    } 
			
	}
	public void firstStep() {
		for(int i=0;i<position.size();i++) {
			num=0;
			for(int j=0;j<position.size();j++) {
				if(i!=j) {
//				lng1=rad(position.get(i).Lng);
//				lng2=rad(position.get(j).Lng);
//				lat1=rad(position.get(i).Lat);
//				lat2=rad(position.get(j).Lat);
//				double result=getDistance(lng1,lat1,lng2,lat2);
				double result=getDistance(position.get(i).Lng,position.get(i).Lat,position.get(j).Lng,position.get(j).Lat);
//				System.out.println(result);
//				System.out.println(result);
				if(result<=Eps1) {
					num++;
//					System.out.println(num);
				}				
				if(num>=minPts1) {				
					core.add(position.get(i));
					break;
				}
				}
//				System.out.println("run");
			}
		}
	}
	public void secondStep() {
//		int clusterID=1;
//		Point firstPoint=core.get(0);
//		List<Point> firstCluster=new ArrayList();
//		firstPoint.clusterNum=1;
//		Cluster.add(firstCluster);
		
//		List <Integer> index=new ArrayList();
		for(int i=0;i<core.size();i++) {
			Point curPoint=core.get(i);
//			System.out.println(i);
			if(curPoint.isVisted==true)
				continue;
			List<Point> adList=new ArrayList();
//			List<Point> outList=new ArrayList();
			getAdjacentPoint(curPoint, adList,i);
			if(adList.size()!=0) {
				for(int j=0;j<adList.size();j++) { //鏈�鏈�鏈�鍏抽敭鐨勬槸姣忔鍔犵偣杩涘幓杩欎釜size灏变細澧炲姞锛屽氨濂芥瘮鑷姩浼氭悳鍔犺繘鍘荤殑鐐圭殑鍗婂緞
//					System.out.println("run");
					Point p=adList.get(j);
					if(p.isVisted==false) {
						p.isVisted=true;
						List<Point> list=new ArrayList();
//						List<Point> oList=new ArrayList();
						getAdjacentPoint(p, list,i);
						if(list.size()!=0) {
							adList.addAll(list);
//							outList.addAll(oList);
						}
					}
				}
				if(adList.size()!=0)
				Cluster.add(adList);
				curPoint.isVisted=true;
			}
			
		}


		
	}
	public void getAdjacentPoint(Point p,List<Point> adList,int index) {
		for(int i=index+1;i<core.size();i++) {
			if(core.get(i).isVisted==true)
				return;
		double result=getDistance(p.Lng,p.Lat,core.get(i).Lng,core.get(i).Lat);						
		if(result<=Eps1) {	
			
			adList.add(core.get(i));
			
		}					
		}
	}
//	public void getAdjacentPointOut(Point p,List<Point> adList) {
//		for(int i=0;i<core.size();i++) {
//		double result=getDistance(p.Lng,p.Lat,core.get(i).Lng,core.get(i).Lat);						
//		if(result<=minPts1&&result>0.9*minPts1) {		
//			
//			adList.add(core.get(i));
//		}					
//		}
//	}
	public static double getDistance(double lng1, double lat1, double lng2, double lat2){  
	       double radLat1 = rad(lat1);  
	       double radLat2 = rad(lat2);  
	       double a = radLat1 - radLat2;  
	       double b = rad(lng1) - rad(lng2);  
	       double s = 2 * Math.asin(  
	            Math.sqrt(  
	                Math.pow(Math.sin(a/2),2)   
	                + Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)  
	            )  
	        );  
	       s = s * EARTH_RADIUS;  
	       s = Math.round(s * 10000d) / 10000d;  
	       return s;  
	    } 
    public static double rad(double d){  
	       return d * Math.PI / 180.0;
	
    }
    
	public void output() {
		String csvFilePath = "/Users/mac/Documents/澶ф暟鎹疄楠�/result1.csv";  
	    try {  
	        // 鍒涘缓CSV鍐欏璞� 渚嬪:CsvWriter(鏂囦欢璺緞锛屽垎闅旂锛岀紪鐮佹牸寮�);  
	        CsvWriter csvWriter = new CsvWriter(csvFilePath, ',', Charset.forName("UTF-8"));  
	        // 鍐欒〃澶�  
	        String[] csvHeaders = { "Cluster","Long", "Lat", "status" };  
	        csvWriter.writeRecord(csvHeaders);  
	        // 鍐欏唴瀹�  
	        for (int i = 0; i < Cluster.size(); i++) {  
	        		for(int j=0;j<Cluster.get(i).size();j++) {
	            String[] csvContent = { "Cluster"+ (i+1),Double.toString(Cluster.get(i).get(j).Lng) , Double.toString(Cluster.get(i).get(j).Lat),Cluster.get(i).get(j).status };  
	            csvWriter.writeRecord(csvContent);  
	        		}
	        }  
	        
	        
	        csvWriter.close();  
	        System.out.println("--------CSV鏂囦欢宸茬粡鍐欏叆--------");  
	    } catch (IOException e) {  
	        e.printStackTrace();
	    } 
//		for(int i=0;i<Cluster.size();i++) {
//			for(int j=0;j<Cluster.get(i).size();j++) {
//				cl.insertData(Integer.toString(i+1),Cluster.get(i).get(j).Lng , Cluster.get(i).get(j).Lat,Cluster.get(i).get(j).status);
//			}
//		}
}
//	public void deleteTheIndex() {
//		 Collections.sort(deleteIndex);
//		for(int i=0;i<deleteIndex.size();i++) {
//			System.out.println(deleteIndex.get(i));
//			Cluster.remove(deleteIndex.get(i)-i);
//		}
//	}
	public void test() {
		for(int i=0;i<Cluster.size();i++) {
			for(int j=0;j<Cluster.get(i).size();j++) {
				System.out.println("cluster"+(i+1)+" "+Cluster.get(i).get(j).Lng+" "+Cluster.get(i).get(j).Lat);
			}
		}
		
	}
	public static void main(String[] args) {
		new DBScan();
	}
}
