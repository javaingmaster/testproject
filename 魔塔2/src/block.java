
public class block //����ÿһ�����������
{
	int across=1;//���÷������ԣ� 0�ǿ���ͨ����1��ǽ��������ͨ����2���ţ�������ͨ��Կ�״�,Ĭ��Ϊǽ��3����һ�㣬-1����һ��
	int num=1,num2=1;//���ù�������࣬Ĭ��Ϊ1����Ʒ����Ĭ��Ϊ1
	Thing obj=new Thing();//���÷��������Ʒ
	boolean isTh=false;//�����Ƿ�������Ʒ
	boolean ismon=false;//�����Ƿ���ڹ�������false���ʾ�����ڹ�������true���ʾ���ڹ���	������ڹ����ʱ��Ĭ������acrossΪ0
	monster mon=new monster();//����й���Ļ������������ù�������
	mons ml=new mons();
	Things tl=new Things();
	void mond(int count)
	{
		mon=ml.list.get(count);
	}
	
	void objs(int count)
	{
		obj=tl.list2.get(count-1);
	}
	
	
}
