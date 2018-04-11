package רҵʵѵ;

    import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
		public int index=0;
		public int maxx_;
		public int maxy_;
		public int minx_=1000;
		public int miny_=1000;
		public int countarea=0;
		public  BufferedImage[] sub;
		static int[][] pixel;
		static int[] sign;
		public static int width,height,minx,miny;
		static ArrayList Temp=new ArrayList();
		static int count;
		//static int xde=0;
		Test(){
			try {
				img=ImageIO.read(this.getClass().getResource("/images/test1.bmp"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 width = img.getWidth();  
	         height = img.getHeight();  
	         minx = img.getMinX();  
	         miny = img.getMinY();  
	        gray=new int[width][height];
	        sign=new int[width*height];
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
			separate(img);
			
			/*BufferedImage img0=img;
			int w = img0.getWidth();
	        int h = img0.getHeight();
	        int type = img0.getColorModel().getTransparency();

	        Graphics2D graphics2d;
	        (graphics2d = (img0 = new BufferedImage(w, h, type))
	                .createGraphics()).setRenderingHint(
	                RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        graphics2d.rotate(Math.toRadians(60), w / 2, h / 2);*/
	        
	        
	        
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
		                int pixel =img.getRGB(i, j); // �������д��뽫һ������ת��ΪRGB����  
		                rgb[0] = (pixel & 0xff0000) >> 16;  
		                rgb[1] = (pixel & 0xff00) >> 8;  
		                rgb[2] = (pixel & 0xff);  
		                gray[i][j] = (rgb[0]*19595 + rgb[1]*38469 + rgb[2]*7472) >> 16; //һ�ֻҶȻ����㷨
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
			
			int width = img.getWidth();       //����Ӧ��ֵ�㷨  
	        int height = img.getHeight();  
	        int minx = img.getMinX();  
	        int miny = img.getMinY();  
	        
	        */
	        int old_threshold=127;    //�ɵ���ֵ
	        int new_threshold=0;    //�µ���ֵ
	        int g_threshold=0;    //���ڸ�����ֵ�ĺ�
	        int l_threshold=0;   //С�ڸ�����ֵ�ĺ�
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
			
			int width = img.getWidth();       //8��ͨ���㷨
	        int height = img.getHeight();  
	        int minx = img.getMinX();  
	        int miny = img.getMinY();  
	        
	        
	        */
	        int n;
	        for(int i=minx;i<width;i++){    //�Ƚ�ͼƬ�ı߽�ȫ����Ϊ��ɫ
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
//	        int[][] sign=new int[width][height];
	      //  int[][] pixel=new int[width][height];
	         pixel=new int[width][height];
			for(int i=minx;i<width;i++){     //��ʼ�����
				for(int j=miny;j<height;j++){
					pixel[i][j]=0;
				}
				}		
			for(int i=0;i<width*height;i++){
				sign[i]=0;		
			}
			for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
					if(((img.getRGB(i, j) & 0xffffff)==0)&& pixel[i][j]==0){	//������ɫ���ص���ұ��Ϊ0				
						firstDealLabel(img,i,j);
						
					//	System.out.println(count);
					//	System.out.println(i+" "+j);
						}					
				}		
				}
			findFather(img);
			for(int t=1;t<=count;t++){
				n=0;			
				for(int i=minx;i<width;i++){
					for(int j=miny;j<height;j++){
					//	System.out.println(pixel[i][j]);
						if(pixel[i][j]==t)						
							n++;						
					}
				}
				if(n!=0)
					System.out.println(n);
				if(n<(width*height*0.001)){
					for(int a=minx;a<width;a++){
						for(int b=miny;b<height;b++){
							if(pixel[a][b]==t)
							{
								img.setRGB(a, b, 0xffffff);
								pixel[a][b]=0;
							}
						}
					}
				}else
				{
					countarea++;
					System.out.println(countarea);
				}
				count=changeLabel();
						
			}
			sub=new BufferedImage[countarea];
			System.out.println("sub ok");
			}
	/*	
		public void dealBwlabe(int i, int j,int count){
			
			
			int width = img.getWidth();       //��ͨ���㷨
	        int height = img.getHeight();  
	        int minx = img.getMinX();  
	        int miny = img.getMinY();
	        
	        //��
	        //xde++;
			
			if (i>minx && ((img.getRGB(i-1, j) & 0xffffff)==0)  && pi[i-1][j]==0) {
				pi[i-1][j] = count;
			
			//	System.out.println("��ǰ��ת������"+xde);
	            dealBwlabe(i-1, j,count);
	        }
	        
	        //��
	        if (j>miny && ((img.getRGB(i, j-1) & 0xffffff)==0)  && pi[i][j-1]==0) {
	        	pi[i][j-1] = count;
	        	
	            dealBwlabe(i, j-1,count);
	        }
	        
	        //��
	        if (i<width-1 && ((img.getRGB(i+1, j) & 0xffffff)==0)  && pi[i+1][j]==0) {
	        	pi[i+1][j] = count;
	        	
	            dealBwlabe(i+1, j,count);
	        }
	        //��
	        if (j<height-1 && ((img.getRGB(i, j+1) & 0xffffff)==0) && pi[i][j+1]==0) {
	        	pi[i][j+1] = count;
	        	
	            dealBwlabe(i, j+1,count);
	        }        
		}

	    */
		public void firstDealLabel(BufferedImage img,int i,int j){    //��һ��ͼ��ɨ��
			
			  						
			int temp=0; 						// ���ص�������С�ı����
			find(i,j);  				//Ѱ��������С������ĺ���
			if(Temp.size()==0){   					//�������û�б����ô����һ���±��
				 count++;
				  pixel[i][j]=count;
				  Temp.clear();
			}
			else{
				temp=(int)Temp.get(0);       //����б����ô�ҳ���С���Ǹ���ֵ��temp
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
					for(int j=miny;j<miny;j++){
						if(pixel[i][j]==t)
						pixel[i][j]=newlabel;
				}
				}
				newlabel++;
			}		
			}
			return newlabel;
		}

	���ڵ���ǰ��û��ϵ��QQ�ֻ���������ʱ��ؽ�����Ϣ�����̰�װ

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
		public void separate(BufferedImage img)//��ճ��ͼ��ָ�
		{			
			    
			   
			    			    
	    
			    for(int t=1;t<=count;t++){
								
					for(int i=minx;i<width;i++){
						for(int j=miny;j<height;j++){
						
							if(pixel[i][j]==t)
							{
								Takewindowofarea(i,j);
							}
													
						}
					}
					System.out.println("sss");
					System.out.println(maxx_);
					System.out.println(maxy_);
					System.out.println(minx_);
					System.out.println(miny_);
					sub[index]=img.getSubimage(minx_,miny_,maxx_-minx_+1,maxy_-miny_+1);
			        index++;
			        maxx_=0;
					maxy_=0;
					minx_=1000;
					miny_=1000;
				}
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    for(int p=0;p<countarea;p++)//��֤
			    {			    	
			    ImageIcon c=new ImageIcon();
				JLabel l=new JLabel();
				c.setImage(sub[p]);
				l.setIcon(c);
				System.out.println("ok");
				this.add(l);
			    }
			    
			    
			    
			    
			    
		}
		
		public void Takewindowofarea(int i,int j)//��ճ��
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
		
		
		
		
		
		
		
		
		public void crossCutting(BufferedImage img){    //�����и��㷨
			int n;      //����ÿ���к�ɫ���صĸ���
			for(int i=miny;i<height;i++){
				n=0;
				for(int j=minx;j<width;j++){
					if((img.getRGB(i, j) & 0xfffffff)==0)
						n++;
				}
				
					
			}
		}
		public void lengthwiseCutting(BufferedImage img){  //�����и��㷨
			
		}
		public void getAveragewidth(BufferedImage img){
			
			
		}
		public static void main(String[] args){
			new Test();
		}
	}



