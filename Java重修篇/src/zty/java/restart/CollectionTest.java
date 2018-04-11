package zty.java.restart;

import java.util.Stack;

public class CollectionTest {
	//List<String> ll=new ArrayList<String>();
	//List<String> staff=new LinkedList<String>();
	//Vector v=new Vector(); Enumeration enum = v1.elements();
	
	//stack
	
	//Set<String> words=new HashSet<>();
	//TreeSet ts=new TreeSet();
	
	//BlockingQueue<Integer> lq=new LinkedBlockingQueue<Integer>();
	
	/*ConcurrentLinkedQueue<Integer> q=new ConcurrentLinkedQueue<Integer>();//允许多线程访问的无边界队列
	q.add(6);
	q.add(10);
	Iterator<Integer> iter=q.iterator();
	while(iter.hasNext()){
		System.out.println(iter.next());
	}

	/*List<String> l=new ArrayList<String>();
	List<String> ll=new ArrayList<String>();
	l.add("ASfd");
	l.add("asdaff");
	l.add("123");
	l.add("1234");
	l.add("12345");
	ll.add("111");
	ll.add("10");
	ll.add("123");
	l.retainAll(ll);//反选删除
	
	List<String> staff=new LinkedList<String>();
	staff.add("tom");
	staff.add("join");
	staff.add("bean");
	ListIterator<String> iter=staff.listIterator(2);//ListIterator迭代器指定位置添加元素
	//iter.next();
	//iter.next();
	//iter.add("juit");
	//iter.set("juit");
	//iter.previous();
	//iter.set("jjj");
	/*Iterator<String> iterr=staff.iterator();
	while(iterr.hasNext()){
		System.out.println(iterr.next());
	}*/
	//System.out.println(iter.next());
	/*Vector v=new Vector();
	v.addElement("aaa");
	v.addElement("bbb");
	v.insertElementAt("ccc", 1);
	v.setElementAt("jjj",1);
	v.removeAllElements();
	System.out.println(v.indexOf("jjj"));*/
	
	//HashSet的四种构造方法
	/*Set<String> words=new HashSet<>();
	long totaltime=0;
	
	Scanner in=new Scanner(System.in);
	while(in.hasNext()){
		String word=in.next();
		long calltime=System.currentTimeMillis();
		words.add(word);
		calltime=System.currentTimeMillis()-calltime;
		totaltime+=calltime;
	}
	Iterator<String> iter=words.iterator();
	for(int i=1;i<=20&&iter.hasNext();i++){
		System.out.println(iter.next());
		System.out.println(words.size()+"distinct words "+totaltime+"milliseconds");
	}*/
	/*long currentTime = System.currentTimeMillis();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
	Date date = new Date(currentTime);
	System.out.println(formatter.format(date));*/
	
	/*TreeSet ts=new TreeSet();
	List l=new ArrayList();
	l.add(4);
	l.add(10);
	l.add(2);
	l.add(1);
	ts.addAll(l);
	List link=new LinkedList();
	Iterator iter=ts.iterator();
	while(iter.hasNext()){
		link.add(iter.next());
	}*/
	/*BlockingQueue<Integer> lq=new LinkedBlockingQueue<Integer>();
	lq.add(4);
	lq.add(10);
	lq.add(2);
	lq.add(1);*/
	/*Map<Integer,Person> staff=new HashMap<>();
	staff.put(0, new Person("tom"));
	staff.put(1, new Person("tim"));
	staff.remove(1);*/
	//System.out.println(staff.get(1).name);
	
	/*Map<Integer,Person> staff=new TreeMap<>();
	staff.put(0, new Person("jom"));
	staff.put(2,new Person("nnn"));
	staff.put(1, new Person("tim"));
	
	Set<Integer>staffkeys=staff.keySet();
	
	//Map s=new LinkedHashMap()
	for(Integer key: staffkeys){
		System.out.println(staff.get(key).name);
	}*/
	
	
	/*for(Object a : staff){
		System.out.println(a);
	}*/
}
