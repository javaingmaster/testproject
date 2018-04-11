package Solar_system;

import java.awt.Graphics;
import java.awt.Image;

public class Star
{
	double x,y;
	double imagewidth;
	double imageheight;
	Image imageofstar;
    public Star(){}
	
	public Star(double x,double y,String path)
	{
		this.x=x;
		this.y=y;
		this.imageofstar=Gameimage.getimage(path);
		this.imageheight=imageofstar.getHeight(null);
		this.imagewidth=imageofstar.getWidth(null);
	}
	public void drawmyself(Graphics g)
	{
		g.drawImage(imageofstar,(int)x,(int)y,null);
	}

}
