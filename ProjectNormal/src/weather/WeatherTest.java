package weather;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cdyne.ws.weatherws.*;

public class WeatherTest
	{

		public static void main(String[] args)
			{
				Executor executor = Executors.newFixedThreadPool(4);
				WeatherSoap weatherService = new Weather().getWeatherSoap();
				WeatherReturn weather = weatherService.getCityWeatherByZIP("60051");
				///for (int i = 0; i < Integer.MAX_VALUE / 4; i++)
					//{
					//	System.out.println(i);
					//	WeatherReturn weather = weatherService.getCityWeatherByZIP(String.format("%d", i));
					//	if(weather.getCity().equals("")) continue;
					//	executor.execute(() ->
					//		{
								System.out.format("%s, %s : %s : Temperature: %s, Wind: %s, Weather ID: %s \n", weather.getCity(),
									weather.getState(), weather.getDescription(), weather.getTemperature(),
										weather.getWind(),weather.getWeatherID());
						//});

					///}

			}
	}
