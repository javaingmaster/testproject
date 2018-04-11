package Toolbag;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import play.Plane;

public class KeyListener extends KeyAdapter         //定义监听器
{		
	Plane me;
	public KeyListener(Plane me)
	{
		this.me=me;
	}
	
	public void keyPressed(KeyEvent e)              //监听器可以同时监听多个键值，因此可以实现多键控制
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
