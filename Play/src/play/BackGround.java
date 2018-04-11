package play;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Toolbag.Gameimage;

public class BackGround 
{
	ArrayList<Image> background;
	Image backgroundone,backgroundtwo,backgroundthree,backgroundfour,backgroundfive;
	int drx=0,dry=-520;
	
	public BackGround()
	{
		background=new ArrayList<Image>();
		backgroundtwo=Gameimage.getimage("images/bg2.jpg");
		background.add(backgroundtwo);
	}
	
	public void drawbg(Graphics g)
	{
		g.drawImage(background.get(0), drx, dry, drx+667, dry+2000, null);
		dry+=1;
		if(dry==0){
			dry=-520;
		}
	}

}
