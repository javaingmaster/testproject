package zty.java.restart;

public class MyThread implements Runnable{

	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName());
			}	
	}
	/*Bank bank=new Bank(5);
	Acount a0=new Acount(bank,0);
	Acount a1=new Acount(bank,1);
	Acount a2=new Acount(bank,2);
	Acount a3=new Acount(bank,3);
	Acount a4=new Acount(bank,4);
	
	Thread tbank=new Thread(bank);
	tbank.setName("bank");
	Thread t0=new Thread(a0);
	tbank.setName("a0");
	Thread t1=new Thread(a1);
	tbank.setName("a1");
	Thread t2=new Thread(a2);
	tbank.setName("a2");
	Thread t3=new Thread(a3);
	tbank.setName("a3");
	Thread t4=new Thread(a4);
	tbank.setName("a4");
	
	tbank.start();
	t0.start();
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	
	try {
		Thread.currentThread().sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	int sum=0;
	System.out.println("ȫ������֮��");
	for(int i=0;i<5;i++){
		System.out.print(bank.acounts[i]+"  ");
		sum+=bank.acounts[i];
	}
	System.out.println();
	System.out.println("�ܶ�: "+sum);
	    //Thread.currentThread().setPriority(5);
	   // Thread.currentThread().setName("main");
		//Runnable r=new MyThread();
		//Thread t=new Thread(r);
		//t.setPriority(10);
		//t.setName("t");
		//t.start();
			//t.sleep(1000);ע���߳���ִ��sleep��wait����interrupt��û���ã���Ϊ��ʱ�߳�������״̬
			//t.interrupt();
			/*if(t.isInterrupted()){
				System.out.println("�߳�"+t.getName()+"�Ѿ����ж�");
			}else{
				System.out.println(t.getName()+"�̼߳���ִ��");
			}*/
		
		//t.currentThread().isInterrupted()�߳��Ƿ��ж�
		//t.interrupt();�ж��߳�
		/*while(true){
		System.out.println(Thread.currentThread().getName());
		}*/
		//һ���߳�ֻ�б�ִ��yield���߱�������ȴ�ʱ���̲߳�ʧȥ����Ȩ
		//��a�߳�����b�̵߳���ʱ����������ֱ���������
		//�߳�run���������˳����߳����������߳̽�����ֹ״̬
	   //yieldʹ�߳��ò�����cpu�ø����ȼ����ڵ��ڸ��̵߳��߳�
		
		//t.setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
		

}
