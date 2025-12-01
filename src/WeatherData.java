import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Author: Jase Test
 *
 * Purpose: Uses Zippopotam API to convert zip code into coordinates,
 * then uses Open-Meto to get the weather data. The purpose is to provide
 * weather information given a zip code
 *
 * Github Link: https://github.com/jasetest/JaseTestWeatherAPI
 */

//fields
public class WeatherData {
    private final Location location;
    private final LocalDateTime observationTime;
    private final double temperature; // Degrees in fahrenheit
    private final double windSpeed;
    private final double windDirection;
    private final double precipitationProbability;

    /**
     * @param location Stores location info: City, State, Country, Latitude, Longitude
     * @param observationTime Time weather object created
     * @param temperature Open-Meteo API Variable: temperature_2m - Air temperature at 2 meters above ground
     * @param windSpeed Open-Meteo API Variable: wind_speed_10m - Wind speed at 10, 80, 120 or 180 meters above ground. Wind speed on 10 meters is the standard level.
     * @param windDirection Open-Meteo API Variable: wind_direction_10m - Wind direction at 10, 80, 120 or 180 meters above ground
     * @param precipitationProbability Open-Meteo API Variable: precipitation_probability Preceding hour probability % Probability of precipitation with more than 0.1 mm of the preceding hour. Probability is based on ensemble weather models with 0.25° (~27 km) resolution. 0 different simulations are computed to better represent future weather conditions.
     */

    //constructor
    public WeatherData(Location location, LocalDateTime observationTime, double temperature, double windSpeed, double windDirection, double precipitationProbability) {
        this.location = location;
        this.observationTime = observationTime;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.precipitationProbability = precipitationProbability;
    }

    //getters
    public Location getLocation() {
        return location;
    }

    public LocalDateTime getObservationTime() {
        return observationTime;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getPrecipitationProbability() {
        return precipitationProbability;
    }

    //toString() override for console.
    @Override
    public String toString() {
        return String.format(
                "Weather Report for %s\n" +
                        "Observed at: %s\n" +
                        "Temperature: %.1f °F\n" +
                        "Wind Speed: %.1f mph\n" +
                        "Wind Direction: %.1f°\n" +
                        "Precipitation Probability: %.1f%%",
                location,
                observationTime,
                temperature,
                windSpeed,
                windDirection,
                precipitationProbability
        );
    }


}