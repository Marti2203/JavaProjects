package weather;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cdyne.ws.weatherws.*;

public class WeatherTest
	{

		public static void main(String[] args)
			{
				WeatherSoap weatherService = new Weather().getWeatherSoap();
				WeatherReturn weather = weatherService.getCityWeatherByZIP("60051");
				System.out.format("%s, %s : %s : Temperature: %s, Wind: %s, Weather ID: %s \n", weather.getCity(),
						weather.getState(), weather.getDescription(), weather.getTemperature(), weather.getWind(),
						weather.getWeatherID());

			}
	}
