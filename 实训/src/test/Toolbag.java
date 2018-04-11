package test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Toolbag 
{
	public static int[] divideinto16area(BufferedImage img) //将一个字符分成16个区域，记录每个区域的像素数，作为第一个特征值
	{
		int[] areasdata=new int[16];
		int row=0;
		int column=0;
		int number=0;//计数黑点
		int index=0;
		
		for(int c=0;c<4;c++)
		{
			for(int m=0;m<4;m++)
			{
			
	    for(int i=row;i<row+20;i++)
	    {
	    	for(int j=column;j<column+20;j++)
	    	{
	    		if((img.getRGB(i, j) & 0xffffff)==0){
	    			number++;
	    		}
	    	}
	    }
	    areasdata[index]=number;
	    column+=20;
	    number=0;
	    index++;
		}
			row+=20;
			column=0;
	}
		
		/*for(int p=0;p<16;p++)
		{
			System.out.println(areasdata[p]);
		}*/
		
		return areasdata;
}
	
	public static int getminy(BufferedImage img)//获取一个字符的最小纵坐标
	{
		int miny=100;
		for(int i=0;i<img.getWidth();i++){
			for(int j=0;j<img.getHeight();j++){
				if((img.getRGB(i, j) & 0xffffff)==0){
	    			if(j<miny){
	    				miny=j;
	    			}
	    		}
			}
		}
		return miny;
	}
	public static int getminx(BufferedImage img)//获取一个字符的最小横坐标
	{
		int minx=100;
		for(int i=0;i<img.getWidth();i++){
			for(int j=0;j<img.getHeight();j++){
				if((img.getRGB(i, j) & 0xffffff)==0){
	    			if(i<minx){
	    				minx=i;
	    			}
	    		}
			}
		}
		return minx;
	}
	public static int getmaxy(BufferedImage img)//获取一个字符的最大纵坐标
	{
		int maxy=0;
		for(int i=0;i<img.getWidth();i++){
			for(int j=0;j<img.getHeight();j++){
				if((img.getRGB(i, j) & 0xffffff)==0){
					if(j>maxy){
	    			maxy=j;
					}
	    		}
			}
		}
		return maxy;
	}

	public static int getmaxx(BufferedImage img)//获取一个字符的最大横坐标
	{
		int maxx=0;
		for(int i=0;i<img.getWidth();i++){
			for(int j=0;j<img.getHeight();j++){
				if((img.getRGB(i, j) & 0xffffff)==0){
					if(i>maxx){
	    			maxx=i;
					}
	    		}
			}
		}
		return maxx;
	}
	public static int[] getfocusnumberv(BufferedImage img,int minx,int maxx)//纵扫一个字符的，获取8个等距焦点数为第三特征
	{
		boolean ispasswhite=true;
		
		int[] rowfocus=new int[8];
		int count=0;//统计焦点数
		int min=minx;
		int index=0;
		int add=(maxx-minx)/8;
		
		for(int i=min;i<maxx;i+=add){
			for(int j=0;j<img.getHeight();j++){
				if((img.getRGB(i, j) & 0xffffff)==0){
	    			
	    			if(ispasswhite){
	    				count++;
	    				ispasswhite=false;
	    			}
	    		}
				else{
	    		    ispasswhite=true;
	    		}
				
			}		
			rowfocus[index]=count;
			count=0;
			
			if(min>maxx){
				break;
			}
			index++;
			if(index>7){
				break;
			}
		}
		return rowfocus;
	}
	public static int[] getfocusnumber(BufferedImage img,int miny,int maxy)//横扫一个字符的，获取8个等距焦点数为第二特征
	{
		boolean ispasswhite=true;
		
		int[] rowfocus=new int[8];
		int count=0;//统计焦点数
		int min=miny;
		int index=0;
		int add=(maxy-miny)/8;
		for(int j=min;j<maxy;j+=add){
		   for(int i=0;i<img.getWidth();i++){
			
				if((img.getRGB(i, j) & 0xffffff)==0){
	    			
	    			if(ispasswhite){
	    				count++;
	    				ispasswhite=false;
	    			}
	    		}
				else{
	    		    ispasswhite=true;
	    		}
				
			}		
			rowfocus[index]=count;
			count=0;
			
			if(min>maxy){
				break;
			}
			index++;
			if(index>7){
				break;
			}
		}
		return rowfocus;
	}
	public static int[] getoutlinefromright(BufferedImage img)
	{
		int[] outline=new int[80];
		int count=0;
		
		 for(int j=0;j<img.getHeight();j++){
		       for(int i=img.getWidth()-1;i>=0;i--){
		  
			   if((img.getRGB(i, j) & 0xffffff)==0){
	    			
	    		break;
	    		}else{
	    			count++;
	    		}
		   }
		   outline[j]=count;
		   count=0;
		}		
		return outline;
	}
	public static int[] getoutlinefromleft(BufferedImage img)
	{
		int[] outline=new int[80];
		int count=0;
		
		 for(int j=0;j<img.getHeight();j++){
		       for(int i=0;i<img.getWidth();i++){
		  
			   if((img.getRGB(i, j) & 0xffffff)==0){
	    			
	    		break;
	    		}else{
	    			count++;
	    		}
		   }
		   outline[j]=count;
		   count=0;
		}		
		return outline;
	}
	public static int[] getoutlinefromdown(BufferedImage img)
	{
		int[] outline=new int[80];
		int count=0;

		for(int i=0;i<img.getWidth();i++){
		   for(int j=img.getHeight()-1;j>=0;j--){
			
			   if((img.getRGB(i, j) & 0xffffff)==0){
	    			
	    		break;
	    		}else{
	    			count++;
	    		}
		   }
		   outline[i]=count;
		   count=0;
		}		
		return outline;
	}
	public static int[] getoutlinefromup(BufferedImage img)
	{
		int[] outline=new int[80];
		int count=0;

		for(int i=0;i<img.getWidth();i++){
		   for(int j=0;j<img.getHeight();j++){
			
			   if((img.getRGB(i, j) & 0xffffff)==0){
	    			
	    		break;
	    		}else{
	    			count++;
	    		}
		   }
		   outline[i]=count;
		   count=0;
		}		
		return outline;
	}
	public static void fill(BufferedImage img)//子图象填充白点
	{
	        int n;
	       
	        for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) {  
	    			n=0;
	    			for(int a=i-1;a<=i+1;a++){
	    				for(int b=j-1;b<=j+1;b++){	 
	    					
	    					if((img.getRGB(a,b) & 0xffffff)==0)
	    						n++;
	    						
	    				}
	    			}   	
	    			
	    			if(n>=7){
	    				img.setRGB(i, j, 0x00);
	    			//System.out.println("填充");
	    				}
	    	} 
		}       
	        n=0;
	        for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) {  
	    			n=0;
	    			for(int a=i-1;a<=i+1;a++){
	    				for(int b=j-1;b<=j+1;b++){	 
	    					
	    					if((img.getRGB(a,b) & 0xffffff)==0xffffff)
	    						n++;
	    						
	    				}
	    			}   	
	    			
	    			if(n>=7){
	    				img.setRGB(i, j, 0xffffff);
	    			//System.out.println("去掉");
	    				}
	    	} 
		}       
	}
	public static boolean regconize(Feature[] data,Feature imaged,int compareindex)
	{
		boolean isrecognize=false;
		boolean first=false,second=false,third=false;
		int count=0;
			
		for(int i=0;i<80;i++)
		{
			if(Math.abs(imaged.up[i]-data[compareindex].up[i])<=data[compareindex].up[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("upcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("up is successful!");
			data[compareindex].isup=true;
		}
		count=0;
		
		for(int i=0;i<imaged.down.length;i++)
		{
			if(Math.abs(imaged.down[i]-data[compareindex].down[i])<=data[compareindex].down[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("downcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("down is successful!");
			data[compareindex].isdown=true;
		}
		count=0;
		
		for(int i=0;i<imaged.left.length;i++)
		{
			if(Math.abs(imaged.left[i]-data[compareindex].left[i])<=data[compareindex].left[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("leftcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("left is successful!");
			data[compareindex].isleft=true;
		}
		count=0;
		
		for(int i=0;i<imaged.right.length;i++)
		{
			if(Math.abs(imaged.right[i]-data[compareindex].right[i])<=data[compareindex].right[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("rightcount is "+count);
		if(count>=0.8*80)
		{
			System.out.println("right is successful!");
			data[compareindex].isright=true;
		}
		count=0;
		
		
		
		if(data[compareindex].isdown&&data[compareindex].isup){
			System.out.println(data[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(data[compareindex].isdown&&data[compareindex].isleft){
			System.out.println(data[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(data[compareindex].isdown&&data[compareindex].isright){
			System.out.println(data[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(data[compareindex].isleft&&data[compareindex].isup){
			System.out.println(data[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(data[compareindex].isright&&data[compareindex].isup){ 
			System.out.println(data[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(data[compareindex].isright&&data[compareindex].isleft){
			System.out.println(data[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else{
			System.out.println(data[compareindex].symbol+" is failed!");
		}
		
		
		for(int i=0;i<imaged.rowfocus.length;i++)
		{
			if(Math.abs(imaged.rowfocus[i]-data[compareindex].rowfocus[i])<=data[compareindex].rowfocus[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("rowfocuscount is "+count);
		if(count>=6)
		{
			//System.out.println("rowfocus is successful!");
			second=true;
		}else{
			//System.out.println("rowfocus is failed for outline!");
		}
		count=0;
		
		
		/*if(second){               准备二度过滤
			System.out.println("rowfocus is failed!");
		}*/
		
		
		for(int i=0;i<imaged.columnfocus.length;i++)
		{
			if(Math.abs(imaged.columnfocus[i]-data[compareindex].columnfocus[i])<=data[compareindex].columnfocus[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("columnfocuscount is "+count);
		if(count>=6)
		{
			//System.out.println("columnfocus is successful!");
			third=true;
		}else{
			//System.out.println("columnfocus is failed!");
		}
		count=0;
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!加一个满足字符的变量！！！！！！！！！！！！！！！！！！！！！！！！！！
		
		if (second&&third){
			System.out.println("focus is right!");
			System.out.println(data[compareindex].symbol+" is regconized!");
			isrecognize=true;
			return isrecognize;
		}
		
		first=false;
		second=false;
		third=false;
		
		return isrecognize;
		
	}
}
