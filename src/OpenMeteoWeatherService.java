import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OpenMeteoWeatherService implements WeatherService {
    private final HttpClient httpClient;

    public OpenMeteoWeatherService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public WeatherData getCurrentWeather(Location location) throws ValidateWeather.WeatherLookupException {
        try {
            String url = String.format(
                    "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&hourly=temperature_2m,precipitation_probability&current=temperature_2m,wind_speed_10m,wind_direction_10m&timezone=auto&wind_speed_unit=mph&temperature_unit=fahrenheit&precipitation_unit=inch",
                    location.getLatitude(), location.getLongitude()
            );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new ValidateWeather.WeatherLookupException("Bad response: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            JsonNode current = root.path("current");
            double temperature = current.path("temperature_2m").asDouble();
            double windSpeed = current.path("wind_speed_10m").asDouble();
            double windDirection = current.path("wind_direction_10m").asDouble();

            JsonNode hourly = root.path("hourly");
            JsonNode precipArray = hourly.path("precipitation_probability");
            double precipProb = precipArray.isArray() && precipArray.size() > 0
                    ? precipArray.get(0).asDouble()
                    : 0.0;


            LocalDateTime time;
            String timeStr = current.path("time").asText();
            if (!timeStr.isEmpty()) {
                time = LocalDateTime.parse(timeStr, DateTimeFormatter.ISO_DATE_TIME);
            } else {
                time = LocalDateTime.now();
            }

            return new WeatherData(location, time, temperature, windSpeed, windDirection, precipProb);

        } catch (IOException | InterruptedException e) {
            throw new ValidateWeather.WeatherLookupException("Error calling open-meteo", e);
        }
    }
}
