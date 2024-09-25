package project;

import java.util.*;
import java.util.stream.Collectors;

public class WeatherAggregator {
    
    private List<WeatherData> weatherDataList;

    public WeatherAggregator(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    public Map<String, Double> averageTemperatureByLocation() {
        return weatherDataList.stream()
                .collect(Collectors.groupingBy(WeatherData::getLocation,
                        Collectors.averagingDouble(WeatherData::getTemperature)));
    }

    public Map<String, Double> averageHumidityByLocation() {
        return weatherDataList.stream()
                .collect(Collectors.groupingBy(WeatherData::getLocation,
                        Collectors.averagingDouble(WeatherData::getHumidity)));
    }

    public Map<String, List<WeatherData>> dataByDate() {
        return weatherDataList.stream()
                .collect(Collectors.groupingBy(WeatherData::getDate));
    }

    public List<WeatherData> getAllData() {
        return weatherDataList;
    }
}

