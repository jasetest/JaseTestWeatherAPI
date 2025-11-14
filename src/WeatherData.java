import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Author: JaseTest
 * Github Link: https://github.com/jasetest/JaseTestWeatherAPI
 */


public class WeatherData {
    private final Location location;
    private final LocalDateTime observationTime;
    private final double temperature; // Degrees in fahrenheit
    private final double windSpeed;
    private final double windDirection;

    private double precipitationProbability;

    /**
     * @param temperature Open-Meteo API Variable: temperature_2m - Air temperature at 2 meters above ground
     * @param windSpeed Open-Meteo API Variable: wind_speed_10m - Wind speed at 10, 80, 120 or 180 meters above ground. Wind speed on 10 meters is the standard level.
     * @param city Will need to get from https://api.zippopotam.us/
     * @param state Will need to get from https://api.zippopotam.us/
     * @param country Will need to get from https://api.zippopotam.us/
     * @param windDirection Open-Meteo API Variable: wind_direction_10m - Wind direction at 10, 80, 120 or 180 meters above ground
     * @param precipitationProbability Open-Meteo API Variable: precipitation_probability Preceding hour probability % Probability of precipitation with more than 0.1 mm of the preceding hour. Probability is based on ensemble weather models with 0.25° (~27 km) resolution. 0 different simulations are computed to better represent future weather conditions.
     */

    public WeatherData(double temperature, double windSpeed, String city, String state, String country, double windDirection, double precipitationProbability) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.city = city;
        this.state = state;
        this.country = country;
        this.windDirection = windDirection;
        this.precipitationProbability = precipitationProbability;
    }
    public WeatherData(String city, String state, String country){
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getPrecipitationProbability() {
        return precipitationProbability;
    }

    // Helper method to convert degrees (angles) to wind direction
}