package Play;

public class GetBezierCurvesPoint {
	public int y1=0;
	public boolean up1=false;
	public int y2=880;
	public boolean up2=true;

	public void movepoint()
	{
		if(this.y1<=0){
			up1=false;
			y1+=5;
			
		}else if(this.y1>=880){
			up1=true;
			y1-=5;
		}else{
			move();
		}
		
		if(this.y2<=0){
			up2=false;
			y2+=5;
			
		}else if(this.y2>=880){
			up2=true;
			y2-=5;
		}else{
			move();
		}
	}
	private void move()
	{
		if(up1){
			y1-=5;
		}else{
			y1+=5;
		}
		
		if(up2){
			y2-=5;
		}else{
			y2+=5;
		}
	}
    public int gety1(){
    	return this.y1;
	}
    public int gety2(){
    	return this.y2;
	}
}
