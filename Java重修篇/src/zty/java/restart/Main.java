package zty.java.restart;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {	
	
	public static void main(String[] aaa){
		
		int[] arr={12,7,88,9,0,12,4,2,78,45,5,-1,65,77,32,61};
		NumberTheroy nt=new NumberTheroy();
		//nt.getPrimeNumber(arr);
		System.out.print(nt.getGreatestCommonDivisor(231, 6));
		
		/*JavaUnionFind jud=new JavaUnionFind(4);
		for(int i=0;i<jud.pre.length;i++){
			jud.find(i);
		}
		jud.join(0, 3);
		jud.showPre();*/
		
		/*for(Object a : staff){
			System.out.println(a);
		}*/
		
		/*StringBuilder sb=new StringBuilder("hello world");
		sb.append("the price of this shit is ");
		sb.append(new Integer(100));
		sb.insert(0, "insert a word ");
		//System.out.println(sb.lastIndexOf("s", 5));
		//sb.deleteCharAt(1);
		//sb.delete(0, 10);
		//sb.replace(0, sb.length(), "replace it!");
		//sb.reverse();
		
		System.out.println(sb.toString());
        		
		
		//myPattern p=new myPattern();
		//p.test();
		//System.out.println(Arrays.toString(p.split("\\d", "sdaf1sg5sd")));
		//List<String> l=p.getUrl("www.qq.com++http://www.qq.com");
		//Iterator iter=l.iterator();
		//while(iter.hasNext()){
		//	System.out.println(iter.next());
		//}
		
		
		
		
		
		
	}
	
}

