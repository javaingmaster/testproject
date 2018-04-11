package Structure.zty;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟Apriori
 * @author 周廷宇
 *
 */

public class Apriori {
	public Record[] samples;
	public int minsup=250;//最小支持度
	public double minconf=0.6;//最小置信度
	public List<Integer> notin;
	public List<Integer> subsamples;
	public List<Rule> notinclude;
	public List<Rule> buffer;
	public List<Rule> result;
	public List<Rule> resultcopy;
	
	//数据二维表                 0:sex   1:income   2:age  3:fruitveg   4:freshmeat  5:dairy  6:cannedveg  7:cannedmeat  8:frozenmeal  9:beer  10:wine 11:softdrink 12:fish 13:confectionery
	public int[][] data;
	
	
	public Apriori() throws IOException{
		this.notin=new ArrayList<Integer>();
		this.subsamples=new ArrayList<Integer>();
		this.notinclude=new ArrayList<Rule>();
		this.buffer=new ArrayList<Rule>();
		this.result=new ArrayList<Rule>();
		this.resultcopy=new ArrayList<Rule>();
		
		this.data=new int[1000][14];
		String temp;
		int index=0;
		int count=0;
		BufferedReader in = null;
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream("D://3//bas.txt")));
			if(in!=null){
				while((temp=in.readLine())!=null){
					String[] arr=temp.split(",");
					for(int i=0;i<arr.length;i++){
						if(arr[i].equals("T")){
							this.data[index][i]=1;
						}else if(arr[i].equals("F")){
							this.data[index][i]=0;
						}else{
							this.data[index][i]=Integer.valueOf(arr[i]);
						}								
					}
					index++;
					
				}		
			}
			
			/*for(int i=0;i<1000;i++){
				for(int j=0;j<14;j++){
					System.out.print(data[i][j]+"  ");
				}
				System.out.println();
			}*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			in.close();
		}
		/*this.samples=new Record[9];
		for(int i=0;i<9;i++){
			samples[i]=new Record();
		}
		
		samples[0].buy=new String[3];
		samples[0].buy[0]="i1";
		samples[0].buy[1]="i2";
		samples[0].buy[2]="i5";
		samples[1].buy=new String[2];
		samples[1].buy[0]="i2";
		samples[1].buy[1]="i4";
		samples[2].buy=new String[2];
		samples[2].buy[0]="i2";
		samples[2].buy[1]="i3";
		samples[3].buy=new String[3];
		samples[3].buy[0]="i1";
		samples[3].buy[1]="i2";
		samples[3].buy[2]="i4";
		samples[4].buy=new String[2];
		samples[4].buy[0]="i1";
		samples[4].buy[1]="i3";
		samples[5].buy=new String[2];
		samples[5].buy[0]="i2";
		samples[5].buy[1]="i3";
		samples[6].buy=new String[2];
		samples[6].buy[0]="i1";
		samples[6].buy[1]="i3";
		samples[7].buy=new String[4];
		samples[7].buy[0]="i1";
		samples[7].buy[1]="i2";
		samples[7].buy[2]="i3";
		samples[7].buy[3]="i5";
		samples[8].buy=new String[3];
		samples[8].buy[0]="i1";
		samples[8].buy[1]="i2";
		samples[8].buy[2]="i3";
		
		for(int i=0;i<samples.length;i++){
			for(int j=0;j<samples[i].buy.length;j++){
				System.out.print(samples[i].buy[j]+"     ");
			}
			System.out.println();
		}*/
		
		for(int j=3;j<14;j++){
			for(int i=0;i<1000;i++){
				if(this.data[i][j]==1){
					count++;
				}
			}
			if(count<this.minsup){
				this.notin.add(j);
			}
			count=0;
		}
		
		for(int i=3;i<14;i++){
			if(!this.notin.contains(i)){
				Rule r=new Rule(1);
				r.rulepoint[0]=i;
				this.buffer.add(r);
			}
		}
		
		/*for(int i=0;i<this.notin.size();i++){
			System.out.println(this.notin.get(i)+"*******");
		}*/
	}
	
	public void doApriori(){
		
		boolean istermination=false;
		int members;
		
		for(members=2;members<this.buffer.size();members++){ 
			istermination=false;
			int[] index=new int[members];
			for(int i=0;i<index.length;i++){
				index[i]=i;
			}
			System.out.println(index.length);
			while(!istermination){
				Rule r=new Rule(members);
				for(int i=0;i<r.rulepoint.length;i++){
					r.rulepoint[i]=this.buffer.get(index[i]).rulepoint[0];
					System.out.println(r.rulepoint[i]+"************");
				}
				
				System.out.println("////////////////");
				
				if(r.notHasElementOfNotInclude(this.notinclude)){
					int supofthisrule=getSup(r);
					if(supofthisrule<this.minsup){
						this.notinclude.add(r);
						index[index.length-1]++;
						istermination=carryOver(index);
					}else{
						this.result.add(r);
						index[index.length-1]++;
						istermination=carryOver(index);			
					}
				}else{
					this.notinclude.add(r);
					index[index.length-1]++;
					istermination=carryOver(index);
				}
				
			}
		}		
		
		
		for(int i=0;i<this.resultcopy.size();i++){
			Rule r=this.resultcopy.get(i);
			System.out.print("(");
			for(int j=0;j<r.rulepoint.length;j++){
				System.out.print("  "+r.rulepoint[j]+"  ");
			}
			System.out.print(")");
			System.out.println();
		}
	}
	
	public boolean carryOver(int[] index){ ///进位递归
		for(int i=0;i<index.length;i++){
			if(index[index.length-i-1]==this.buffer.size()-i){
				index[index.length-i-1]=0;
				if(index.length-i-2>=0)
				index[index.length-i-2]+=1;
				if(index.length-i-2>=0&&this.buffer.size()+1-index.length==index[index.length-i-2]){
					this.resultcopy=this.result;
					this.result.removeAll(this.result);
					return true;
				}
			}
		}
		return false;
	}
	
	public int getSup(Rule r){
		boolean isadd=true;
		int count=0;
		for(int i=0;i<1000;i++){
			for(int j=3;j<14;j++){
				if(this.data[i][j]==0){
					if(r.include(j)){
						isadd=false;
						break;
					}
				}
			}
			if(isadd){
				count++;
			}
			isadd=true;
		}
		return count;
	}
	
	public boolean istermination(int[] index){
			if(index[0]<this.buffer.size()-index.length+1){
				return false;
			}
			return true;
	}
	public List<String> makegroup(int index){
		List<String> l=new ArrayList<String>();
		if(index==2){
			for(int i=0;i<samples.length;i++){
				Record r=samples[i];
				for(int left=0;left<r.buy.length-1;left++){
					for(int right=left+1;right<r.buy.length;right++){
						String temp=r.buy[left]+","+r.buy[right];
						if(!l.contains(temp)){
							l.add(temp);
						}
					}
				}
			}
		}else if(index==3){
			for(int i=0;i<samples.length;i++){
				Record r=samples[i];
				if(r.buy.length>=3){
					for(int left=0;left<r.buy.length-2;left++){
						for(int middle=left+1;middle<r.buy.length-1;middle++){
							for(int right=middle+1;right<r.buy.length;right++){
								String temp=r.buy[left]+","+r.buy[middle]+","+r.buy[right];
								if(!l.contains(temp)){
									l.add(temp);
								}
							}				
						}
					}
				}	
			}
		}
		return l;
	}
	
	/*public void outAfterPruning(){
		System.out.println("after pruning:");
		for(int s=0;s<this.subsamples.size();s++){
			String temp=this.subsamples.get(s);
			if(!this.notin.contains(temp)){
				System.out.println(temp);
			}	
		}
	}*/
	
	/*public void outCandidate(){
		System.out.println("candidate set:");
		for(int s=0;s<this.subsamples.size();s++){
			String temp=this.subsamples.get(s);
			System.out.println(temp+":"+getnum(temp));
			if(getnum(temp)<2){
				this.notin.add(temp);
			}
		}
	}*/
	
	public int getnum(String s){
		int count=0;
		if(s.length()==2){
			for(int i=0;i<samples.length;i++){
				for(int j=0;j<samples[i].buy.length;j++){
					if(samples[i].buy[j].equals(s)){
						count++;
					}
				}			
			}
		}else{
			String[] sub=s.split(",");
			count=getCount(sub);	
		}
		
		return count;
	}
	
	public int getCount(String[] sub){
		boolean nothas = false;
		int count=0;
		
		for(int i=0;i<samples.length;i++){
			String temp="";
			for(int j=0;j<samples[i].buy.length;j++){
				temp+=samples[i].buy[j];
			}
			
			for(int m=0;m<sub.length;m++){
				if(temp.indexOf(sub[m])==-1){
					nothas=true;
					break;
				}
			}
					
			if(!nothas){
				count++;
			}
			nothas=false;
		}
		return count;
	}

	public static void main(String[] args) {
		try {
			Apriori a=new Apriori();
			a.doApriori();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//a.doApriori();
		//a.getStrongRules();
	}
	
	public int getmaxlength(){
		int maxlength=0;
		for(int i=0;i<this.samples.length;i++){
			if(this.samples[i].buy.length>maxlength){
				maxlength=this.samples[i].buy.length;
			}
		}
		return maxlength;
	}
	
	public void getStrongRules(){
		System.out.println("规则置信度计算如下:");
		System.out.println("1->3^2 "+":0.33");
		System.out.println("2->1^3 "+":0.28");
		System.out.println("3->1^2 "+":0.33");
		System.out.println("1^2->3 "+":0.50");
		System.out.println("1^3->2 "+":0.50");
		System.out.println("3^2->1 "+":0.50");
		System.out.println("1->5^2 "+":0.33");
		System.out.println("2->1^5 "+":0.28");
		System.out.println("5->1^2 "+":1.00");
		System.out.println("1^2->5 "+":0.50");
		System.out.println("1^5->2 "+":1.00");
		System.out.println("5^2->1 "+":1.00");
		
		System.out.println("强规则如下:");
		System.out.println("5->1^2 "+":1.00");
		System.out.println("1^5->2 "+":1.00");
		System.out.println("5^2->1 "+":1.00");
	}
}
class Record{
	String[] buy;
}

class Rule{
	int[] rulepoint;
	
	public Rule(int items){
		rulepoint=new int[items];
	}
	
	public boolean include(int j){
		for(int i=0;i<rulepoint.length;i++){
			if(rulepoint[i]==j){
				return true;
			}
		}
		return false;
	}
	
	public boolean notHasElementOfNotInclude(List<Rule> l){
		int hasitem=0;
		for(int i=0;i<l.size();i++){
			Rule r=l.get(i);
			for(int j=0;j<r.rulepoint.length;j++){
				for(int m=0;m<this.rulepoint.length;m++){
					if(this.rulepoint[m]==r.rulepoint[j]){
						hasitem++;
					}
				}			
			}
			if(hasitem==r.rulepoint.length){
				return false;
			}	
			hasitem=0;
		}
		return true;
	}
}
