import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Denoise {
	BufferedImage img;
	int width,height,minx,miny;
	static int count=0;
	 int[] sign;
     static int[][] pixel;
	static ArrayList Temp=new ArrayList();
	Denoise(BufferedImage img){
		this.img=img;
		width = img.getWidth();  
       height = img.getHeight();  
       minx = img.getMinX();  
       miny = img.getMinY();  
       Denoise1(img);
       Denoise2(img);
	}
	public void Denoise1(BufferedImage img){
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
	    			if(n>=6)
	    				img.setRGB(i, j, 0xffffff);
	    		}
	        }
	}
	public void Denoise2(BufferedImage img){
        int n;
        int field=0;
        sign=new int[width*height];
        pixel=new int[width][height];
        int[] m=new int[width*height];
        int average=0;
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
					firstDealLabel(i,j);
					}					
			}		
			}
		findFather();
		field=count;
		for(int t=1;t<=count;t++){
			n=0;
			for(int i=minx;i<width;i++){
				for(int j=miny;j<height;j++){
					if(pixel[i][j]==t)
						n++;
				}
			}
			if(n==0)
				field--;
			m[t]=n;
			average+=n;
		}
		average=average/field;
		for(int t=1;t<=count;t++){
			if(m[t]<(average*0.7)){
				for(int a=minx;a<width;a++){
					for(int b=miny;b<height;b++){			
						if(pixel[a][b]==t){
							img.setRGB(a, b, 0xffffff);
							pixel[a][b]=0;
							}
					}
				}
					}
			}	
		count=changeLabel();
		//System.out.println(count);
		}
	public void firstDealLabel(int i,int j){    //��һ��ͼ��ɨ��	
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
		 label(temp);
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
		/*
		if(pixel[i-1][j-1]>0){
			Temp.add(pixel[i-1][j-1]);
		}
		if(pixel[i-1][j+1]>0){
			Temp.add(pixel[i-1][j+1]);
		}
		*/
	}
	public void secondDealLabel(int a,int b){
		for(int x=minx;x<width;x++){
			for(int y=miny;y<height;y++){
				if(pixel[x][y]==b)
					pixel[x][y]=a;
			}
		}
	}
	
	
	
	public void findFather(){
		int t=0;
		for(int i=1;i<=count;i++){
			t=i;
			while(sign[i]!=0){
				i=sign[i];
			}
			secondDealLabel(i,t);
			i=t;		
		}			
	}
	public void label(int temp){
		for(int i=0;i<Temp.size();i++){
			if((int)Temp.get(i)!=temp){
				if(sign[(int)Temp.get(i)]==0)
				sign[(int)Temp.get(i)]=temp;
				else if(sign[(int)Temp.get(i)]>temp)
					sign[(int)Temp.get(i)]=temp;
		}
			
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
	public int getCount(){
		return count;
	}
	public int[][] getPixel(){
		return pixel;
	}
}
