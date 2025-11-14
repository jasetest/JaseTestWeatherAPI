import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenMeteoWeatherService implements WeatherService{
    private final HttpClient httpClient;

    public OpenMeteoWeatherService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public WeatherData getCurrentWeather(Location location) throws ValidateWeather.WeatherLookupException{
        try{
            String url = String.format(
                "",//enter location and %f
                    location.getLatitude(), location.getLongitude()
            );
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build;
            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() != 200){
                throw new ValidateWeather().WeatherLookupException("Bad Response: " + response.statusCode());
            }

            //Will parse JSON here... another time though

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}