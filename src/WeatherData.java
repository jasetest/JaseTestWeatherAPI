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
     * @param location Open-Meteo API Variable: Dont know.
     * @param windDirection Open-Meteo API Variable: wind_direction_10m - Wind direction at 10, 80, 120 or 180 meters above ground
     * @param observationTime Open-Meteo API Variable: precipitation_probability Preceding hour probability % Probability of precipitation with more than 0.1 mm of the preceding hour. Probability is based on ensemble weather models with 0.25° (~27 km) resolution. 0 different simulations are computed to better represent future weather conditions.
     */


    public WeatherData(Location location, LocalDateTime observationTime, double temperature, double windSpeed, double windDirection) {
        this.location = location;
        this.observationTime = observationTime;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }




    // Helper method to convert degrees (angles) to wind direction
}