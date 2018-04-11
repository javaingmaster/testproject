import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;



public class Separate
{
	String path="/images/k1.jpg";
	Feature1[] character;
	BufferedImage img;
	BufferedImage[] sub;
	public static int count,minx,miny,width,height,maxx_,maxy_,index=0,maxxx_,minxx_=1000,minyy_=1000,minx_=1000,miny_=1000;
	int[][] pixel;
	Separate(BufferedImage img,int count,int[][] pixel){
		this.img=img;
		 width = img.getWidth();  
         height = img.getHeight();  
         minx = img.getMinX();  
         miny = img.getMinY(); 
         this.count=count;
         this.pixel=pixel;
	}
	public BufferedImage[] separate()//不粘连图像分割
	{			
		    
		sub=new BufferedImage[count-1];//子图象容器	    
		   
		    for(int t=1;t<count;t++)
		    {
		    for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
				
					if(pixel[i][j]==t)
					{
						Takewindowofarea(i,j);
					}
											
				}
			}
		    	    	    			
			sub[index]=img.getSubimage(minx_, miny_, maxx_-minx_+1, maxy_-miny_+1);
			To_noisetosub(sub[index]);
			
			BufferedImage fillback=new BufferedImage(2*sub[index].getWidth(),2*sub[index].getHeight(),sub[index].getType());
			int startwidth=sub[index].getWidth()/2;
			int startheight=sub[index].getHeight()/2;
			for(int i=fillback.getMinX();i<fillback.getWidth();i++)
			{
				for(int j=fillback.getMinY();j<fillback.getHeight();j++)
				{
					fillback.setRGB(i, j, 0xffffff);
				}
			}
			for(int i=startwidth;i<startwidth+sub[index].getWidth();i++)
			{
				for(int j=startheight;j<startheight+sub[index].getHeight();j++)
				{
					fillback.setRGB(i, j,sub[index].getRGB(i-startwidth+sub[index].getMinX(), j-startheight+sub[index].getMinY()));
				}
			}
			sub[index]=fillback;
			rotateImage(sub[index]);
			Image draw=sub[index].getScaledInstance(80, 80, Image.SCALE_SMOOTH);

			sub[index]=toBufferedImage(draw);
			
			fill(sub[index]);
	
