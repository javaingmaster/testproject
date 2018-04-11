package Structure.zty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import jxl.read.biff.BiffException;

public class Knn {
	ArrayList<String> carname;
	ArrayList<String> time;
	ArrayList<Double> x;
	ArrayList<Double> y;
	ArrayList<String> isdriving;
	public Knn() throws BiffException, IOException{
		this.carname=new ArrayList<String>();
		this.time=new ArrayList<String>();
		this.x=new ArrayList<Double>();
		this.y=new ArrayList<Double>();
		this.isdriving=new ArrayList<String>();
		
		BufferedReader in = null;
		String temp;
		//int control=0;
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("D://3//daa.txt")));
			if(in!=null){
				temp=in.readLine();
				while(((temp=in.readLine())!=null)){ //&&control<50000
					String[] sp=temp.split(",");
					this.carname.add(sp[1]);
					String[] pro=sp[2].split(" ");
					this.time.add(pro[1]);
					this.x.add(Double.parseDouble(sp[3]));
					this.y.add(Double.parseDouble(sp[4]));
					this.isdriving.add(sp[5]);
					//control++;
				}		
			}
		}catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally{
				in.close();
			}
	}
	/**
	 * 输出在time时间点上，距离x，y最近的k个车辆信息    信息写入路径 D://3//out.txt
	 * @param x  维度
	 * @param y  精度
	 * @param time  时间
	 * @param k  数据量
	 * @throws IOException
	 */
	public void doKnn(double x, double y, String time,int k) throws IOException{
		List<Integer> indexofOut=new ArrayList<Integer>();
		double range=0.000;
		double rangeExpanding=0.001;
		
		int timelimit=60;
		String[] valueoftime=time.split(":");
		int hour=Integer.valueOf(valueoftime[0]);
		int minute=Integer.valueOf(valueoftime[1]);
		int second=Integer.valueOf(valueoftime[2]);
		
		while(indexofOut.size()<k){
			indexofOut.removeAll(indexofOut);
			range+=rangeExpanding;
			
			for(int i=0;i<this.carname.size();i++){
				if(Math.sqrt(Math.pow(this.x.get(i)-x,2 )+Math.pow(this.y.get(i)-y, 2))<range){
					indexofOut.add(i);
				}
			}
		
		for(int i=0;i<indexofOut.size();i++){
			String temp=this.time.get(indexofOut.get(i));
			String temp1[]=temp.split(":");
			int tempvalue=(Math.abs((Integer.valueOf(temp1[0])-hour))*3600+Math.abs((Integer.valueOf(temp1[1])-minute))*60+Math.abs(Integer.valueOf(temp1[2])-second));
			if(tempvalue>timelimit){
				indexofOut.remove(i);
				i--;
			}
		}
		if(range==1){
			System.out.println("距离过远! 无匹配结果!");
			return;
		}
	}
		String outwrite="";
		for(int i=0;i<k;i++){
			outwrite+=(this.carname.get(indexofOut.get(i))+"   "+this.time.get(indexofOut.get(i))+"   "+this.x.get(indexofOut.get(i))+"   "+this.y.get(indexofOut.get(i))+"   "+"\r\n");
		}
		
		File writename = new File("D://3//out.txt"); 
		 BufferedWriter  out=null;
        try {
        		if(writename==null){
        			writename.createNewFile();
        		}			
				out = new BufferedWriter(new FileWriter(writename));  
				
		        out.write(outwrite); 
		        out.flush(); 
		        
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
       			
	}
	public static void main(String[] args) throws BiffException, IOException {
		Knn k=new Knn();
		k.doKnn(102.724502, 25.95262, "16:48:14", 100);
	}
}
