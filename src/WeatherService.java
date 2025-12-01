public interface WeatherService {
    WeatherData getCurrentWeather(Location location) throws ValidateWeather.LocationLookupException, ValidateWeather.WeatherLookupException;
}