

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class Train 
{
	ArrayList<Feature[]> character;
	Feature processchar=null;
	BufferedImage[] sub;
	int index;
	Feature[] k;
	Feature[] d;
	Feature[] q;
	Feature[] u;
	
	public Train(BufferedImage[] sub,int index)
	{
		this.sub=sub;
		character=new ArrayList<Feature[]>();	
		this.index=index;
	}
	
	public void traink()
	{		
		processchar=new Feature();
		BufferedImage image=sub[index];
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
		
		String[] imagepathk={ "/images/k1.jpg","/images/k2.jpg","/images/k3.jpg","/images/k4.jpg","/images/k5.jpg","/images/k6.jpg","/images/k7.jpg","/images/k8.jpg","/images/k9.jpg","/images/k10.jpg","/images/k11.jpg","/images/k12.jpg","/images/k13.jpg","/images/k14.jpg","/images/k15.jpg" };
		k=new Feature[15];
		for(int l=0;l<15;l++)
	    {
			k[l]=new Feature();
		}
		
		for(int i=0;i<15;i++)
		{
		try {
			BufferedImage cimage=ImageIO.read(this.getClass().getResource(imagepathk[i]));
			k[i].symbol='K';
			k[i].area16=Toolbag.divideinto16area(cimage);
			k[i].minx=Toolbag.getminx(cimage);
			k[i].maxx=Toolbag.getmaxx(cimage);
			k[i].miny=Toolbag.getminy(cimage);
			k[i].maxy=Toolbag.getmaxy(cimage);
			k[i].up=Toolbag.getoutlinefromup(cimage);
			k[i].down=Toolbag.getoutlinefromdown(cimage);
			k[i].left=Toolbag.getoutlinefromleft(cimage);
			k[i].right=Toolbag.getoutlinefromright(cimage);
			k[i].rowfocus=Toolbag.getfocusnumber(cimage,k[i].miny,k[i].maxy);
			k[i].columnfocus=Toolbag.getfocusnumberv(cimage,k[i].minx,k[i].maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		String[] imagepathd={ "/images/D1.jpg","/images/D2.jpg","/images/D3.jpg","/images/D4.jpg","/images/D5.jpg","/images/D6.jpg","/images/D7.jpg","/images/D8.jpg","/images/D9.jpg","/images/D10.jpg","/images/D11.jpg","/images/D12.jpg","/images/D13.jpg","/images/D14.jpg","/images/D15.jpg" };
		d=new Feature[15];
		for(int l=0;l<15;l++)
	    {
			d[l]=new Feature();
		}
		
		for(int i=0;i<15;i++)
		{
		try {
			BufferedImage cimage=ImageIO.read(this.getClass().getResource(imagepathd[i]));
			d[i].symbol='D';
			d[i].area16=Toolbag.divideinto16area(cimage);
			d[i].minx=Toolbag.getminx(cimage);
			d[i].maxx=Toolbag.getmaxx(cimage);
			d[i].miny=Toolbag.getminy(cimage);
			d[i].maxy=Toolbag.getmaxy(cimage);
			d[i].up=Toolbag.getoutlinefromup(cimage);
			d[i].down=Toolbag.getoutlinefromdown(cimage);
			d[i].left=Toolbag.getoutlinefromleft(cimage);
			d[i].right=Toolbag.getoutlinefromright(cimage);
			d[i].rowfocus=Toolbag.getfocusnumber(cimage,d[i].miny,d[i].maxy);
			d[i].columnfocus=Toolbag.getfocusnumberv(cimage,d[i].minx,d[i].maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		String[] imagepathq={ "/images/Q1.jpg","/images/Q2.jpg","/images/Q3.jpg","/images/Q4.jpg","/images/Q5.jpg","/images/Q6.jpg","/images/Q7.jpg","/images/Q8.jpg","/images/Q9.jpg","/images/Q10.jpg","/images/Q11.jpg","/images/Q12.jpg","/images/Q13.jpg","/images/Q14.jpg","/images/Q15.jpg" };
		q=new Feature[15];
		for(int l=0;l<15;l++)
	    {
			q[l]=new Feature();
		}
		
		for(int i=0;i<15;i++)
		{
		try {
			BufferedImage cimage=ImageIO.read(this.getClass().getResource(imagepathq[i]));
			q[i].symbol='Q';
			q[i].area16=Toolbag.divideinto16area(cimage);
			q[i].minx=Toolbag.getminx(cimage);
			q[i].maxx=Toolbag.getmaxx(cimage);
			q[i].miny=Toolbag.getminy(cimage);
			q[i].maxy=Toolbag.getmaxy(cimage);
			q[i].up=Toolbag.getoutlinefromup(cimage);
			q[i].down=Toolbag.getoutlinefromdown(cimage);
			q[i].left=Toolbag.getoutlinefromleft(cimage);
			q[i].right=Toolbag.getoutlinefromright(cimage);
			q[i].rowfocus=Toolbag.getfocusnumber(cimage,q[i].miny,q[i].maxy);
			q[i].columnfocus=Toolbag.getfocusnumberv(cimage,q[i].minx,q[i].maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		String[] imagepathu={ "/images/U1.jpg","/images/U2.jpg","/images/U3.jpg","/images/U4.jpg","/images/U5.jpg","/images/U6.jpg","/images/U7.jpg","/images/U8.jpg","/images/U9.jpg","/images/U10.jpg","/images/U11.jpg","/images/U12.jpg","/images/U13.jpg","/images/U14.jpg","/images/U15.jpg" };
		u=new Feature[15];
		for(int l=0;l<15;l++)
	    {
			u[l]=new Feature();
		}
		
		for(int i=0;i<15;i++)
		{
		try {
			BufferedImage cimage=ImageIO.read(this.getClass().getResource(imagepathu[i]));
			u[i].symbol='U';
			u[i].area16=Toolbag.divideinto16area(cimage);
			u[i].minx=Toolbag.getminx(cimage);
			u[i].maxx=Toolbag.getmaxx(cimage);
			u[i].miny=Toolbag.getminy(cimage);
			u[i].maxy=Toolbag.getmaxy(cimage);
			u[i].up=Toolbag.getoutlinefromup(cimage);
			u[i].down=Toolbag.getoutlinefromdown(cimage);
			u[i].left=Toolbag.getoutlinefromleft(cimage);
			u[i].right=Toolbag.getoutlinefromright(cimage);
			u[i].rowfocus=Toolbag.getfocusnumber(cimage,u[i].miny,u[i].maxy);
			u[i].columnfocus=Toolbag.getfocusnumberv(cimage,u[i].minx,u[i].maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		
		character.add(k);
		character.add(d);
		character.add(q);
		character.add(u);
		
	}
	
	public void exerecognize()
	{
		boolean isrecognize=false;
		for(int j=0;j<character.size();j++)
		{
		for(int i=0;i<15;i++)
		{
			isrecognize=Toolbag.regconize(character.get(j),processchar,i);
			if(isrecognize){		
				return ;
			}			
		}
		
		}
		System.out.println("the character cannot be recognized .");
	}
}

