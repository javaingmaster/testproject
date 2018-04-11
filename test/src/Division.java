import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Division {
	BufferedImage img;
	int width,height,minx,miny;
	static int col=0;
	static int row=0;
	int[] row_;
	static BufferedImage[] bf; 
	int count;
	int[][] pixel;
	Division(BufferedImage img,int count,int[][] pixel){
		this.img=img;
		this.count=count;
		this.pixel=pixel;
		 width = img.getWidth();  
        height = img.getHeight();  
        minx = img.getMinX();  
        miny = img.getMinY();  
        pixel=new int[width][height];
        crossCutting();
        lengthwiseCutting();
	}
	public void crossCutting(){    //横向切割算法
		int n;      //计算每行中黑色像素的个数
		int cut_up=0;
		int cut_down=0;   //切割的位置变量
		boolean control=false;    //一个判断分行的控制变量
		for(int i=miny;i<height;i++){
			n=0;
			for(int j=minx;j<width;j++){
//				System.out.println(pixel[j][i]);
				if(pixel[j][i]>0){
					n++;
				//System.out.println(n);
					}
			}
			if(n>width*0.001 &&control==false){
					cut_up=i-1;
					control=true;
			}
			if(control==true && n<width*0.001){
				cut_down=i;
				oprateImage(cut_up,cut_down);
				control=false;
			}
		}
	}
	public void oprateImage(int y1,int y2){
		BufferedImage newimg;	
		col++;
		row=0;
		//System.out.println(num);
		newimg=img.getSubimage(minx, y1, width, y2-y1);
		try {
			ImageIO.write(newimg, "jpg", new File("D:\\test"+col+" "+row+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void oprateImage2(int x1,int average,int a,int w,int h,int mw,int mh){
		BufferedImage newimg;		
		row++;
		newimg=bf[a].getSubimage(x1, mh, average, h);
		try {
			ImageIO.write(newimg, "jpg", new File("D:\\test"+a+" "+row+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void lengthwiseCutting(){  //纵向切割算法
		int wwidth=0;
		int w_width=0;
		int l_cut=0;
		int r_cut=0;
		boolean control=false;
		int n;
		int w,mw;
		int h,mh;	
		bf=new BufferedImage[col+1];
		wwidth=getRect();
		for(int a=1;a<=col;a++){
			 try {
				bf[a]  = ImageIO.read(new File("D:\\test"+a+" "+0+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 row=0;
			 w=bf[a].getWidth();
			 h=bf[a].getHeight();
			 mw=bf[a].getMinX();
			 mh=bf[a].getMinY();
			// System.out.println(h+"..");
			int[] t=new int[w];
			n=1;
			for(int i=0;i<w;i++){
				t[n]=0;
			}
		for(int i=mw+1;i<w;i++){			
			for(int j=mh;j<h;j++){
					if((bf[a].getRGB(i, j)&0xffffff )==0)
						t[n]++;
				}
				n++;
			}
		for(int i=1;i<n-1;i++){
		if(t[i]<=h*0.00 && t[i+1]>0&&control==false){
				l_cut=i;
				control=true;
		}
			else if(t[i]<=h*0.00 && t[i-1]>0 &&control==true){
				r_cut=i;
				control=false;
				//System.out.println(r_cut-l_cut);
				/*
				if( (r_cut-l_cut<wwidth-3||r_cut-l_cut>wwidth+3 )&&(l_cut+wwidth)<w-1){
					oprateImage2(l_cut, wwidth,a,w,h,mw,mh);
					r_cut=wwidth-(r_cut-l_cut);
					i+=r_cut;
					//System.out.println("...");
				}
				*/
				/*
				if((r_cut-l_cut<h-10||r_cut-l_cut>h+10 )&&(l_cut+h)<w-1){
					l_cut=l_cut-h/15;
					oprateImage2(l_cut, h,a,w,h,mw,mh);
					i=l_cut+h;
				}
				
				else
					*/
				//System.out.println(r_cut);
				//System.out.println(l_cut+"!!");
				if(r_cut-l_cut>0)
				oprateImage2(l_cut, r_cut-l_cut,a,w,h,mw,mh);
			}			
		}
		}
	}
	public int  getRect(){
		int min=0;
		int max=0;
		int n=0;
		int[] w_width=new int[width];
		int wwidth=0;
		for(int t=1;t<count;t++){
		for(int i=miny;i<height;i++){
			for(int j=minx;j<width;j++){
				if(pixel[j][i]==t){
		if(min==0 && max==0){
			min=j;
			max=j;
		}
		if(j<min){
			min=j;
		}
		if(j>max){
			max=j;
		}
			}
			}
		}
		w_width[n]=max-min;
		if(max-min!=0)
		n++;
		max=0;
		min=0;
		}
		for(int i=0;i<count;i++){
			wwidth+=w_width[i];
		}
		wwidth=wwidth/n;
		//System.out.println(n);
		//System.out.println(wwidth);
		return wwidth;
	}
}
