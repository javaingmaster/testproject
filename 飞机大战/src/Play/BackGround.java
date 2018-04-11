package Play;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Toolbag.Gameimage;

public class BackGround 
{
	ArrayList<Image> background;
	Image backgroundone,backgroundtwo,backgroundthree,backgroundfour,backgroundfive,databj;
	int drx=0,dry=-520;
	int databjx=667;
	int databiy=0;
	
	public BackGround()
	{
		background=new ArrayList<Image>();
		backgroundtwo=Gameimage.getimage("images/bg2.jpg");
		background.add(backgroundtwo);
		
		databj=Gameimage.getimage("images/databj.jpg");
	}
	
	public void drawbg(Graphics g)
	{
		g.drawImage(background.get(0), drx, dry, drx+667, dry+2000, null);
		dry+=0.5;
		if(dry==0){
			dry=-520;
		}
	}
	public void drawdatabj(Graphics g)
	{
		g.drawImage(databj, databjx, databiy, 333, 1000, null);
	}

}
