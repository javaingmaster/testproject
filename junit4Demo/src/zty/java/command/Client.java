package zty.java.command;

/*我们编写的TestCase就像是一个命令
 * 通过调用器调用后，JUnit框架中有相应的接收者来执行我们的测试方法。
 */
public class Client {
	public static void main(String[] args){
		 // 接收者
        Receiver receiver = new Receiver();

        // 命令：具体命令关联接收者
        Command command = new ConcreteCommand(receiver);

        // 调用者
        Invoker invoker = new Invoker(command);

        // 调用者调用命令，实际是所关联的接收者执行操作
        invoker.doInvokerAction();
	}
}
