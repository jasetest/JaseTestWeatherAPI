import java.net.http.HttpClient;
import java.util.Scanner;

public class WeatherConsoleDriver {
    public static void main(String[] args)  {
        HttpClient httpClient = HttpClient.newHttpClient();

        LocationService locationService = new ZippopotamusLocationService(httpClient);
        WeatherService weatherService = new OpenMeteoWeatherService(httpClient);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a U.S. zip code: ");
        String zipCode = scanner.nextLine();


        try {

            Location location = locationService.getLocation(zipCode);
            if (location == null) {
                System.out.println("Could not find location for zip code " + zipCode);
                return;
            }

            WeatherData weatherData = weatherService.getCurrentWeather(location);

            System.out.println(weatherData);

        } catch (ValidateWeather.WeatherLookupException | ValidateWeather.LocationLookupException e) {
            System.out.println("Error retrieving weather: " + e.getMessage());
        }
    }
}
