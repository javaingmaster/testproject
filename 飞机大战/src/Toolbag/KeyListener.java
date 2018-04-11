package Toolbag;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Play.Plane;

public class KeyListener extends KeyAdapter         //���������
{		
	Plane me;
	public KeyListener(Plane me)
	{
		this.me=me;
	}
	
	public void keyPressed(KeyEvent e)              //����������ͬʱ���������ֵ����˿���ʵ�ֶ������
	{
		me.addmove(e);	
		me.attackpress(e);
	}
	public void keyReleased(KeyEvent e)
	{			
		me.releasemove(e);
		me.attackrelease(e);
	}
}
