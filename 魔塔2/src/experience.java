
public class experience //��ȼ�������ص���
{
	//����дһ���㷨�ɣ�ÿһ������������� level*100
	// ÿ��һ��������������5������������5������������50��Ѫ����50������ֵ����
	
	void level_up(player play)//��������ϵͳ
	{
		if(play.expe>=play.level*100)
		{
			//play.expe=play.expe-play.level*100;
			play.level++;
			play.attack=play.attack+5;
			play.Def=play.Def+5;
			play.maxlife=play.maxlife+50;
			play.life=play.life+50;
		}
	}
	
	
	
}
