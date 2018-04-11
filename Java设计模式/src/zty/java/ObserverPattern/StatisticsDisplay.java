package zty.java.ObserverPattern;

public class StatisticsDisplay implements Observer,DisplayElement{

	private float maxtemp=0.0f;
	private float mintemp=200;
	private float tempSum=0.0f;
	private int numReadings;
	private WeatherData weatherData;
	
	public StatisticsDisplay(WeatherData weatherData){
		this.weatherData=weatherData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		 System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)  
		            + "/" + maxtemp + "/" + mintemp);  
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		tempSum+=temp;
		numReadings++;
		
		if(temp>maxtemp){
			maxtemp=temp;
		}
		if(temp<mintemp){
			mintemp=temp;
		}
		display();
	}

}
