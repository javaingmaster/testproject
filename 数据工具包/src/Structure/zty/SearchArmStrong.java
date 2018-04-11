package Structure.zty;
/*
 * 筛选出n位数中所有的ArmStrong数
 */
public class SearchArmStrong {
	private int bit;
	private int[] everybits;
	
	public SearchArmStrong(int bit){
		this.bit=bit;
		this.everybits=new int[this.bit];
	}
	
	public void getArmStrongNumbers(){
		for(int i=0;i<Math.pow(10, this.bit);i++){
			int temp=i;
			int index=0;
			while(temp>0){
				this.everybits[index]=temp%10;
				temp=temp/10;
				index++;
			}
			int value=0;
			for(int j=0;j<this.bit;j++){
				value+=Math.pow(everybits[j], index);
			}
			
			if(value==i){
				System.out.println("筛选出一个ArmStrong数: "+i);
			}
		}
	}

}
