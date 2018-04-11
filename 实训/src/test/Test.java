package test;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Test extends JFrame{
	static BufferedImage img;
	ImageIcon ic=new ImageIcon();
	JLabel jl=new JLabel();
	int[][] gray;
	//static int[][] pi;
	static int[][] pixel;
	static int[] sign;
	//static String path="/images/k1.jpg";
	static Feature[] character;
	public static int stopsign=0x0ff;
	public int leftbound=1000;
	public int rightbound;
	public int index=0;
	public int maxx_;
	public int maxy_;
	public int minx_=1000;
	public int miny_=1000;
	public int maxxx_;
	public int maxyy_;
	public int minxx_=1000;
	public int minyy_=1000;
	public int countarea=0;
	public static ArrayList<Integer> dripresult;
	public  BufferedImage[] sub;
	public static int width,height,minx,miny;
	static ArrayList Temp=new ArrayList();
	static int count;
	static int num=0;
	//static int xde=0;
	Test(){
		try {			
			img=ImageIO.read(this.getClass().getResource("/images/m.jpg"));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		 width = img.getWidth();  
         height = img.getHeight();  
         minx = img.getMinX();  
         miny = img.getMinY();  
        gray=new int[width][height];
        sign=new int[width*height];
		this.setSize(1000, 600);
		this.setLocation(300,300);
		ic.setImage(img);
		jl.setIcon(ic);
		this.add(jl);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grayscale(img);//灰度化
		Binaryzation();//二值化
		To_noise(img);//去小噪点
		To_noise2(img);//去大噪点
		dripresult=new ArrayList<Integer>();
		adhesiongetdata(img);//粘连验证码分析
		//separate(img);//非粘连验证码分析
		
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
	
	
public void Binaryzation(){
		
		/*
		
		int width = img.getWidth();       //自适应阈值算法  
        int height = img.getHeight();  
        int minx = img.getMinX();  
        int miny = img.getMinY();  
        
        */
		int old_threshold=0;
        int new_threshold=127;
        int g_threshold=0;    //大于给定阈值的和
        int l_threshold=0;   //小于给定阈值的和
        int x,y;  
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
        count=0;
        int n;
//        int[][] sign=new int[width][height];
      //  int[][] pixel=new int[width][height];
         pixel=new int[width][height];
		for(int i=minx;i<width;i++){     //初始化标记
			for(int j=miny;j<height;j++){
				pixel[i][j]=0;
			}
			}		
		for(int i=0;i<width*height;i++){
			sign[i]=0;		
		}
		for(int i=minx;i<width;i++){
			for(int j=miny;j<height;j++){
				if(((img.getRGB(i, j) & 0xffffff)==0)&& pixel[i][j]==0){	//遇到黑色像素点而且标记为0				
					firstDealLabel(img,i,j);
					
				//	System.out.println(count);
				//	System.out.println(i+" "+j);
					}					
			}		
			}
		findFather(img);
		/*
		int[] min_x=new int[width];
		int[] max_x=new int[width]; 
		int[] min_y=new int[height];
		int[] max_y=new int[height];
		int num=0;
		*/
		for(int t=1;t<=count;t++){
			n=0;
			for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
				//	System.out.println(pixel[i][j]);
					if(pixel[i][j]==t)
						n++;
				}
			}
			//if(n!=0)
			//	System.out.println(n);
			if(n<(width*height*0.00071)){
				for(int a=minx;a<width;a++){
					for(int b=miny;b<height;b++){
						if(pixel[a][b]==t){
							img.setRGB(a, b, 0xffffff);
							pixel[a][b]=0;}
					}
				}
			}/*
			for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
					if(pixel[i][j]==t){
						if(min_x[num]==0 &&min_y[num]==0 &&max_x[num]==0&&max_y[num]==0)
							if()
						min_x[num]=max_x[num]=i;		
						if(i<min_x[num]){
							
						}
							
					}
				}
			}*/
		}
		count=changeLabel();
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
	public void firstDealLabel(BufferedImage img,int i,int j){    //第一次图像扫描
		
		  						
		int temp=0; 						// 像素点四周最小的标记数
		find(i,j);  				//寻找四周最小标记数的函数
		if(Temp.size()==0){   					//如果四周没有标记那么给他一个新标记
			 count++;
			  pixel[i][j]=count;
			  Temp.clear();
		}
		else{
			temp=(int)Temp.get(0);       //如果有标记那么找出最小的那个赋值给temp
		for(int a=1;a<Temp.size();a++){
			if(temp>(int)Temp.get(a))
				temp=(int)Temp.get(a);
			
		}
		 label(img,temp);
		Temp.clear();  		
		pixel[i][j]=temp;
		temp=0;	
	}
	}
	public void  find(int i,int j){
		/*
		if(pixel[i+1][j]>0){
			Temp.add(pixel[i+1][j]);						
		}
		*/
		if(pixel[i-1][j]>0){
			Temp.add(pixel[i-1][j]);			
			
		}
		/*
		if(pixel[i][j+1]>0){
			Temp.add(pixel[i][j+1]);
	
	    }
	    */
		if(pixel[i][j-1]>0){
			Temp.add(pixel[i][j-1]);
					
		}
		if(pixel[i-1][j-1]>0){
			Temp.add(pixel[i-1][j-1]);
		}
		if(pixel[i-1][j+1]>0){
			Temp.add(pixel[i-1][j+1]);
		}
		
	}
	public void secondDealLabel(BufferedImage img,int a,int b){
		for(int x=minx;x<width;x++){
			for(int y=miny;y<height;y++){
				if(pixel[x][y]==b)
					pixel[x][y]=a;
			}
		}
	}
	
	
	
	public void findFather(BufferedImage img){
		int t=0;
		for(int i=1;i<=count;i++){
			t=i;
			while(sign[i]!=0){
				i=sign[i];
			}
			secondDealLabel(img,i,t);
			i=t;		
		}			
	}
	
	public void label(BufferedImage img,int temp){
		for(int i=0;i<Temp.size();i++){
			if((int)Temp.get(i)!=temp){
				if(sign[(int)Temp.get(i)]==0)
				sign[(int)Temp.get(i)]=temp;
				else if(sign[(int)Temp.get(i)]>temp)
					sign[(int)Temp.get(i)]=temp;
		}
			
	}
	}
	public void separate(BufferedImage img)//不粘连图像分割
	{			
		    
		   sub=new BufferedImage[count];//子图象容器	    
		  // String[] name=new String[count];
		 	  
		   //Image[] myimage=new Image[count];
		   
		  /* character=new  Feature[count];//特征值类
		   for(int l=0;l<count;l++)
		   {
			   character[l]=new Feature();
		   }*/
		   
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
			//myimage[index]=draw;
			sub[index]=toBufferedImage(draw);
			
			fill(sub[index]);
			//character[index].area16=divideinto16area(sub[index]);//16区域特征
			//character[index].minx=getminx(sub[index]);
			//character[index].maxx=getmaxx(sub[index]);
			//character[index].miny=getminy(sub[index]);
			//character[index].maxy=getmaxy(sub[index]);
			
			//System.out.println(character[index].miny);
			//System.out.println(character[index].maxy);
			//System.out.println(character[index].minx);
			//System.out.println(character[index].maxx);
			
			//character[index].rowfocus=getfocusnumber(sub[index],character[index].miny,character[index].maxy);
			/*for(int p=0;p<8;p++)
			{
				System.out.println(character[index].rowfocus[p]);
			}*/
			
			//character[index].columnfocus=getfocusnumberv(sub[index],character[index].minx,character[index].maxx);
			/*for(int p=0;p<8;p++)
			{
				System.out.println(character[index].columnfocus[p]);
			}*/
			
			 //character[index].up=getoutlinefromup(sub[index]);
			 /*for(int p=0;p<80;p++)
				{
					System.out.println(character[index].up[p]);
				}
			 System.out.println("********************");*/
			 //character[index].down=getoutlinefromdown(sub[index]);
			 //character[index].left=getoutlinefromleft(sub[index]);
			 //character[index].right=getoutlinefromright(sub[index]);
 
			int newwidth=sub[index].getWidth();
			int newheight=sub[index].getHeight();
			//System.out.println(name[index]);		
			File outImageFile=new File("1231.jpg");	
			try {
				ImageIO.write(sub[0], "jpeg", outImageFile);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				resizeimg(outImageFile,newwidth,newheight);
			} catch (IOException e) {
				e.printStackTrace();
			}
			index++;
			maxx_=0;
			maxy_=0;
			minx_=1000;
			miny_=1000;		    
		    }
		 	    
			int k=20;
		    this.setLayout(null);
		    
		    
		    for(int p=0;p<count-1;p++)//   验证不粘连图像分割
		    {			    	
		    ImageIcon c=new ImageIcon();
			JLabel l=new JLabel();
			c.setImage(sub[p]);
			//c.setImage(myimage[p]);
			l.setIcon(c);
			this.add(l);
			l.setBounds(k,50,250,250);
			k+=90;			
		    }
		    
		    Train train=new Train();
		    train.traink();
		    train.exerecognize();
		    		    
	}
	
	/*public void exerecognize()
	{
		boolean isrecognize=false;
		for(int i=0;i<10;i++)
		{
			isrecognize=regconize(path,i);
			if(isrecognize){
				//System.out.println(i);
				return ;
			}
			//System.out.println("index"+i+" fail");
		}
		System.out.println("the character cannot be recognized!****************");
	}*/
	
	/*public boolean regconize(String path,int compareindex)
	{
		boolean isrecognize=false;
		boolean first=false,second=false,third=false;
		int count=0;
		Feature imaged=null;
		try {
			imaged=new Feature();
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
		
		
		//if(second){               准备二度过滤
			//System.out.println("rowfocus is failed!");
		//}
		
		
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
		
	}*/
	
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
		
		//for(int p=0;p<16;p++)
		//{
		//	System.out.println(areasdata[p]);
		//}
		
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
	    				//movex=Math.abs(Math.sqrt((Math.pow(xmiddle-i, 2)+Math.pow(ymiddle-j,2)))*Math.cos(Math.atan(j-ymiddle/i-xmiddle))-i*Math.cos(Math.toRadians(angle))+j*Math.sin(Math.toRadians(angle)));
	    			    //movey=Math.abs(Math.sqrt((Math.pow(xmiddle-i, 2)+Math.pow(ymiddle-j,2)))*Math.sin(Math.atan(j-ymiddle/i-xmiddle))-i*Math.sin(Math.toRadians(angle))+j*Math.cos(Math.toRadians(angle)));    				  
	    				newx =(int)( (i - xmiddle+1) * Math.cos(Math.toRadians(angle*1.0)) - (j - ymiddle+1) * Math.sin(Math.toRadians(angle*1.0)) + xmiddle-1);  
	    		        newy = (int)((i - xmiddle+1) *Math.sin(Math.toRadians(angle*1.0)) + (j - ymiddle+1) * Math.cos(Math.toRadians(angle*1.0))+ ymiddle-1);
	    				
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
	
	public void adhesiongetdata(BufferedImage img)
	{
		int pcount=0;
		int[] sizeofeveryarea=new int[count-1];
		int[] leftboundtool=new int[count-1];
		int[] rightboundtool=new int[count-1];
		
		for(int t=1;t<count;t++)
	    {
	    
	    for(int i=minx;i<width;i++){
			for(int j=miny;j<height;j++){
			
				if(pixel[i][j]==t)
				{
					pcount++;
					Takebound(i);
				}
										
			}
		}
	    sizeofeveryarea[t-1]=pcount;
	    pcount=0;
	    leftboundtool[t-1]=leftbound;
	    rightboundtool[t-1]=rightbound;
	    leftbound=1000;
	    rightbound=0;
	    
	    }
		
		/*for(int i=0;i<count-1;i++)
		{
			System.out.println(sizeofeveryarea[i]);
			System.out.println(leftboundtool[i]);
			System.out.println(rightboundtool[i]);
		}*/
		
		for(int m=1;m<count;m++)
	    {
			if(rightboundtool[m-1]-leftboundtool[m-1]>img.getWidth()*3/8) //!!!!!!!!!!!!这个阈值必须修改！！！！！！！！！！！！！！！！！
			{
				System.out.println("检测出一个粘连区域！");
				adhesionprocess(leftboundtool[m-1],rightboundtool[m-1]);
			}	
	    }
	}
	
	public void adhesionprocess(int left,int right)
	{
		int i=1,j;
		ArrayList<Integer> shadowdata=new ArrayList<Integer>();
		int columncount=0;
		for(j=left;j<right;j++)//将一个粘连的区域投影，数据记录在shadowdata
		{
			for(i=1;i<img.getHeight();i++)                
			{
				if((img.getRGB(j, i) & 0xffffff)==0)
				{
					columncount++;
				}
			}
			shadowdata.add(columncount);
			columncount=0;
		}
		
		/*for(int ii=0;ii<shadowdata.size();ii++)
		{
			System.out.println(shadowdata.get(ii));
		}*/
		
		shadowanalysis(shadowdata,left,right);
	}
	
	public void shadowanalysis(ArrayList<Integer> shadowdata,int left,int right)
	{
		int height=img.getHeight();
		int end=left;
		int last_i=0;
		
		
		/*for(int u=0;u<shadowdata.size();u++)
		{
			int m=shadowdata.get(u);
			System.out.println(m);
		}*/
		
		//System.out.println(img.getWidth()+"****");
		
					
		for(int i=1;i<=shadowdata.size()-2;i++)
		{
			if((shadowdata.get(i)-shadowdata.get(i-1))<0&&(shadowdata.get(i+1)-shadowdata.get(i))>0&&((i-last_i)>(img.getWidth()/16))) //&&(i-left)<(img.getWidth()/4+10)&&(i-left)>(img.getWidth()/4-10)  &&((i-end)>(img.getWidth()/500))
				//这个条件判断还要考虑
			{
				end=end+i-last_i;
				drip(end);
				last_i=i;
			}
		}
		for(int i=0;i<img.getWidth();i++)
		{
			if(img.getRGB(i, height-3)==-16776961)
			{
				dripresult.add(i);
				System.out.println(i);
			}
		}
	}
	
	public void drip(int end)
	{
		int x=end,y=1;
		
		ArrayList<Integer> stop=new ArrayList<Integer>();
		while(y!=img.getHeight()-1)
		{
			//System.out.println(img.getRGB(x-1, y+1) & 0xffffff);
			//System.out.println(img.getRGB(x, y+1) & 0xffffff);
			//System.out.println(img.getRGB(x+1, y+1) & 0xffffff);
			//System.out.println(img.getRGB(x+1, y) & 0xffffff);
			//System.out.println(img.getRGB(x-1, y) & 0xffffff);
			if(((img.getRGB(x-1, y+1) & 0xffffff)==16777215)&&((img.getRGB(x, y+1) & 0xffffff)==16777215)&&((img.getRGB(x+1, y+1) & 0xffffff)==16777215)&&((img.getRGB(x+1, y) & 0xffffff)==16777215)&&((img.getRGB(x-1, y) & 0xffffff)==16777215))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				y++;
				//System.out.println("向下");
			}
			else if(((img.getRGB(x-1, y+1) & 0xffffff)==0)&&((img.getRGB(x, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y) & 0xffffff)==0)&&((img.getRGB(x-1, y) & 0xffffff)==0))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				y++;
				//System.out.println("向下");
			}
			else if(((img.getRGB(x-1, y+1) & 0xffffff)==16777215)&&((img.getRGB(x, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y) & 0xffffff)==0)&&((img.getRGB(x-1, y) & 0xffffff)==0))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				x--;
				y++;
				//System.out.println("左下");
			}
			else if(((img.getRGB(x-1, y+1) & 0xffffff)==0)&&((img.getRGB(x, y+1) & 0xffffff)==16777215))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				y++;
				//System.out.println("向下");
			}
			else if(((img.getRGB(x-1, y+1) & 0xffffff)==0)&&((img.getRGB(x, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y+1) & 0xffffff)==16777215))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				x++;
				y++;
				//System.out.println("右下");
			}
			else if(((img.getRGB(x-1, y+1) & 0xffffff)==0)&&((img.getRGB(x, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y) & 0xffffff)==16777215))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				x++;
				//System.out.println("向右");
			}
			else if(((img.getRGB(x-1, y+1) & 0xffffff)==0)&&((img.getRGB(x, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y+1) & 0xffffff)==0)&&((img.getRGB(x+1, y) & 0xffffff)==0)&&((img.getRGB(x-1, y) & 0xffffff)==16777215))
			{
				//System.out.println(x);
				//System.out.println(y);
				img.setRGB(x, y, stopsign);
				x--;
				//System.out.println("向左");
			}
			else{
				//System.out.println(x);
				//System.out.println(y);
				//System.out.println("error!");
				img.setRGB(x, y, stopsign);
				y++;	
			}
		}
			
	}
	
	public void Takebound(int j)
    {
        if(j>=rightbound)
        {
            rightbound=j;
        }
        if(j<=leftbound)
        {
            leftbound=j;
        }
    }
	
	public int changeLabel(){
		int num=0;
		int newlabel=1;
		for(int t=1;t<=count;t++){
			for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
					if(pixel[i][j]==t)
					num++;
				}
			}
			if(num!=0){
				for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
					if(pixel[i][j]==t)
					pixel[i][j]=newlabel;
			}
			}
				num=0;
			newlabel++;
		}		
		}
		return newlabel;
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
	
	public static void main(String[] args){
		new Test();
	}
}

