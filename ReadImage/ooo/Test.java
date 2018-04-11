import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Test extends JFrame{
	static BufferedImage img;
	ImageIcon ic=new ImageIcon();
	JLabel jl=new JLabel();
	int[][] gray;
	//static int[][] pi;
	static int[][] pixel;
	static int[] sign;
	public static int width,height,minx,miny;
	
	//static int xde=0;
	Test(){
		try {
			img=ImageIO.read(this.getClass().getResource("/pis/test.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 width = img.getWidth();  
         height = img.getHeight();  
         minx = img.getMinX();  
         miny = img.getMinY();  
        gray=new int[width][height];
        sign=new int[(width-minx)*(height-miny)];
		this.setSize(800, 600);
		this.setLocation(300,300);
		ic.setImage(img);
		jl.setIcon(ic);
		this.add(jl);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grayscale(img);
		Binaryzation(img,gray);
		To_noise(img);
		To_noise2(img);
		this.setVisible(true);
	}
	
	
	public void grayscale(BufferedImage img){
	/*	
		
		int width = img.getWidth();  
        int height = img.getHeight();  
        int minx = img.getMinX();  
        int miny = img.getMinY();  
        
        */
	        int[] rgb=new int[3];
	        for (int i = minx; i < width; i++) {  
	            for (int j = miny; j < height; j++) {  
	                int pixel =img.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字  
	                rgb[0] = (pixel & 0xff0000) >> 16;  
	                rgb[1] = (pixel & 0xff00) >> 8;  
	                rgb[2] = (pixel & 0xff);  
	                gray[i][j] = (rgb[0]*19595 + rgb[1]*38469 + rgb[2]*7472) >> 16; //一种灰度化的算法
	                rgb[0]=gray[i][j]<<16;
	                rgb[1]=gray[i][j]<<8;
	                rgb[2]=gray[i][j];
	                pixel=rgb[0]+rgb[1]+rgb[2];
	                img.setRGB(i, j, pixel);	             	                
	            }          
	   }     
		
	}
	
	
	public void Binaryzation(BufferedImage img,int[][] gray){
		
		/*
		
		int width = img.getWidth();       //自适应阈值算法  
        int height = img.getHeight();  
        int minx = img.getMinX();  
        int miny = img.getMinY();  
        
        */
        int old_threshold=127;    //旧的阈值
        int new_threshold=0;    //新的阈值
        int g_threshold=0;    //大于给定阈值的和
        int l_threshold=0;   //小于给定阈值的和
        int x,y;  
        do{
        	x=0;y=0;
        	for (int i = minx; i < width; i++) {  
        		for (int j = miny; j < height; j++) {  
        			if(gray[i][j]>=old_threshold){
        				x++;
        				g_threshold+=gray[i][j];
        			}	
        			else{
        				y++;
        				l_threshold+=gray[i][j];
        			}    	
        		}
        	}
        	new_threshold=(g_threshold/x+l_threshold/y)/2;
        }while(new_threshold!=old_threshold);
        for (int i = minx; i < width; i++) {  
    		for (int j = miny; j < height; j++) {  
    			if(gray[i][j]>=new_threshold)
    				img.setRGB(i, j, 0xffffff);
    			else
    				img.setRGB(i, j, 0x000000);
    			
    		}
        }
	}
	
	public void To_noise(BufferedImage img){
		
		/*
		
		int width = img.getWidth();       //8连通域算法
        int height = img.getHeight();  
        int minx = img.getMinX();  
        int miny = img.getMinY();  
        
        
        */
        int n;
        for(int i=minx;i<width;i++){    //先将图片的边界全部设为白色
        	img.setRGB(i, miny, 0xffffff);
        	img.setRGB(i, height-1, 0xffffff);
        }
        for(int j=miny;j<height;j++){
        	img.setRGB(minx, j, 0xffffff);
        	img.setRGB(width-1, j, 0xffffff);
        }
        for (int i = minx+1; i < width-1; i++) {  
    		for (int j = miny+1; j < height-1; j++) {  
    			n=0;
    			for(int a=i-1;a<=i+1;a++){
    				for(int b=j-1;b<=j+1;b++){	
    					//System.out.println(0xffffff); 
    					
    					if((img.getRGB(a,b) & 0xffffff)==0xffffff)
    						n++;
    						
    				}
    			}   	
    			
    			if(n>=5)
    				img.setRGB(i, j, 0xffffff);
    			
    	} 
	}

        
        
        
	}
	
	public void To_noise2(BufferedImage img){
		
		/*
		 int width = img.getWidth();       //连通域算法
        int height = img.getHeight();  
        int minx = img.getMinX();  
        int miny = img.getMinY();
        
        */
        int  count=0;
        int n;
//        int[][] sign=new int[width][height];
      //  int[][] pixel=new int[width][height];
         pixel=new int[width][height];
		for(int i=minx;i<width;i++){
			for(int j=miny;j<height;j++){
				pixel[i][j]=0;
				
			}
		}
		
		for(int i=minx;i<width;i++){
			for(int j=miny;j<height;j++){
				if(((img.getRGB(i, j) & 0xffffff)==0)&& pixel[i][j]==0){
					count++;	
					pixel[i][j]=count;
					firstDealLabel(img,i,j,count);
				//	System.out.println(count);
					}					
			}		
			}
		findFather(img, count);
		for(int t=1;t<=count;t++){
			n=0;
			for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
					if(pixel[i][j]==t)
						n++;
				}
			}
			System.out.println(n);
			if(n<180){
				for(int a=minx;a<width;a++){
					for(int b=miny;b<height;b++){
						if(pixel[a][b]==t)
							img.setRGB(a, b, 0xffffff);
					}
				}
			}
		}
		}
/*	
	public void dealBwlabe(int i, int j,int count){
		
		
		int width = img.getWidth();       //连通域算法
        int height = img.getHeight();  
        int minx = img.getMinX();  
        int miny = img.getMinY();
        
        //上
        //xde++;
		
		if (i>minx && ((img.getRGB(i-1, j) & 0xffffff)==0)  && pi[i-1][j]==0) {
			pi[i-1][j] = count;
		
		//	System.out.println("当前运转次数："+xde);
            dealBwlabe(i-1, j,count);
        }
        
        //左
        if (j>miny && ((img.getRGB(i, j-1) & 0xffffff)==0)  && pi[i][j-1]==0) {
        	pi[i][j-1] = count;
        	
            dealBwlabe(i, j-1,count);
        }
        
        //下
        if (i<width-1 && ((img.getRGB(i+1, j) & 0xffffff)==0)  && pi[i+1][j]==0) {
        	pi[i+1][j] = count;
        	
            dealBwlabe(i+1, j,count);
        }
        //右
        if (j<height-1 && ((img.getRGB(i, j+1) & 0xffffff)==0) && pi[i][j+1]==0) {
        	pi[i][j+1] = count;
        	
            dealBwlabe(i, j+1,count);
        }        
	}

    */
	public void firstDealLabel(BufferedImage img,int i,int j,int count){
		  if (i<width-1 && ((img.getRGB(i+1, j) & 0xffffff)==0))   {
			  if(pixel[i+1][j]>0){
				  sign[count]=pixel[i+1][j];
			  }
			  else{
	        	pixel[i+1][j] = count;
	            firstDealLabel(img,i+1, j,count);
			  }
	        }
	        //右
	        if (j<height-1 && ((img.getRGB(i, j+1) & 0xffffff)==0) ) {
	        	if(pixel[i][j+1]>0){
					  sign[count]=pixel[i][j+1];
	        	}
	        	else{
	        	pixel[i][j+1] = count;
	            firstDealLabel(img,i, j+1,count);
	        	}
	        }
	}
	
	public void secondDealLabel(BufferedImage img,int a,int b){
		for(int i=minx;i<width;i++){
			for(int j=miny;j<height;j++){
				if(pixel[i][j]==b)
					pixel[i][j]=a;
			}
		}
	}
	
	
	
	public void findFather(BufferedImage img,int count){
		int t;
		for(int i=1;i<=count;i++){
			t=i;
			while(sign[i]!=0){
				i=sign[i];
			}
			secondDealLabel(img,i,t);
			i=t;		
		}			
	}
	
	
	
	public void separate(BufferedImage img){
		
		
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		new Test();
	}
}
