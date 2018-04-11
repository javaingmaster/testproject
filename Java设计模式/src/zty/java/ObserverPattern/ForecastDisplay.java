package zty.java.ObserverPattern;

public class ForecastDisplay implements Observer, DisplayElement{

	private float currentPressure=39.6f;
	private float lastPressure;
	private WeatherData weatherData;
	
	 public ForecastDisplay(WeatherData weatherData) {  
	        this.weatherData = weatherData;  
	        weatherData.registerObserver(this);  
	    }  
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.print("Forecast: ");
		if(currentPressure>lastPressure){
			System.out.println(" improve ");
		}else if(currentPressure==lastPressure){
			System.out.println(" more of the same ");
		}else if(currentPressure<lastPressure){
			System.out.println(" desease ");
		}
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.lastPressure=this.currentPressure;
		this.currentPressure=pressure;
		display();
	}

}
