package project;

public class WeatherData {
    private String date; // Format: YYYY-MM-DD
    private double temperature; // in Celsius
    private double humidity; // in percentage
    private String location;

    public WeatherData(String date, double temperature, double humidity, String location) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "date='" + date + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", location='" + location + '\'' +
                '}';
    }
}

