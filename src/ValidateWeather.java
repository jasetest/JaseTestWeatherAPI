public class ValidateWeather {
    public class LocationLookupException extends Exception {
        public LocationLookupException(String message) { super(message); }
        public LocationLookupException(String message, Throwable cause) { super(message, cause); }
    }

    public class WeatherLookupException extends Exception {
        public WeatherLookupException(String message) { super(message); }
        public WeatherLookupException(String message, Throwable cause) { super(message, cause); }
    }
}