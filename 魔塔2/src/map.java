import java.util.ArrayList;

//����ʵ���ǵ�ͼ��

public class map //������ ��һά�൱�� ͼ�е�x���꼴��������   �ڶ�ά�൱��ͼ�е�y���꼴��������
{
	block [][] ma=new block[18][15];//����һ���洢�����Ƶ����顣
	int x;//����ÿ��ͼ����ҵ���ʼx����
	int y;//����ÿ��ͼ����ҵ���ʼy����
	int l_x;//����ÿ��ͼ����ҵ���ʼx����
	int l_y;//����ÿ��ͼ����ҵ���ʼy����
	public map()//Ϊ��ά���鴴��ʵ��
	{
		for(int i=0;i<18;i++)
			for(int j=0;j<15;j++)
			{
				ma[i][j]=new block();
			}
	}
}
