import java.net.http.HttpClient;
import java.util.Scanner;

public class WeatherConsoleDriver {
    public static void main(String[] args)  {
        //creates http client
        HttpClient httpClient = HttpClient.newHttpClient();

        //initiate services
        LocationService locationService = new ZippopotamusLocationService(httpClient);
        WeatherService weatherService = new OpenMeteoWeatherService(httpClient);

        //scanner go scan scan
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a U.S. zip code: ");
        String zipCode = scanner.nextLine();


        //try to fetch location and weather
        try {
            Location location = locationService.getLocation(zipCode);
            if (location == null) {
                System.out.println("Could not find location for zip code " + zipCode);
                return;
            }

            WeatherData weatherData = weatherService.getCurrentWeather(location);

            System.out.println(weatherData);
        //handle exceptions
        } catch (ValidateWeather.WeatherLookupException | ValidateWeather.LocationLookupException e) {
            System.out.println("Error retrieving weather: " + e.getMessage());
        }
    }
}
