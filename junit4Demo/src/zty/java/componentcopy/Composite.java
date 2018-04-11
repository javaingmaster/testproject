package zty.java.componentcopy;

import java.util.ArrayList;
import java.util.List;
/**
 * “ª∏ˆTestSuite
 * @author ÷‹Õ¢”Ó
 *
 */
public class Composite implements Component{

	private List<Component> l;
	
	public Composite(){
		this.l=new ArrayList<Component>();
	}
	
	public void add(Component c){
		l.add(c);
	}
	
	public void remove(Component c){
		l.remove(c);
	}
	
	public List<Component> getAll(){
		return l;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(Component c: l){
			c.execute();
		}
	}
	
}
