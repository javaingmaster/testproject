package test;

import java.util.ArrayList;

public class Feature 
{
	char symbol='K';
	
	int[] area16;//像素整体分布
	
	int minx;
	int maxx;
	int[] rowfocus;//取8个横向焦点数
	
	int miny;
	int maxy;
	int[] columnfocus;//取8个纵向向焦点数
	
	int[] up=new int[80];
	int[] down=new int[80];
	int[] left=new int[80];
	int[] right=new int[80];
	
	boolean isup;
	boolean isdown;
	boolean isleft;
	boolean isright;
	
}
