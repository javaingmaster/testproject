import java.awt.image.BufferedImage;

public class Thresholding {
	BufferedImage img;
	int width,height,minx,miny;
	Thresholding(BufferedImage img){
		this.img=img;
		 width = img.getWidth();  
        height = img.getHeight();  
        minx = img.getMinX();  
        miny = img.getMinY();  
        thresholding(img);
	}
	public void thresholding(BufferedImage img){
		int old_threshold=0;
        int new_threshold=127;
        int g_threshold=0;    //大于给定阈值的和
        int l_threshold=0;   //小于给定阈值的和
        int x,y;  
        int[][] gray=new int[width][height];
        int[] rgb=new int[3];
        for (int i = minx; i < width; i++) {  
            for (int j = miny; j < height; j++) {  
                int pixel =img.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字  
                rgb[0] = (pixel & 0xff0000) >> 16;  
                rgb[1] = (pixel & 0xff00) >> 8;  
                rgb[2] = (pixel & 0xff);  
                gray[i][j] = (rgb[0]*19595 + rgb[1]*38469 + rgb[2]*7472) >> 16;
        
            }
        }
        do{
        	x=0;y=0;  
        	g_threshold=0;
        	l_threshold=0;
        	for (int i = minx; i < width; i++) {  
        		for (int j = miny; j < height; j++) {  
        			if(gray[i][j]>=new_threshold){
        				x++;
        				g_threshold+=gray[i][j];
        				
        			}	
        			else{
        				y++;
        				l_threshold+=gray[i][j];
        				
        			}    	
        		}
        	}
        	old_threshold=new_threshold;
        	new_threshold=(g_threshold/x+l_threshold/y)/2;
        }while(old_threshold!=new_threshold);
        for (int i = minx; i < width; i++) {  
    		for (int j = miny; j < height; j++) {  
    			if(gray[i][j]>=new_threshold)
    				img.setRGB(i, j, 0xffffff);
    			else
    				img.setRGB(i, j, 0x000000);
    			
    		}
        }
	}
}
