package zty.java.restart;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myPattern {
	
	public String replace(String pattern,String matcher,String replace){
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(matcher);
	    return m.replaceAll(replace);
	}
	public String[] split(String pattern,String matcher){
		return matcher.split(pattern);
	}
	public List<String> getLandlineTelephoneNumber(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("(0\\d{2,3}-\\d{7,9})");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}
	public List<String> getMobilePhoneNumber(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("(1[35789]\\d{9})");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	} 
	public List<String> getMailBox(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("([\\w\\-]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,4}){1,2})");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}
	public List<String> getMailBoxtwo(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("(^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$)");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}
	public List<String> getChinese(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("([\\u4e00-\\u9fa5])");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}
	public List<String> getUrl(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("([a-zA-Z]+://[^\\s]*)");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}
	public List<String> getip(String matcher){
		List<String> l=new LinkedList<String>();
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		Pattern p=Pattern.compile("('^' + num + '\\.' + num + '\\.' + num + '\\.' + num + '$')");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}           
	public List<String> getPersonInformation(String matcher){
		List<String> l=new LinkedList<String>();
		Pattern p=Pattern.compile("((^\\d{18}$)|(^\\d{15}$))");
		Matcher m=p.matcher(matcher);
		while(m.find()){
			l.add(m.group());
		}
		return l;
	}
}
