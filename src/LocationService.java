public interface LocationService {
    Location lookupByZip(String zipCode) throws ValidateWeather.LocationLookupException;
}