import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Gray {
	BufferedImage img;
	int width,height,minx,miny;
	Gray(BufferedImage img){
		this.img=img;
		 width = img.getWidth();  
         height = img.getHeight();  
         minx = img.getMinX();  
         miny = img.getMinY();  
		gray(img);
	}
	public void gray(BufferedImage img){
		 int[] rgb=new int[3];
		 int[][] gray=new int[width][height];
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
}
