import java.util.ArrayList;


public class player //�û�״̬
{
	String name="����";//�����û�����
	boolean alive=true;//�����ж��û��Ƿ�������true�����������false���������
	int maxlife=1000;//������������
	int life=1000;//��������״̬
	int level=1;//����ȼ�
	int attack=10;//���幥����
	int Def=10;//���������
	int expe=0;//���徭��ֵ
    int key=1;//��������Կ��
	int money=0;//�����Ǯ
	int x;//�û���ǰλ��
	int y;//�û���ǰλ��
	ArrayList <Thing> object=new ArrayList<Thing>();//����һ�����������洢����
}
