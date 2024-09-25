package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Sample data
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("2024-09-20", 22.5, 65, "New York"));
        weatherDataList.add(new WeatherData("2024-09-20", 23.0, 70, "New York"));
        weatherDataList.add(new WeatherData("2024-09-20", 25.0, 60, "Los Angeles"));
        weatherDataList.add(new WeatherData("2024-09-21", 21.0, 50, "New York"));
        weatherDataList.add(new WeatherData("2024-09-21", 24.5, 55, "Los Angeles"));

        WeatherAggregator aggregator = new WeatherAggregator(weatherDataList);

        // Average temperature by location
        Map<String, Double> avgTempByLocation = aggregator.averageTemperatureByLocation();
        System.out.println("Average Temperature by Location: " + avgTempByLocation);

        // Average humidity by location
        Map<String, Double> avgHumidityByLocation = aggregator.averageHumidityByLocation();
        System.out.println("Average Humidity by Location: " + avgHumidityByLocation);

        // Weather data by date
        Map<String, List<WeatherData>> dataByDate = aggregator.dataByDate();
        System.out.println("Weather Data by Date: " + dataByDate);
    }
}
