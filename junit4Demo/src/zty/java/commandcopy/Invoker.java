package zty.java.commandcopy;

public class Invoker {
	private Command c;
	
	public Invoker(Command c){
		this.c=c;
	}
	
	public void call(){
		c.execute();
	}
}
