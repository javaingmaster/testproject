
public class battles //��������������ս����
{
	
	boolean bat(player pla,monster mon,String s)//���Ǵ���ս���ķ���
	{
		while(!(pla.life<=0||mon.life<=0))//ս��ִ�е�����һ��Ѫ��Ϊ0
		{
			
			//����ȹ�
			int a=(int)Math.random()*100;//��Ʊ�������
			if(a<=95)
			{
				if(pla.attack<=mon.Def)
				{
					mon.life=mon.life-1;
					s+="���δ�Թ����Ʒ���ǿ�����  1  ���˺�\n";
					
					System.out.println("���δ�Թ����Ʒ���ǿ�����  1  ���˺�");
				}
				else
				{
					mon.life=mon.life-pla.attack+mon.Def;
					s+="��Ҷ�������   "+(pla.attack-mon.Def)+" ���˺�\n";
					System.out.println("��Ҷ�������   "+(pla.attack-mon.Def)+" ���˺�");
				}
			}
			else//��������������2���˺�
			{
				if(pla.attack<=mon.Def)
				{
					mon.life=mon.life-1;
					s+="���δ�Թ����Ʒ���ǿ�����  1  ���˺�\n";
					System.out.println("���δ�Թ����Ʒ���ǿ�����  1  ���˺�");
				}
				else
				{
					mon.life=mon.life-2*(pla.attack-mon.Def);
					s+="����һ���� ��ҶԹ������   "+2*(pla.attack-mon.Def)+" ���˺�\n";
					System.out.println("����һ���� ��ҶԹ������   "+2*(pla.attack-mon.Def)+" ���˺�");
				}
			}
			
			if(mon.life<=0)break;//������������ˣ��ͽ���ս��
				
				
			//�����
			int b=(int)Math.random()*100;//��Ʊ�������
			if(a<=98)
			{
				if(mon.attack<=pla.Def)
				{
					pla.life=pla.life-1;
					s+="����δ������Ʒ���ǿ�����  1  ���˺�\n";
					System.out.println("����δ������Ʒ���ǿ�����  1  ���˺�");
				}
				else
				{
					pla.life=pla.life-mon.attack+pla.Def;
					s+="�����������   "+(mon.attack-pla.Def)+" ���˺�\n";
					System.out.println("�����������   "+(mon.attack-pla.Def)+" ���˺�");
				}		
			}
			else//��������������2���˺�
			{
				if(mon.attack<=pla.Def)
				{
					pla.life=pla.life-1;
					s+="����δ������Ʒ���ǿ�����  1 ���˺�\n";
					System.out.println("����δ������Ʒ���ǿ�����  1 ���˺�");
				}
				else
				{
					pla.life=mon.life-2*(mon.attack-pla.Def);
					s+="����һ���� ��ҶԹ������   "+2*(mon.attack-pla.Def)+" ���˺�\n";
					System.out.println("����һ���� ��ҶԹ������   "+2*(mon.attack-pla.Def)+" ���˺�");
				}
			}
		}
		
		if(pla.life<=0)//������ûѪ�ˣ��򷵻�false
		{
			return false;
		}
		else if(mon.life<=0)//�������ûѪ�ˣ��򷵻�true������þ���
		{
			pla.expe=pla.expe+mon.exper;//�����ﾭ��ֵ�����û�
			
			experience ex=new experience();
			ex.level_up(pla);//�������ж��Ƿ�����������������������
			
			pla.key=pla.key+mon.key;//������Я����Կ�׸����û�
			
			if(mon.isThing==true)//�������Я���˵��ߣ��ѵ��߸����û�
			{
				pla.object.add(mon.obj);
			}
			return true;
		}
		
		return true;
		
	}
}
