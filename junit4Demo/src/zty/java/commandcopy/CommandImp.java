package zty.java.commandcopy;

public class CommandImp implements Command{

	private Receiver receiver;
	
	public CommandImp(Receiver receiver){
		this.receiver=receiver;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		receiver.request();
	}
	
}
