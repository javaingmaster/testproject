package zty.java.command;

/*���Ǳ�д��TestCase������һ������
 * ͨ�����������ú�JUnit���������Ӧ�Ľ�������ִ�����ǵĲ��Է�����
 */
public class Client {
	public static void main(String[] args){
		 // ������
        Receiver receiver = new Receiver();

        // ��������������������
        Command command = new ConcreteCommand(receiver);

        // ������
        Invoker invoker = new Invoker(command);

        // �����ߵ������ʵ�����������Ľ�����ִ�в���
        invoker.doInvokerAction();
	}
}