			index++;
			maxx_=0;
			maxy_=0;
			minx_=1000;
			miny_=1000;		    
		    }
		    
		    return sub;
		    		    
	}
	
	public void exerecognize()
	{
		boolean isrecognize=false;
		for(int i=0;i<count-1;i++)
		{
			isrecognize=regconize(path,i);
			if(isrecognize){
				//System.out.println(i);
				return ;
			}
			//System.out.println("index"+i+" fail");
		}
		System.out.println("the character cannot be recognized!****************");
	}
	
	public boolean regconize(String path,int compareindex)
	{
		boolean isrecognize=false;
		boolean first=false,second=false,third=false;
		int count=0;
		Feature1 imaged=null;
		try {
			imaged=new Feature1();
			BufferedImage image=ImageIO.read(this.getClass().getResource(path));
			imaged.area16=divideinto16area(image);//16区域特征
			imaged.minx=getminx(image);
			imaged.maxx=getmaxx(image);
			imaged.miny=getminy(image);
			imaged.maxy=getmaxy(image);
			imaged.up=getoutlinefromup(image);
			imaged.down=getoutlinefromdown(image);
			imaged.left=getoutlinefromleft(image);
			imaged.right=getoutlinefromright(image);
			imaged.rowfocus=getfocusnumber(image,imaged.miny,imaged.maxy);
			imaged.columnfocus=getfocusnumberv(image,imaged.minx,imaged.maxx);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		for(int i=0;i<80;i++)
		{
			if(Math.abs(imaged.up[i]-character[compareindex].up[i])<=character[compareindex].up[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("upcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("up is successful!");
			character[compareindex].isup=true;
		}
		count=0;
		
		for(int i=0;i<imaged.down.length;i++)
		{
			if(Math.abs(imaged.down[i]-character[compareindex].down[i])<=character[compareindex].down[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("downcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("down is successful!");
			character[compareindex].isdown=true;
		}
		count=0;
		
		for(int i=0;i<imaged.left.length;i++)
		{
			if(Math.abs(imaged.left[i]-character[compareindex].left[i])<=character[compareindex].left[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("leftcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("left is successful!");
			character[compareindex].isleft=true;
		}
		count=0;
		
		for(int i=0;i<imaged.right.length;i++)
		{
			if(Math.abs(imaged.right[i]-character[compareindex].right[i])<=character[compareindex].right[i]*0.2)
			{
				count++;
			}
		}
		//System.out.println("rightcount is "+count);
		if(count>=0.8*80)
		{
			//System.out.println("right is successful!");
			character[compareindex].isright=true;
		}
		count=0;
		
		
		
		if(character[compareindex].isdown&&character[compareindex].isup){
			System.out.println(character[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(character[compareindex].isdown&&character[compareindex].isleft){
			System.out.println(character[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(character[compareindex].isdown&&character[compareindex].isright){
			System.out.println(character[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(character[compareindex].isleft&&character[compareindex].isup){
			System.out.println(character[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(character[compareindex].isright&&character[compareindex].isup){ 
			System.out.println(character[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else if(character[compareindex].isright&&character[compareindex].isleft){
			System.out.println(character[compareindex].symbol+" is regconized!");  first=true; isrecognize=true; return isrecognize;
		}else{
			System.out.println(character[compareindex].symbol+" is failed!");
		}
		
		
		for(int i=0;i<imaged.rowfocus.length;i++)
		{
			if(Math.abs(imaged.rowfocus[i]-character[compareindex].rowfocus[i])<=character[compareindex].rowfocus[i]*0.2)
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
			System.out.println("rowfocus is failed for outline!");
		}
		count=0;
		
		
		/*if(second){               准备二度过滤
			System.out.println("rowfocus is failed!");
		}*/
		
		
		for(int i=0;i<imaged.columnfocus.length;i++)
		{
			if(Math.abs(imaged.columnfocus[i]-character[compareindex].columnfocus[i])<=character[compareindex].columnfocus[i]*0.2)
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
			//System.out.println("focus is right!");
			System.out.println(character[compareindex].symbol+" is regconized!");
			isrecognize=true;
			return isrecognize;
		}
		
		first=false;
		second=false;
		third=false;
		
		return isrecognize;
		
	}
	public void fill(BufferedImage img)//子图象填充白点
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
	public int[] getoutlinefromright(BufferedImage img)
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
	public int[] getoutlinefromleft(BufferedImage img)
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
	public int[] getoutlinefromdown(BufferedImage img)
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
	public int[] getoutlinefromup(BufferedImage img)
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
	
	public int[] getfocusnumberv(BufferedImage img,int minx,int maxx)//纵扫一个字符的，获取8个等距焦点数为第三特征
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
	public int[] getfocusnumber(BufferedImage img,int miny,int maxy)//横扫一个字符的，获取8个等距焦点数为第二特征
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
	public int getminy(BufferedImage img)//获取一个字符的最小纵坐标
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
	public int getminx(BufferedImage img)//获取一个字符的最小横坐标
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
	public int getmaxy(BufferedImage img)//获取一个字符的最大纵坐标
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
	public int getmaxx(BufferedImage img)//获取一个字符的最大横坐标
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
	
	public int[] divideinto16area(BufferedImage img) //将一个字符分成16个区域，记录每个区域的像素数，作为第一个特征值
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
	
	public void Takewindowofarea(int i,int j)//提取函数
    {
        if(i>=maxx_)
        {
            maxx_=i;
        }	       
        if(i<=minx_)
        {
            minx_=i;
        }
        if(j>=maxy_)
        {
            maxy_=j;
        }
        if(j<=miny_)
        {
            miny_=j;
        }
    }
	
	@SuppressWarnings("restriction")
	public void resizeimg(File f,int w,int h) throws IOException
	{
	    FileOutputStream out = null;
	    try{
	            BufferedImage expand = javax.imageio.ImageIO.read(f);  
	            // 放大边长
	            BufferedImage expandencode = new BufferedImage(w*2, h*2, BufferedImage.TYPE_INT_RGB);  
	            //绘制放大后的图片
	            expandencode.getGraphics().drawImage(expand, 0, 0, w*2, h*2, null);  
	            out = new FileOutputStream("D://newsubimage.jpg");  
	            @SuppressWarnings("restriction")
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
	            encoder.encode(expandencode);  
	    }catch(Exception e){
	    e.printStackTrace();
	    }finally{
	    if(out != null){
	                out.close();  
	    }
	    }
	    }
	
		
	public void To_noisetosub(BufferedImage img)//子图象噪点处理
	{
	        int n;
	        for(int i=0;i<img.getWidth();i++){    //先将图片的边界全部设为白色
	        	img.setRGB(i, 0, 0xffffff);
	        	img.setRGB(i, img.getHeight()-1, 0xffffff);
	        }
	        for(int j=0;j<img.getHeight();j++){
	        	img.setRGB(0, j, 0xffffff);
	        	img.setRGB(img.getWidth()-1, j, 0xffffff);
	        }
	        for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) {  
	    			n=0;
	    			for(int a=i-1;a<=i+1;a++){
	    				for(int b=j-1;b<=j+1;b++){	 
	    					
	    					if((img.getRGB(a,b) & 0xffffff)==0xffffff)
	    						n++;
	    						
	    				}
	    			}   	
	    			
	    			if(n>=5)
	    				img.setRGB(i, j, 0xffffff);
	    			
	    	} 
		}
	}
	
	public void rotateImage(BufferedImage img)
    {
		BufferedImage copy;
		int angle=3;
		int newx;
		int newy ;
		int min=1000;
		int bestangle=0;
		int n;
		int control=0;
		
		int xmiddle=img.getWidth()/2-1;
		int ymiddle=img.getHeight()/2-1;
		
		//int[][] tool=new int[img.getWidth()][img.getHeight()];
		
		while(control<6)
		{
			copy=img.getSubimage(0, 0, img.getWidth(), img.getHeight());

			
		int[][] tool=new int[img.getWidth()][img.getHeight()];
		
		 for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) { 
	    			if((img.getRGB(i, j) & 0xffffff)==0)
	    			{		  
	    newx =(int)((i - xmiddle+1) * Math.cos(Math.toRadians(angle*1.0)) - (j - ymiddle+1) * Math.sin(Math.toRadians(angle*1.0))+ xmiddle-1);  
	    newy =(int)((i - xmiddle+1) *Math.sin(Math.toRadians(angle*1.0)) + (j - ymiddle+1) * Math.cos(Math.toRadians(angle*1.0))+ ymiddle-1);
	    				
	    				if(newx>=0&&newx<=img.getWidth()-1&&newy>=0&&newy<=img.getHeight()-1)
	    				{
	    				tool[newx][newy]=1;
	    				}else
	    				{
	    					System.out.println("4象限有坐标经变换后出界.");
	    					System.out.println("出错横坐标为 newx= "+newx+"出错纵坐标为newy= "+newy);   				}
	    			}
	    			
	    		}
		 }
		 for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) { 
	    			if(tool[i][j]==1)
	    			{
	    				img.setRGB(i, j, 0x00);
	    			}else
	    			{
	    				img.setRGB(i, j, 0xffffff);
	    			}
	    			
	    		}
		 }
		 
		 for (int i = 1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) {  
	    			n=0;
	    			for(int a=i-1;a<=i+1;a++){
	    				for(int b=j-1;b<=j+1;b++){		    					
	    					
	    					if((img.getRGB(a,b) & 0xffffff)==0)
	    						n++;
	    						
	    				}
	    			}   	
	    			
	    			if(n>=7)
	    				img.setRGB(i, j, 0x00);	    			
	    	} 
		}
		 for(int i=0;i<img.getWidth();i++){
				for(int j=0;j<img.getHeight();j++){
				
					if((copy.getRGB(i,j) & 0xffffff)==0)
					{
						Takewindowofsubarea(i,j);
					}
											
				}
			}
			
			if(maxxx_-minxx_<=min)
			{
				min=maxxx_-minxx_;
				bestangle=angle;
			}
			
	        maxxx_=0;				
			minxx_=1000;
			angle--;
			control++;
	}
		int[][] tool=new int[img.getWidth()][img.getHeight()];
		
		 for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) { 
	    			if((img.getRGB(i, j) & 0xffffff)==0)
	    			{
	    				newx=(int)(i*Math.cos(Math.toRadians(bestangle))-j*Math.sin(Math.toRadians(bestangle)));
	    				newy=(int)(i*Math.sin(Math.toRadians(bestangle))+j*Math.cos(Math.toRadians(bestangle)));
	    				if(newx>=0&&newx<=img.getWidth()-1&&newy>=0&&newy<=img.getHeight()-1)
	    				{
	    				tool[newx][newy]=1;
	    				}else
	    				{
	    					System.out.println("最终有坐标经变换后出界.");
	    				}
	    			}
	    			
	    		}
		 }
		 for (int i =1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) { 
	    			if(tool[i][j]==1)
	    			{
	    				img.setRGB(i, j, 0x00);
	    			}else
	    			{
	    				img.setRGB(i, j, 0xffffff);
	    			}
	    			
	    		}
		 }
		 for (int i = 1; i < img.getWidth()-1; i++) {  
	    		for (int j = 1; j < img.getHeight()-1; j++) {  
	    			n=0;
	    			for(int a=i-1;a<=i+1;a++){
	    				for(int b=j-1;b<=j+1;b++){		    					
	    					
	    					if((img.getRGB(a,b) & 0xffffff)==0)
	    						n++;
	    						
	    				}
	    			}   	
	    			
	    			if(n>=5)
	    				img.setRGB(i, j, 0x00);	    			
	    	} 
		}
    }
		 
		
		
  
	
	public void Takewindowofsubarea(int i,int j)//提取子图象函数
    {
        if(i>=maxxx_)
        {
            maxxx_=i;
        }	       
        if(i<=minxx_)
        {
            minxx_=i;
        }
    }
	
	 public static BufferedImage toBufferedImage(Image image) {  
	        if (image instanceof BufferedImage) {  
	            return (BufferedImage)image;  
	         }  
	        
	        // This code ensures that all the pixels in the image are loaded  
	         image = new ImageIcon(image).getImage();  
	        
	        // Determine if the image has transparent pixels; for this method's  
	        // implementation, see e661 Determining If an Image Has Transparent Pixels  
	        //boolean hasAlpha = hasAlpha(image);  
	        
	        // Create a buffered image with a format that's compatible with the screen  
	         BufferedImage bimage = null;  
	         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();  
	        try {  
	            // Determine the type of transparency of the new buffered image  
	            int transparency = Transparency.OPAQUE;  
	           /* if (hasAlpha) { 
	             transparency = Transparency.BITMASK; 
	             }*/  
	        
	            // Create the buffered image  
	             GraphicsDevice gs = ge.getDefaultScreenDevice();  
	             GraphicsConfiguration gc = gs.getDefaultConfiguration();  
	             bimage = gc.createCompatibleImage(  
	             image.getWidth(null), image.getHeight(null), transparency);  
	         } catch (HeadlessException e) {  
	            // The system does not have a screen  
	         }  
	        
	        if (bimage == null) {  
	            // Create a buffered image using the default color model  
	            int type = BufferedImage.TYPE_INT_RGB;  
	            //int type = BufferedImage.TYPE_3BYTE_BGR;//by wang  
	            /*if (hasAlpha) { 
	             type = BufferedImage.TYPE_INT_ARGB; 
	             }*/  
	             bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);  
	         }  
	        
	        // Copy image to buffered image  
	         Graphics g = bimage.createGraphics();  
	        
	        // Paint the image onto the buffered image  
	         g.drawImage(image, 0, 0, null);  
	         g.dispose();  
	        
	        return bimage;  
	    }  

}
