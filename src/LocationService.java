public interface LocationService {
    Location getLocation(String zipCode) throws ValidateWeather.WeatherLookupException, ValidateWeather.LocationLookupException;
}
