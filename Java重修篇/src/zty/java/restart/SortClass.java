package zty.java.restart;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortClass<classname> {
	
	public SortClass(){
		
		Object[] a=new classname[3];
		Map<String,Integer> m=new TreeMap<>();
		for(int i=0;i<3;i++){
			a[i]=new Person(9-i+"ss");
			m.put(a[i].name, i);
			System.out.println(a[i].name);
		}
					
		Set<String> person=m.keySet();
		Iterator iter=person.iterator();
		
		Person[] acopy=new Person[3];	
		for(int i=0;i<3;i++){
			acopy[i]=new Person();
		}
		int index=0;
		while(iter.hasNext()){
			acopy[index]=a[m.get(iter.next()).intValue()];
			index++;	
		}
	}    
}
