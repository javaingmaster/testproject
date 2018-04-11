package cn.xu;

public class Point {
	double Lng;
	double Lat;
	int clusterNum;
	String status;
	boolean isVisted=false;
	public Point() {
		
	}
	public Point(double Lng,double Lat,int clusterNum,String status) {
		this.Lng=Lng;
		this.Lat=Lat;
		this.clusterNum=clusterNum;
		this.status=status;
	}
}
