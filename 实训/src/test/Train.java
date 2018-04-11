package test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Train 
{
	Feature processchar=null;
	
	Feature[] k;
	
	public void traink()
	{
		try {
			processchar=new Feature();
			BufferedImage image=ImageIO.read(this.getClass().getResource( "/images/k2.jpg"));
			processchar.area16=Toolbag.divideinto16area(image);
			processchar.minx=Toolbag.getminx(image);
			processchar.maxx=Toolbag.getmaxx(image);
			processchar.miny=Toolbag.getminy(image);
			processchar.maxy=Toolbag.getmaxy(image);
			processchar.up=Toolbag.getoutlinefromup(image);
			processchar.down=Toolbag.getoutlinefromdown(image);
			processchar.left=Toolbag.getoutlinefromleft(image);
			processchar.right=Toolbag.getoutlinefromright(image);
			processchar.rowfocus=Toolbag.getfocusnumber(image,processchar.miny,processchar.maxy);
			processchar.columnfocus=Toolbag.getfocusnumberv(image,processchar.minx,processchar.maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] imagepath={ "/images/k1.jpg","/images/k2.jpg","/images/k3.jpg","/images/k4.jpg","/images/k5.jpg","/images/k6.jpg","/images/k7.jpg","/images/k8.jpg","/images/k9.jpg","/images/k10.jpg" };
		k=new Feature[10];
		for(int l=0;l<10;l++)
	    {
			k[l]=new Feature();
		}
		
		for(int i=0;i<10;i++)
		{
		try {
			BufferedImage image=ImageIO.read(this.getClass().getResource(imagepath[i]));
			k[i].area16=Toolbag.divideinto16area(image);
			k[i].minx=Toolbag.getminx(image);
			k[i].maxx=Toolbag.getmaxx(image);
			k[i].miny=Toolbag.getminy(image);
			k[i].maxy=Toolbag.getmaxy(image);
			k[i].up=Toolbag.getoutlinefromup(image);
			k[i].down=Toolbag.getoutlinefromdown(image);
			k[i].left=Toolbag.getoutlinefromleft(image);
			k[i].right=Toolbag.getoutlinefromright(image);
			k[i].rowfocus=Toolbag.getfocusnumber(image,k[i].miny,k[i].maxy);
			k[i].columnfocus=Toolbag.getfocusnumberv(image,k[i].minx,k[i].maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
	}
	
	public void exerecognize()
	{
		boolean isrecognize=false;
		for(int i=0;i<10;i++)
		{
			isrecognize=Toolbag.regconize(k,processchar,i);
			if(isrecognize){		
				return ;
			}			
		}
		System.out.println("the character cannot be recognized by "+k[0].symbol);
	}
}

