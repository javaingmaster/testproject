package array_struct;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class set_array 
{
	String word;
	String meaning;
	public void dictionary(String word,String meaning)
	{
		this.word=word;
		this.meaning=meaning;
	}
	public String getword()
	{
		return(word);
	}
	public String getmeaning()
	{
		return(meaning);
	}
}
class test
{
	public static void main(String[] args)
	{
		set_array one=new set_array();
		one.dictionary("test", "≤‚ ‘");
		set_array two=new set_array();
		one.dictionary("sdfst1", " ‘1");
		set_array there=new set_array();
		one.dictionary("ghjst2", "yyy ‘2");
		HashSet<String> set=new HashSet<String>();
		set.add(o);
		set.add("2");
		set.add("3");
		Iterator<String> iterator=set.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
