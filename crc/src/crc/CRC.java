package crc;
import java.util.Scanner;

public class CRC 
{
	public static void main(String args[])
	{ 
		Scanner input=new Scanner(System.in);
		System.out.println("请输入预发送编码：");
		int D=input.nextInt();
		System.out.println("请输入r：");
		int r=input.nextInt();
		System.out.println("请输入G编码：");
		int G=input.nextInt();
        int i=0;	   
	    String arrayD=String.valueOf(D);
	    char[] Darray = arrayD.toCharArray();
	    String arrayG=String.valueOf(G);
	    char[] Garray = arrayG.toCharArray();
	    int Dlength=Darray.length;
	    int Glength=Garray.length;
	    int sub=Dlength-Glength;
	    sub=sub+r;
	    char[] newDarray=new char[Dlength+r];
	    for(i=0;i<Dlength;i++)
	    {
	    	newDarray[i]=Darray[i];
	    }
	    i=0;
	    
	    while(i<r)
	    {
	    	newDarray[Dlength+i]=48;
	    	i++;
	    }
	    int[] div=new int[10];
	    int[] intDarray=new int[newDarray.length];
	    int[] intGarray=new int[Glength];
	    for(i=0;i<Garray.length;i++)
	    {
	    	intGarray[i]=Garray[i]-48;
	    }
	    for(i=0;i<newDarray.length;i++)
	    {
	    	intDarray[i]=newDarray[i]-48;
	    }
	    int[] copyarray=new int[newDarray.length];
	    for(i=0;i<newDarray.length;i++)
	    {
	    	copyarray[i]=intDarray[i];
	    }
	    int Dstart=0;
	    sub++;
	    int subcopy=sub;
	    while(sub>0)
	    {
	    if(intDarray[Dstart]==0){Dstart++; sub--;}
	    else{
	    	
	    for(i=0;i<Glength;i++)
	    {
	    	intDarray[Dstart+i]=intDarray[Dstart+i]^intGarray[i];
	    }
	    Dstart++;
	    sub--;
	    }
	    }	   
	   int[] send=new int[copyarray.length];
	   for(i=0;i<Dlength;i++)
	    {
	    	send[i]=copyarray[i];
	    }
	    int m=i;
	    for(i=0;i<r;i++)
	    {
	    	send[m+i]=intDarray[Dstart+i];
	    }
	    System.out.println("预发送编码为：");
	    for(i=0;i<send.length;i++)
	    {
	    	System.out.print(send[i]);
	    }
	    System.out.println();	    
		System.out.println("接收端收到数据并开始效验。");
		Dstart=0;
	    while(subcopy>0)
	    {
	    if(send[Dstart]==0){Dstart++; subcopy--;}
	    else{
	    	
	    for(i=0;i<Glength;i++)
	    {
	    	send[Dstart+i]=send[Dstart+i]^intGarray[i];
	    }
	    Dstart++;
	    subcopy--;
	    }
	    }	   
	    int iszero=0;
	    for(i=0;i<r;i++)
	    {
	    	if(send[Dstart+i]==0){ iszero++;}	    	
	    }
	    if(iszero==r)
	    {
	    	System.out.println("余数为0，数据发送正确。");
	    }
	    else{
	    	System.out.println("数据有错误！");
	    }
	} 


}
