package ʵ���;

import java.util.Scanner;

public class Lab2 
{
	public void average()
	{
		double[] buff=new double[100];
		int bufflength=0;
		String control;
		double sum =0;
		while(true)
		{
		System.out.println("input the number: (����'average'Ϊ����ƽ��ֵ�ͷ���)");
		Scanner scanner = new Scanner(System.in);
		if((control=scanner.nextLine()).equals("average"))
		{ 
			System.out.println("�������������ƽ��ֵ");
			break;
		}
		else{			
			buff[bufflength]=Double.parseDouble(control);
			System.out.println("����ɹ�һ����");
			bufflength++;
		}		
		}
		for(int i=0;i<bufflength;i++)
		{
			sum+=buff[i];
		}
		double average=sum/bufflength;
		//System.out.println("ƽ��ֵ��: "+average);
		//System.out.println("ƽ������: "+Math.sqrt(average));
	}
	
	public void temperature()
	{
		System.out.println("input the temp: ");
		Scanner scanner = new Scanner(System.in);
        double temp=scanner.nextDouble();
        double cent=5*(temp-32)/9.0;
       // System.out.println("Centigrade is: "+cent);
      //  System.out.println();
	}
	public void compute()
	{
		int pay=25;
		int hourwork=40;
		int grosspay=pay*hourwork;
		double tax=grosspay*0.15;
		double nextpay=grosspay-tax;
		//System.out.println("grosspay: "+grosspay);
		//System.out.println("tax: "+tax);
		//System.out.println("nextpay: "+nextpay);
	}

	public static void main(String[] args)
	{
		Lab2 a=new Lab2();
		//a.average();
		//a.temperature();		
		//a.compute();
		System.out.println(Math.E);
	}

}
