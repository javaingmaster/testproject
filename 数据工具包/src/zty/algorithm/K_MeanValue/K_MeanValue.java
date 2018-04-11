package zty.algorithm.K_MeanValue;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class K_MeanValue {
	private List<Integer> age;
	private List<String> sex;
	private List<String> bp;
	private List<String> ch;
	private List<Double> na;
	private List<Double> k;
	private List<String> drug;
	
	public K_MeanValue() throws BiffException, IOException{
		age=new ArrayList<Integer>(); 
		sex=new ArrayList<String>(); 
		bp=new ArrayList<String>(); 
		ch=new ArrayList<String>(); 
		na=new ArrayList<Double>(); 
		k=new ArrayList<Double>(); 
		drug=new ArrayList<String>(); 
		FileInputStream fis = new FileInputStream("D://3//Data.xls");     
		Workbook rwb = Workbook.getWorkbook(fis);   
		Sheet sheet = rwb.getSheet(0);   
		              	
		   for(int i = 1; i < sheet.getRows(); i++) {   
				Cell[] cells = sheet.getRow(i);
				age.add(Integer.valueOf(cells[0].getContents()));
				sex.add(cells[1].getContents());
				bp.add(cells[2].getContents());
				ch.add(cells[3].getContents());
				na.add(Double.parseDouble(cells[4].getContents()));
				k.add(Double.parseDouble(cells[5].getContents()));
				drug.add(cells[6].getContents());
		   }
	}
	
	public void K_MeanSort(List<Integer> l,int classnum){
		boolean finish=true;
		//ȡ����
		int max=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<l.size();i++){
			if(l.get(i)>max){
				max=l.get(i);
			}
			if(l.get(i)<min){
				min=l.get(i);
			}
		}
		int sub=max-min;//����
		
		//���ʶ����
		int[] classsign=new int[l.size()];
		
		//ȡclassnum����ʼ���ĵ�
		int[] theoldclass=new int[classnum];
		int[] thenewclass=new int[classnum];
		
		for(int i=0;i<theoldclass.length;i++){
			int indexofcenter=(int)(Math.random()*l.size());
			theoldclass[i]=l.get(indexofcenter);
			classsign[indexofcenter]=i+1;
		}
		
		while(finish){
			//�������
			for(int i=0;i<l.size();i++){
				int temp=l.get(i);
				double distance=Double.MAX_VALUE;
				int classtype=0;
				
				for(int j=0;j<classnum;j++){
					double distancetemp=getDistance(temp,theoldclass[j]);				
					if(distancetemp<distance){
						distance=distancetemp;
						classtype=j+1;
					}
				}
				
				classsign[i]=classtype;
			}
			//����ÿһ��ľ�ֵ�������µľ�������
			for(int i=0;i<classnum;i++){
				
				int sum=0;
				int count=0;
				
				for(int j=0;j<l.size();j++){			
					if(classsign[j]==i+1){
						sum+=l.get(j);
						count++;
					}
				}
				thenewclass[i]=sum/count;		
			}
			
			//�ж����ɵ��¾��������Ƿ�С��ĳ����ֵ(��ֵ�趨0.33����)
			for(int i=0;i<classnum;i++){
				if(Math.abs(thenewclass[i]-theoldclass[i])>0.33*sub){
					theoldclass[i]=thenewclass[i];
					//��ʱ�����classsign
					break;
				}
				finish=false;
			}
		}
		
		//���ÿһ����
		for(int i=0;i<classnum;i++){
			for(int j=0;j<l.size();j++){
				if(classsign[j]==i+1){
					System.out.println("��"+(i+1)+"��: age: "+l.get(j)+" sex: "+this.sex.get(j)+" bp: "+this.bp.get(j)+"        ch: "+this.ch.get(j)+"          na: "+this.na.get(j)+"         k: "+this.k.get(j)+ "         drug: "+this.drug.get(j));
				}
			}
		}
		
	}
	
	public double getDistance(int temp,int center){
		return Math.abs(temp-center);
	}
	public static void main(String[] a){
		K_MeanValue k;
		try {
			k = new K_MeanValue();
			k.K_MeanSort(k.age,5);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
